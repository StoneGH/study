package org.study.java.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Administrator on 2017/7/4 0004.
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/study?user=root&password=&useUnicode=true&characterEncoding=utf8");
        Statement statement = connection.createStatement();
//        boolean bool = statement.execute("insert into student values(1,'张三',1,21);");
        ResultSet resultSet = statement.executeQuery("select * from student");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.println("id:" + id + ",name:" + name);
        }
        statement.close();
        connection.close();
    }
}
