package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.FeedBack;

import java.util.List;

public interface FeedBackService {
    int saveFeedBack(FeedBack fd);

    FeedBack getFeedBackById(Long id);

    FeedBack getFeedByNameSender(String namesender);

    List<FeedBack> findAll();

    int deleteFeedBack(Long id);
}
