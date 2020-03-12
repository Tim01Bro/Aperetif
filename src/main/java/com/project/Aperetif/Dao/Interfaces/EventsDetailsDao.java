package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Model.EventDetails;

import java.util.List;

public interface EventsDetailsDao {

    int saveEvents(EventDetails event);

    EventDetails getEventById(Long id);

    List<EventDetails> findAll();

    int deleteEvent(Long id);

    int updateEvent(EventDetails event);

}
