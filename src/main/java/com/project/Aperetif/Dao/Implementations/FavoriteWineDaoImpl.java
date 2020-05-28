package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.FavoriteWinesDao;
import com.project.Aperetif.Dao.Mappers.FavoriteWineMapper;
import com.project.Aperetif.Model.FavoriteWIne;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class FavoriteWineDaoImpl implements FavoriteWinesDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(FavoriteWineDaoImpl.class);

    public FavoriteWineDaoImpl(DataSource dataSource){

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int saveFavoriteWine(FavoriteWIne favoriteWIne) {
        String sql = "INSERT INTO favoritewine( wineid, userid, dateadd)values (?,?,?)";
        log.info("Add favorite wine by wine id = " + favoriteWIne.getIdWine() +
                "and user id by = " + favoriteWIne.getIdUser());
        return jdbcTemplate.update(sql,favoriteWIne.getIdWine(),
                favoriteWIne.getIdUser(),favoriteWIne.getDateAdded());
    }

    @Override
    public List<FavoriteWIne> findAll() {
        String sql = "SELECT * FROM favoritewine";
        log.info("Get all favoorite wine");
        return jdbcTemplate.query(sql,new FavoriteWineMapper());
    }

    @Override
    public List<FavoriteWIne> findAllByUserId(Long idUser) {
        String sql = "SELECT * FROM favoritewine WHERE userid = ?";
        log.info("Get all faworite wine by user id = " + idUser);
        return jdbcTemplate.query(sql,new FavoriteWineMapper(),idUser);
     }

    @Override
    public int deleteFavoriteWineById(Long idWine) {
        String sql = "DELETE FROM favoritewine WHERE wineid = ?";
        log.info("Delete favorite wine by id = " + idWine);
        return jdbcTemplate.update(sql,idWine);
    }
}
