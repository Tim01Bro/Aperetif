package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.FavoriteWinesDao;
import com.project.Aperetif.Model.FavoriteWIne;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class FavoriteWineDaoImplTest {
    private FavoriteWinesDao favoriteWinesDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        favoriteWinesDao = new FavoriteWineDaoImpl(dataSource);
    }
    @Test
    public void saveFavoriteWine() {
        FavoriteWIne fw = new FavoriteWIne(10L,7L, LocalDateTime.now().toString());
         assertTrue(favoriteWinesDao.saveFavoriteWine(fw) > 0);
    }

    @Test
    public void findAll() {
        List<FavoriteWIne>allFW = favoriteWinesDao.findAll();
        assertTrue(allFW.size()>0);
    }

    @Test
    public void findAllByUserId() {
        List<FavoriteWIne>allFw = favoriteWinesDao.findAllByUserId(7L);
        assertTrue(allFw.size() > 0);
    }

    @Test
    public void deleteFavoriteWineById() {
        assertTrue(favoriteWinesDao.deleteFavoriteWineById(10L)>0);
    }
}