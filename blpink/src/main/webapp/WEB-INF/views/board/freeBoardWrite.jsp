<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 글쓰기</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-black.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/user.css">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/freeBoardWrite.js"></script>
</head>
<body>
	<div class="w3-content mxw650 w3-margin-top">
	<!-- 페이지 헤더 -->
	<header class="w3-col w3-card-4 mgb20">
		<h1 class="w3-grey w3-center w3-padding mg0">CAMP24 자유게시판 글쓰기</h1>
		<nav class="w3-bar w3-dark-grey">
			<div class="w3-col w150 w3-button w3-small w3-black" id="hbtn">home</div>
			<div class="w3-col w150 w3-button w3-small w3-black w3-right" id="obtn">logout</div>
		</nav>
	</header>
	
	<form method="POST" action="/camp24/freeBoard/freeBoardWriteProc.cmp" name="frm" id="frm"
			class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding mgb20">
		<input type="hidden" name="mno" value="${DATA.mno}">
		<div class="w3-col box120 pdAll10 w3-border-right w3-border-black">
			<img src="/camp24/resources/img/avatar/${DATA.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
		</div>
		<div class="w3-rest w3-padding">
				<div class="w3-col w3-border-bottom w3-border-black">
					<span class="mgb10 ft10"><b>${SID}</b></span>
					<p>제목</p>
					<textarea name="title" id="title" style="resize: none;" class="w3-col w3-padding ft12"></textarea>
				</div>
				<div class="w3-col w3-margin-top">
					<span>내용</span>
					<textarea name="body" id="body" class="w3-col w3-padding ft12 w3-border-black" style="resize: none; height: 100%;"></textarea>
					</div>
				</div>
				<input type="hidden" id="nowPage" name="nowPage" value="${param.nowPage}">
			</form>
			<div class="w3-col w3-card-4">
				<div class="w3-third w3-button w3-black" id="lbtn">list</div>
				<div class="w3-third w3-button w3-dark-grey" id="rbtn">reset</div>
				<div class="w3-third w3-button w3-black" id="wbtn">글등록</div>
			</div>
		</div>
</body>
</html>