package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.WineDao;
import com.project.Aperetif.Dao.Interfaces.WorkersDao;
import com.project.Aperetif.Model.Workers;
import com.project.Aperetif.Model.enums.PositionWorker;
import com.project.Aperetif.Services.interfaces.WineService;
import com.project.Aperetif.Services.interfaces.WorkersService;
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
public class WorkersServiceImplTest {

    @Autowired
    private WorkersService workersService;

    @MockBean
    private WorkersDao workersDao;

    @Test
    public void saveWorker() {
        when(workersDao.saveWorker(new Workers("sd","sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda"))).thenReturn(1);
        assertEquals(1,workersService.saveWorker(new Workers("sd",
                "sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda")));

    }

    @Test
    public void getOneWorkerById() {
        when(workersDao.getOneWorkerById(1L)).thenReturn(new Workers("sd",
                "sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda"));
        assertEquals("sd",workersService.getOneWorkerById(1L).getNameWorker());
    }

    @Test
    public void getOneWorkerByName() {
        when(workersDao.getOneWorkerByName("sa")).thenReturn(new Workers("sa","sds",
                "sds","sds", PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda"));
        assertEquals("sa",workersService.getOneWorkerByName("sa").getNameWorker());
    }

    @Test
    public void findAllWorker() {
        when(workersDao.findAllWorker()).thenReturn(Stream.of(new Workers("sd","sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda"),new Workers("sd","sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda")).collect(Collectors.toList()));
        assertEquals(2,workersService.findAllWorker().size());
    }

    @Test
    public void updateWorker() {
        when(workersDao.updateWorker(new Workers("sd","sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda"))).thenReturn(1);
        assertEquals(1,workersService.updateWorker(new Workers("sd","sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda")));
    }

    @Test
    public void deleteWorker() {
        when(workersDao.deleteWorker(1L)).thenReturn(1);
        assertEquals(1,workersService.deleteWorker(1L));
    }

    @Test
    public void FailedSave(){
        when(workersDao.saveWorker(new Workers("","sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda"))).thenReturn(1);
        assertEquals(0,workersService.saveWorker(new Workers("",
                "sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda")));
    }

    @Test
    public void FailedgetOneWorkerById(){
        when(workersDao.getOneWorkerById(-1L)).thenReturn(null);
        assertNull(workersService.getOneWorkerById(-1L));
    }

    @Test
    public void FailedgetOneWorkerByName(){
        when(workersDao.getOneWorkerByName("")).thenReturn(null);
        assertNull(workersService.getOneWorkerByName(""));
    }

    @Test
    public void FailedUpdate(){
        when(workersDao.updateWorker(new Workers("","sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda"))).thenReturn(0);
        assertEquals(0,workersService.updateWorker(new Workers("","sds","sds","sds",
                PositionWorker.WINEMAKER_SENIOR,
                "sd","ssda","sda")));
    }
    @Test
    public void FailedDelete(){
        when(workersDao.deleteWorker(-1L)).thenReturn(0);
        assertEquals(0,workersService.deleteWorker(-1L));
    }
    
}