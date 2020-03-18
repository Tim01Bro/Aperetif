package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.Users;

import java.util.List;

public interface UserService {
    int saveUser(Users user);

    Users getUserById(Long id);

    Users getUserByName(String username);

    List<Users> findAll();

    int deleteUser(Long id);

    int update(Users users);

}

