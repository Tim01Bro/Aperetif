package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Model.FavoriteWIne;

import java.util.List;

public interface FavoriteWinesDao {

    int saveFavoriteWine(FavoriteWIne favoriteWIne);

    List<FavoriteWIne>findAll();

    List<FavoriteWIne>findAllByUserId(Long idUser);

    int deleteFavoriteWineById(Long idWine);

}
