package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.UserDao;
import com.project.Aperetif.Model.Users;
import com.project.Aperetif.Services.interfaces.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService, UserDetailsService {

    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userDao.getUserByName(username);
        BCryptPasswordEncoder encoder = passwordEncoder;

        if(user==null){
            throw new UsernameNotFoundException("User not found in DataBase");
        }
         return new org.springframework.security.core.userdetails.User(user.getUsername(),encoder.encode(user.getPassword()), Collections.singleton(user.getRole()));

    }

    @Override
    public int saveUser(Users user) {
        if(!user.getUsername().equals("") &&
                !user.getPassword().equals("")&&!user.getEmail().equals("")
                &&user.getRole()!=null){
            log.info("Save user with success");
            return userDao.saveUser(user);
        }else {
            log.info("Can't save user because of illegal argument");
            return 0;
        }
    }

    @Override
    public Users getUserById(Long id) {
        if(id!=null && id>0){
            log.info("Get one user by id =" + id + " with success");
            return userDao.getUserById(id);
        }else{
            log.info("Can't get user because of illegal argument");
            return null;
        }
    }

    @Override
    public Users getUserByName(String username) {
        if(!username.equals("")){
            log.info("Find user by username = " + username + " with success");
            return userDao.getUserByName(username);
        }else {
            log.info("Can't find user because of illegal argument");
            return null;
        }
    }

    @Override
    public List<Users> findAll() {
        log.info("Get all users");
        return userDao.findAll();
    }

    @Override
    public int deleteUser(Long id) {
        if(id!=null) {
            log.info("Delete user by id = " + id + " with success");
            return userDao.deleteUser(id);
        }else {
                log.info("Can't delete user because of illegal argument");
            return 0;
        }
    }

    @Override
    public int update(Users users) {
        if(!users.getUsername().equals("") &&
                !users.getPassword().equals("")&&!users.getEmail().equals("")
                &&users.getRole()!=null) {
            log.info("Update user by id = " + users.getId() + " with success");
            return userDao.update(users);
        }else {
            log.info("Can't update user because of illegal argument");
            return 0;
        }

    }

}
