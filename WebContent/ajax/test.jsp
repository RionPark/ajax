<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button onclick="getBiz()">가져오기</button>
<div id="rDiv"></div>
<script>
function getBiz(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/ajax/biz.jsp');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if(xhr.status==200){
				var strArr = JSON.parse(xhr.responseText);
				for(var i=0;i<strArr.length;i++){
					document.querySelector('#rDiv').innerHTML += strArr[i] + '<br>';
				}
			}
		}
	}
	xhr.send();
}
</script>
</body>
</html>