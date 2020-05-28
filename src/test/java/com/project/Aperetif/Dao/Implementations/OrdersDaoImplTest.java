package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.OrdersDao;
import com.project.Aperetif.Model.Orders;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        Orders orders = new Orders(1L,8L,9,  LocalDate.now().toString());
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
        order.setUserId(3L);
        assertTrue(ordersDao.updateOrder(order) > 0);
     }

    @Test
    public void deleteOrder() {
        assertTrue(ordersDao.deleteOrder(1L) > 0);
    }
}