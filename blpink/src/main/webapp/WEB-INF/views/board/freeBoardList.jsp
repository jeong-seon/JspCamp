<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Free Board</title>
<meta charset="UTF-8">
</head>
<body>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/w3.css">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/user.css">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/freeBoard.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
<style>
.w3-sidebar {
  z-index: 3;
  width: 250px;
  top: 43px;
  bottom: 0;
  height: inherit;
  
}
</style>

<script type="text/javascript">

</script>
</head>
<body>
<div class="w3-container">
<!-- Navbar -->
<div class="w3-top">
  <div class="w3-bar w3-theme w3-top w3-left-align w3-large">
    <a class="w3-bar-item w3-button w3-right w3-hide-large w3-hover-white w3-large w3-theme-l1" href="javascript:void(0)" onclick="w3_open()"><i class="fa fa-bars"></i></a>
    <a href="#" class="w3-bar-item w3-button w3-theme-l1">Logo</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">About</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Values</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">News</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hover-white">Contact</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Clients</a>
    <a href="#" class="w3-bar-item w3-button w3-hide-small w3-hide-medium w3-hover-white">Partners</a>
  </div>
</div>

<!-- Sidebar -->
<nav class="w3-sidebar w3-bar-block w3-collapse w3-large w3-theme-l5 w3-animate-left" id="mySidebar">
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-right w3-xlarge w3-padding-large w3-hover-black w3-hide-large" title="Close Menu">
    <i class="fa fa-remove"></i>
  </a>
  <h4 class="w3-bar-item"><b>Menu</b></h4>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Community</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">FAQ</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">QnA</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Review</a>
  <a class="w3-bar-item w3-button w3-hover-black" href="#">Search</a>
  <a class="w3-bar-item w3-button w3-hover-black" onclick="location.href='/camp24/fakeLogin.cmp'">fakeLogin</a><!-- 클릭하는 순간 로그인 완료 -->
  <a class="w3-col">${SID}</a><!-- 클릭하는 순간 로그인 완료 -->
</nav>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- Main content: shift it to the right by 250 pixels when the sidebar is visible -->
<div class="w3-main" style="margin-left:250px">

  <div class="w3-row w3-padding-64">
  <div class="w3-button w3-green w3-hover-lime w3-right" id="wbtn">글 쓰기</div>
<c:if test="${empty SID}">
  <div class="w3-button w3-green w3-hover-lime" id="wbtn">로그인</div>
</c:if>
  
<c:forEach var="data" items="${LIST}">
		<div class="w3-col" style="padding-left: ${data.step * 70}px">
			<div class="w3-col w3-round-large w3-card-4 w3-margin-bottom w3-padding">
				<div class="w3-col box120 pdAll10 w3-border-right">
					<img src="/camp24/resources/img/avatar/${data.avatar}" class="inblock avtBox100 w3-border w3-border-grey">
				</div>
				<div class="w3-rest w3-padding">
					<div class="w3-col w3-border-bottom w3-rest">
						<div class="w3-col w3-third w3-right w3-rest" id="${data.fbno}">
							<div class="w3-col w3-button w3-small w70 w3-blue w3-right cmtbtn">댓글</div>
			<c:if test="${SID eq data.id}">
							<div class="w3-col w3-button w3-small w70 w3-orange w3-right">수정</div>
							<div class="w3-col w3-button w3-small w70 w3-red w3-right dbtn">삭제</div>
			</c:if>
						</div>
						<div>
						<span class="w3-third w3-left mgb10 ft10"><small><strong>아이디 : ${data.id}</strong></small></span>
						<span class="w3-third w3-left mgb10 ft10"><small>작성일 : ${data.sdate}</small></span>
						<span class="w3-third w3-left mgb10 ft10"><small>제목 : ${data.ftitle}</small></span>
						<span class="w3-third w3-left mgb10 ft10"><small>수정일 : ${data.sedate}</small></span>
						</div>
					</div>
					<div class="w3-col w3-margin-top">
						<span class="w3-col w3-padding ft12">${data.fbody}</span>
					</div>
				</div>
			</div>
		</div>
</c:forEach>
  </div>
  
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

<!-- END MAIN -->
</div>

<script>
// Get the Sidebar
var mySidebar = document.getElementById("mySidebar");

// Get the DIV with overlay effect
var overlayBg = document.getElementById("myOverlay");

// Toggle between showing and hiding the sidebar, and add overlay effect
function w3_open() {
  if (mySidebar.style.display === 'block') {
    mySidebar.style.display = 'none';
    overlayBg.style.display = "none";
  } else {
    mySidebar.style.display = 'block';
    overlayBg.style.display = "block";
  }
}

// Close the sidebar with the close button
function w3_close() {
  mySidebar.style.display = "none";
  overlayBg.style.display = "none";
}
</script>


	<!-- 메세지 출력 모달창  -->
<c:if test="${not empty MSG}">
	  <div id="modal" class="w3-modal" style="display:block;">
	 	 <div class="w3-modal-content mxw650 w3-animate-top w3-card-4">
			<header class="w3-container w3-blue">
	      		<span onclick="document.getElementById('modal').style.display='none'"
	     		 class="w3-button w3-display-topright">&times;</span>
	      <h2>Message</h2>
	    </header>
	    <div class="w3-container w3-center">
	      <h4>${MSG}</h4>
	    </div>
	  </div>
	</div>
</c:if>


	<!-- 데이터 전송용 form 태그 -->
	<form method="POST" action="/camp24/freeBoard/freeBoardList.cmp" id="frm" name="frm">
		<input type="hidden" id="nowPage" name="nowPage" value="${PAGE.nowPage}">
		<input type="hidden" id="fbno" name="fbno">
	</form>
</div>
</body>
</html>
<%@ include file="../footer.jsp" %>