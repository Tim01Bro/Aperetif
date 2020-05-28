package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Model.EventsVenue;

import java.util.List;

public interface EventVenueDao {

    int saveEvents(EventsVenue event);

    EventsVenue getEventById(Long id);

    List<EventsVenue> findAll();

    int deleteEvent(Long id);

    int updateEvent(EventsVenue event);
}
