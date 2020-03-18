package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.FeedBackDao;
import com.project.Aperetif.Dao.Interfaces.OrdersDao;
import com.project.Aperetif.Model.FeedBack;
import com.project.Aperetif.Services.interfaces.FeedBackService;
import com.project.Aperetif.Services.interfaces.OrderService;
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
public class FeedBackServiceImplTest {

    @Autowired
    private FeedBackService feedBackService;

    @MockBean
    private FeedBackDao feedBackDao;

    @Test
    public void saveFeedBack() {
        when(feedBackDao.saveFeedBack(new FeedBack("sa","sa","sa","sa"))).thenReturn(1);
        assertEquals(1,feedBackService.saveFeedBack(new FeedBack("sa","sa","sa","sa")));
    }

    @Test
    public void getFeedBackById() {
        when(feedBackDao.getFeedBackById(1L)).thenReturn(new FeedBack("sa","sa","sa",""));
        assertEquals("sa",feedBackService.getFeedBackById(1L).getNameSender());

    }

    @Test
    public void getFeedByNameSender() {
        when(feedBackDao.getFeedByNameSender("sas")).thenReturn(new FeedBack("sas","sa","sa",""));
        assertEquals("sas",feedBackService.getFeedByNameSender("sas").getNameSender());

    }

    @Test
    public void findAll() {
        when(feedBackDao.findAll()).thenReturn(Stream.of(new FeedBack("sas","sa","sa",""),new FeedBack("sas","sa","sa","")).collect(Collectors.toList()));
        assertEquals(2,feedBackService.findAll().size());
    }

    @Test
    public void deleteFeedBack() {
        when(feedBackDao.deleteFeedBack(1L)).thenReturn(1);
        assertEquals(1,feedBackService.deleteFeedBack(1L));
    }

    @Test
    public void FailedSave(){
        when(feedBackDao.saveFeedBack(new FeedBack("","sa","sa",""))).thenReturn(0);
        assertEquals(0,feedBackService.saveFeedBack(new FeedBack("","sa","sa","sa")));
    }

    @Test
    public void FailedgetFeedBackById(){
        when(feedBackDao.getFeedBackById(-1L)).thenReturn(new FeedBack("","sa","sa",""));
        assertNull(feedBackService.getFeedBackById(-1L));

    }
    @Test
    public void FailedGetFeedBackByName(){
        when(feedBackDao.getFeedByNameSender("")).thenReturn(null);
        assertNull(feedBackService.getFeedByNameSender(""));
    }

    @Test
    public void FailedDeleteFeedBack(){
        when(feedBackDao.deleteFeedBack(-1L)).thenReturn(0);
        assertEquals(0,feedBackService.deleteFeedBack(-1L));
    }
}