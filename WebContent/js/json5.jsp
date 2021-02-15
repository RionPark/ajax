<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#rDiv{
	border : 1px solid;
}
</style>
</head>
<body>
<div id="rDiv">
안녕하세요
</div>
<button onclick="change()">내용바꾸기</button>
<script>
function change(){
	var names = '["문경훈","이도경","한준표"]';
	names = JSON.parse(names);
	var obj = document.querySelector('#rDiv');
	var html = '';
	for(var i=0;i<names.length;i++){
		html += names[i] + '<br>';
	}
	obj.innerHTML = html;
}
</script>
</body>
</html>