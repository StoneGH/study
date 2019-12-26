<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link
href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
rel="stylesheet">
<link
href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
rel="stylesheet">
<link rel="stylesheet"
href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css"
type="text/css"></link>
<script type="text/javascript"
src="http://cdn.bootcss.com/jquery/2.2.1/jquery.js"></script>
<script type="text/javascript"
src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.container {
width: 540px !important;
}

form .form-group input {
height: 40px;
}

.vcimg {
border: none;
font-size: 24px;
background: #ccc;
text-align: center;
color: #666;
width: 100%;
}
</style>
<body>
<div class="container">
<h1 class="text-center">SpringSecurity Demo</h1>
<form id="loginForm" class="form-horizontal">
<div class="form-group">
<label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
<div class="col-sm-10">
<input type="text" class="form-control" id="username"
name="username" placeholder="请输入用户名" required="required">
</div>
</div>
<div class="form-group">
<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
<div class="col-sm-10">
<input type="password" class="form-control" id="password"
name="password" placeholder="请输入密码" required="required">
</div>
</div>
<div class="form-group">
<label for="inputPassword3" class="col-sm-2 control-label">验证码</label>
<div class="col-sm-4">
<input type="text" class="form-control" id="verifyCode"
name="verifyCode" placeholder="请输入验证码" required="required">
</div>
<div class="col-sm-6">
<input class="vcimg" type="text" value="1231" readonly="readonly" />
</div>
</div>
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10">
<div class="checkbox">
<label> <input type="checkbox"> 记住密码
</label>
</div>
</div>
</div>
<div class="form-group">
<div class="col-sm-offset-2 col-sm-10">
<button type="submit" class="btn btn-default">Sign in</button>
</div>
</div>
</form>
</div>
</body>

<script type="text/javascript">
$(function() {
/////////////////登录提交////////////////////////////
$("#loginForm")
.submit(
function() {
var username = $("#username").val();
var password = $("#password").val();
var verifyCode = $("#verifyCode").val();
var data = {
username : username,
password : password,
verifyCode : verifyCode
};
var url = "${pageContext.request.contextPath}/loginjson";
$
.ajax({
type : "POST",
url : url,
data : data,
// contentType: "application/json",
dataType : "json",
success : function(result) {
if (result.status == "1") {
location.href = "${pageContext.request.contextPath}/index";
} else {
showErrInfo(result.msg);
}
},
error : function(XMLHttpRequest,
textStatus, errorThrown) {
// alert(XMLHttpRequest.status);
// alert(XMLHttpRequest.readyState);
// alert(textStatus);
//alert(XMLHttpRequest.responseText);
alert('读取超时，请检查网络连接');
}
});
return false;
});
///////////////////验证码更新/////////////
$("#verify").click(
function() {
$(this).attr("src",
"/upsweb/index?timestamp=" + new Date().getTime());
});

});

function showErrInfo(msg) {
$(".error").remove();
$("#loginForm")
.prepend(
"<div class='error'><font color='red'>" + msg
+ "</font></div>");
}

$(function() {
$("#dd").popover();
});
</script>
</html>