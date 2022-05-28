
$(document).ready(function(){
	
	/* 페이지 버튼 클릭이벤트 처리 */
	$('.pbtn').click(function(){
		// 페이지번호 읽고
		var pno = $(this).attr('id');
		// 페이지 번호 셋팅하고
		$('#nowPage').val(pno);
		// 폼 태그 전송
		$('#pageFrm').submit();
	});
	
	
	//리뷰쓰기 버튼
	$('#wbtn').click(function(){
		$('#pageFrm').attr('action', '/camp24/board/reBoardWrite.cmp');
		$('#pageFrm').submit();
//		$('#Frm').attr('action', '/camp24/board/reBoardWrite.cmp');
//		$('#Frm').submit();
		
	});
	
	//삭제
	$('#debtn').click(function(){
		$('#Frm').attr('action', '/camp24/board/reBoardDelete.cmp');
		$('#Frm').submit();
		
	});
	
	
	
//	//리뷰관리버튼
//	$('#manbtn').click(function(){
//		$(location).attr('href', '/camp24/board/reBoardList2.cmp');
//	});
	
	//이전페이지 버튼
	$('#listbtn').click(function(){
		$('#frm').attr('action', '/camp24/board/reBoardList.cmp');
		$('#nowPage').prop('disabled', true);
		$('#title').prop('disabled', true);
		$('#body').prop('disabled', true);
		$('#frm').submit();
//		$(location).attr('href', '/camp24/board/reBoardList.cmp');
	});
	
	//글 작성후 글등록 버튼(reboardWrite)
	$('#wpbtn').click(function(){
		var title = $('#title').val();
		if(!title){
			$('#title').focus();
			return;
		}
		var body = $('#body').val();
		if(!body){
			$('#body').focus();
			return;
		}
		
		$('#frm').submit();
		$('#Frm').submit();
	});
	
	/*
	//리스트로 돌아가기 버튼 
	$('#listbtn').click(function(){
		//form태그의 action속성값 변경
		$('#frm').attr('action', '/camp24/board/reBoardList.cmp');
		//사용하지 않는 태그 비활성시키고
		$('#mno').prop('disabled', true);
		$('#body').prop('disabled', true);
		
		$('#frm').submit();
	});
	*/
	
	
});