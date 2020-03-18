package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.Wine;

import java.util.List;

public interface WineService {

    int saveWine(Wine wine);

    Wine getWineById(Long id);

    Wine getWineByName(String name);

    List<Wine> findAll();

    int deleteWine(Long id);

    int update(Wine wine);

}
