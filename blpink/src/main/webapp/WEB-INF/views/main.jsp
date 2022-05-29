<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>Camp24</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/main.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
#rank {
	position: relative;
	top: -10px;
}
</style>
</head>
<body class="w3-light-grey">

<!-- w3-content defines a container for fixed size centered content, 
and is wrapped around the whole page content, except for the footer in this example -->


<!-- Header -->
	<div class="w3-row">

		<div class="w3-col">
			<div class="w3-card-4 w3-margin w3-white w3-center">
<%-- <c:forEach var="data" items="${LIST}">
				<div class="w3-col m3 w3-border"><strong>캠핑장 정보</strong></div>
</c:forEach> --%>
				<img style="width: 100%; "src="/camp24/resources/img/pic/camp.png">
   			</div>
   		</div>
   		<div class="w3-col">
			<div class="w3-card-4 w3-margin w3-white w3-center">
				<h4 style="font-size: 36pt; display: inline-block;">Best 캠핑장</h4><img id="rank" style="width: 70px; height: auto;" src="/camp24/resources/img/pic/rank.png">
   			</div>
   		</div>
		<hr>
	</div>

</body>
</html>
<%@ include file="footer.jsp" %>