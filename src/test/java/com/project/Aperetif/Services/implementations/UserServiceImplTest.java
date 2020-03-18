package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.UserDao;
import com.project.Aperetif.Model.Users;
import com.project.Aperetif.Model.enums.Role;
import com.project.Aperetif.Services.interfaces.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserDao userDao;

    @Test
    public void saveUser() {
        when(userDao.saveUser(new Users("Tim","Josd","asda",Role.USER))).thenReturn(1);
        assertEquals(1,userService.saveUser(new Users("Tim","Josd","asda",Role.USER)));
    }

    @Test
    public void getUserById() {
        when(userDao.getUserById(1L)).thenReturn(new Users("Tim","Josd","asda",Role.USER));
        assertEquals("Tim",userService.getUserById(1L).getUsername());
    }

    @Test
    public void getUserByName() {
        when(userDao.getUserByName("Tim")).thenReturn(new Users("Tim","Josd","asda",Role.USER));
        assertEquals("Tim",userService.getUserByName("Tim").getUsername());

    }

    @Test
    public void findAll() {
        when(userDao.findAll()).thenReturn(Stream.of(new Users("Tim","Josd","asda",Role.USER)).collect(Collectors.toList()));
        assertEquals(1, userService.findAll().size());
    }

    @Test
    public void deleteUser() {
        when(userDao.deleteUser(1L)).thenReturn(1);
        assertEquals(1,userService.deleteUser(1L));
    }

    @Test
    public void update() {
        when(userDao.update(new Users("Tim","Jos","123",Role.USER))).thenReturn(1);
        assertEquals(1,userService.update(new Users("Tim","Jos","123",Role.USER)));
    }

    @Test
    public void FailedSave(){
        when(userDao.saveUser(new Users("","Josd","asda",Role.USER))).thenReturn(0);
        assertEquals(0,userService.saveUser(new Users("","Josd","asda",Role.USER)));
    }

    @Test
    public void FailedGetById(){
        when(userDao.getUserById(-1L)).thenReturn(null);
        assertNull(userService.getUserById(-1L));
    }

    @Test
    public void FailedGetByUserName(){
        when(userDao.getUserByName("")).thenReturn(null);
        assertNull(userService.getUserByName(""));
    }

    @Test
    public void FailedDelete(){
        when(userDao.deleteUser(-1L)).thenReturn(0);
        assertEquals(0,userService.deleteUser(-1L));
    }

    @Test
    public void FailedUpdate(){
        when(userDao.update(new Users("","Josd","asda",Role.USER))).thenReturn(0);
        assertEquals(0,userService.update(new Users("","Josd","asda",Role.USER)));
    }
}