<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Camp24 캠핑장정보</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/w3.css">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
</head>
<body class="w3-light-grey">
<div class="w3-content" style="max-width:1400px">

	<div class="w3-row">
		<div class="w3-col">
			<div class="w3-card-4 w3-margin w3-white w3-center">
				<h2 class="w3-green w3-padding-16 w3-center">캠핑장 정보</h2>
<c:forEach var="data" items="${LIST}">
	<div class="w3-row w3-center w3-padding-64 w3-card-4">
		<div class="w3-margin w3-center">
			<h5>주소 : ${data.addr1}</h5>
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
</c:forEach>
   			</div>
   		</div>
		<hr>
	</div>
	<form method="post" action="/camp24/campapi/campApi.cmp" id="frm" name="frm">
		<div class="w3-row w3-center">
			<div class="w3-button w3-center w3-dark-gray" id="before">이전페이지</div>
			<div class="w3-button w3-center w3-dark-gray" id="next">다음페이지</div>
			<input type="hidden" id="pageno" name="pageno" value="3">
		</div>
	</form>
</div>


</body>
</html>
<%@ include file="../footer.jsp" %>