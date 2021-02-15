<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="rDiv"></div>
<button onclick="getNames()">이름가져오기</button>
<script>

function getNames(){
	var xhr = new XMLHttpRequest();
	alert(xhr.readyState); // <-- 0임
	var url = '/js/list.jsp';
	xhr.open('GET',url);
	alert(xhr.readyState); // <-- 1임
	
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = xhr.responseText;
			res = JSON.parse(res);
			var html ='';
			for(var i=0;i<res.length;i++){
				html += res[i] + '<br>';
			}
			document.querySelector('#rDiv').innerHTML = html;
		}
	}
	xhr.send();
}
</script>
</body>
</html>