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
	$('#jbtn').click(function(){
		$(location).attr('href', '/camp24/member/join.cmp');
	});

	$('#lbtn').click(function(){
		$(location).attr('href', '/camp24/member/login.cmp');
	});
	
	$('#obtn').click(function(){
		$(location).attr('href', '/camp24/member/logout.cmp');
	});
	
	$('#mlbtn').click(function(){
		$(location).attr('href', '/camp24/member/memberList.cmp');
	});
	
	$('#ibtn').click(function(){
		$(location).attr('href', '/camp24/member/myInfo.cmp');
	});
});