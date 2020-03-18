package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.WineDao;
import com.project.Aperetif.Dao.Interfaces.WorkersDao;
import com.project.Aperetif.Model.Workers;
import com.project.Aperetif.Services.interfaces.WorkersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WorkersServiceImpl implements WorkersService {

    private static final Logger log = Logger.getLogger(WorkersServiceImpl.class);

    @Autowired
    private WorkersDao workersDao;

    @Override
    public int saveWorker(Workers worker) {
        if(!worker.getDescribe().equals("") && !worker.getFilename().equals("")
                && !worker.getNameWorker().equals("") && !worker.getLingLinkedIN().equals("")&&
        !worker.getSonameWorker().equals("") && !worker.getLinkFacebook().equals("")&&
        !worker.getLinkTwitter().equals("")&&worker.getPositionWorkers()!=null){
            log.info("Save worker with success");
            return workersDao.saveWorker(worker);
        }else{
            log.info("Can't save worker because of illegal argument");
            return 0;
        }

    }

    @Override
    public Workers getOneWorkerById(Long idWorker) {
        if(idWorker!=null && idWorker > 0){
            log.info("Get worker by id = " + idWorker + " with success");
            return workersDao.getOneWorkerById(idWorker);
        }else{
            log.info("Can't get worker by id because illegal argument");
            return null;
        }

    }

    @Override
    public Workers getOneWorkerByName(String name) {
        if(!name.equals("")){
            log.info("Get worker by name = " + name + " with success");
            return workersDao.getOneWorkerByName(name);
        }else{
            log.info("Can't get worker name because of illegal argument");
            return null;
        }

    }

    @Override
    public List<Workers> findAllWorker() {
        return workersDao.findAllWorker();
    }

    @Override
    public int updateWorker(Workers worker) {
        if(!worker.getDescribe().equals("") && !worker.getFilename().equals("")
                && !worker.getNameWorker().equals("") && !worker.getLingLinkedIN().equals("")&&
                !worker.getSonameWorker().equals("") && !worker.getLinkFacebook().equals("")&&
                !worker.getLinkTwitter().equals("")&&worker.getPositionWorkers()!=null) {
            log.info("Update worker with success");
            return workersDao.updateWorker(worker);
        }else{
            log.info("Can't update worker because of illegal argument");
            return 0;
        }
    }

    @Override
    public int deleteWorker(Long idWorker) {
        if(idWorker!=null && idWorker > 0){
            log.info("Delete worker by id = " + idWorker + " with success");
            return workersDao.deleteWorker(idWorker);
        }else{
            log.info("Can't delete by id because of illegal argument");
            return 0;
        }
    }
}
