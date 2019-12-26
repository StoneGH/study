package com.study.ssh.service;

import com.study.ssh.entity.User;

import java.util.List;

/**
 * Created by shitao on 2017/3/2.
 */
public interface UserService {
    User getById(String id);

    List<User> queryAll();
}
