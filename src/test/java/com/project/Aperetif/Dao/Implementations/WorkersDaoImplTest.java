package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.WorkersDao;
import com.project.Aperetif.Model.Workers;
import com.project.Aperetif.Model.enums.PositionWorker;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class WorkersDaoImplTest {
    private WorkersDao workersDao;

    @Before
    public void setUp(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        workersDao = new WorkersDaoImpl(dataSource);
    }

    @Test
    public void saveWorker() {
        Workers workers = new Workers(1L,"","","","", PositionWorker.WINEMAKER_SENIOR,"","","");
        assertTrue(workersDao.saveWorker(workers) > 0);
    }

    @Test
    public void getOneWorkerById() {
        Workers workers = workersDao.getOneWorkerById(1L);
        assertNotNull(workers);
    }

    @Test
    public void getOneWorkerByName() {
        Workers workers = workersDao.getOneWorkerByName("");
        assertNotNull(workers);
    }

    @Test
    public void findAllWorker() {
        List<Workers> allWorker = workersDao.findAllWorker();
        assertTrue(allWorker.size() > 0);
    }

    @Test
    public void updateWorker() {
        Workers workers = workersDao.getOneWorkerById(1L);
        workers.setNameWorker("Tim");
        assertTrue(workersDao.updateWorker(workers) > 0);
    }

    @Test
    public void deleteWorker() {
        assertTrue(workersDao.deleteWorker(1L)>0);
    }
}