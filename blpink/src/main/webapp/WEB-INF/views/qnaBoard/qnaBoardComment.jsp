<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Camp24 QnA 게시판 답변 작성</title>
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/user.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/qnaBoardComment.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>
<style type="text/css">
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
	.box120 {
		width: 135px;
		height: auto;
	}
	.mid {
		position: relative;
		top: 5px;
		right: 5px;
	}
</style>
</head>
<body class="w3-light-grey">
<div class="w3-container">
	<div class="w3-content mxw750 w3-margin-top">
		<!-- 페이지 헤더 -->
		<header class="w3-col w3-card-4 mgb20">
			<h1 class="w3-gray w3-center w3-padding mg0">Camp24 QnA 게시판 답변 작성</h1>
		</header>
		
		<!-- 페이지 본문 -->
		<div class="w3-col">
			<div class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding">
				<div class="w3-col box120 pdAll10 w3-border-right">
					<img src="/camp24/resources/img/avatar/${DATA.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
					<span class="w3-col w3-center ft10 mid"><b>${SID}</b></span>
				</div>
				<div class="w3-rest w3-padding">
					<div class="w3-col w3-border-bottom">
						<span class="w3-col w3-left mgb10 ft10"><strong>질문 내용 : </strong> ${DATA.body}</span>
					</div>
					<form method="POST" action="" id="frm" name="frm" class="w3-col w3-margin-top">
						<input type="hidden" id="nowPage" name="nowPage" value="${param.nowPage}">
						<input type="hidden" id="mno" name="mno" value="${DATA.mno}">
						<input type="hidden" id="qno" name="qno" value="${param.qno}">
						<textarea class="w3-col w3-padding ft12" id="body" name="body" style="resize: none;"></textarea>
					</form>
				</div>
			</div>
		</div>
		
		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-third w3-button w3-gray" id="listbtn">리스트</div>
			<div class="w3-third w3-button w3-light-gray" id="reset">리셋</div>
			<div class="w3-third w3-button w3-gray" id="cmtbtn">답변 등록</div>
		</div>
	</div>
</div>
</body>
</html>
<%@ include file="../footer.jsp" %>