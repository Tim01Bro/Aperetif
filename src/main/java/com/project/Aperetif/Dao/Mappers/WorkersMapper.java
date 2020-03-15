package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.Workers;
import com.project.Aperetif.Model.enums.PositionWorker;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WorkersMapper implements RowMapper<Workers> {

    @Override
    public Workers mapRow(ResultSet resultSet, int i) throws SQLException {
        Workers workers = new Workers();
        workers.setId(resultSet.getLong("id"));
        workers.setNameWorker(resultSet.getString("nameworker"));
        workers.setSonameWorker(resultSet.getString("sonameworker"));
        workers.setFilename(resultSet.getString("filename"));
        workers.setDescribe(resultSet.getString("describeworker"));
        workers.setPositionWorkers(PositionWorker.findByIndex(resultSet.getInt("positionworkerid")));
        workers.setLinkFacebook(resultSet.getString("linkfacebook"));
        workers.setLinkTwitter(resultSet.getString("linktwitter"));
        workers.setLingLinkedIN(resultSet.getString("linklinkedin"));

        return workers;
    }
}
