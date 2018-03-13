<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<c:set var="ctx" value="<%=basePath%>"></c:set>
<script type="text/javascript">
    var $ctx = '${ctx}';
</script>
<script type="text/javascript" charset="utf8" src="${ctx}/resources/plugins/jquery/jquery-2.2.1.min.js"></script>
