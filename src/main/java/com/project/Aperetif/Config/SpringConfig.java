package com.project.Aperetif.Config;

import com.project.Aperetif.Dao.Implementations.*;
import com.project.Aperetif.Dao.Interfaces.*;
import com.project.Aperetif.Services.implementations.EventDetailsServiceImpl;
import com.project.Aperetif.Services.implementations.OrderServiceImpl;
import com.project.Aperetif.Services.implementations.UserServiceImpl;
import com.project.Aperetif.Services.implementations.WineServiceImpl;
import com.project.Aperetif.Services.interfaces.EventDetailsService;
import com.project.Aperetif.Services.interfaces.OrderService;
import com.project.Aperetif.Services.interfaces.UserService;
import com.project.Aperetif.Services.interfaces.WineService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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


}
