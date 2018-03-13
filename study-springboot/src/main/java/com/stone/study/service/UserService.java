package com.stone.study.service;

import com.stone.study.dao.UserDao;
import com.stone.study.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by shitao on 2018/3/13.
 */
@Service
@Transactional//类的所有方法事务增强，如需单个方法添加事务，只需改对应方法上添加改注解
public class UserService {
    @Autowired
    private UserDao userDao;

    public int getMatchCount(User user) {
        return userDao.getMatchCount(user);
    }
}
