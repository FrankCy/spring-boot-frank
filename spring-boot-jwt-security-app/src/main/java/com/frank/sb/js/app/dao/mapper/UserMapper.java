package com.frank.sb.js.app.dao.mapper;

import com.frank.sb.js.app.domain.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMapper extends JpaRepository<User, Long>  {
    /**
     * Find by username user.
     *
     * @param username the username
     * @return the user
     */
    User findByUsername(String username);

}
