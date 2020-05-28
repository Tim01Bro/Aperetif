package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.OrdersDao;
import com.project.Aperetif.Model.Orders;
import com.project.Aperetif.Services.interfaces.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;

    @MockBean
    private OrdersDao ordersDao;

    @Test
    public void saveOrder() {
        when(ordersDao.saveOrder(new Orders(1L,1L,2,"s"))).thenReturn(1);
        assertEquals(1,orderService.saveOrder(new Orders(1L,1L,2,"s")));
    }

    @Test
    public void getOneOrders() {
        when(ordersDao.getOneOrders(1L)).thenReturn(new Orders(1L,1L,2,""));
        assertEquals(new Long(1),orderService.getOneOrders(1L).getUserId());
    }

    @Test
    public void findAll() {
        when(ordersDao.FindAll()).thenReturn(Stream.of(new Orders(1L,1L,2,"")).collect(Collectors.toList()));
        assertEquals(1,orderService.FindAll().size());
    }

    @Test
    public void findAllByUserId() {
        when(ordersDao.FindAllByUserId(1L)).thenReturn(Stream.of(new Orders(1L,1L,2,"")).collect(Collectors.toList()));
        assertEquals(1,orderService.FindAllByUserId(1L).size());
    }

    @Test
    public void updateOrder() {
        when(ordersDao.updateOrder(new Orders(1L,1L,2,"s"))).thenReturn(1);
        assertEquals(1,orderService.updateOrder(new Orders(1L,1L,2,"s")));
    }

    @Test
    public void deleteOrder() {
        when(ordersDao.deleteOrder(1L)).thenReturn(1);
        assertEquals(1,orderService.deleteOrder(1L));
    }

    @Test
    public void FailedSave(){
        when(ordersDao.saveOrder(new Orders(1L,-1L,2,""))).thenReturn(0);
        assertEquals(0,orderService.saveOrder(new Orders(1L,-1L,2,"")));
    }

    @Test
    public void FailedGetOneOrder(){
        when(ordersDao.getOneOrders(-1L)).thenReturn(null);
        assertNull(orderService.getOneOrders(-1L));
    }

    @Test
    public void FailedAllUserById(){
        when(ordersDao.FindAllByUserId(-1L)).thenReturn(null);
        assertNull(orderService.FindAllByUserId(-1L));
    }

    @Test
    public void FailedUpdate(){
        when(ordersDao.updateOrder(new Orders(1L,-1L,2,""))).thenReturn(0);
        assertEquals(0,orderService.updateOrder(new Orders(1L,-1L,2,"")));
    }

    @Test
    public void FailedDelete(){
        when(ordersDao.deleteOrder(-1L)).thenReturn(0);
        assertEquals(0,orderService.deleteOrder(-1L));
    }
}