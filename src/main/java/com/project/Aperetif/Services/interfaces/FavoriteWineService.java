package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.FavoriteWIne;

import java.util.List;

public interface FavoriteWineService {

    int saveFavoriteWine(FavoriteWIne favoriteWIne);

    List<FavoriteWIne> findAll();

    List<FavoriteWIne>findAllByUserId(Long idUser);

    int deleteFavoriteWineById(Long idWine);
}
