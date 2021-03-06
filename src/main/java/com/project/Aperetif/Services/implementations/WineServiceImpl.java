package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.WineDao;
import com.project.Aperetif.Model.Wine;
import com.project.Aperetif.Model.enums.TypeWine;
import com.project.Aperetif.Services.interfaces.WineService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class WineServiceImpl implements WineService {

    private static final Logger log = Logger.getLogger(WineServiceImpl.class);

    @Autowired
    private WineDao wineDao;

    @Value("${upload.path}")
    private String uploadPath;

    @Override
    public int saveWine(Wine wine) {
        if(!wine.getNameWine().equals("") && !wine.getDescribe().equals("") &&
           !wine.getDateAdded().equals("")&& !wine.getFilename().equals("")){
            log.info("Save wine with success");
            wine.setDateAdded(LocalDate.now().toString());
             return wineDao.saveWine(wine);
        }else {
            log.info("Can't save wine because of illegal argument");
            return 0;
        }
    }

    @Override
    public Wine getWineById(Long id) {
        if(id!=null && id > 0) {
            log.info("Get wine by id = " + id + " with success");
            return wineDao.getWineById(id);
        }else {
            log.info("Can't get wine by id because of illegal argument");
            return null;
        }
    }

    @Override
    public List<Wine> getWineByName(String name) {
        if(!name.equals("")){
            log.info("Get wine by name = " + name + " with success");
            return wineDao.getWineByName(name);
        }else {
            log.info("Can't get wine by name because of illegal argument");
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
            log.info("Can't delete wine by because of id illegal argument");
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
            log.info("Can't update wine by because of id illegal argument");
            return 0;
        }
    }

    @Override
    public List<Wine> findByType(TypeWine typeWine) {
        if(typeWine!=null){
            log.info("Get all wine by type");
            return wineDao.findByType(typeWine);
        }else {
            log.info("Can't get wine by type because of  illegal argument");
            return null;
        }
    }

    @Override
    public List<Wine> findByLimitPrice(Integer minPrice, Integer maxPrice) {
        if(minPrice>-1 && maxPrice > -1 && minPrice < maxPrice) {
            log.info("Get all wine by limit price");
            return wineDao.findByLimitPrice(minPrice,maxPrice);
        }else{
            log.info("Can't get wine by limit price because of illegal argument");
            return null;
        }

    }

    public void saveFile(Wine wine, MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();//Уникальное имя файла
            String resultFileName = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFileName));

            wine.setFilename(resultFileName);
        }
    }
}
