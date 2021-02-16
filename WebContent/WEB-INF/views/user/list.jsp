<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.tr-link{
	cursor:pointer;
	background-color:#fff;
}
.tr-link:hover{
	background-color: #a1f1f1;
}
</style>
</head>
<body>
<script>
function goView(uiNum){
	location.href='/views/user/view?ui_num=' + uiNum;
}
function getUserList(param){
	var url="/user/list";
	if(param){
		url += param;
	}
	var xhr = new XMLHttpRequest();
	xhr.open('GET',url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.responseText);
			var html = '';
			for(var i=0;i<res.length;i++){
				html += '<tr class="tr-link" onclick="goView(' + res[i].ui_num + ')">';
				html += '<td>' + res[i].ui_num + '</td>';
				html += '<td>' + res[i].ui_name + '</td>';
				html += '<td>' + res[i].ui_id + '</td>';
				html += '<td>' + res[i].ui_email + '</td>';
				html += '<td>' + res[i].ui_genre + '</td>';
				html += '<td>' + res[i].ui_address + '</td>';
				html += '<td>' + res[i].credat + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();
}

window.onload = function(){
	getUserList();
};
function search(){
	var param = '?ui_name=' + document.querySelector('#ui_name').value;
	param += '&ui_id=' + document.querySelector('#ui_id').value;
	param += '&ui_email=' + document.querySelector('#ui_email').value;
	param += '&ui_address=' + document.querySelector('#ui_address').value;
	getUserList(param);
}
</script>
<h1>영화목록</h1>
<input type="text" id="ui_name" placeholder="성명"><br>
<input type="text" id="ui_id" placeholder="아이디"><br>
<input type="text" id="ui_email" placeholder="이메일"><br>
<input type="text" id="ui_address" placeholder="주소"><button onclick="search()">검색</button>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>성명</th>
			<th>아이디</th>
			<th>이메일</th>
			<th>좋아하는장르</th>
			<th>주소</th>
			<th>가입일</th>
		</tr>
	</thead>
	<tbody id="tBody">
	</tbody>
</table>
</body>
</html>