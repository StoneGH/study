<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:url value="/logout" var="logoutUrl" />
		<h2>
			Welcome : ${pageContext.request.userPrincipal.name} | <a
				href="${logoutUrl }"> Logout</a>
		</h2>
	</c:if>

</body>
</html>