package com.study.ssh.service.impl;

import com.study.ssh.dao.UserDao;
import com.study.ssh.entity.User;
import com.study.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by shitao on 2017/3/2.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public User getById(String id) {
        return null;
    }

    public List<User> queryAll() {
        return userDao.findAll();
    }
}
