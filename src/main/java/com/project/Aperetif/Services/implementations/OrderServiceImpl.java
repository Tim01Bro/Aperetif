package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.OrdersDao;
import com.project.Aperetif.Model.Orders;
import com.project.Aperetif.Services.interfaces.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private static final Logger log = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public int saveOrder(Orders orders) {
        if(orders.getUserId()!=0 && orders.getWineId()!=0 && !orders.getDateAdd().equals("")){
            log.info("Save order with success");
            return ordersDao.saveOrder(orders);
        }else {
            log.info("Can't save order because of illegal argument");
            return 0;
        }
    }

    @Override
    public Orders getOneOrders(Long idOrder) {
        if(idOrder!=null && idOrder>0){
            log.info("Get order by id = " + idOrder +  " with success");
            return ordersDao.getOneOrders(idOrder);
        }else{
            log.info("Can't get order by id because of illegal argument");
            return null;
        }
    }

    @Override
    public List<Orders> FindAll() {
        return ordersDao.FindAll();
    }

    @Override
    public List<Orders> FindAllByUserId(Long idUser) {
        if(idUser!=null && idUser > 0){
            log.info("Get all order for user by id = " + idUser + " with success");
            return ordersDao.FindAllByUserId(idUser);
        }else{
            log.info("Can't get all order for user by id because of illegal argument");
            return null;
        }

    }

    @Override
    public int updateOrder(Orders order) {
        if(order.getUserId()!=0 && order.getWineId()!=0 && !order.getDateAdd().equals("")){
            log.info("Update order by id " + order.getId()  + " with success");
            return ordersDao.updateOrder(order);
        }else{
            log.info("Can't update order by id because of illegal argument");
            return 0;
        }

    }

    @Override
    public int deleteOrder(Long idorder) {
        if(idorder!=null && idorder>0){
            log.info("Delete order by id = " + idorder + " with success");
            return ordersDao.deleteOrder(idorder);
        }else{
            log.info("Can't delete order by id because of illegal argument");
            return 0;
        }
    }

    @Override
    public int deleteAllByUserId(Long userId) {
        if(userId!=null && userId>0){
            log.info("Delete order by id = " + userId + " with success");
            return ordersDao.deleteAllByUserId(userId);
        }else{
            log.info("Can't delete order by id because of illegal argument");
            return 0;
        }
    }
}
