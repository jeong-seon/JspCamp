$(document).ready(function(){


	//var ex = {"response":{"header":{"resultCode":"00","resultMsg":"NORMAL_SERVICE"},"body":{"dataType":"JSON","items":{"item":[{"baseDate":"20220524","baseTime":"0500","category":"TMP","fcstDate":"20220524","fcstTime":"0600","fcstValue":"15","nx":55,"ny":127}]},"pageNo":1,"numOfRows":1,"totalCount":809}}};
	
	
	//console.log(ex.response.body.items.item[0].fcstTime);

	
	$.ajax({
		url : '/main.cmp',
		type : 'post',
		dataType : 'json',
	  	data : '',
		success: function(data){
			
			var tmp = data.response.body.items.item[0].fcstValue;
			
			console.log(tmp);
//			alert(' 기온은 ' + tmp + '도 입니다!');
		},
		error : function(request, status, error){
			alert("code = " + request.status + "message = " + request.responseText + " error =  " + error);
		}
		
		
	})
	

	
	
});