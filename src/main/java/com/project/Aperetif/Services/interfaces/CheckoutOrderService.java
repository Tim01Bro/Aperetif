package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.CheckoutOrder;

import java.util.List;

public interface CheckoutOrderService {

    int SaveCheckoutOrder(CheckoutOrder checkoutOrder);

    List<CheckoutOrder> findAllCheckoutOrders();

    List<CheckoutOrder>findAllCheckoutOrdersByNameCustomer(String nameCustomer);

    CheckoutOrder getOneCheckoutOrderById(Long id);

    int updateCheckoutOrder(CheckoutOrder checkoutOrder);

    int deleteCheckoutOrderById(Long id);

}
