<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<h1>로그인</h1>

<form action="${root}/main.do" method="post">
<input type="hidden" name="action" value="login">
아이디: <input type="text" name="id" value="ssafy"><br>
패스워: <input type="password" name="pw" value="1111"><br>
<input type="submit" value="로그인">
</form>

</body>
</html>