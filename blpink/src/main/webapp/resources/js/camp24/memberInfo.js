$(document).ready(function(){
	$('#dbtn').click(function(){
		// 보낼 데이터 읽고
		var sname = $('#name').html();
		var sid = $('#id').html();
		// 보낼 데이터 셋팅하고
		$('#sname').val(sname);
		$('#sid').val(sid);
		// 보낼주소 수정하고
		$('#frm').attr('action', '/camp24/member/delInfo.cmp');
		
		if(confirm('정말 탈퇴합니까?')){
			// form 태그가 완성이 됬으니 전송한다.
			$('#frm').submit();
		}
	});
	$('#ebtn').click(function(){
		$(location).attr('href', '/camp24/member/editInfo.cmp');
	});
});