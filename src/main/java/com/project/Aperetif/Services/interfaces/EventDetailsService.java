package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.EventDetails;

import java.util.List;

public interface EventDetailsService {
    int saveEvents(EventDetails event);

    EventDetails getEventById(Integer id);

    List<EventDetails> findAll();

    int deleteEvent(Long id);

    int updateEvent(EventDetails event);
}
