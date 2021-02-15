<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var person = {
		name : '하하',
		age : 33,
		job : '개발자'
}
alert('사람의 이름 : ' + person.name);
alert('사람의 나이 : ' + person.age);
alert('사람의 직업 : ' + person.job);

var jsonStr = '{"name":"하하","age":33,"job":"개발자"}';
//document.write(jsonStr);

var obj = JSON.parse(jsonStr);
document.write('obj의 이름 : ' + obj.name +'<br>');
document.write('obj의 나이 : ' + obj.age +'<br>');
document.write('obj의 직업 : ' + obj.job +'<br>');
</script>
</body>
</html>









