package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Model.FeedBack;
import com.project.Aperetif.Model.Users;

import java.util.List;

public interface FeedBackDao {
    int saveFeedBack(FeedBack fd);

    FeedBack getFeedBackById(Long id);

    FeedBack getFeedByNameSender(String namesender);

    List<FeedBack> findAll();

    int deleteFeedBack(Long id);
}
