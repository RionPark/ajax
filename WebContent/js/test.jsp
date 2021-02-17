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
var obj = {
		ui_num : 1,
		ui_name : '김길동',
		ui_address : '서울'
};


//javascript의 for문은 크게 3가지
// 1. 일반적인
for(var i=0;i<10;i++){
	console.log(i);
}
// 2. for-in
for(var key in obj){
	console.log('key : ' + key + ', value:' + obj[key]);
}
var arr = ['멍멍이','동동이','우하하'];
// 3. for-of
for(var v of arr){
	console.log(v);
}
</script>
</body>
</html>