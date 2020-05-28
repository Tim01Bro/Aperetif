package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.FavoriteWinesDao;
import com.project.Aperetif.Model.FavoriteWIne;
import com.project.Aperetif.Services.interfaces.FavoriteWineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FavoriteWineServiceImpl implements FavoriteWineService {
    @Autowired
    private FavoriteWinesDao favoriteWinesDao;

    private static final Logger log = Logger.getLogger(FavoriteWineServiceImpl.class);

    @Override
    public int saveFavoriteWine(FavoriteWIne favoriteWIne) {
        if(favoriteWIne!=null &&favoriteWIne.getIdUser()!=null && favoriteWIne.getIdWine()!=null){
            log.info("Save favorite wine by user id and wine id");
            return favoriteWinesDao.saveFavoriteWine(favoriteWIne);
        }else{
            log.info("Can't save favorite wine because of illegal argument");
            return 0;
        }

    }

    @Override
    public List<FavoriteWIne> findAll() {
        log.info("Get all favorite wine");
        return favoriteWinesDao.findAll();
    }

    @Override
    public List<FavoriteWIne> findAllByUserId(Long idUser) {
        if(idUser > 0){
            log.info("Get all favorite wine by user id");
            return favoriteWinesDao.findAllByUserId(idUser);
        }else{
            log.info("Can't get all favorite wine because of illegal argument");
            return null;
        }

    }

    @Override
    public int deleteFavoriteWineById(Long idWine) {
        if(idWine>0){
            log.info("Delete favorite wine by id = " + idWine);
            return favoriteWinesDao.deleteFavoriteWineById(idWine);
        } else{
            log.info("Can't delete favorite wine by id because of illegal argument");
            return 0;
        }
     }
}
