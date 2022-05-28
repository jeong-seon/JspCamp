$(document).ready(function(){
	$('#lbtn').click(function(){
		var sid = $('#id').val();
		if(!sid){
			$('#id').focus();
			return;
		}
		var spw = $('#pw').val();
		if(!spw){
			$('#pw').focus();
			return;
		}
		$('#frm').attr('action', '/camp24/member/loginProc.cmp');
		$('#frm').submit();
	});
	
	// 홈버튼 클릭이벤트
	$('#hbtn').click(function(){
		$(location).attr('href', '/camp24/main.cmp');
	});
	$('#jbtn').click(function(){
		$(location).attr('href', '/camp24/member/join.cmp');
	});
});