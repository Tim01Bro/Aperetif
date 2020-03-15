package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.EventDetails;
import com.project.Aperetif.Model.enums.CategoryEvent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDetailsMapper implements RowMapper<EventDetails> {
    @Override
    public EventDetails mapRow(ResultSet resultSet, int i) throws SQLException {
        EventDetails eventDetails = new EventDetails();
        eventDetails.setId(resultSet.getLong("id"));
        eventDetails.setDateStart(resultSet.getString("datestart"));
        eventDetails.setTimeStart(resultSet.getString("timestart"));
        eventDetails.setCostEvent(resultSet.getInt("costevent"));
        eventDetails.setCategoryEvents(CategoryEvent.findByIndex(resultSet.getInt("categoryevent")));
        return eventDetails;
    }
}
