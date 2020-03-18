package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.EventsVenue;

import java.util.List;

public interface EventsVenueService {
    int saveEvents(EventsVenue event);

    EventsVenue getEventById(Long id);

    List<EventsVenue> findAll();

    int deleteEvent(Long id);

    int updateEvent(EventsVenue event);
}
