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
<script>
	var uiNum = ${param.uiNum};

	$(document).ready(function(){
		$.ajax({
			url:'/ajax/user',
			data:{
				cmd:'view',
				uiNum:uiNum
			},
			success:function(res){
				$('th[data-col]').each(function(idx,row){
					var col = row.getAttribute('data-col');
					$('#' + col).html(res[col]);
				});
			}
		})
	})
	
	function changeModify(){
		$('[id]').each(function(idx,td){
			var value = td.innerText;
			var html = '<input type="text" id="i' +td.id+'" value="'+ value +'">' ;
			td.innerHTML = html;
		})
	}
	
	function doDelete(){
		$.ajax({
			url:'/ajax/user',
			method:'POST',
			data:JSON.stringify({
				cmd:'delete',
				uiNum:uiNum
			}),
			success:function(res){
				if(res.result){
					alert('삭제 되었습니다.');
					location.href='/user/list.jsp';
				}else{
					alert('이미 삭제되었습니다.');
				}
			}
		})
	}
</script>
<table border="1">
	<tr>
		<th data-col="uiNum">번호</th>
		<td id="uiNum"></td>
	</tr>
	<tr>
		<th data-col="uiName">이름</th>
		<td id="uiName"></td>
	</tr>
	<tr>
		<th data-col="uiId">아이디</th>
		<td id="uiId"></td>
	</tr>
	<tr>
		<th data-col="uiAge">나이</th>
		<td id="uiAge"></td>
	</tr>
	<tr>
		<th data-col="uiNickname">별명</th>
		<td id="uiNickname"></td>
	</tr>
	<tr>
		<th data-col="uiCredat">가입일</th>
		<td id="uiCredat"></td>
	</tr>
	<tr>
		<th data-col="uiAdmin">어드민여부</th>
		<td id="uiAdmin"></td>
	</tr>
	<tr>
		<th colspan="2">
			<button onclick="changeModify()">수정</button>
			<button onclick="doDelete()">삭제</button>
		</th>
	</tr>
</table>
</body>
</html>