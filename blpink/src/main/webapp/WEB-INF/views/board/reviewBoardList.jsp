 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Camp24 방문후기 게시판</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/user.css">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/reboard.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
</head>
<body class="w3-light-grey">
<div class="w3-container">
<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main">
<h2 class="w3-green w3-padding-16 w3-center">방문후기 게시판</h2>
  <div class="w3-row w3-padding-64">
  
  <div class="w3-button w3-green w3-hover-lime w3-right" id="wbtn">리뷰 쓰기</div>
<%--  <c:if test="${not empty SID}"> --%>
<!-- 				<div class="w3-button w3-cyan w3-hover-lime w3-right" id="manbtn">리뷰관리</div> -->
<%-- </c:if> --%>

<%-- <c:forEach var="data" items="${LIST}">
  <div class="w3-row">
    <div class="w3-twothird w3-container">
<c:if test="${SID eq data.id}">
				<div class="w3-button w3-grey w3-hover-red w3-right" 
				style="position:relative; top:30px;" id="debtn">리뷰삭제</div>
</c:if>
      <h1 class="w3-text-teal">${data.title}</h1>
      <span>${data.body}</span>
      <div class="w3-col box120 pdAll10 w3-border-right" style="width: 135px;">
		<img src="/camp24/resources/img/avatar/${data.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
	      <span class="w3-col w3-center" style="display: inline-block">${data.id}</span>
		</div>
    </div>
    
    </div>
  </c:forEach> --%>
  	<form method="POST" action="/camp24/board/reBoardWriteProc.cmp" id="Frm" name="Frm">
			<input type="hidden" name="title" id="title" value="${data.title}">
			<input type="hidden" name="body" id="body" value="${data.body}">
			<input type="hidden" name="id" id="id" value="${data.id}">
			<input type="hidden" name="rno" id="rno" value="${data.rno}">
			
	</form>

<c:forEach var="data" items="${LIST}">
		<div class="w3-col">
			<div class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding">
				<div class="w3-col box120 pdAll10 w3-border-right" style="width: 135px;">
					<img src="/camp24/resources/img/avatar/${data.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
				</div>
				<div class="w3-rest w3-padding">
					<div class="w3-col w3-border-bottom">
						<div class="w3-cell w3-right" id="${data.rno}">
			<c:if test="${SID eq data.id}">
				<div class="w3-button w3-grey w3-hover-red w3-right debtn" 
				style="position:relative; top:30px;">리뷰삭제</div>
			</c:if>
						</div>
						<div>
							<span class="w3-third w3-left mgb10 ft10"><small><strong>아이디 : ${data.id}</strong></small></span>
							<span class="w3-third w3-left mgb10 ft10"><small>작성일 : ${data.wdate}</small></span>
							<span class="w3-third w3-left mgb10 ft10"><small>제목 : ${data.title}</small></span>
							<span class="w3-third w3-left mgb10 ft10"><small>캠핑장 : ${data.cname}</small></span>
							<span class="w3-third w3-left mgb10 ft10"><small>별점 : ${data.score}</small></span>
							<span class="w3-third w3-left mgb10 ft10"><small>조회수 : ${data.click}</small></span>
						</div>
					</div>
					<div class="w3-col w3-margin-top">
						<span class="w3-col w3-padding ft12">${data.body}</span>
					</div>
<c:forEach var="image" items="${IMAGE}">
			<c:if test="${data.rno eq image.rno}">
					<div class="w3-col w3-margin-top">
						<img style="width: 200px; height: auto;" src="/camp24/resources/upload/${image.isavename}">
					</div>
			</c:if>
</c:forEach>
				</div>
			</div>
		</div>
</c:forEach>


 <!-- 페이지 처리 -->
	<div class="w3-center">
		<div class="w3-bar w3-border w3-margin-top w3-margin-bottom">
	<c:if test="${PAGE.startPage eq 1}">
			<div class="w3-bar-item w3-light-grey">&laquo;</div>
	</c:if>
	<c:if test="${PAGE.startPage ne 1}">
			<div class="w3-bar-item w3-button w3-hover-green pbtn" id="${PAGE.startPage - 1}">&laquo;</div>
	</c:if>
	<c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
		<c:if test="${page eq PAGE.nowPage}">
			<div class="w3-bar-item w3-lime">${page}</div>
		</c:if>
		<c:if test="${page ne PAGE.nowPage}">
			<div class="w3-bar-item w3-button w3-hover-green pbtn" id="${page}">${page}</div>
		</c:if>
	</c:forEach>
		<c:if test="${PAGE.endPage eq PAGE.totalPage}">
			<div class="w3-bar-item w3-light-grey">&raquo;</div>
		</c:if>
		<c:if test="${PAGE.endPage ne PAGE.totalPage}">
			<div class="w3-bar-item w3-button w3-hover-green pbtn" id="${PAGE.endPage + 1}">&raquo;</div>
		</c:if>
		</div>
	</div>
	<!-- 페이지 처리 태그 끝 -->
	<form method="POST" action="/camp24/board/reBoardList.cmp" id="pageFrm" name="pageFrm">
			<input type="hidden" name="nowPage" id="nowPage" value="${PAGE.nowPage}">
			
	</form>
<!-- 		 데이터 전송용 form 태그  -->
	<%-- <form method="POST" action="/whistle/reboard/reboardList.blp" id="frm" name="frm">
		<input type="hidden" id="nowPage" name="nowPage" value="${PAGE.nowPage}">
		<input type="hidden" id="bno" name="bno">
	</form> --%>
<!-- END MAIN -->
</div>

</div>
</div>
</body>
</html>
<%@ include file="../footer.jsp" %>