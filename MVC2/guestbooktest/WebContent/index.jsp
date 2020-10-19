<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>SSAFY</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div align="center">
<h3>SSAFY 방명록!!!(JSP)</h3>
<c:if test="${userinfo == null}">
<h3>${msg}</h3>
<%@ include file="/user/login.jsp" %>
</c:if>
<c:if test="${userinfo != null}">
<div>
<strong>${userinfo.username}</strong>님 환영합니다.
<a href="${root}/main.do?act=logout">로그아웃</a>
</div>
<a href="${root}/main.do?act=mvwrite">글쓰기</a><br>
<a href="${root}/main.do?act=list&key=&word=">글목록</a>
</c:if>
</div>
</body>
</html>