package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.OrdersDao;
import com.project.Aperetif.Dao.Mappers.OrdersMapper;
import com.project.Aperetif.Model.Orders;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(Orders.class);


    public OrdersDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int saveOrder(Orders orders) {
        String sql = "INSERT INTO orders(id, userid, wineid, dateadd) VALUES (?,?,?,?)";
        log.info("Save order to database to table Orders");
        return jdbcTemplate.update(sql,orders.getId(),orders.getUserId(),orders.getWineId(),Date.valueOf(orders.getDateAdd()));
    }

    @Override
    public Orders getOneOrders(Long idOrder) {
        String sql = "SELECT * FROM Orders WHERE id = ?";
        log.info("Get one order by order id = " + idOrder);
        return jdbcTemplate.queryForObject(sql,new OrdersMapper(),idOrder);
    }

    @Override
    public List<Orders> FindAll() {
        String sql = "SELECT * FROM Orders ";
        log.info("Get all order");
        return jdbcTemplate.query(sql,new OrdersMapper());
    }

    @Override
    public List<Orders> FindAllByUserId(Long idUser) {
        String sql = "SELECT * FROM Orders WHERE userid = ? ";
        log.info("Get all order for user by id = " + idUser);
        return jdbcTemplate.query(sql,new OrdersMapper(),idUser);
    }

    @Override
    public int updateOrder(Orders order) {
        String sql = "UPDATE Orders SET userid = ?,wineid = ? WHERE id = ?";
        log.info("Update order by id = " + order.getId());
        return jdbcTemplate.update(sql,order.getUserId(),order.getWineId(),order.getId());
    }

    @Override
    public int deleteOrder(Long idorder) {
        String sql = "DELETE FROM Orders WHERE id = ?";
        log.info("Delete order by id =" + idorder);
        return jdbcTemplate.update(sql,idorder);
    }

}
