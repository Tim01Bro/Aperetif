package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.WorkersDao;
import com.project.Aperetif.Dao.Mappers.WorkersMapper;
import com.project.Aperetif.Model.Workers;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class WorkersDaoImpl implements WorkersDao {
    private static final Logger log = Logger.getLogger(WorkersDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public WorkersDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int saveWorker(Workers worker) {
        String sql ="INSERT INTO workers(id,nameworker,sonameworker,filename,describeworker," +
                "positionworkerid,linkfacebook,linktwitter,linklinkedin) values(?,?,?,?,?,?,?,?,?)";
        log.info("Save worker to database to table workers");
        return jdbcTemplate.update(sql,worker.getId(),worker.getNameWorker(),worker.getSonameWorker()
                ,worker.getFilename(),worker.getDescribe(),
                worker.getPositionWorkers().getIndexForDb(),worker.getLinkFacebook(),worker.getLinkTwitter(),
                worker.getLingLinkedIN());
    }

    @Override
    public Workers getOneWorkerById(Long idWorker) {
        String sql ="SELECT * FROM workers WHERE id = ?";
        log.info("Get one worker by id = "+idWorker);
        return jdbcTemplate.queryForObject(sql,new WorkersMapper(),idWorker);
    }

    @Override
    public Workers getOneWorkerByName(String name) {
        String sql ="SELECT * FROM workers WHERE nameworker = ?";
        log.info("Get one worker by name = " + name);
        return jdbcTemplate.queryForObject(sql,new WorkersMapper(),name);
    }

    @Override
    public List<Workers> findAllWorker() {
        String sql ="SELECT * FROM workers";
        log.info("Get all workers");
        return jdbcTemplate.query(sql,new WorkersMapper());
    }

    @Override
    public int updateWorker(Workers worker) {
        String sql ="UPDATE workers SET nameworker = ?, sonameworker = ?,filename=?," +
                "describeworker = ?,positionworkerid=?,linkfacebook=?,linktwitter=?,linklinkedin=? WHERE id = ?";
        log.info("Update worker by id = " + worker.getId());
        return jdbcTemplate.update(sql,worker.getNameWorker(),worker.getSonameWorker(),worker.getDescribe(),
                worker.getFilename(),worker.getPositionWorkers().getIndexForDb(),
                worker.getLinkFacebook(),worker.getLinkTwitter(),worker.getLingLinkedIN(),worker.getId());
    }

    @Override
    public int deleteWorker(Long idWorker) {
        String sql ="DELETE FROM workers WHERE id = ?";
        log.info("Delete worker by id = " + idWorker);
        return jdbcTemplate.update(sql,idWorker);
    }
}
