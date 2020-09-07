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
<!-- jquery 실행이 가능한거임. -->
<div class="search">
	<input type="number" id="MI_NUM" placeholder="번호검색">
	<input type="text" id="MI_NAME" placeholder="이름검색">
	<input type="text" id="MI_ID" placeholder="아이디검색">
	<button onclick="searchList()">검색</button>
</div>
<table border="1" id="memberList">
	<thead>
		<tr>
			<th data-col="MI_NUM">번호</th>
			<th data-col="MI_NAME">이름</th>
			<th data-col="MI_ID">아이디</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
</table>
<div id="pageDiv">
</div>
<script>
function searchList(){
	getList(1);
}
var pageSize = 10;
var totalCnt = 0;
var totalPage = 0;
$(document).ready(getList);

function getList(page){
	if(isNaN(page)){
		page = 1;
	}
	$.ajax({
		url:'/ajax/member',
		data:{
			cmd:'list',
			page:page,
			pageSize:pageSize,
			MI_NUM:$('#MI_NUM').val(),
			MI_NAME:$('#MI_NAME').val(),
			MI_ID:$('#MI_ID').val()
		},
		success:function(res){
			totalCnt = res.totalCnt;
			totalPage = Math.ceil(totalCnt/pageSize);
			var html=''
			for(var i=0;i<res.list.length;i++){
				html += '<tr>';
				$('th[data-col]').each(function(idx,row){
					var col = this.getAttribute('data-col');
					html += '<td><a href="/user/view.jsp?uiNum=' + res.list[i].uiNum +'">' + res.list[i][col] + '</a></td>';
				})
				html += '</tr>';
			}
			if(!res.list.length){
				html += '<tr><td colspan="' + $('th[data-col]').length + '">검색된 내용이 없습니다.</td></tr>';
			}
			$('#memberList>tbody').html(html);
			
			if(res.list.length){
				var pageHtml = '<a href="#" onclick="getList()">◀◀</a> <a href="#" onclick="getList(' + (page-1) + ')">◀</a>';
				if(page==1){
					pageHtml = '◀'; 
				}
				var sNum = (Math.ceil(page/10)-1) * 10 + 1;
				var lNum = sNum + (10-1);
				if(lNum>totalPage){
					lNum = totalPage;
				}
				for(var i=sNum;i<=lNum;i++){
					if(page==i){
						pageHtml += '[<b>' + i + '</b>]'
					}else{
						pageHtml += '[<a href="#" onclick="getList(' + i + ')">' + i + '</a>] ';
					}
				}
				var lastPageHtml = '<a href="#" onclick="getList(' + (page+1) + ')">▶</a>';
				if(totalPage==page){
					lastPageHtml = '▶';
				}
				lastPageHtml += ' <a href="#" onclick="getList(' + totalPage + ')">▶▶</a>';
				$('#pageDiv').html(pageHtml + lastPageHtml);
			}else{
				$('#pageDiv').html('');
			}			
		}
	})
}
</script>
</body>
</html>

<!-- 
1. crud 
2. mvc
3. ajax + JSON
4. maven
5. mybatis
6. pagination
 -->


