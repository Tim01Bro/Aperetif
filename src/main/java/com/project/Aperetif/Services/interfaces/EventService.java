package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.Events;

import java.util.List;

public interface EventService {
    int saveEvents(Events event);

    Events getEventById(Long id);

    List<Events> getEventByName(String name);

    List<Events> findAll();

    int deleteEvent(Long id);

    int updateEvent(Events event);
}
