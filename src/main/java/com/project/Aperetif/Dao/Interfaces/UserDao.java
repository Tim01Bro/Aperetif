package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Model.Users;

import java.util.List;

public interface UserDao {
    int saveUser(Users user);

    Users getUserById(Long id);

    Users getUserByName(String username);

    List<Users> findAll();

    int deleteUser(Long id);

    int update(Users users);

    boolean ExistsUser(String username);

}
