<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test="${userinfo == null}">
	<c:redirect url="/main.do"/>
</c:if>
<c:if test="${userinfo != null}">
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>SSAFY-글수정</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function writeArticle() {
	if(document.getElementById("subject").value == "") {
		alert("제목 입력!!!!");
		return;
	} else if(document.getElementById("content").value == "") {
		alert("내용 입력!!!!");
		return;
	} else {
	  	document.getElementById("writeform").action = "${root}/main.do";
	  	document.getElementById("writeform").submit();
	}
  }
  </script>
</head>
<body>

<div class="container" align="center">
	<div class="col-lg-6" align="right">
	<strong>${userinfo.username}</strong>님 환영합니다.
	<a href="${root}/main.do?act=logout">로그아웃</a>
	</div>
	<div class="col-lg-6" align="center">
		<h2>방명록 글수정</h2>
		<form id="writeform" method="post" action="">
		<input type="hidden" name="act" id="act" value="modify">
		<input type="hidden" name="articleno" id="articleno" value="${article.articleno}">
			<div class="form-group" align="left">
				<label for="subject">제목:</label>
				<input type="text" class="form-control" id="subject" name="subject" value="${article.subject}">
			</div>
			<div class="form-group" align="left">
				<label for="content">내용:</label>
				<textarea class="form-control" rows="15" id="content" name="content">${article.content}</textarea>
			</div>
			<button type="button" class="btn btn-primary" onclick="javascript:writeArticle();">글수정</button>
			<button type="reset" class="btn btn-warning">초기화</button>
		</form>
	</div>
</div>
</body>
</html>
</c:if>