package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.EventsDao;
import com.project.Aperetif.Model.Events;
import com.project.Aperetif.Services.interfaces.EventDetailsService;
import com.project.Aperetif.Services.interfaces.EventService;
import com.project.Aperetif.Services.interfaces.EventsVenueService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventServiceImpl implements EventService {
    private static final Logger log = Logger.getLogger(EventServiceImpl.class);

    @Autowired
    private EventsDao eventsDao;

    @Autowired
    private EventDetailsService eventDetailsService;

    @Autowired
    private EventsVenueService eventsVenueService;

    @Override
    public int saveEvents(Events event) {
        if(!event.getDescribeEvent().equals("") && !event.getNameEvent().equals("")
        && event.getEventDetailsId()>0 && event.getEventsVenueId()>0){
            log.info("Save event with success");
            return eventsDao.saveEvents(event);
        }else{
            log.info("Can't save event because of illegal argument");
            return 0;
        }

    }

    @Override
    public Events getEventById(Long id) {
        if(id != null && id > 0){
            log.info("Get one event by id = " + id + " with success");
            Events eventsById = eventsDao.getEventById(id);
            Integer idDetailsEvent = eventsById.getEventDetailsId();
            Integer idVenueEvent = eventsById.getEventsVenueId();

            eventsById.setEventDetails(eventDetailsService.getEventById(idDetailsEvent));
            eventsById.setEventsVenue(eventsVenueService.getEventById(Long.valueOf(idVenueEvent)));
            return eventsById;
        }else{
            log.info("Can't get event by id because of illegal argument");
            return null;
        }

    }

    @Override
    public List<Events> getEventByName(String name) {
        if(!name.equals("")){
            log.info("Get one event by name = " + name + " with success");
            List<Events> eventsByName = eventsDao.getEventByName(name);
            return eventsByName;
        }else{
            log.info("Can't get event by name because of illegal argument");
            return null;
        }

    }

    @Override
    public List<Events> findAll() {
        List<Events>allEvents = eventsDao.findAll();
        for (Events ev:allEvents
             ) {
            Integer idDetailsEvent = ev.getEventDetailsId();
            Integer idVenueEvent = ev.getEventsVenueId();

            ev.setEventDetails(eventDetailsService.getEventById(idDetailsEvent));
            ev.setEventsVenue(eventsVenueService.getEventById(Long.valueOf(idVenueEvent)));

        }
        return allEvents;
    }

    @Override
    public int deleteEvent(Long id) {
        if(id != null && id > 0) {
         log.info("Delete event by id = " + id + " with success");
         return eventsDao.deleteEvent(id);
        }else{
            log.info("Can't delete event by id because of illegal argument");
            return 0;
        }

    }

    @Override
    public int updateEvent(Events event) {
        if(!event.getDescribeEvent().equals("") && !event.getNameEvent().equals("")
                && event.getEventDetailsId()>0 && event.getEventsVenueId()>0){
            log.info("Update event by id = " +event.getId() + " with success");
            return eventsDao.updateEvent(event);
        }else {
            log.info("Can't update event by id because of illegal argument");
            return 0;
        }
    }
}
