$(document).ready(function(){

/* 리스트 버튼 클릭 이벤트 */
$('#listbtn').click(function(){
	// 폼 태그의 액션 속성값 변경
	$('#frm').attr('action', '/camp24/qnaBoard/qnaBoardList.cmp');
	// 사용하지 않는 태그 비활성화 시키기
	$('#mno').prop('disabled', true);
	$('#body').prop('disabled', true);
	
	$('#frm').submit();
});

/* 리셋 버튼 클릭 이벤트 */
$('#reset').click(function(){
	document.frm.reset();
});

	/* 댓글등록 버튼 클릭 이벤트 */
	$('#cmtbtn').click(function(){
		var btxt = $('#body').val();
		btxt = btxt.trim();
		if(!btxt){
			$('#body').focus();
			return;
		}
		
		if(btxt.length > 200){
			btxt = btxt.subString(0, 200);
			$('#body').val(btxt);
			alert('댓글의 글자수는 200자를 초과할 수 없습니다.');
			return;
		}
		
		$('#frm').attr('action', '/camp24/qnaBoard/qnacmWriteProc.cmp');
		$('#frm'). submit();
	});
});