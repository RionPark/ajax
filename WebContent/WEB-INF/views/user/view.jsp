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
	function showUDiv(){
		var dis = document.querySelector('#rDiv').style.display;
		if(dis){
			document.querySelector('#rDiv').style.display = '';
			document.querySelector('#uDiv').style.display = 'none';
		}else{
			document.querySelector('#rDiv').style.display = 'none';
			document.querySelector('#uDiv').style.display = '';
		}
	}
	window.onload = function() {
		var xhr = new XMLHttpRequest();
		xhr.open('GET', '/user/view?ui_num='+<%=request.getParameter("ui_num")%>);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var res = xhr.responseText;
				res = JSON.parse(res);
				var html = '<table border="1">';
				html += '<tr>';
				html += '<th>이름</th>'
				html += '<td>' + res.ui_name + '</td>'
				html += '</tr>';
				html += '<tr>';
				html += '<th>아이디</th>'
				html += '<td>' + res.ui_id + '</td>'
				html += '</tr>';
				html += '<tr>';
				html += '<th>이메일</th>'
				html += '<td>' + res.ui_email + '</td>'
				html += '</tr>';
				html += '<tr>';
				html += '<th>주소</th>'
				html += '<td>' + res.ui_address + '</td>'
				html += '</tr>';
				html += '<tr>';
				html += '<th colspan="2"><button onclick="showUDiv()">수정</button>  <button>삭제</button></th>'
				html += '</tr>';
				html += '</table>';
				document.querySelector('#rDiv').innerHTML = html;
				for(var key in res){
					var obj = document.querySelector('#' + key);
					if(obj){
						obj.value = res[key];
					}
				}
			}
		}
		xhr.send();
	}
</script>
	<div id="rDiv"></div>
	<div id="uDiv" style="display:none">
		<table border="1">
			<tbody>
				<tr>
					<th>이름</th>
					<td><input type="text" id="ui_name"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="ui_id"></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" id="ui_email"></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" id="ui_address"></td>
				</tr>
				<tr>
					<th colspan="2">
						<button>수정</button>
						<button onclick="showUDiv()">취소</button>
					</th>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>