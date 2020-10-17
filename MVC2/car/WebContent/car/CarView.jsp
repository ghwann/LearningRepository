<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>조회</title>
</head>
<body>
<h1>조회</h1>

<c:if test="${not empty user}">
<h4>${user}님 로그인 되었습니다. <a href="${root}/main.do?action=logout">로그아웃</a></h4>
</c:if>

<table border="1">
<tr><td>모델번호</td><td>${car.num}</td></tr>
<tr><td>모델이름</td><td>${car.model}</td></tr>
<tr><td>모델가격</td><td>${car.price}</td></tr>
<tr><td>제조사명</td><td>${car.vname}</td></tr>
</table>

<p>
<a href="${root}/main.do?action=list">목록</a>
<a href="${root}/main.do?action=dele&num=${car.num}">삭제</a>

</body>
</html>