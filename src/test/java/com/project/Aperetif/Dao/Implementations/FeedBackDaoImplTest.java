package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.FeedBackDao;
import com.project.Aperetif.Dao.Interfaces.UserDao;
import com.project.Aperetif.Model.FeedBack;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.*;

public class FeedBackDaoImplTest {

    private FeedBackDao feedBackDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        feedBackDao = new FeedBackDaoImpl(dataSource);
    }
    @Test
    public void saveFeedBack() {
        FeedBack fd = new FeedBack(1L,"Tim","Tim","Test", LocalDateTime.now().toString());
        assertTrue(feedBackDao.saveFeedBack(fd) > 0);
    }

    @Test
    public void getFeedBackById() {
        FeedBack fd = feedBackDao.getFeedBackById(1L);
        assertNotNull(fd);
    }

    @Test
    public void getFeedByNameSender() {
        FeedBack fd = feedBackDao.getFeedByNameSender("Tim");
        System.out.println(fd);
     }

    @Test
    public void findAll() {
        List<FeedBack>fdLst = feedBackDao.findAll();
        assertTrue(fdLst.size() > 0);
    }

    @Test
    public void deleteFeedBack() {
        assertTrue(feedBackDao.deleteFeedBack(1L) > 0);
    }
}