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
window.onload = function(){
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/ajax');
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status==200){
			var res = xhr.responseText;
			res = JSON.parse(res);
			var html = '';
			for(var i=0;i<res.length;i++){
				var map = res[i];
				html += '<tr><td>' + map.name + '</td><td>' + map.age + '</td></tr>';
			}
			document.querySelector('#tBody').innerHTML = html;
		}
	}
	xhr.send();
}
</script>
<table border="1">
	<thead>
		<tr>
			<th>이름</th>
			<th>나이</th>
		</tr>
	</thead>
	<tbody id="tBody">
	</tbody>
</table>
</body>
</html>