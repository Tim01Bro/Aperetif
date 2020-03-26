package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.EventsDetailsDao;
import com.project.Aperetif.Model.EventDetails;
import com.project.Aperetif.Services.interfaces.EventDetailsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventDetailsServiceImpl implements EventDetailsService {

    private static final Logger log = Logger.getLogger(EventDetailsServiceImpl.class);

    @Autowired
    private EventsDetailsDao eventsDetailsDao;

    @Override
    public int saveEvents(EventDetails event) {

        if(!event.getDateStart().equals("") && !event.getTimeStart().equals("")
                && event.getCostEvent() != 0 && event.getCategoryEvents()!=null){
            log.info("Save event details with success");
            return eventsDetailsDao.saveEvents(event);
        }else {
            log.info("Can't save event details because of illegal argument");
            return 0;
        }

    }

    @Override
    public EventDetails getEventById(Integer id) {
        if(id != null && id > 0){
            log.info("Get event details by id = " + id + " with success");
            return eventsDetailsDao.getEventById(id);
        }else {
            log.info("Can't get event details by id because of illegal argument");
            return null;
        }

    }

    @Override
    public List<EventDetails> findAll() {
        return eventsDetailsDao.findAll();
    }

    @Override
    public int deleteEvent(Long id) {
        if(id != null && id > 0) {
            log.info("Delete event details by id = " + id + " with success");
            return eventsDetailsDao.deleteEvent(id);
        }else{
            log.info("Can't delete event details because of illegal argument");
            return 0;
        }

    }

    @Override
    public int updateEvent(EventDetails event) {
        if(!event.getDateStart().equals("") && !event.getTimeStart().equals("")
                && event.getCostEvent() != 0 && event.getCategoryEvents()!=null) {
            log.info("Update event details by id = " + event.getId() + " with success");
            return eventsDetailsDao.updateEvent(event);
        }else{
            log.info("Can't update event details by id because of illegal argument");
            return 0;
        }
    }
}
