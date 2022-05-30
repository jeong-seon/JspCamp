<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Camp24 캠핑장검색</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/search.js"></script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
</head>
<body class="w3-light-grey">
<div class="w3-row w3-padding-64">
	<form method="post" action="/camp24/board/searchBoardList.cmp" id="frm" name="frm"
			class="w3-content w3-center w3-margin-bottom">
		<label class="w3-col m3"><strong style="font-size: 18pt; font-family: Raleway;">캠핑장 검색 : </strong>&nbsp;</label>
		<input type="text" class="w3-col m7 w3-input" placeholder="캠핑장 이름을 입력하세요." id="name" name="input">
		<div class="w3-rest w3-button w3-dark-gray" id="sbtn">검색</div>
	</form>
<c:if test="${empty LIST}">
	<div class="w3-center w3-content w3-padding-32">
		<h4>검색결과가 없습니다.</h4>
		<h4>정확한 캠핑장이름을 검색해주세요.</h4>
	</div>
</c:if>
<c:forEach var="data" items="${LIST}">
<c:if test="${data.facltNm ne '검색결과없음'}">
	<div class="w3-row w3-center w3-padding-64 w3-card-4">
		<div class="w3-margin w3-center">
			<h5>주소 : ${data.addr1} ${param.input}</h5>
			<h5>캠핑장명 : ${data.facltNm}</h5>
			<h5>입지구분 : ${data.lctCl}</h5>
			<h5>업종 : ${data.induty}</h5>
			<h5>캠핑장비대여 가능장비 : ${data.eqpmnLendCl}</h5>
			<h5>캠핑장 전화번호 : ${data.tel}</h5>
			<h5>경도 : ${data.mapX}</h5>
			<h5>위도 : ${data.mapY}</h5>
			<h5>애완동물 출입여부 : ${data.animalCmgCl}</h5>
			<a href="${data.homepage}"><img src="${data.firstImageUrl}"></a>
		</div>
	</div>
</c:if>
</c:forEach>

</div>
	
</body>
</html>
<%@ include file="../footer.jsp" %>