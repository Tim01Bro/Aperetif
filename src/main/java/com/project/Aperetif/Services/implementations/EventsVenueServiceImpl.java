package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.EventVenueDao;
import com.project.Aperetif.Dao.Interfaces.EventsDao;
import com.project.Aperetif.Model.EventsVenue;
import com.project.Aperetif.Services.interfaces.EventsVenueService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventsVenueServiceImpl implements EventsVenueService {

    private static final Logger log = Logger.getLogger(EventsVenueServiceImpl.class);

    @Autowired
    private EventVenueDao eventVenueDao;

    @Override
    public int saveEvents(EventsVenue event) {
        if(!event.getAddressEvent().equals("") && !event.getPhoneEvent().equals("")
                && !event.getPlaceEvent().equals("") && !event.getWebSiteEvent().equals("")){
            log.info("Save event venue with success");
            return eventVenueDao.saveEvents(event);
        }else{
            log.info("Can't save event venue because of illegal argument");
            return 0;
        }

    }

    @Override
    public EventsVenue getEventById(Long id) {
        if(id!=null&&id>0){
            log.info("Get event venue by id = " + id + " with success");
            return eventVenueDao.getEventById(id);
        }else {
            log.info("Can't get venue by id because of illegal argument");
            return null;
        }

    }

    @Override
    public List<EventsVenue> findAll() {
        return eventVenueDao.findAll();
    }

    @Override
    public int deleteEvent(Long id) {
        if(id!=null&&id>0) {
            log.info("Delete event venue by id = " + id + " with success");
            return eventVenueDao.deleteEvent(id);
        }else{
            log.info("Can't get venue by id because of illegal argument");
            return 0;
        }

    }

    @Override
    public int updateEvent(EventsVenue event) {
        if(!event.getAddressEvent().equals("") && !event.getPhoneEvent().equals("")
                && !event.getPlaceEvent().equals("") && !event.getWebSiteEvent().equals("")){
            log.info("Update event venue with success");
            return eventVenueDao.updateEvent(event);
        }else{
            log.info("Can't update event venue because of illegal argument");
            return 0;
        }
    }
}
