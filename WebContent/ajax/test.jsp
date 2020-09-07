<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
<button onclick="getBiz()">가져오기</button>
<div id="rDiv"></div>
<script>
function getBiz(){
	$.ajax({
		url:'/ajax/biz.jsp',
		method:'GET',
		success : function(res){
			var list = JSON.parse(res);
			for(var i=0;i<list.length;i++){
				var m = list[i];
				document.querySelector('#rDiv').innerHTML += m.name + ',' + m.age + ',' + m.addr + '<br>';
			}
		}
	});
}
</script>
</body>
</html>