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
	xhr.open('GET','/user/view?ui_num=' + <%=request.getParameter("ui_num")%>);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = xhr.responseText;
			res = JSON.parse(res);
			var html = '<table border="1">';
			html += '<tr>';
			html += '<th>이름</th>'
			html += '<td>' + res.ui_name + '</td>'
			html += '</tr>';
			html += '</table>';
			document.querySelector('#rDiv').innerHTML = html;
		}
	}
	xhr.send();
}
</script>
<div id="rDiv"></div>
</body>
</html>