<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Camp24 리뷰작성</title>
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
<style type="text/css">
	input[type="file"].w3-margin-bottom {
		margin-bottom: 5px!important;
	}
</style>
</head>
<body class="w3-light-grey">
<div class="w3-container">
<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main">

 <div class="w3-content mxw700">
		<h1 class="w3-light-grey w3-padding w3-center w3-card-4">Review</h1>
		<form enctype="multipart/form-data" method="POST" action="/camp24/board/reBoardWriteProc.cmp" 
				id="frm" name="frm" class="w3-col w3-card-4 frmpadding">
			<input type="hidden" name="nowPage" id="nowPage" value="${nowPage}">
		<div class="w3-padding">
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label for="title" class="w3-col s2">Title</label>
				<input type="text" id="title" name="title" class="w3-col m10 w3-input w3-border">
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label for="title" class="w3-col s2">캠핑장 선택</label>
				<select id="clist" name="clist">
					<option value="none">캠핑장 선택</option>
					<c:forEach var="data" items="${CAMP}">
						<option value="${data.cno}">${data.cname}</option>
					</c:forEach>
				</select>
			</div>
			<div class="w3-col w3-margin-bottom">
				<label class="w3-col s2">File</label>
				<div class="w3-col m10" id="filebox">
					<input type="file" class="w3-input w3-border w3-margin-bottom upfile">
				</div>
			</div>
			<div class="w3-col w3-margin-bottom" id="previewbox" style="display: none;">
				<label class="w3-col s2">Preview</label>
				<div class="w3-col m10 w3-center" id="preview">
				</div>
			</div>
			<div class="w3-col w3-margin-top w3-margin-bottom">
				<label class="w3-col s2">별점</label>
				<input type="radio" id="descore" name="score" value="1"><label for="star1" style="margin-right: 33px">☆</label>
				<input type="radio" name="score" value="2"><label for="star2" style="margin-right: 33px">☆☆</label>
				<input type="radio" name="score" value="3"><label for="star3" style="margin-right: 33px">☆☆☆</label>
				<input type="radio" name="score" value="4"><label for="star4" style="margin-right: 33px">☆☆☆☆</label>
				<input type="radio" name="score" value="5"><label for="star5" style="margin-right: 33px">☆☆☆☆☆</label>
			</div>
			<div class="w3-col">
				<label for="body" class="w3-col s2">글본문</label>
				<div class="w3-col m10">
					<textarea class="w3-col w3-input w3-padding w3-border w3-margin-bottom" 
							id="body" name="body" rows="10" style="resize: none;"></textarea>
				</div>
			</div>
		</div>
		</form>
		
		<div class="w3-col w3-margin-top w3-card-4">
			<div class="w3-half w3-button w3-grey" id="listbtn">이전 페이지</div>
			<div class="w3-half w3-button w3-black" id="wpbtn">글등록</div>
		</div>
	</div>


<!-- END MAIN -->
</div>

</div>
</body>
</html>
<%@ include file="../footer.jsp" %>