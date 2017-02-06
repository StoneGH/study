<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="http://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>
</head>
<body>
	<form id="loginForm">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input id="username" type="text" name="username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input id="password" type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input id="loginBtn"
					type="submit" value=" 登录 " /> <input type="reset" value=" 重置 " /></td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	$(function() {
		var username = $("#username").val();
		var password = $("#password").val();
		$("#loginForm").submit(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/login.json",
				type : "post",
				dataType : "json",
				// 				data : {
				// 					"username" : username,
				// 					"password" : password
				// 				},
				data : $("#loginForm").serialize(),
				success : function(ret) {
					alert(ret.message);
				}
			});
		});
	});
</script>
</html>