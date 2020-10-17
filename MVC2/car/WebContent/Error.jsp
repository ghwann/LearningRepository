<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러</title>
</head>
<body>
<h1>에러</h1>
<h4>${msg}</h4>

<p>
<a href="${root}/main.do">메인</a>

</body>
</html>