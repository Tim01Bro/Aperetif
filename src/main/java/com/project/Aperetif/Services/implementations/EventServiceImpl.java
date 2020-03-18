package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.EventsDao;
import com.project.Aperetif.Dao.Interfaces.OrdersDao;
import com.project.Aperetif.Model.Events;
import com.project.Aperetif.Services.interfaces.EventService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import java.util.List;

public class EventServiceImpl implements EventService {
    private static final Logger log = Logger.getLogger(EventServiceImpl.class);

    @Autowired
    private EventsDao eventsDao;

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
            return eventsDao.getEventById(id);
        }else{
            log.info("Can't get event by id because of illegal argument");
            return null;
        }

    }

    @Override
    public Events getEventByName(String name) {
        if(!name.equals("")){
            log.info("Get one event by name = " + name + " with success");
            return eventsDao.getEventByName(name);
        }else{
            log.info("Can't get event by name because of illegal argument");
            return null;
        }

    }

    @Override
    public List<Events> findAll() {
        return eventsDao.findAll();
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
