package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.UserDao;
import com.project.Aperetif.Model.Role;
import com.project.Aperetif.Model.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.Assert.*;

public class UserDaoImplTest {

    private UserDao userDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        userDao = new UserDaoImpl(dataSource);
    }


    @Test
    public void saveUser() {
        Users users = new Users(1L,"Tim","Tim23@ga.xa","123", Role.USER);
        Assert.assertTrue(userDao.saveUser(users)>0);
    }

    @Test
    public void getUserById() {
        Users users = userDao.getUserById(1L);
        Assert.assertNotNull(users);
    }

    @Test
    public void getUserByName() {
        Users users = userDao.getUserByName("Tim");
        Assert.assertNotNull(users);
    }

    @Test
    public void findAll() {
        List<Users>allUser = userDao.findAll();
        Assert.assertTrue(allUser.size() > 0);
    }

    @Test
    public void deleteUser() {
        Assert.assertTrue(userDao.deleteUser(1L) > 0);
    }

}