package ibf2022.paf.assessment.server.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.User;

// TODO: Task 3
@Repository
public class UserRepository {

    public static final String FIND_USERBY_USERNAME_SQL = "select * from user where username = ?";

    public static final String INSERT_USER_SQL = "insert into user (user_id, username, name) values (?,?,?)";

    @Autowired
    JdbcTemplate template;

    public Optional<User> findUserByUsername(String username) {
        try {
            User user = template.queryForObject(FIND_USERBY_USERNAME_SQL, BeanPropertyRowMapper.newInstance(User.class), username);
            return Optional.ofNullable(user);
        } catch (DataAccessException e) {
            // handle the exception here
            return Optional.empty();
        }
    }

    public String insertUser(User user) {
        String ID = UUID.randomUUID().toString().substring(0, 8);
        template.update(INSERT_USER_SQL, ID, user.getUsername(), user.getName());
        user.setUserId(ID);

        return ID;
    }

}
