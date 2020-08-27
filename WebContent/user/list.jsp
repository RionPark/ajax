<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
<table border="1" id="userList">
	<thead>
		<tr>
			<th data-col="uiNum">번호</th>
			<th data-col="uiName">이름</th>
			<th data-col="uiId">아이디</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
<script>
$(document).ready(function(){
	$.ajax({
		url:'/ajax/user',
		data:{
			cmd:'list'
		},
		success:function(res){
			var html=''
			for(var i=0;i<res.length;i++){
				html += '<tr>';
				$('th[data-col]').each(function(idx,row){
					var col = this.getAttribute('data-col');
					html += '<td>' + res[i][col] + '</td>';
				})
				html += '</tr>';
			}
			$('#userList>tbody').html(html);
		}
	})
})
</script>
</body>
</html>