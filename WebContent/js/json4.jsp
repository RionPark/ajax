<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul id="nameUl">
</ul>

<ul id="nameUl2">
</ul>
<script>
	var arr = ['홍길동','김길동','주길동'];
	var nameUl = document.querySelector('#nameUl');
	var html = '';
	for(var i=0;i<arr.length;i++){
		html += '<li>' + arr[i] + '</li>';
	}
	nameUl.innerHTML = html;
	
	var json = '["하하","호호","허허"]';
	json = JSON.parse(json);
	var nameUl2 = document.querySelector('#nameUl2');
	html = '';
	for(var i=0;i<json.length;i++){
		html += '<li>' + json[i] + '</li>';
	}
	nameUl2.innerHTML = html;
</script>
</body>
</html>