package com.stone.study.dao;

import com.stone.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by shitao on 2018/3/12.
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(User user) {
        int result = jdbcTemplate.queryForObject("", Integer.class);
        return result;
    }
}
