package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.FeedBackDao;
import com.project.Aperetif.Dao.Mappers.FeedBackMapper;
import com.project.Aperetif.Model.FeedBack;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class FeedBackDaoImpl implements FeedBackDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(UserDaoImpl.class);

    public FeedBackDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int saveFeedBack(FeedBack fd) {
        String sql = "INSERT INTO feedback(id,namesender,sonamesender,commentsender,datesender)values(?,?,?,?,?)";
        log.info("Save feedback to database to table feedback");
        return jdbcTemplate.update(sql,fd.getId(),fd.getNameSender(),fd.getSonameSender(),fd.getCommentSender(),fd.getDateSender());
    }

    @Override
    public FeedBack getFeedBackById(Long id) {
        String sql = "SELECT * FROM feedback WHERE id = ?";
        log.info("Get one feedback by id = " + id);
        return jdbcTemplate.queryForObject(sql,new FeedBackMapper(),id);
    }

    @Override
    public FeedBack getFeedByNameSender(String namesender) {
        String sql = "SELECT * FROM feedback WHERE namesender = ?";
        log.info("Get one feedback by name = " + namesender );
        return jdbcTemplate.queryForObject(sql,new FeedBackMapper(),namesender);
    }

    @Override
    public List<FeedBack> findAll() {
        String sql = "SELECT * FROM feedback";
        log.info("Get all feedback");
        return jdbcTemplate.query(sql,new FeedBackMapper());
    }

    @Override
    public int deleteFeedBack(Long id) {
        String sql = "DELETE FROM feedback WHERE id = ?";
        log.info("Delete feedback by id = " + id);
        return jdbcTemplate.update(sql,id);
    }
}
