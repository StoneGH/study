<%--
  Created by IntelliJ IDEA.
  User: shitao
  Date: 2017/3/2
  Time: 下午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>用户页</h2>
<c:forEach items="${users}" var="user">
    <table>
        <thead>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>昵称</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.nickname}</td>
            <td>${user.status eq "1"?"正常":"非正常" }</td>
            <td><a href="">修改</a><a href="">删除</a></td>
        </tr>
        </tbody>
    </table>
</c:forEach>
</body>
</html>
