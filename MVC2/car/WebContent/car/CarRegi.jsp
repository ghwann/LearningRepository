<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록</title>
</head>
<body>
<h1>등록</h1>

<c:if test="${not empty user}">
<h4>${user}님 로그인 되었습니다. <a href="${root}/main.do?action=logout">로그아웃</a></h4>
</c:if>

<form action="${root}/main.do" method="post">
<input type="hidden" name="action" value="save">
모델번호 : <input type="text" name="num" value="S20JU1"><br>
모델이름 : <input type="text" name="model" value="SM6"><br>
모델가격 : <input type="text" name="price" value="1100"><br>
제조사명 : <select name="vcode">
           <option value="10" selected>삼성</option>
           <option value="20">현대</option>
           <option value="30">기아</option>
        </select><br>
<input type="submit" value="등록">
<input type="reset" value="취소">
</form>

</body>
</html>