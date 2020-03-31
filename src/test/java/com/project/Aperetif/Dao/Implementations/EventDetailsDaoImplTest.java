package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.EventsDetailsDao;
import com.project.Aperetif.Model.EventDetails;
import com.project.Aperetif.Model.enums.CategoryEvent;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.Assert.*;

public class EventDetailsDaoImplTest {

    private EventsDetailsDao eventsDetailsDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        eventsDetailsDao = new EventDetailsDaoImpl(dataSource);
    }

    @Test
    public void saveEvents() {
        EventDetails ev = new EventDetails("123","123",123, CategoryEvent.WINE_TASTING);
        assertTrue(eventsDetailsDao.saveEvents(ev)>0);

    }

    @Test
    public void getEventById() {
        EventDetails ev = eventsDetailsDao.getEventById(2);
        assertNotNull(ev);
    }

    @Test
    public void findAll() {
        List<EventDetails>evList = eventsDetailsDao.findAll();
        assertTrue(evList.size() > 0);
    }
    @Test
    public void updateEvent() {
        EventDetails ev = eventsDetailsDao.getEventById(3);
        ev.setTimeStart("23asdasdsadasd2");
        assertTrue(eventsDetailsDao.updateEvent(ev) > 0);
    }

    @Test
    public void deleteEvent() {
        assertTrue(eventsDetailsDao.deleteEvent(2L)>0);
    }


}