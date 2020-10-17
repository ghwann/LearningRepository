<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
<h1>목록</h1>

<c:if test="${not empty user}">
<h4>${user}님 로그인 되었습니다. <a href="${root}/main.do?action=logout">로그아웃</a></h4>
</c:if>


<table border="1">
<tr>
<td>모델번호</td><td>모델이름</td><td>모델가격</td><td>제조사명</td><td>삭제</td>
</tr>

<form action="${root}/main.do" method="post">
<input type="hidden" name="action" value="dele">
<c:choose>
<c:when test="${empty cars}">
<tr>
<td colspan="5">입력된 정보가 없습니다</td>
</tr>
</c:when>

<c:otherwise>
<c:forEach var="car" items="${cars}">
<tr>
<td><a href="${root}/main.do?action=view&num=${car.num}">${car.num}</a></td>
<td>${car.model}</td>
<td>${car.price}</td>
<td>${car.vname}</td>
<td><input type="checkbox" name="num" value="${car.num}"></td>
</tr>
</c:forEach>
</c:otherwise>
</c:choose>

</table>

<p>
<a href="${root}/main.do?action=regi">등록</a>
<input type="submit" value="삭제"> 

<%-- 
<button><a style="text-decoration:none" href="${root}/main.do?action=regi">등록</a></button>
<input type="submit" value="삭제">
--%>

<%-- 
<a href="${root}/main.do?action=regi">등록</a>
<input type="submit" value="삭제" style="border:none;background:white;text-decoration:underline;font-size:1em;cursor:pointer">
 --%>
</form> 

</body>
</html>