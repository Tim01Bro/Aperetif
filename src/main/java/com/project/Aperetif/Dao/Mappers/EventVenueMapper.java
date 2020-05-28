package com.project.Aperetif.Dao.Mappers;

import com.project.Aperetif.Model.EventsVenue;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EventVenueMapper  implements RowMapper<EventsVenue> {
    @Override
    public EventsVenue mapRow(ResultSet resultSet, int i) throws SQLException {
        EventsVenue event = new EventsVenue();
        event.setId(resultSet.getLong("id"));
        event.setPlaceEvent(resultSet.getString("placeevent"));
        event.setAddressEvent(resultSet.getString("addressevent"));
        event.setWebSiteEvent(resultSet.getString("websiteevent"));
        event.setPhoneEvent(resultSet.getString("phoneevent"));
        return event;
    }
}
