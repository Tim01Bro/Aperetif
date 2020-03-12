package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.EventsDao;
import com.project.Aperetif.Dao.Mappers.EventsMapper;
import com.project.Aperetif.Model.Events;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EventsDaoImpl implements EventsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(EventsDaoImpl.class);

    public EventsDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int saveEvents(Events ev) {
        String sql = "INSERT INTO events(id,nameevent,describeevent,eventdetailsid,eventsvenueid)" +
                "values(?,?,?,?,?)";
        log.info("Save events to database to table events");
        return jdbcTemplate.update(sql,ev.getId(),ev.getNameEvent(),ev.getDescribeEvent(),
                ev.getEventDetailsId(),ev.getEventsVenueId());
    }

    @Override
    public Events getEventById(Long id) {
        String sql = "SELECT * FROM events WHERE id = ?";
        log.info("Get one event by id = " + id);
        return jdbcTemplate.queryForObject(sql,new EventsMapper(),id);
    }

    @Override
    public Events getEventByName(String name) {
        String sql = "SELECT * FROM events WHERE nameevent = ?";
        log.info("Get one event by name = " + name);
        return jdbcTemplate.queryForObject(sql,new EventsMapper(),name);
    }

    @Override
    public List<Events> findAll() {
        String sql = "SELECT * FROM events";
        log.info("Get all events");
        return jdbcTemplate.query(sql,new EventsMapper());
    }

    @Override
    public int deleteEvent(Long id) {
        String sql = "DELETE FROM events WHERE id = ?";
        log.info("Delete event by id = " + id);
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateEvent(Events event) {
        String sql  = "UPDATE events SET nameevent = ?,describeevent = ?" +
                ",eventdetailsid = ?,eventsvenueid=? WHERE id = ?";
        log.info("Update event by id = " + event.getId());
        return jdbcTemplate.update(sql,
                event.getNameEvent(),event.getDescribeEvent(),event.getEventDetailsId(),
                event.getEventsVenueId(),event.getId());
    }
}
