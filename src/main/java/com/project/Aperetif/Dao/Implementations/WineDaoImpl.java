package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.WineDao;
import com.project.Aperetif.Dao.Mappers.WineMapper;
import com.project.Aperetif.Model.Wine;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;

public class WineDaoImpl implements WineDao {

    private static final Logger log = Logger.getLogger(WineDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WineDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int saveWine(Wine wine) {
        String sql = "INSERT INTO wine(namewine,rating,typewinesid,describewine,quantity,filename,dateadded) values (?,?,?,?,?,?,?)";
        log.info("Save wine to database to table wine");
        return jdbcTemplate.update(sql,wine.getNameWine(),
                wine.getRating(),wine.getTypeWines(),wine.getDescribe(),
                wine.getQuantity(),wine.getFilename(), Date.valueOf(wine.getDateAdded()));
    }

    @Override
    public Wine getWineById(Long id) {
        String sql = "SELECT * FROM wine WHERE id = ?";
        log.info("Get wine by id =" + id);
        return jdbcTemplate.queryForObject(sql,new WineMapper(),id);
    }

    @Override
    public Wine getWineByName(String name) {
        String sql = "SELECT * FROM wine WHERE namewine = ?";
        log.info("Get wine by name =" + name);
        return jdbcTemplate.queryForObject(sql,new WineMapper(),name);
    }

    @Override
    public List<Wine> findAll() {
        String sql = "SELECT * FROM wine";
        log.info("Get all wine to list");
        return jdbcTemplate.query(sql,new WineMapper());
    }

    @Override
    public int deleteWine(Long id) {
        String sql = "delete from wine where id = ?";
        log.info("Delete wine by id = " + id);
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int update(Wine wine) {
        String sql = "UPDATE Wine Set  namewine = ? ," +
                " rating = ?, typewinesid = ?, describewine = ?, quantity = ?," +
                "filename = ?,dateadded=? WHERE id = ?";

        log.info("Update wine");
        return jdbcTemplate.update(sql,wine.getNameWine(),
                wine.getRating(),wine.getTypeWines(),wine.getDescribe(),wine.getQuantity(),
                wine.getFilename(),Date.valueOf(wine.getDateAdded()),wine.getId());
    }
}
