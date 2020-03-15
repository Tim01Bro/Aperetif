package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.EventVenueDao;
import com.project.Aperetif.Model.EventsVenue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.Assert.*;

public class EventVenueDaoImplTest {

    private EventVenueDao eventVenueDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        eventVenueDao = new EventVenueDaoImpl(dataSource);
    }
    @Test
    public void saveEvents() {
        EventsVenue ev = new EventsVenue(1L,"Test","Test","test","test");
        assertTrue(eventVenueDao.saveEvents(ev)>0);
    }

    @Test
    public void getEventById() {
        EventsVenue ev = eventVenueDao.getEventById(1L);
        assertNotNull(ev);
    }

    @Test
    public void findAll() {
        List<EventsVenue>allEv = eventVenueDao.findAll();
        assertTrue(allEv.size() > 0);
    }

    @Test
    public void updateEvent() {
        EventsVenue ev = eventVenueDao.getEventById(1L);
        ev.setPhoneEvent("123123123");
        assertTrue(eventVenueDao.updateEvent(ev)>0);
    }

    @Test
    public void deleteEvent() {
        assertTrue(eventVenueDao.deleteEvent(1L) > 0);
    }


}