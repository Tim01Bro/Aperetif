package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.WineDao;
import com.project.Aperetif.Model.enums.TypeWine;
import com.project.Aperetif.Model.Wine;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

public class WineDaoImplTest {
    private WineDao wineDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        wineDao = new WineDaoImpl(dataSource);
    }

    @Test
    public void saveWine() {
        Wine wine = new Wine("asdasd",1, TypeWine.BERRY.ordinal(),"asdasdasdsadas",12,"testWineImg.jpg", LocalDate.now().toString(),25);
        assertTrue(wineDao.saveWine(wine) > 0);

    }

    @Test
    public void getWineById() {
        Wine wine = wineDao.getWineById(1L);
        assertNotNull(wine);
    }

    @Test
    public void getWineByName() {
        List<Wine>wines = wineDao.getWineByName("asdasd");
        assertTrue(wines.size()>0);
      }

    @Test
    public void findAll() {
        List<Wine>wines = wineDao.findAll();
        assertTrue(wines.size()>0);
    }

    @Test
    public void deleteWine() {
        assertTrue(wineDao.deleteWine(1L)>0);
    }

    @Test
    public void updateWine() {
        Wine wine = wineDao.getWineById(1L);
        wine.setNameWine("JACKY");
        assertTrue(wineDao.update(wine)>0);
    }

    @Test
    public void findbyType(){
        List<Wine>wines = wineDao.findByType(TypeWine.BERRY);
        assertTrue(wines.size()>0);
    }

    @Test
    public void findByPrice(){
        List<Wine>wines = wineDao.findByLimitPrice(12,18);
        assertTrue(wines.size()>0);
     }

}