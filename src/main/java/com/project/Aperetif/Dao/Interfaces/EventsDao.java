package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Model.Events;

import java.util.List;

public interface EventsDao {

    int saveEvents(Events event);

    Events getEventById(Long id);

    Events getEventByName(String name);

    List<Events> findAll();

    int deleteEvent(Long id);

    int updateEvent(Events event);


}
