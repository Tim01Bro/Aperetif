package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Model.Wine;

import java.util.List;

public interface WineDao {

    int saveWine(Wine wine);

    Wine getWineById(Long id);

    Wine getWineByName(String name);

    List<Wine> findAll();

    int deleteWine(Long id);

    int update(Wine wine);

}
