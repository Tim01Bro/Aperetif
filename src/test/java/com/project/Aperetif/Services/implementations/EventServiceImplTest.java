package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.EventsDao;
import com.project.Aperetif.Model.Events;
import com.project.Aperetif.Services.interfaces.EventService;
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
public class EventServiceImplTest {

    @Autowired
    private EventService eventService;

    @MockBean
    private EventsDao eventsDao;

    @Test
    public void saveEvents() {
        when(eventsDao.saveEvents(new Events("s","s",1,1))).thenReturn(1);
        assertEquals(1,eventService.saveEvents(new Events("s","s",1,1)));
    }

    @Test
    public void getEventById() {
        when(eventsDao.getEventById(1L)).thenReturn(new Events("s","s",1,1));
        assertEquals("s",eventService.getEventById(1L).getNameEvent());
    }

    @Test
    public void getEventByName() {
        when(eventsDao.getEventByName("s")).thenReturn(Stream.of(new Events("s","s",1,1)).collect(Collectors.toList()));
        assertEquals("s",eventService.getEventByName("s").get(0).getDescribeEvent());

    }

    @Test
    public void findAll() {
        when(eventsDao.findAll()).thenReturn(Stream.of(new Events("s","s",1,1)).collect(Collectors.toList()));
        assertEquals(1,eventService.findAll().size());
    }

    @Test
    public void deleteEvent() {
        when(eventsDao.deleteEvent(1L)).thenReturn(1);
        assertEquals(1,eventService.deleteEvent(1L));
    }

    @Test
    public void updateEvent() {
        when(eventsDao.updateEvent(new Events("s","s",1,1))).thenReturn(1);
        assertEquals(1,eventService.updateEvent(new Events("s","s",1,1)));
    }

    @Test
    public void FailedSave(){
        when(eventsDao.saveEvents(new Events("","s",1,1))).thenReturn(0);
        assertEquals(0,eventService.saveEvents(new Events("","s",1,1)));
    }

    @Test
    public void FailedGetById(){
        when(eventsDao.getEventById(-1L)).thenReturn(null);
        assertNull(eventService.getEventById(-1L));
    }
    @Test
    public void FailedGetByName(){
        when(eventsDao.getEventByName("")).thenReturn(null);
        assertNull(eventService.getEventByName(""));
    }
    @Test
    public void FailedDelete(){
        when(eventsDao.deleteEvent(-1L)).thenReturn(0);
        assertEquals(0,eventService.deleteEvent(-1L));
    }

    @Test
    public void FailedUpdate(){
        when(eventsDao.updateEvent(new Events("","",1,1))).thenReturn(0);
        assertEquals(0,eventService.updateEvent(new Events("","",1,1)));
    }
}