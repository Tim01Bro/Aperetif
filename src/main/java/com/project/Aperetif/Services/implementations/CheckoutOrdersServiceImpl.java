package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.CheckoutOrderDao;
import com.project.Aperetif.Model.CheckoutOrder;
import com.project.Aperetif.Services.interfaces.CheckoutOrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CheckoutOrdersServiceImpl implements CheckoutOrderService {
    private static final Logger log = Logger.getLogger(CheckoutOrdersServiceImpl.class);

    @Autowired
    private CheckoutOrderDao checkoutOrderDao;


    @Override
    public int SaveCheckoutOrder(CheckoutOrder checkoutOrder) {
        if(!checkoutOrder.getFirstName().equals("")&&!checkoutOrder.getLastName().equals("")
            && !checkoutOrder.getPhone().equals("")&&!checkoutOrder.getEmail().equals("")){
            log.info("Save checkout order to database");
            return checkoutOrderDao.SaveCheckoutOrder(checkoutOrder);
        }else{
            log.info("Can't save checkout order because of illegal arguments");
            return 0;
        }

    }

    @Override
    public List<CheckoutOrder> findAllCheckoutOrders() {
        log.info("Get all checkout orders");
        return checkoutOrderDao.findAllCheckoutOrders();
    }

    @Override
    public List<CheckoutOrder> findAllCheckoutOrdersByNameCustomer(String nameCustomer) {
        if(!nameCustomer.equals("")){
            log.info("Get all checkout orders by name user = " + nameCustomer);
            return checkoutOrderDao.findAllCheckoutOrdersByNameCustomer(nameCustomer);
        }else{
            log.info("Can't get checkout orders by name because of illegal argument");
            return null;
        }

    }

    @Override
    public CheckoutOrder getOneCheckoutOrderById(Long id) {
        if(id > 0) {
            log.info("Get one checkout orders by id " + id);
            return checkoutOrderDao.getOneCheckoutOrderById(id);
        }else {
            log.info("Can't get checkout orders by id because of illegal argument");
            return null;
        }
     }

    @Override
    public int updateCheckoutOrder(CheckoutOrder checkoutOrder) {
        if(!checkoutOrder.getFirstName().equals("")&&!checkoutOrder.getLastName().equals("")
                && !checkoutOrder.getPhone().equals("")&&!checkoutOrder.getEmail().equals("")){
            log.info("Update checkout order to database");
            return checkoutOrderDao.updateCheckoutOrder(checkoutOrder);
        }else{
            log.info("Can't update checkout order because of illegal arguments");
            return 0;
        }
    }

    @Override
    public int deleteCheckoutOrderById(Long id) {
            if(id > 0) {
                log.info("Delete checkout order by id = " + id);
                return checkoutOrderDao.deleteCheckoutOrderById(id);
            }else {
                log.info("Can't delete checkout order because of illegal arguments");
                return 0;
            }
        }
}
