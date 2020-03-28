package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.CheckoutOrderDao;
import com.project.Aperetif.Model.CheckoutOrder;
import com.project.Aperetif.Services.interfaces.CheckoutOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@SpringBootTest
public class CheckoutOrdersServiceImplTest {
    @Autowired
    private CheckoutOrderService checkoutOrderService;

    @MockBean
    private CheckoutOrderDao checkoutOrderDao;

    @Test
    public void saveCheckoutOrder() {
        when(checkoutOrderDao.SaveCheckoutOrder(new CheckoutOrder())).thenReturn(1);
        assertEquals(1,checkoutOrderDao.SaveCheckoutOrder(new CheckoutOrder()));
    }

    @Test
    public void findAllCheckoutOrders() {
    }

    @Test
    public void findAllCheckoutOrdersByNameCustomer() {
    }

    @Test
    public void getOneCheckoutOrderById() {
    }

    @Test
    public void updateCheckoutOrder() {
    }

    @Test
    public void deleteCheckoutOrderById() {
    }
}