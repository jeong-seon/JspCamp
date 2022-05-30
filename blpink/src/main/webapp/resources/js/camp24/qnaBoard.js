$(document).ready(function(){
	$('#wbtn').click(function(){
		$('#frm').attr('action', '/camp24/qnaBoard/qnaBoardWrite.cmp');
		$('#frm').submit();
	});
	
	$('#lbtn').click(function(){
		$(location).attr('href', '/camp24/member/login.cmp');
	});
	
	/* 페이지 버튼 클릭 이벤트 처리 */
	$('.pbtn').click(function(){
		// 페이지번호 읽고
		var pno = $(this).attr('id');
		// 페이지번호 세팅하고
		$('#nowPage').val(pno);
		// 폼 태그 전송하고
		$('#frm').submit();
	});
	
	/* 댓글 쓰기 버튼 클릭 이벤트 처리 */
	$('.cmtbtn').click(function(){
		var sno = $(this).parent().attr('id');
		$('#qno').val(sno);
		
		$('#frm').attr('action', '/camp24/qnaBoard/qnaComment.cmp');
		$('#frm').submit();
	});
	
	/* 게시글 수정 버튼 클릭 이벤트 처리 */
	$('.ebtn').click(function(){
		var sno = $(this).parent().attr('id');
		$('#qno').val(sno);
		
		$('#frm').attr('action', '/camp24/qnaBoard/qnaBoardEdit.cmp');
		$('#frm').submit();
	});
	
	/* 삭제 버튼 클릭 이벤트 처리 */
	$('.dbtn').click(function(){
		var sno = $(this).parent().attr('id');
		$('#qno').val(sno);
		$('#frm').attr('action', '/camp24/qnaBoard/qnaBoardDel.cmp');
		$('#frm').submit();
	});
});