package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.Wine;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WineMapper implements RowMapper<Wine> {
    @Override
    public Wine mapRow(ResultSet resultSet, int i) throws SQLException {
        Wine wine = new Wine();
        wine.setId(resultSet.getLong("id"));
        wine.setNameWine(resultSet.getString("namewine"));
        wine.setRating(resultSet.getInt("rating"));
        wine.setTypeWines(resultSet.getInt("typewinesid"));
        wine.setDescribe(resultSet.getString("describewine"));
        wine.setQuantity(resultSet.getInt("quantity"));
        wine.setFilename(resultSet.getString("filename"));
        wine.setDateAdded(resultSet.getDate("dateadded").toString());
        return wine;
    }
}
