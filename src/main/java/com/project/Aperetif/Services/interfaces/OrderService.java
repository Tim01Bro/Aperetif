package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.Orders;

import java.util.List;

public interface OrderService {

    int saveOrder(Orders orders);

    Orders getOneOrders(Long idOrder);

    List<Orders> FindAll();

    List<Orders>FindAllByUserId(Long idUser);

    int updateOrder(Orders order);

    int deleteOrder(Long idorder);

    int deleteAllByUserId(Long userId);

}
