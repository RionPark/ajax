<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="id">
<script>
var info = {
		id : 'test'
}

info = '{"id":"test"}';
info = JSON.parse(info);
console.log(info);
document.querySelector('#id').value=info.id;


</script>
</body>
</html>