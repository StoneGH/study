package com.stone.sbmc.service.impl;

import com.stone.sbmc.dao.TestDao;
import com.stone.sbmc.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @ClassName: TestServiceImpl
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2020/09/24 09:41
 * @Version: 1.0
 * @Modified By:
 */
@Service
public class TestServiceImpl {

    @Autowired
    private TestDao testDao;


    public List<Test> query() {
        return this.testDao.queryAll();
    }
}
