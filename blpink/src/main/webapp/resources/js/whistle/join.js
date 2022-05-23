$(document).ready(function(){
	$(document.frm.gen).change(function(){
		var sgen = $(this).val();
		$('#avtfr').stop().slideUp(500, function(){
			if(sgen == 'M'){
				$('#favt').css('display', 'none');
				$('#mavt').css('display', 'block');
				$('#avtfr').stop().slideDown(500);
			} else {
				$('#mavt').css('display', 'none');
				$('#favt').css('display', 'block');
				$('#avtfr').stop().slideDown(500);
			}
		});
	});
	$('#hbtn').click(function(){
		$(location).attr('href', '/whistle/');
	});
	$('#rbtn').click(function(){
		frm.reset();
		$('#avtfr').css('display', 'none');
	});
	$('#jbtn').click(function(){
		/*
		var name = $('#id').val();
		var id = $('#id').val();
		var pw = $('#id').val();
		var mail = $('#id').val();
		var tel = $('#id').val();
		*/
		var el = $('.ck');
		for(var i = 0; i < el.length; i++){
			var tmp = el.eq(i).val();
			if(!tmp){
				el.eq(i).focus();
				alert(el.eq(i).attr('id') + ' 값을 입력해주세요 !');
				return;
			}
		}
		var gen = $('input[name="gen"]:checked').val();
		var ano = $('input[name="ano"]:checked').val();
		if(!gen){
			alert('성별을 선택해주세요 !');
			return;
		}
		if(!ano){
			alert('아바타를 선택해주세요 !');
			return;
		}
		$('#frm').attr('action', '/whistle/member/joinProc.blp');
		$('#frm').submit();
		alert('회원가입이 성공적으로 완료되었습니다 !');
	});
	
	// 아이디체크 버튼 클릭이벤트
	$('#idck').click(function(){
		// 할일
		// 입력된 아이디 값 꺼내오고
		var sid = $('#id').val();
		var idPat = /^[a-zA-Z0-9]{4,10}$/;
		var idResult = idPat.test(sid);
		
		if(!sid){
			// 입력내용이 없는 경우
			$('#id').focus();
			alert('* 아이디를 입력해주세요! *');
			return;
		}
		// 전달해서 사용가능 유무 판단
		$.ajax({
			url: '/whistle/member/idCheck.blp',
			type: 'POST',
			dataType: 'json',
			data: {
				id: sid
			},
			success: function(data){
				var result = data.result;
				$('#idmsg').removeClass('w3-text-green w3-text-red');
				// 뷰에 보여주고
				if(result == 'OK'){
					if(idResult){
						// 입력한 아이디가 사용가능한 경우
						$('#idmsg').html('* 사용 가능한 아이디입니다! *');
						$('#idmsg').addClass('w3-text-green');
					} else {
						$('#idmsg').html('* 아이디 형식에 맞지 않는 아이디입니다! *');
						$('#idmsg').addClass('w3-text-red');
						$('#id').val('');
						$('#id').focus();
					}
				} else {
					// 입력한 아이디가 사용 불가능한 경우
					$('#idmsg').html('* 사용 불가능한 아이디입니다!*');
					$('#idmsg').addClass('w3-text-red');
					$('#id').val('');
					$('#id').focus();
				}
				$('#idmsg').css('display', 'block');
			},
			error: function(){
				alert('### 통신 에러 ###');
			}
		});
	});
	
	// 비밀번호 입력이벤트
	$('#pw').change(function(){
		// 할 일
		// 입력된 데이터 읽어오기
		var pw = $(this).val();
		var pwPat = /^12345$/;
		var pwResult = pwPat.test(pw);
		
		if(!pwResult){
			$('#pwmsg').html('# 비밀번호는 12345 만 가능합니다.');
			$('#pwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-red');
		} else {
			$('#pwmsg').html('* 정확한 비밀번호 입니다. *');
			$('#pwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-green');
		}
		$('#pwmsg').css('display', 'block');
	});
	
	// 비밀번호 체크 입력이벤트
	$('#repw').keyup(function(){
		// 할 일
		// 입력된 데이터 읽어오기
		var pw = $('#pw').val();
		var repw = $(this).val();
		if(pw != repw){
			$('#repwmsg').html('* 비밀번호가 일치하지 않습니다! *');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-red');
		} else {
			$('#repwmsg').html('* 비밀번호가 일치합니다! *');
			$('#repwmsg').removeClass('w3-text-green w3-text-red').addClass('w3-text-green');
		}
		$('#repwmsg').css('display', 'block');
	});
	
	$('#mail').focus(function(){
		var mail = $('#mail').val();
		if(mail){
			return;
		} else {
			$('#mailmsg').removeClass('w3-text-red').addClass('w3-text-gray');
			$('#mailmsg').html('* 이메일 형식 : 영문 대소문자 및 숫자 4 ~ 10글자 (@ 이전)');			
		}
	});
	
	$('#mail').focusout(function(){
		var mail = $('#mail').val();
		if(!mail){
			$('#mailmsg').html('');
		}
	});
	
	$('#mail').change(function(){
		var smail = $('#mail').val();
		var mailPat = /^[a-zA-Z0-9]{4,10}[@].*$/;
		var mailResult = mailPat.test(smail);
		
		if(!smail){
			return;
		}
		if(mailResult){
			$('#mailmsg').removeClass('w3-text-red w3-text-gray').addClass('w3-text-green');
			$('#mailmsg').html('* 이메일 형식에 일치합니다 ! *');
		} else {
			$('#mailmsg').removeClass('w3-text-green w3-text-gray').addClass('w3-text-red');
			$('#mailmsg').html('* 이메일 형식에 일치하지 않습니다. 다시 입력해주세요 ! *');
			$('#mail').val('');
			$('#mail').focus();
		}
	});
	
	$('#tel').focus(function(){
		var tel = $('#tel').val();
		if(tel){
			return;
		} else {
			$('#telmsg').removeClass('w3-text-red').addClass('w3-text-gray');
			$('#telmsg').html('* 전화번호 형식 : [010-????-????] 형식으로 작성하세요 *');
		}
	});
	
	$('#tel').focusout(function(){
		var tel = $('#tel').val();
		if(!tel){
			$('#telmsg').html('');
		}
	});
	
	$('#tel').change(function(){
		var stel = $('#tel').val();
		var telPat = /^010-[0-9]{4}-[0-9]{4}$/;
		var telResult = telPat.test(stel);
		
		if(!stel){
			return;
		}
		if(telResult){
			$('#telmsg').removeClass('w3-text-red w3-text-gray').addClass('w3-text-green');
			$('#telmsg').html('* 전화번호 형식에 일치합니다! *');
		} else {
			$('#telmsg').removeClass('w3-text-green w3-text-gray').addClass('w3-text-red');
			$('#telmsg').html('* 전화번호 형식에 일치하지 않습니다. 다시 입력해주세요! *');
			$('#tel').val('');
			$('#tel').focus();
		}
	});
});