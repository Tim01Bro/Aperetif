package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.Events;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventsMapper implements RowMapper<Events> {
    @Override
    public Events mapRow(ResultSet resultSet, int i) throws SQLException {
        Events events = new Events();
        events.setId(resultSet.getLong("id"));
        events.setNameEvent(resultSet.getString("nameevent"));
        events.setDescribeEvent(resultSet.getString("describeevent"));
        events.setEventDetailsId(resultSet.getInt("eventdetailsid"));
        events.setEventsVenueId(resultSet.getInt("eventsvenueid"));

        return events;
    }
}
