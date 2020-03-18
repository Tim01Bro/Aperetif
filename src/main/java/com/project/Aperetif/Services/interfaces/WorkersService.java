package com.project.Aperetif.Services.interfaces;

import com.project.Aperetif.Model.Workers;

import java.util.List;

public interface WorkersService {

    int saveWorker(Workers worker);

    Workers getOneWorkerById(Long idWorker);

    Workers getOneWorkerByName(String name);

    List<Workers> findAllWorker();

    int updateWorker(Workers worker);

    int deleteWorker(Long idWorker);

}
