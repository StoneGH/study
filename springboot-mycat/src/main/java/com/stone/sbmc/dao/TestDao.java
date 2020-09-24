package com.stone.sbmc.dao;

import com.stone.sbmc.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @ClassName: TestDao
 * @Desc: TODO
 * @Auther: shitao
 * @Date: 2020/09/24 10:51
 * @Version: 1.0
 * @Modified By:
 */
public interface TestDao extends JpaRepository<Test, Integer> {

    @Query(value = "select * from test", nativeQuery = true)
    List<Test> queryAll();
}
