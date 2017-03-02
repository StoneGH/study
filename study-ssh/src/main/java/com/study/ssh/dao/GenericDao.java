package com.study.ssh.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by shitao on 2017/3/2.
 */
public interface GenericDao<T, PK extends Serializable> {
    T load(PK id);

    T get(PK id);

    List<T> findAll();

    void persist(T entity);

    PK save(T entity);

    void saveOrUpdate(T entity);

    void delete(PK id);

    void flush();
}
