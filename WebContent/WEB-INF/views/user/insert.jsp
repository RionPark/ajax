<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="ui_name" placeholder="이름"><br>
<input type="text" id="ui_id" placeholder="아이디"><button onclick="checkId()">중복확인</button><br>
<input type="text" id="ui_pwd" placeholder="비밀번호"><br>
<input type="checkbox" id="g1" name="ui_genre" value="미스터리">
<label for="g1">미스터리</label>
<input type="checkbox" id="g2" name="ui_genre" value="추리">
<label for="g2">추리</label>
<input type="checkbox" id="g3" name="ui_genre" value="반전">
<label for="g3">반전</label>
<br>
<input type="text" id="ui_email" placeholder="이메일"><br>
<select id="ui_phone1">
	<option>선택</option>
	<option value="010">010</option>
	<option value="011">011</option>
	<option value="017">017</option>
	<option value="018">018</option>
	<option value="019">019</option>
</select>-
<input type="text" id="ui_phone2" placeholder="폰번호2"><br>
<input type="text" id="ui_address" placeholder="주소"><br>
<select id="ui_hint">
	<option>질문선택</option>
	<option value="보물1호">보물1호</option>
	<option value="별명">별명</option>
</select><br>
<input type="text" id="ui_answer" placeholder="대답"><br>
<input type="file" id="ui_img"><br>
<button onclick="insertUser()">유저등록</button>
<script>
function checkId(){
	var uiId = document.querySelector('#ui_id').value;
	if(uiId.trim().length<4){
		alert('아이디는 4글자 이상입니다.');
		return;
	}
	var xhr = new XMLHttpRequest();
	xhr.open('GET','/user/check?ui_id=' + uiId);
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			console.log(xhr.responseText);
			var res = JSON.parse(xhr.responseText);
			if(res.result==1){
				alert('해당아이디로는 가입이 불가능합니다.');
				document.querySelector('#ui_id').value = '';
				document.querySelector('#ui_id').focus();
			}else{
				alert('해당아이디로는 가입가능한 아이디입니다.');
				idCheck = true;
			}
		}
	}
	xhr.send();
}
function insertUser(){
	var uiName = document.querySelector('#ui_name').value;
	if(uiName.trim().length<2){
		alert('이름은 1글자일 수 없습니다.');
		return;
	}
	var xhr = new XMLHttpRequest();
	var param = {
			ui_name : document.querySelector('#ui_name').value,
			ui_id : document.querySelector('#ui_id').value,
			ui_pwd : document.querySelector('#ui_pwd').value,
			ui_phone1 : document.querySelector('#ui_phone1').value,
			ui_phone2 : document.querySelector('#ui_phone2').value,
			ui_address : document.querySelector('#ui_address').value,
			ui_email : document.querySelector('#ui_email').value,
			ui_hint : document.querySelector('#ui_hint').value,
			ui_answer : document.querySelector('#ui_answer').value
	}
	var checks = document.querySelectorAll('[name=ui_genre]:checked');
	var ui_genre = '';
	for(var i=0;i<checks.length;i++){
		var obj = checks[i];
		ui_genre += obj.value+ ",";
	}
	ui_genre = ui_genre.substring(0,ui_genre.length-1);
	param.ui_genre = ui_genre;
	param = JSON.stringify(param);
	xhr.open('POST','/user/insert');
	xhr.setRequestHeader('content-type','application/json');
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4 && xhr.status==200){
			var res = JSON.parse(xhr.responseText);
			if(res.result==1){
				alert('회원가입이 완료되었습니다.');
			}else{
				alert('회원가입 중 에러가 발생하였습니다.');	
			}
		}
	}
	xhr.send(param);
}
</script>
</body>
</html>