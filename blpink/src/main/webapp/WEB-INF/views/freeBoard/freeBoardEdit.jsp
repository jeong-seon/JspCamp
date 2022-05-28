<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Camp24 자유게시판 글 수정</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/user.css">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/freeBoardEdit.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
</head>
<body class="w3-light-grey">
<div class="w3-container">
	<div class="w3-content mxw650 w3-margin-top">
	<!-- 페이지 헤더 -->
	<header class="w3-col w3-card-4 mgb20">
		<h1 class="w3-grey w3-center w3-padding mg0">Camp24 자유게시판 글 수정</h1>
	</header>
	
	<form method="POST" action="/camp24/freeBoard/freeBoardEditProc.cmp" name="frm" id="frm"
			class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding mgb20">
		<input type="hidden" name="mno" value="${DATA.mno}">
		<input type="hidden" name="fbno" value="${DATA.fbno}">
		<input type="hidden" id="stitle" value="${DATA.title}">
		<input type="hidden" id="sbody" value="${DATA.body}">
		
		<div class="w3-col box120 pdAll10">
			<img src="/camp24/resources/img/avatar/${DATA.avatar}" class="inblock avtBox100 w3-border w3-border-gray">
					<span class="mgb10 ft10" style="padding: 40px;"><b>${SID}</b></span>
		</div>
		<div class="w3-rest w3-padding w3-border-left">
				<div class="w3-col w3-border-gray">
					<label for="title"><small><strong>제목</strong></small></label>
					<input name="title" id="title" class="w3-col w3-padding ft12" value="${DATA.title}">
				</div>
				<div class="w3-col w3-margin-top">
					<label for="body"><small><strong>내용</strong></small></label>
					<textarea name="body" id="body" class="w3-col w3-padding ft12 w3-border-gray" style="resize: none; height: 100%;">${DATA.body}</textarea>
					</div>
				</div>
				<input type="hidden" id="nowPage" name="nowPage" value="${param.nowPage}">
	</form>
			<div class="w3-col w3-card-4">
				<div class="w3-third w3-button w3-gray" id="lbtn">리스트</div>
				<div class="w3-third w3-button w3-light-gray" id="rbtn">리셋</div>
				<div class="w3-third w3-button w3-gray" id="ebtn">수정</div>
			</div>
		</div>
	</div>
</body>
</html>
<%@ include file="../footer.jsp" %>