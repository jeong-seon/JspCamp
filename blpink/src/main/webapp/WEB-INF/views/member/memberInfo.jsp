<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Camp24 My Info</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/base.css">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/memberInfo.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>
<style type="text/css">
	.avtbox {
	
	}
	.w3-display-container {
		position: relative;
		top: 10px;
	}
	
	.pdl20 > h4 > span:nth-child(2) {
		position: relative;
		left: 20px;
	}
	.pdl20 {
		position: relative;
		top: 40px;
	}
</style>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
</head>
<body class="w3-light-grey">
<div class="w3-container">
	<%--
		요청시 부가정보 전달용 태그
	 --%>
	 <form method="POST" action="" id="frm" name="frm">
	 	<input type="hidden" name="name" id="sname">
	 	<input type="hidden" name="id" id="sid">
	 </form>

	<div class="w3-content mx650">
<c:if test="${DATA.gen ne 'F'}">
		<h1 class="w3-gray w3-center w3-padding w3-card-4">
	<c:if test="${DATA.id eq SID}">
			마이페이지
	</c:if>
	<c:if test="${DATA.id ne SID}">
			${DATA.name} 회원 정보
	</c:if>
		</h1>
</c:if>
<c:if test="${DATA.gen eq 'F'}">
		<h1 class="w3-gray w3-center w3-padding w3-card-4">
	<c:if test="${DATA.id eq SID}">
			마이페이지
	</c:if>
	<c:if test="${DATA.id ne SID}">
			${DATA.name} 회원 정보
	</c:if>
		</h1>
</c:if>
		<div class="w3-col w3-margin-top w3-padding w3-card-4">
			<div class="w3-display-container w3-col w3-border-right" style="width: 200px; height: 270px;">
				<div class="avtbox w3-display-middle">
					<img class="avtimg" src="/camp24/resources/img/avatar/${DATA.savename}" id="infoavt">
				
				</div>
			</div>
			<div class="w3-rest w3-text-grey pdl20">
				<h4><span class="w3-col m3 w3-left-align">&nbsp;이름 : </span><span class="w3-rest w3-center" id="name">${DATA.name}</span></h4>
				<h4><span class="w3-col m3 w3-left-align">&nbsp;아이디 : </span><span class="w3-rest w3-center" id="id">${DATA.id}</span></h4>
				<h4><span class="w3-col m3 w3-left-align">&nbsp;전화번호 : </span><span class="w3-rest w3-center" id="tel">${DATA.tel}</span></h4>
				<h4><span class="w3-col m3 w3-left-align">&nbsp;이메일 : </span><span class="w3-rest w3-center" id="mail">${DATA.mail}</span></h4>
				<h4><span class="w3-col m3 w3-left-align">&nbsp;성별 : </span><span class="w3-rest w3-center" id="gen">${DATA.gen == 'M' ? "남자":"여자"}</span></h4>
			</div>
		</div>
		<footer class="w3-col w3-margin-top w3-card-4">
<c:if test="${DATA.id eq SID}"><%-- 내 정보를 조회한 경우... --%>
			<div class="w3-half w3-button w3-light-gray" id="ebtn">수정</div>
			<div class="w3-half w3-button w3-dark-gray" id="dbtn">회원탈퇴</div>
</c:if>

		</footer>
	</div>
</div>
</body>
</html>
<%@ include file="../footer.jsp" %>