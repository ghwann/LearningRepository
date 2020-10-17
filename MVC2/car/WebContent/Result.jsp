<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
<h1>결과</h1>
<h4>${msg}</h4>

<c:if test="${not empty user}">
<h4>${user}님 로그인 되었습니다. <a href="${root}/main.do?action=logout">로그아웃</a></h4>
</c:if>

<p>
<a href="${root}/main.do?action=list">목록</a>

</body>
</html>