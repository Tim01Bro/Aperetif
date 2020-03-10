package com.project.Aperetif.Config;

import com.project.Aperetif.Dao.Implementations.EventsDaoImpl;
import com.project.Aperetif.Dao.Implementations.FeedBackDaoImpl;
import com.project.Aperetif.Dao.Implementations.UserDaoImpl;
import com.project.Aperetif.Dao.Implementations.WineDaoImpl;
import com.project.Aperetif.Dao.Interfaces.EventsDao;
import com.project.Aperetif.Dao.Interfaces.FeedBackDao;
import com.project.Aperetif.Dao.Interfaces.UserDao;
import com.project.Aperetif.Dao.Interfaces.WineDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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
    public EventsDao getEventsDao(){return new EventsDaoImpl(getDataSource());
    }

}
