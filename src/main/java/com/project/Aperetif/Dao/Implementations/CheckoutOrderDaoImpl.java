package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.CheckoutOrderDao;
import com.project.Aperetif.Dao.Mappers.CheckoutOrderMapper;
import com.project.Aperetif.Model.CheckoutOrder;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CheckoutOrderDaoImpl implements CheckoutOrderDao {

    private JdbcTemplate jdbcTemplate;

    public CheckoutOrderDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final Logger log = Logger.getLogger(CheckoutOrderDaoImpl.class);


    @Override
    public int SaveCheckoutOrder(CheckoutOrder checkoutOrder) {
        String sql = "INSERT INTO checkoutorder(firstname, lastname, companyname, " +
                "country, streetadress, city, postcode, phone, email)values (?,?,?,?,?,?,?,?,?)";
        log.info("Save checkoutorder to database to table CheckoutOrders");
        return jdbcTemplate.update(sql,checkoutOrder.getFirstName(),checkoutOrder.getLastName(),
                checkoutOrder.getCompanyName(),checkoutOrder.getCountry(),checkoutOrder.getStreetAddress(),
                checkoutOrder.getCity(),checkoutOrder.getPostCode(),checkoutOrder.getPhone(),checkoutOrder.getEmail());
    }

    @Override
    public List<CheckoutOrder> findAllCheckoutOrders() {
        String sql = "SELECT * FROM checkoutorder";
        log.info("Get all checkoutOrders");
        return jdbcTemplate.query(sql,new CheckoutOrderMapper());
    }

    @Override
    public List<CheckoutOrder> findAllCheckoutOrdersByNameCustomer(String nameCustomer) {
        String sql = "SELECT * FROM checkoutorder WHERE firstname = ?";
        log.info("Get all checkoutorders by user = " + nameCustomer);
        return jdbcTemplate.query(sql,new CheckoutOrderMapper(),nameCustomer);
    }

    @Override
    public CheckoutOrder getOneCheckoutOrderById(Long id) {
        String sql = "SELECT * FROM checkoutorder WHERE id = ?";
        log.info("Get one checkoutorder by id =" + id);
        return jdbcTemplate.queryForObject(sql,new CheckoutOrderMapper(),id);
    }

    @Override
    public int updateCheckoutOrder(CheckoutOrder checkoutOrder) {
        String sql = "UPDATE checkoutorder SET firstname = ?,lastname=?,companyname=?,country=?," +
                "streetadress=?,city=?,postcode=?,phone=?,email=? WHERE id = ?";
        log.info("Update CheckoutOrder by id = " + checkoutOrder.getId());
        return jdbcTemplate.update(sql,checkoutOrder.getFirstName(),checkoutOrder.getLastName(),
                checkoutOrder.getCompanyName(),checkoutOrder.getCountry(),
                checkoutOrder.getStreetAddress(),checkoutOrder.getCity(),
                checkoutOrder.getPostCode(),checkoutOrder.getPhone(),
                checkoutOrder.getEmail(),checkoutOrder.getId());
    }

    @Override
    public int deleteCheckoutOrderById(Long id) {
        String sql = "DELETE FROM checkoutorder WHERE id = ?";
        log.info("Delete order by id = " + id);
        return jdbcTemplate.update(sql,id);
    }
}
