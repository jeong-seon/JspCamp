$(document).ready(function(){
	
	/* 리스트 버튼 클릭 이벤트 */
	$('#lbtn').click(function(){
		// 폼 태그의 액션 속성값 변경
		$('#frm').attr('action', '/camp24/freeBoard/freeBoardList.cmp');
		// 사용하지 않는 태그 비활성화 시키기
		$('#mno').prop('disabled', true);
		$('#body').prop('disabled', true);
		
		$('#frm').submit();
		});
	
	/* 리셋 버튼 클릭 이벤트 */
	$('#rbtn').click(function(){
		document.frm.reset();
	});
	
	/* 글등록 버튼 클릭 이벤트 */
	$('#wbtn').click(function(){
		// 입력된 글 유효성 검사
		var txt = $('#body').val();
		
		txt = txt.trim();
		if(!txt || txt.length == 0){
			$('#body').val('');
			$('#body').focus();
			return;
		}
		
		$('#body').val(txt);
		
		$('#frm').submit();
	});
});