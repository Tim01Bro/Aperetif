package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.Orders;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersMapper implements RowMapper<Orders> {
    @Override
    public Orders mapRow(ResultSet resultSet, int i) throws SQLException {
        Orders orders = new Orders();
        orders.setId(resultSet.getLong("id"));
        orders.setUserId(resultSet.getInt("userid"));
        orders.setWineId(resultSet.getInt("wineid"));
        orders.setDateAdd(resultSet.getString("dateadd"));
        return orders;
    }
}
