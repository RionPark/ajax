<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="rDiv">

</div>
<button onclick="print()">출력</button>
<script>
function print(){
	var persons = [
		{
			name : '김철수',
			age : 22
		},
		{
			name : '이순희',
			age : 33
		}
	];
	var obj = document.querySelector('#rDiv');
	var html = '';
	for(var i=0;i<persons.length;i++){
		var person = persons[i];
		html += ' 이름 : ' + person.name + ', 나이 : ' + person.age + '<br>';
	}
	obj.innerHTML = html;
}
</script>
</body>
</html>