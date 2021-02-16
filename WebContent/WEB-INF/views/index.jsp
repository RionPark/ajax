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
function getList(param){
	var url = '/ajax';
	if(param){
		url += param;
	}
	var xhr = new XMLHttpRequest();
	xhr.open('GET',url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var res = xhr.responseText;
			res = JSON.parse(res);
			var html = '';
			for(var i=0;i<res.length;i++){
				var map = res[i];
				html += '<tr><td>' + map.fi_num + '</td><td>' + map.fi_name + '</td>';
				html += '<td>' + map.fi_price + '</td>';
				html += '<td>' + map.fi_type + '</td>';
				html += '<td>' + map.fi_credat + '</td>';
				html += '<td>' + map.fi_cretim + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();
}

window.onload = function(){
	getList();
}
function search(){
	var param = '?fi_name=' + document.querySelector('#fi_name').value;
	getList(param);
}
</script>
<input type="text" id="fi_name" placeholder="메뉴명">
<button onclick="search()">검색</button>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>메뉴</th>
			<th>가격</th>
			<th>종류</th>
			<th>등록일</th>
			<th>등록시간</th>
		</tr>
	</thead>
	<tbody id="tBody">
	</tbody>
</table>
</body>
</html>