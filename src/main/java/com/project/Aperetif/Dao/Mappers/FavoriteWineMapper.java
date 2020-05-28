package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.FavoriteWIne;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FavoriteWineMapper implements RowMapper<FavoriteWIne> {
    @Override
    public FavoriteWIne mapRow(ResultSet resultSet, int i) throws SQLException {
        FavoriteWIne fw = new FavoriteWIne();

        fw.setId(resultSet.getLong("id"));
        fw.setIdUser(resultSet.getLong("userid"));
        fw.setIdWine(resultSet.getLong("wineid"));
        fw.setDateAdded(resultSet.getString("dateadd"));
        return fw;
    }
}
