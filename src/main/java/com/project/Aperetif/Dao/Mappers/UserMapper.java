package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.Users;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
