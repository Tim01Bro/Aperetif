package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.CheckoutOrderDao;
import com.project.Aperetif.Model.CheckoutOrder;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class CheckoutOrderDaoImplTest {
    private CheckoutOrderDao checkoutOrderDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        checkoutOrderDao = new CheckoutOrderDaoImpl(dataSource);
    }

    @Test
    public void saveCheckoutOrder() {
        CheckoutOrder checkoutOrder = new CheckoutOrder("s","sd","s","sd",
                "s","sd","sd","sd","sd");
        assertTrue(checkoutOrderDao.SaveCheckoutOrder(checkoutOrder) > 0);
    }

    @Test
    public void findAllCheckoutOrders() {
        assertTrue(checkoutOrderDao.findAllCheckoutOrders().size() > 0);
    }

    @Test
    public void findAllCheckoutOrdersByNameCustomer() {
        assertTrue(checkoutOrderDao.findAllCheckoutOrdersByNameCustomer("s").size() > 0);
    }

    @Test
    public void getOneCheckoutOrderById() {
        CheckoutOrder checkoutOrder = checkoutOrderDao.getOneCheckoutOrderById(2L);
        assertNotNull(checkoutOrder);
    }

    @Test
    public void updateCheckoutOrder() {
        CheckoutOrder checkoutOrder = checkoutOrderDao.getOneCheckoutOrderById(2L);
        checkoutOrder.setLastName("asdas");
        assertTrue(checkoutOrderDao.updateCheckoutOrder(checkoutOrder) > 0);
    }

    @Test
    public void deleteCheckoutOrderById() {
        assertTrue(checkoutOrderDao.deleteCheckoutOrderById(2L) > 0);
    }
}