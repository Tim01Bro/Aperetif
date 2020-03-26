package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.EventsDao;
import com.project.Aperetif.Model.Events;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class EventsDaoImplTest {
    private EventsDao eventsDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        eventsDao = new EventsDaoImpl(dataSource);
    }

    @Test
    public void saveEvents() {
        Events ev = new Events("teasd","asdsa",1,1);
        assertTrue(eventsDao.saveEvents(ev) > 0);
    }

    @Test
    public void getEventById() {
        Events ev = eventsDao.getEventById(1L);
        assertNotNull(ev);
    }

    @Test
    public void getEventByName() {
        Events ev = eventsDao.getEventByName("teasd");
        assertNotNull(ev);
    }

    @Test
    public void findAll() {
        List<Events>ev = eventsDao.findAll();
        assertTrue(ev.size() > 0);
    }

    @Test
    public void updateEvent() {
        Events ev = eventsDao.getEventById(1L);
        ev.setNameEvent("TIM");
        assertTrue(eventsDao.updateEvent(ev) > 0);
    }

    @Test
    public void deleteEvent() {
        assertTrue(eventsDao.deleteEvent(1L) > 0);
    }

}