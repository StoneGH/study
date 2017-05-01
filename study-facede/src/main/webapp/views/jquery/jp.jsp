<%--
  Created by IntelliJ IDEA.
  User: shitao
  Date: 2017/5/1
  Time: 下午4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jquery插件</title>
    <%@ include file="../public.jsp" %>
</head>
<body>
<h3>jquery插件</h3>
<div>123123</div>
<%--<script type="text/javascript" src="${ctx}/resources/plugins/jquery/jp.js"/>--%>
<script type="text/javascript">
    $(function () {
        if (jQuery) {

            alert("jQuery library is loaded!");

        } else {

            alert("jQuery library is not found!");

        }
        $("div").bold();
    });
</script>
</body>
</html>
