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
function getMovieList(param){
	var url="/movie/list";
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
				html += '<tr>';
				html += '<td>' + res[i].mi_num + '</td>';
				html += '<td>' + res[i].mi_name + '</td>';
				html += '<td>' + res[i].mi_genre + '</td>';
				html += '<td>' + res[i].mi_producer + '</td>';
				html += '<td>' + res[i].mi_director + '</td>';
				html += '<td>' + res[i].mi_release_date + '</td>';
				html += '<td>' + res[i].mi_credat + '</td>';
				html += '</tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();
}

window.onload = function(){
	getMovieList();
};
</script>
<h1>영화목록</h1>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>영화</th>
			<th>장르</th>
			<th>제작사</th>
			<th>감독</th>
			<th>상영일</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody id="tBody">
	</tbody>
</table>
</body>
</html>