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

<table border="1">
	<tr>
		<th data-col="uiName">이름</th>
		<td><input type="text" id="uiName"></td>
	</tr>
	<tr>
		<th data-col="uiId">아이디</th>
		<td><input type="text" id="uiId"></td>
	</tr>
	<tr>
		<th data-col="uiPassword">비밀번호</th>
		<td><input type="password" id="uiPassword"></td>
	</tr>
	<tr>
		<th data-col="uiBirth">나이</th>
		<td><input type="date" id="uiBirth"></td>
	</tr>
	<tr>
		<th data-col="uiAge">나이</th>
		<td><input type="text" id="uiAge"></td>
	</tr>
	<tr>
		<th data-col="uiNickname">별명</th>
		<td><input type="text" id="uiNickname"></td>
	</tr>
	<tr>
		<th data-col="uiAdmin">어드민여부</th>
		<td><input type="text" id="uiAdmin"></td>
	</tr>
	<tr>
		<th colspan="2">
			<button onclick="doInsert()">생성</button>
			<a href="/user/list.jsp"><button>취소</button></a>
		</th>
	</tr>
</table>
<script>
function doInsert(){
	var param = {};
	$('input[id]').each(function(idx,input){
		var id = input.id;
		param[id] = input.value;
	});
	param.cmd = 'insert';
	$.ajax({
		url:'/ajax/user',
		method:'POST',
		data:JSON.stringify(param),
		success:function(res){
			if(res.result){
				alert('생성이 완료되었습니다.');
				location.href='/user/list.jsp';
			}else{
				alert('이미 삭제되었습니다.');
			}
		}
	})
}
</script>
</body>
</html>