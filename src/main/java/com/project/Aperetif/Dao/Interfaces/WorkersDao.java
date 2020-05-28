package com.project.Aperetif.Dao.Interfaces;

import com.project.Aperetif.Dao.Mappers.WorkersMapper;
import com.project.Aperetif.Model.Workers;

import java.util.List;

public interface WorkersDao {

    int saveWorker(Workers worker);

    Workers getOneWorkerById(Long idWorker);

    Workers getOneWorkerByName(String name);

    List<Workers>findAllWorker();

    int updateWorker(Workers worker);

    int deleteWorker(Long idWorker);
}
