package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.EventsDetailsDao;
import com.project.Aperetif.Dao.Mappers.EventDetailsMapper;
import com.project.Aperetif.Model.EventDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EventDetailsDaoImpl implements EventsDetailsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(EventDetailsDaoImpl.class);

    public EventDetailsDaoImpl(DataSource dataSource){

        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public int saveEvents(EventDetails event) {
        String sql = "INSERT INTO eventdetails( datestart, timestart, costevent, categoryevent)" +
                " values (?,?,?,?)";
        log.info("Save eventdetails to database to table eventdetails");
        return jdbcTemplate.update(sql,event.getDateStart(),
                event.getTimeStart(),event.getCostEvent(),event.getCategoryEvents().getIndexForDb());
    }

    @Override
    public EventDetails getEventById(Integer id) {
        String sql = "SELECT * FROM eventdetails WHERE id = ?";
        log.info("Get one eventdetailes by id = "+id);
        return jdbcTemplate.queryForObject(sql,new EventDetailsMapper(),id);
    }

    @Override
    public List<EventDetails> findAll() {
        String sql = "SELECT * FROM eventdetails";
        log.info("Get all eventdetails");
        return jdbcTemplate.query(sql,new EventDetailsMapper());
    }

    @Override
    public int deleteEvent(Long id) {
        String sql = "DELETE FROM eventdetails WHERE id = ?";
        log.info("Delete eventdetails by id = " + id);
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateEvent(EventDetails event) {
        String sql = "UPDATE eventdetails  SET datestart = ?,timestart=?,costevent=?,categoryevent=? WHERE id = ?";
        log.info("Update eventdetails by id = " + event.getId());
        return jdbcTemplate.update(sql,event.getDateStart(),
                event.getTimeStart(),event.getCostEvent(),event.getCategoryEvents().getIndexForDb(),event.getId());
    }
}
