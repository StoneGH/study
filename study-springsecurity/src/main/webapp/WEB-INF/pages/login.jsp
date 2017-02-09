<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<body>
	<div class="container">
		<header> </header>
		<div id="container_demo">
			<div id="wrapper">
				<div id="login" class="animate form">
					<!--			 <form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'> -->
					<h1>电信融合支付平台</h1>
					<form id='loginForm' method="POST">
						<p>
							<label for="" class="uname" data-icon="u"> 用户名 </label> <input
								id="username" name="username" required="required" type="text"
								placeholder="myusername or mymail@mail.com">
						</p>
						<p>
							<label for="" class="youpasswd" data-icon="p"> 密码 </label> <input
								id="password" name="password" required="required"
								type="password" placeholder="eg. X8df!90EO">
						</p>
						<p>
							<label for="verification" class="verification" data-icon="v">
								验证 </label> <img src="index" id="verify" align="middle" title="看不清，请点我"
								style="cursor: hand;" /><br /> <input type="verification"
								id="verifyCode" name="verifyCode" placeholder="验证码"
								required="required">
						</p>
						<!-- 
								<p class="keeplogin"> 
									<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping"> 
									<label for="loginkeeping">保持登录</label>
								</p>
								 -->
						<p class="login button">
							<input type="submit" id="submitId" value="登录">
						</p>
					</form>
				</div>
			</div>
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
												$(".error").remove();
												$("#loginForm")
														.prepend(
																"<div class='error'><font color='red'>"
																		+ result.msg
																		+ "</font></div>");
												$("#verify")
														.attr(
																"src",
																"/upsweb/index?timestamp="
																		+ new Date()
																				.getTime()); // 刷新验证码
											}
										},
										error : function(XMLHttpRequest,
												textStatus, errorThrown) {
											//	 alert(XMLHttpRequest.status);  
											//	alert(XMLHttpRequest.readyState);  
											//   alert(textStatus);  
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

	$(function() {
		$("#dd").popover();
	});
</script>
</html>