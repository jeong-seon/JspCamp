<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Camp24 방문후기 상세정보</title>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/user.css">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/board.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>

</head>
<body class="w3-light-grey">
<div class="w3-container">
<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main">
<div class="w3-content mxw700">
		<h1 class="w3-light-grey w3-padding w3-center w3-card-4">후기</h1>
		<div class="w3-col w3-card-4 frmpadding w3-padding">
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col s2">글번호</label>
				<h4 id="bno" class="w3-col m10">${DATA.bno}</h4>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col s2">Writer</label>
				<h4 id="writer" class="w3-col m10">${DATA.id}</h4>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col s2">Title</label>
				<h4 id="title" class="w3-col m10">${DATA.title}</h4>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col s2">Content</label>
				<h4 id="body" class="w3-col m10">${DATA.body}</h4>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col s2">작성일</label>
				<h4 id="wdate" class="w3-col m10">${DATA.sdate}  ${DATA.stime}</h4>
			</div>
			
<c:if test="${not empty LIST}">			
			<div class="w3-col w3-margin-bottom" id="previewbox">
				<label class="w3-col s2">Image</label>
				<div class="w3-col m10 w3-center" id="preview">
		<c:forEach var="data" items="${LIST}">
			<c:if test="${not empty data.savename}">
					<div class="inblock picbox">
						<img class="pic" src="/whistle${data.dir}/${data.savename}"> 
					</div>
			</c:if>
		</c:forEach>
				</div>
			</div>
</c:if>
		</div>
		
		
		
		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-third w3-button w3-light-grey" id="listbtn">이전 페이지</div>
			<div class="w3-third w3-button w3-black" id="dbtn">후기 삭제</div>
			<div class="w3-third w3-button w3-light-cyan" id="edit">글수정</div>
		</div>
	</div>
	
	<form method="POST" action="/whistle/board/boardList.blp" id="pageFrm" name="pageFrm">
		<input type="hidden" name="nowPage" value="${NOWPAGE}">
<%-- 		<input type="hidden" name="nowPage" value="${param.nowPage}"> --%>
	</form>
	
	<!-- 데이터 전송용 form 태그 -->
	<form method="POST" action="/whistle/reboard/reboardList.blp" id="frm" name="frm">
		<input type="hidden" id="nowPage" name="nowPage" value="${PAGE.nowPage}">
		<input type="hidden" id="bno" name="bno">
	</form>
<!-- END MAIN -->
</div>
</div>
</body>
</html>
<%@ include file="../footer.jsp" %>