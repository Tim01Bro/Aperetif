package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.UserDao;
import com.project.Aperetif.Model.Users;
import com.project.Aperetif.Model.enums.Role;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

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
        Users users = new Users("Tim","Josd","asda",Role.USER);
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
        Assert.assertTrue(userDao.deleteUser(9L) > 0);
    }

    @Test
    public void updateUser() {
        Users users = userDao.getUserById(1L);
        users.setUsername("JO");
        Assert.assertTrue(userDao.update(users) > 0);
    }

    @Test
    public void existsUser(){
        Assert.assertFalse(userDao.ExistsUser("aza"));
    }


}