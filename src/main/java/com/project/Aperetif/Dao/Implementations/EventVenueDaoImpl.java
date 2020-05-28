package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.EventVenueDao;
import com.project.Aperetif.Dao.Mappers.EventVenueMapper;
import com.project.Aperetif.Model.EventsVenue;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EventVenueDaoImpl implements EventVenueDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(EventVenueDaoImpl.class);

    public EventVenueDaoImpl(DataSource dataSource){

        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int saveEvents(EventsVenue event) {
        String sql = "INSERT INTO eventsvenue(id, placeevent, addressevent, " +
                "websiteevent, phoneevent) values (?,?,?,?,?)";
        log.info("Save event venue to database to table eventsvenue");
        return jdbcTemplate.update(sql,event.getId(),event.getPlaceEvent(),
                event.getAddressEvent(),event.getWebSiteEvent(),event.getPhoneEvent());
    }

    @Override
    public EventsVenue getEventById(Long id) {
        String sql = "SELECT * FROM eventsvenue WHERE id = ?";
        log.info("Get one event venue by id = " + id);
        return jdbcTemplate.queryForObject(sql,new EventVenueMapper(),id);
    }

    @Override
    public List<EventsVenue> findAll() {
        String sql = "SELECT * FROM eventsvenue";
        log.info("Get all event venue");
        return jdbcTemplate.query(sql,new EventVenueMapper());
    }

    @Override
    public int deleteEvent(Long id) {
        String sql = "DELETE FROM eventsvenue WHERE id = ?";
        log.info("Delete event venue by id = " + id);
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int updateEvent(EventsVenue event) {
        String sql = "UPDATE eventsvenue SET placeevent = ?,addressevent = ?," +
                "websiteevent = ?, phoneevent = ? WHERE id = ?";
        log.info("Update event venue by id = " + event.getId());
        return jdbcTemplate.update(sql,event.getPlaceEvent(),event.getAddressEvent(),event.
                getWebSiteEvent(),event.getPhoneEvent(),event.getId());
    }
}
