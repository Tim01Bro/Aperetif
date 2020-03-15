package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.FeedBackDao;
import com.project.Aperetif.Dao.Interfaces.OrdersDao;
import com.project.Aperetif.Model.Orders;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersDaoImplTest {
    private OrdersDao ordersDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        ordersDao = new OrdersDaoImpl(dataSource);
    }
    @Test
    public void saveOrder() {
        Orders orders = new Orders(1L,1,1,  LocalDate.now().toString());
        assertTrue(ordersDao.saveOrder(orders) > 0);
    }

    @Test
    public void getOneOrders() {
        Orders orders = ordersDao.getOneOrders(1L);
        assertNotNull(orders);
    }

    @Test
    public void findAll() {
        List<Orders>orders = ordersDao.FindAll();
        assertTrue(orders.size()>0);
    }

    @Test
    public void findAllByUserId() {
        List<Orders>orders = ordersDao.FindAllByUserId(1L);
        assertTrue(orders.size()>0);
    }

    @Test
    public void updateOrder() {
        Orders order = ordersDao.getOneOrders(1L);
        order.setUserId(3);
        assertTrue(ordersDao.updateOrder(order) > 0);
     }

    @Test
    public void deleteOrder() {
        assertTrue(ordersDao.deleteOrder(1L) > 0);
    }
}