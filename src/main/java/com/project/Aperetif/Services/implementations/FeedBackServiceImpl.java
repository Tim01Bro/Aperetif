package com.project.Aperetif.Services.implementations;

import com.project.Aperetif.Dao.Interfaces.FeedBackDao;
import com.project.Aperetif.Dao.Interfaces.OrdersDao;
import com.project.Aperetif.Model.FeedBack;
import com.project.Aperetif.Services.interfaces.FeedBackService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FeedBackServiceImpl implements FeedBackService {

    private static final Logger log = Logger.getLogger(FeedBackServiceImpl.class);

    @Autowired
    private FeedBackDao feedBackDao;

    @Override
    public int saveFeedBack(FeedBack fd) {
        if(!fd.getCommentSender().equals("")&&!fd.getDateSender().equals("")
        &&!fd.getNameSender().equals("")&&!fd.getSonameSender().equals("")){
            log.info("Save feedback with success");
            return feedBackDao.saveFeedBack(fd);
        }else{
            log.info("Can't save feedback because of illegal argument");
            return 0;
        }

    }

    @Override
    public FeedBack getFeedBackById(Long id) {
        if(id!=null && id > 0){
            log.info("Get feedback by id = " + id + " with success");
            return feedBackDao.getFeedBackById(id);
        }else{
            log.info("Can't get feedback by id because of illegal argument");
            return null;
        }

    }

    @Override
    public FeedBack getFeedByNameSender(String namesender) {
        if(!namesender.equals("")){
            log.info("Get feedback by name = " + namesender + " with success");
            return feedBackDao.getFeedByNameSender(namesender);
        }else{
            log.info("Can't get feedback by name because of illegal argument");
            return null;
        }

    }

    @Override
    public List<FeedBack> findAll() {
        return feedBackDao.findAll();
    }

    @Override
    public int deleteFeedBack(Long id) {
        if (id != null && id > 0) {
            log.info("Delete feedback by id = " + id + " with success");
            return feedBackDao.deleteFeedBack(id);
        }else{
            log.info("Can't delete feedback by id because of illegal argument");
            return 0;
        }
    }
}
