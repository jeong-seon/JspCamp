<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Camp24 FAQ 게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/faq.css">
<link rel="stylesheet" type="text/css" href="/camp24/resources/css/w3.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript" src="/camp24/resources/js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/faq.js"></script>
<script type="text/javascript" src="/camp24/resources/js/camp24/header.js"></script>

</head>
<script>
jQuery(function($){
    // Frequently Asked Question
    var article = $('.faq>.faqBody>.article');
    article.addClass('hide');
    article.find('.a').hide();
    article.eq(0).removeClass('hide');
    article.eq(0).find('.a').show();
    $('.faq>.faqBody>.article>.q>a').click(function(){
        var myArticle = $(this).parents('.article:first');
        if(myArticle.hasClass('hide')){
            article.addClass('hide').removeClass('show');
            article.find('.a').slideUp(100);
            myArticle.removeClass('hide').addClass('show');
            myArticle.find('.a').slideDown(100);
        } else {
            myArticle.removeClass('show').addClass('hide');
            myArticle.find('.a').slideUp(100);
        }
        return false;
    });
    $('.faq>.faqHeader>.showAll').click(function(){
        var hidden = $('.faq>.faqBody>.article.hide').length;
        if(hidden > 0){
            article.removeClass('hide').addClass('show');
            article.find('.a').slideDown(100);
        } else {
            article.removeClass('show').addClass('hide');
            article.find('.a').slideUp(100);
        }
    });
});
</script>
<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
<body class="w3-light-grey">

<div class="w3-container">
<h2 class="w3-green w3-padding-16 w3-center">FAQ 게시판</h2>
<div class="faq">
    <div class="faqHeader ">
    </div>
    <ul class="faqBody">
        <li class="article" id="a1">
            <p class="q"><a href="#a1">질문 : 블랙핑크 멤버는 몇명인가요?</a></p>
            <p class="a">답변 : 블랙핑크는 제니,로사,로제,지수 4명으로 구성되어있습니다.</p>
        </li>
        <li class="article" id="a2">
            <p class="q"><a href="#a2">질문 : camp24의 팀원은 몇명인가요? </a></p>
            <p class="a">답변 : 지석,은선,선우,서진,희승</p>
        </li>
        <li class="article" id="a3">
            <p class="q"><a href="#a3">질문 : 이번 프로젝트에 대한 후기는?</a></p>
            <p class="a">답변 : 역시나 시간이 부족했던것 같습니다.</p>
        </li>
        <li class="article" id="a4">
            <p class="q"><a href="#a4">질문 : 캠핑장비 대여나 구매는 안되나요?</a></p>
            <p class="a">답변 : 결제시스템 구현중입니다..</p>
        </li>
    </ul>
</div>

</div>
</body>
</html>
<%@ include file="../footer.jsp" %>