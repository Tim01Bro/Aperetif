package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.UserDao;
import com.project.Aperetif.Dao.Interfaces.WineDao;
import com.project.Aperetif.Model.Wine;
import com.project.Aperetif.Services.interfaces.UserService;
import com.project.Aperetif.Services.interfaces.WineService;
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
public class WineServiceImplTest {

    @Autowired
    private WineService wineService;

    @MockBean
    private WineDao wineDao;

    @Test
    public void saveWine() {
        when(wineDao.saveWine(new Wine("Wine",12,23,"wine",12,"asd","sdas"))).thenReturn(1);
        assertEquals(1,wineService.saveWine(new Wine("Wine",12,23,"wine",12,"asd","sdas")));

    }

    @Test
    public void getWineById() {
        when(wineDao.getWineById(1L)).thenReturn(new Wine("Wine",12,23,"wine",12,"asd","sdas"));
        assertEquals("Wine",wineService.getWineById(1L).getNameWine());
    }

    @Test
    public void getWineByName() {
        when(wineDao.getWineByName("Wine")).thenReturn(new Wine("Wine",12,23,"wine",12,"asd","sdas"));
        assertEquals(Integer.valueOf(12),wineService.getWineByName("Wine").getQuantity());
    }

    @Test
    public void findAll() {
        when(wineDao.findAll()).thenReturn(Stream.of(new Wine("Wine",12,23,"wine",12,"asd","sdas")).collect(Collectors.toList()));
        assertEquals(1,wineService.findAll().size());
    }

    @Test
    public void deleteWine() {
        when(wineDao.deleteWine(1L)).thenReturn(1);
        assertEquals(1,wineService.deleteWine(1L));
    }

    @Test
    public void update() {
        when(wineDao.update(new Wine("Wine",12,23,"wine",12,"asd","sdas"))).thenReturn(1);
        assertEquals(1,wineService.update(new Wine("Wine",12,23,"wine",12,"asd","sdas")));
    }

    @Test
    public void FailedSave(){
        when(wineDao.saveWine(new Wine("",12,23,"wine",12,"asd","sdas"))).thenReturn(0);
        assertEquals(0,wineService.saveWine(new Wine("Wine",12,23,"wine",12,"asd","sdas")));
    }

    @Test
    public void FailedGetWineById(){
        when(wineDao.getWineById(-1L)).thenReturn(null);
        assertNull(wineService.getWineById(-1L));
    }

    @Test
    public void FailedGetName(){
        when(wineDao.getWineByName("")).thenReturn(null);
        assertNull(wineService.getWineByName(""));
    }

    @Test
    public void FailedDelete(){
        when(wineDao.deleteWine(-1L)).thenReturn(0);
        assertEquals(0,wineService.deleteWine(-1L));
    }

    @Test
    public void FailedUpdate(){
        when(wineDao.update(new Wine("",12,23,"wine",12,"asd","sdas"))).thenReturn(0);
        assertEquals(0,wineService.update(new Wine("",12,23,"wine",12,"asd","sdas")));
    }
}