package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.Wine;
import com.project.Aperetif.Model.enums.TypeWine;

import java.util.List;

public interface WineService {

    int saveWine(Wine wine);

    Wine getWineById(Long id);

    List<Wine> getWineByName(String name);

    List<Wine> findAll();

    int deleteWine(Long id);

    int update(Wine wine);

    List<Wine>findByType(TypeWine typeWine);

    List<Wine>findByLimitPrice(Integer minPrice,Integer maxPrice);

}
