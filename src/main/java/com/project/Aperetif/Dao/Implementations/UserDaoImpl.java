package com.project.Aperetif.Dao.Implementations;

import com.project.Aperetif.Dao.Interfaces.UserDao;
import com.project.Aperetif.Dao.Mappers.UserMapper;
import com.project.Aperetif.Model.Users;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final Logger log = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public UserDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public int saveUser(Users user) {
        String sql = "INSERT INTO " +
                "users(username,email,passworduser,roleuserid) values(?,?,?,?)";
        log.info("Save user in database to users table");
        return jdbcTemplate.update(sql,
                user.getUsername(),user.getEmail(),user.getPassword(),user.getRole().getIndexForDb());
    }

    @Override
    public Users getUserById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        log.info("Get user by id = " + id);
        return jdbcTemplate.queryForObject(sql, new UserMapper(), id);
    }

    @Override
    public Users getUserByName(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        log.info("Get user by name = " + username);
        return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
    }

    @Override
    public List<Users> findAll() {
        String sql = "SELECT * FROM users";
        log.info("Find all user");
        return jdbcTemplate.query(sql,new UserMapper());
    }

    @Override
    public int deleteUser(Long id) {
        String sql = "delete from users where id = ?";
        log.info("Delete user by id =" + id);
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public int update(Users users) {
        String sql = "UPDATE users SET  username = ? , email = ?, passworduser = ?," +
                "roleuserid=? WHERE id = ?";
        log.info("Update users");
        return jdbcTemplate.update(sql,users.getUsername(),
                users.getEmail(),users.getPassword(),users.getRole().getIndexForDb(),users.getId());
    }

    @Override
    public boolean ExistsUser(String username) {
        String sql = "SELECT EXISTS(SELECT * from users where username = ?)";
        log.info("Check exsist user by username = " + username);
        return jdbcTemplate.queryForObject(sql,Boolean.class,username);
    }
}
