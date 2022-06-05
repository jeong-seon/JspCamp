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
	});
	
	//삭제
	$('.debtn').click(function(){
		var sno = $(this).parent().attr('id');
		alert('#### sno : ' + sno);
		$('#Frm').attr('action', '/camp24/board/reBoardDelete.cmp');
		$('#rno').val(sno);
		alert('#### rno : ' + $('#rno').val());
		$('#Frm').submit();
		
	});
	
	
	//이전페이지 버튼
	$('#listbtn').click(function(){
		$('#frm').attr('action', '/camp24/board/reBoardList.cmp');
		$('#nowPage').prop('disabled', true);
		$('#title').prop('disabled', true);
		$('#body').prop('disabled', true);
		$('#frm').submit();
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
		// 캠핑장 선택
		var camping = $('#clist').val();
		if(camping == 'none'){
			$('#clist').focus();
			return;
		}
		
		// 별점 선택
		var score = $('input[name="score"]:checked').val();
		if(!score){
			alert('별점을 선택해주세요!');
			return;
		}
		
		var el = $('input[type="file"]');
		
		for(i = 0 ; i < $(el).length ; i++ ){
			var tmp = $(el).eq(i).val();
			if(!tmp){
				$(el).eq(i).prop('disabled', true);
			}
		}
		
		$('.upfile').last().prop('disabled', true);
		
		$('#frm').submit();
	});
	
	$('#filebox').on('change', '.upfile', function(e){
		var txt = $(this).val();
		var len = $('.upfile').length;
		if(!txt && len > 1){
			$('#img' + $(this).attr('id').substring(4)).remove();
			$(this).remove();
			if($('.pic').length == 0){
				$('#previewbox').slideUp(100);
			}
		} else {
			$('#filebox').append('<input type="file" class="w3-input w3-border w3-margin-bottom upfile">');
			
			$('#previewbox').stop().slideUp(300, function(){
				
				var box = document.createElement('div');
				$(box).attr('class', 'inblock picbox');
				var img = document.createElement('img');
				$(img).attr('class', 'pic');
				var path = URL.createObjectURL(e.target.files[0]);
				$(img).attr('src', path);
				$(box).append($(img));
				$('#preview').append($(box));
				
				var cnt = $('.picbox').length;
				for(i = 1; i <= cnt ; i++ ){
					$('.picbox').eq(i-1).attr('id', 'img' + i);
				}
				$('#previewbox').stop().slideDown(300);
			});
		}
		len = $('.upfile').length;
		for(i = 1; i < len ; i++ ){
			$('.upfile').eq(i-1).attr('id', 'file' + i);
			$('.upfile').eq(i-1).attr('name', 'file' + i);
		}
	});
	
});