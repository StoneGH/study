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
        <p>${user.username}</p>
    </c:forEach>
</body>
</html>
