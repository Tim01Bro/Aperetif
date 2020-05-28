package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Config.SpringConfig;
import com.project.Aperetif.Dao.Interfaces.FavoriteWinesDao;
import com.project.Aperetif.Model.FavoriteWIne;
import com.project.Aperetif.Services.interfaces.FavoriteWineService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
@SpringBootTest
public class FavoriteWineServiceImplTest {

    @Autowired
    private FavoriteWineService favoriteWineService;

    @MockBean
    private FavoriteWinesDao favoriteWinesDao;

    @Test
    public void saveFavoriteWine() {
        when(favoriteWinesDao.saveFavoriteWine(new FavoriteWIne(7L,2L,"1231231"))).thenReturn(1);
        Assert.assertEquals(1,favoriteWineService.saveFavoriteWine(new FavoriteWIne(7L,2L,"1231231")));
    }

    @Test
    public void findAll() {
        when(favoriteWinesDao.findAll()).thenReturn(Stream.of(new FavoriteWIne(7L,2L,"1231231"),new FavoriteWIne(7L,2L,"1231231")).collect(Collectors.toList()));
        Assert.assertEquals(2,favoriteWineService.findAll().size());

    }

    @Test
    public void findAllByUserId() {
        when(favoriteWinesDao.findAllByUserId(1L)).thenReturn(Stream.of(new FavoriteWIne(7L,2L,"1231231")).collect(Collectors.toList()));
        Assert.assertEquals(1,favoriteWineService.findAllByUserId(1L).size());
    }

    @Test
    public void deleteFavoriteWineById() {
        when(favoriteWinesDao.deleteFavoriteWineById(1L)).thenReturn(1);
        Assert.assertEquals(1,favoriteWineService.deleteFavoriteWineById(1L));
    }
}