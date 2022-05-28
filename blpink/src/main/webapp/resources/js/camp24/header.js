$(document).ready(function(){
	$('#home').click(function(){
		$(location).attr('href', '/camp24/main.cmp');
	});
	$('#schbtn').click(function(){
		$(location).attr('href', '/camp24/board/searchBoardList.cmp');
	});
	$('#cmpbtn').click(function(){
		$(location).attr('href', '/camp24/campapi/campApi.cmp');
	});
	$('#mapbtn').click(function(){
		$(location).attr('href', '/camp24/map/mapApi.cmp');
	});
	$('#joinbtn').click(function(){
		$(location).attr('href', '/camp24/member/join.cmp');
	});

	$('#loginbtn').click(function(){
		$(location).attr('href', '/camp24/member/login.cmp');
	});
	
	$('#loutbtn').click(function(){
		$(location).attr('href', '/camp24/member/logout.cmp');
	});
	
	$('#mlbtn').click(function(){
		$(location).attr('href', '/camp24/member/memberList.cmp');
	});
	
	$('#mypagebtn').click(function(){
		$(location).attr('href', '/camp24/member/myInfo.cmp');
	});
	
	$('#freebtn').click(function(){
		$(location).attr('href', '/camp24/freeBoard/freeBoardList.cmp');
	});
	$('#qnabtn').click(function(){
		$(location).attr('href', '/camp24/qnaBoard/qnaBoardList.cmp');
	});
	$('#faqbtn').click(function(){
		$(location).attr('href', '/camp24/board/faqList.cmp');
	});
	$('#revbtn').click(function(){
		$(location).attr('href', '/camp24/board/reBoardList.cmp');
	});
});