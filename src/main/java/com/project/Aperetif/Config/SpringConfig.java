package com.project.Aperetif.Config;

import com.project.Aperetif.Dao.Implementations.*;
import com.project.Aperetif.Dao.Interfaces.*;
import com.project.Aperetif.Services.implementations.*;
import com.project.Aperetif.Services.interfaces.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.project.Aperetif")
public class SpringConfig {

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Aperetif");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1234");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    public UserDao getUserDao(){
        return new UserDaoImpl(getDataSource());
    }

    @Bean
    public WineDao getWineDao(){
        return new WineDaoImpl(getDataSource());
    }

    @Bean
    public FeedBackDao getFeedBackDao(){
        return new FeedBackDaoImpl(getDataSource());
    }

    @Bean
    public EventsDao getEventsDao() {
        return new EventsDaoImpl(getDataSource());
    }

    @Bean
    public EventsDetailsDao getEventDetailDao () {
        return new EventDetailsDaoImpl(getDataSource());
    }

    @Bean
    public EventVenueDao getEventVenueDao(){
        return new EventVenueDaoImpl(getDataSource());
    }

    @Bean
    public OrdersDao getOrdersDao(){return new OrdersDaoImpl(getDataSource());}

    @Bean
    public WorkersDao getWorkersDao(){return new WorkersDaoImpl(getDataSource());}

    @Bean
    public UserService getUserService(){return new UserServiceImpl();}

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public WineService getWineService(){return new WineServiceImpl();}

    @Bean
    public OrderService getOrderService(){return new OrderServiceImpl();}

    @Bean
    public EventDetailsService getEventDetailsService(){return new EventDetailsServiceImpl();}

    @Bean
    public EventService getEventService(){return new EventServiceImpl();}

    @Bean
    public EventsVenueService getEventVenueService(){return new EventsVenueServiceImpl();}

    @Bean
    public FeedBackService getFeedBackService(){return new FeedBackServiceImpl();}

    @Bean
    public WorkersService getWorkerService(){return new WorkersServiceImpl();}

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FavoriteWinesDao getFavoriteWineDao(){return new FavoriteWineDaoImpl(getDataSource());}

    @Bean
    public FavoriteWineService getFavoriteWineService(){return new FavoriteWineServiceImpl();}
}
