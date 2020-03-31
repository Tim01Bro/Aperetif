package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.CheckoutOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckoutOrderMapper implements RowMapper<CheckoutOrder> {
    @Override
    public CheckoutOrder mapRow(ResultSet resultSet, int i) throws SQLException {

        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setId(resultSet.getLong("id"));
        checkoutOrder.setCity(resultSet.getString("city"));
        checkoutOrder.setCompanyName(resultSet.getString("companyname"));
        checkoutOrder.setCountry(resultSet.getString("country"));
        checkoutOrder.setFirstName(resultSet.getString("firstname"));
        checkoutOrder.setLastName(resultSet.getString("lastname"));
        checkoutOrder.setStreetAddress(resultSet.getString("streetadress"));
        checkoutOrder.setPhone(resultSet.getString("phone"));
        checkoutOrder.setEmail(resultSet.getString("email"));
        checkoutOrder.setPostCode(resultSet.getString("postcode"));

        return checkoutOrder;
    }
}
