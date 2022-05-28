$(document).ready(function(){
	/* 리스트 버튼 클릭 이벤트 */
	$('#lbtn').click(function(){
		$(location).attr('href', '/camp24/qnaBoard/qnaBoardList.cmp');	
	});
	
	/* 리셋 버튼 클릭 이벤트 */
	$('#rbtn').click(function(){
		document.frm.reset();
	});
	
	/* 수정 버튼 클릭 이벤트 */
	$('#ebtn').click(function(){
		var stitle = $('#stitle').val();
		var sbody = $('#sbody').val();
		
		var title = $('#title').val();
		if(stitle == title){
			$('#title').prop('disabled', true);
		}
		
		var body = $('#body').val();
		if(sbody == body){
			$('#body').prop('disabled', true);
		}
		
		if((stitle == title) && (sbody == body)){
			alert('수정된 내용이 없습니다.');
			return;
		}
		
		$('#frm').submit();
		
	});
});