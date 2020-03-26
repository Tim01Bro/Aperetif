package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.EventsDetailsDao;
import com.project.Aperetif.Model.EventDetails;
import com.project.Aperetif.Model.enums.CategoryEvent;
import com.project.Aperetif.Services.interfaces.EventDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@SpringBootTest
public class EventDetailsServiceImplTest {

    @Autowired
    private EventDetailsService eventDetailsService;

    @MockBean
    private EventsDetailsDao eventsDetailsDao;

    @Test
    public void saveEvents() {
        when(eventsDetailsDao.saveEvents(new EventDetails("as","sa",12, CategoryEvent.WINE_TASTING))).thenReturn(1);
        assertEquals(1,eventDetailsService.saveEvents(new EventDetails("as","sa",12, CategoryEvent.WINE_TASTING)));
    }

    @Test
    public void getEventById() {
        when(eventsDetailsDao.getEventById(1)).thenReturn(new EventDetails("as","sa",12, CategoryEvent.WINE_TASTING));
        assertEquals("as",eventDetailsService.getEventById(1).getDateStart());
    }

    @Test
    public void findAll() {
        when(eventsDetailsDao.findAll()).thenReturn(Stream.of(new EventDetails("as","sa",12, CategoryEvent.WINE_TASTING),new EventDetails("as","sa",12, CategoryEvent.WINE_TASTING)).collect(Collectors.toList()));
        assertEquals(2,eventDetailsService.findAll().size());
    }

    @Test
    public void deleteEvent() {
        when(eventsDetailsDao.deleteEvent(1L)).thenReturn(1);
        assertEquals(1,eventDetailsService.deleteEvent(1L));
    }

    @Test
    public void updateEvent() {
        when(eventsDetailsDao.updateEvent(new EventDetails("as","sa",12, CategoryEvent.WINE_TASTING))).thenReturn(1);
        assertEquals(1,eventDetailsService.updateEvent(new EventDetails("as","sa",12, CategoryEvent.WINE_TASTING)));
    }

    @Test
    public void FailedSave(){
        when(eventsDetailsDao.saveEvents(new EventDetails("","sa",12, CategoryEvent.WINE_TASTING))).thenReturn(0);
        assertEquals(0,eventDetailsService.saveEvents(new EventDetails("as","sa",12, CategoryEvent.WINE_TASTING)));
    }

    @Test
    public void FailedGetEventById(){
        when(eventsDetailsDao.getEventById(-1)).thenReturn(null);
        assertNull(eventDetailsService.getEventById(-1));
    }

    @Test
    public void FailedDelete(){
        when(eventsDetailsDao.deleteEvent(-1L)).thenReturn(0);
        assertEquals(0,eventDetailsService.deleteEvent(-1L));
    }

    @Test
    public void FailedUpdate(){
        when(eventsDetailsDao.updateEvent(new EventDetails("","sa",12, CategoryEvent.WINE_TASTING))).thenReturn(0);
        assertEquals(0,eventDetailsService.updateEvent(new EventDetails("","sa",12, CategoryEvent.WINE_TASTING)));
    }
}