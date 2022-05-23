$(function(){
	$('#jbtn').click(function(){
		$(location).attr('href', '/whistle/member/join.blp');
	});
	$('#lbtn').click(function(){
		$(location).attr('href', '/whistle/member/login.blp');
	});
	$('#obtn').click(function(){
		alert(getSID() + ' 님을 로그아웃 처리합니다.');
		$(location).attr('href', '/whistle/member/logout.blp');
	});
	$('#mlbtn').click(function(){
		$(location).attr('href', '/whistle/member/memberList.blp');
	});
	$('#cbtn').click(function(){
		$('#detail').css('display', 'none');
	});
	$('#ibtn').click(function(){
		$(location).attr('href', '/whistle/member/myInfo.blp');
	});
});