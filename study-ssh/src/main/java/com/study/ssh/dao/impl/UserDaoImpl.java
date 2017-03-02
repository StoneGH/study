package com.study.ssh.dao.impl;

import com.study.ssh.dao.UserDao;
import com.study.ssh.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shitao on 2017/3/2.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public User load(Integer id) {
        return (User) this.getCurrentSession().load(User.class, id);
    }

    public User get(Integer id) {
        return (User) this.getCurrentSession().get(User.class, id);
    }

    public List<User> findAll() {
        return this.getCurrentSession().createQuery("from User").list();
    }

    public void persist(User entity) {
        this.getCurrentSession().persist(entity);
    }

    public Integer save(User entity) {
        return (Integer) this.getCurrentSession().save(entity);
    }

    public void saveOrUpdate(User entity) {
        this.getCurrentSession().saveOrUpdate(entity);
    }

    public void delete(Integer id) {
        this.getCurrentSession().delete(id);
    }

    public void flush() {
        this.getCurrentSession().flush();
    }
}
