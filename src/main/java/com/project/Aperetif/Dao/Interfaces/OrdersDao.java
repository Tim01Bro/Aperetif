package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Model.Orders;

import java.util.List;

public interface OrdersDao {

    int saveOrder(Orders orders);

    Orders getOneOrders(Long idOrder);

    List<Orders>FindAll();

    List<Orders>FindAllByUserId(Long idUser);

    int updateOrder(Orders order);

    int deleteOrder(Long idorder);

    int deleteAllByUserId(Long userId);
}
