package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.Role;
import com.project.Aperetif.Model.Users;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        Users users = new Users();
        users.setId(resultSet.getLong("id"));
        users.setUsername(resultSet.getString("username"));
        users.setEmail(resultSet.getString("email"));
        users.setPassword(resultSet.getString("passworduser"));
        users.setRole(Role.findByIndex(resultSet.getInt("roleuserid")));

        return users;
    }
}
