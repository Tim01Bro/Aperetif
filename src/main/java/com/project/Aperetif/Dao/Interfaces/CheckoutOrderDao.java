package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Model.CheckoutOrder;

import java.util.List;

public interface CheckoutOrderDao {

    int SaveCheckoutOrder(CheckoutOrder checkoutOrder);

    List<CheckoutOrder>findAllCheckoutOrders();

    List<CheckoutOrder>findAllCheckoutOrdersByNameCustomer(String nameCustomer);

    CheckoutOrder getOneCheckoutOrderById(Long id);

    int updateCheckoutOrder(CheckoutOrder checkoutOrder);

    int deleteCheckoutOrderById(Long id);
}
