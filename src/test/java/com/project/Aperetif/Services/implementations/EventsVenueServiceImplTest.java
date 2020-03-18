package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.EventVenueDao;
import com.project.Aperetif.Dao.Interfaces.EventsDetailsDao;
import com.project.Aperetif.Model.EventsVenue;
import com.project.Aperetif.Services.interfaces.EventDetailsService;
import com.project.Aperetif.Services.interfaces.EventsVenueService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@SpringBootTest
public class EventsVenueServiceImplTest {

    @Autowired
    private EventsVenueService eventsVenueService;

    @MockBean
    private EventVenueDao eventVenueDao;
    @Test
    public void saveEvents() {
        when(eventVenueDao.saveEvents(new EventsVenue("as","ds","as","sd"))).thenReturn(1);
        assertEquals(1,eventsVenueService.saveEvents(new EventsVenue("as","ds","as","sd")));
    }

    @Test
    public void getEventById() {
        when(eventVenueDao.getEventById(1L)).thenReturn(new EventsVenue("as","ds","as","sd"));
        assertEquals("as",eventsVenueService.getEventById(1L).getPlaceEvent());
    }

    @Test
    public void findAll() {
        when(eventVenueDao.findAll()).thenReturn(Stream.of(new EventsVenue("as","ds","as","sd"),new EventsVenue("as","ds","as","sd")).collect(Collectors.toList()));
        assertEquals(2,eventsVenueService.findAll().size());
    }

    @Test
    public void deleteEvent() {
        when(eventVenueDao.deleteEvent(1L)).thenReturn(1);
        assertEquals(1,eventsVenueService.deleteEvent(1L));
    }

    @Test
    public void updateEvent() {
        when(eventVenueDao.updateEvent(new EventsVenue("as","ds","as","sd"))).thenReturn(1);
        assertEquals(1,eventsVenueService.updateEvent(new EventsVenue("as","ds","as","sd")));
    }

    @Test
    public void FailedSave(){
        when(eventVenueDao.saveEvents(new EventsVenue("","ds","as","sd"))).thenReturn(0);
        assertEquals(0,eventsVenueService.saveEvents(new EventsVenue("","ds","as","sd")));
    }

    @Test
    public void FailedGetById(){
        when(eventVenueDao.getEventById(-1L)).thenReturn(null);
        assertNull(eventsVenueService.getEventById(-1L));
    }

    @Test
    public void FailedDelete(){
        when(eventVenueDao.deleteEvent(-1L)).thenReturn(0);
        assertEquals(0,eventsVenueService.deleteEvent(-1L));
    }

    @Test
    public void FailedUpdate(){
        when(eventVenueDao.updateEvent(new EventsVenue("","ds","as","sd"))).thenReturn(0);
        assertEquals(0,eventsVenueService.updateEvent(new EventsVenue("","ds","as","sd")));
    }
}
