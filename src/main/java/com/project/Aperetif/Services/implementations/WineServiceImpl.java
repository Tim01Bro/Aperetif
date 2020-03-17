package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.WineDao;
import com.project.Aperetif.Model.Wine;
import com.project.Aperetif.Services.interfaces.WineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WineServiceImpl implements WineService {

    private static final Logger log = Logger.getLogger(WineServiceImpl.class);

    @Autowired
    private WineDao wineDao;

    @Override
    public int saveWine(Wine wine) {
        if(!wine.getNameWine().equals("") && !wine.getDescribe().equals("") &&
           !wine.getDateAdded().equals("")&& !wine.getFilename().equals("")){
            log.info("Save wine with success");
            return wineDao.saveWine(wine);
        }else {
            log.info("Can't save wine illegal argument");
            return 0;
        }
    }

    @Override
    public Wine getWineById(Long id) {
        if(id!=null && id > 0) {
            log.info("Get wine by id = " + id + " with success");
            return wineDao.getWineById(id);
        }else {
            log.info("Can't get wine by id illegal argument");
            return null;
        }
    }

    @Override
    public Wine getWineByName(String name) {
        if(!name.equals("")){
            log.info("Get wine by name = " + name + " with success");
            return wineDao.getWineByName(name);
        }else {
            log.info("Can't get wine by name illegal argument");
            return null;
        }
    }

    @Override
    public List<Wine> findAll() {
        return wineDao.findAll();
    }

    @Override
    public int deleteWine(Long id) {
        if(id!=null && id > 0){
            log.info("Delete wine by id = " + id + " with success");
            return wineDao.deleteWine(id);
        }else {
            log.info("Can't delete wine by id illegal argument");
            return 0;
        }
    }

    @Override
    public int update(Wine wine) {
        if(!wine.getNameWine().equals("") && !wine.getDescribe().equals("") &&
                !wine.getDateAdded().equals("")&& !wine.getFilename().equals("")) {
            log.info("Update wine by id = " + wine.getId() + " with success");
            return wineDao.update(wine);
        }else{
            log.info("Can't update wine by id illegal argument");
            return 0;
        }
    }
}
