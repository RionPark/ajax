<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="id"><button onclick="doSend()">전송</button>
<script>
function doSend(){
	var param = {
			id : document.querySelector('#id').value
	}
	document.getElementById('id');
	console.log(param);
	param = JSON.stringify(param);
	console.log(param);
}
</script>
</body>
</html>