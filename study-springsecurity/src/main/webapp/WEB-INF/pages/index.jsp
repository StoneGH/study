<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<html>
<body>
<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Welcome : ${pageContext.request.userPrincipal.name} | <a
            href="${pageContext.request.contextPath }/logout"> Logout</a>
    </h2>
</c:if>
<ul>
    <li><a href="${pageContext.request.contextPath }/admin">管理页</a></li>
    <li><a href="${pageContext.request.contextPath }/data">数据页</a></li>
</ul>
</body>
</html>