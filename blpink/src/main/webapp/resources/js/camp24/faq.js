/**
 * 
 */
 
 // 홈버튼 클릭이벤트
  $(document).ready(function(){
	$('#hbtn').click(function(){
		$(location).attr('href', '/camp24/main.cmp');
	});
});