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
			pageSize:pageSize
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
			$('#memberList>tbody').html(html);
			var pageHtml = '<a href="#" onclick="getList(' + (page-1) + ')">◀</a>';
			for(var i=1;i<=10;i++){
				if(page==i){
					pageHtml += '[<b>' + i + '</b>]'
				}else{
					pageHtml += '[<a href="#" onclick="getList(' + i + ')">' + i + '</a>] ';
				}
			}
			pageHtml+= '<a href="#" onclick="getList(' + (page+1) + ')">▶</a>';
			$('#pageDiv').html(pageHtml);
		}
	})
}
</script>
</body>
</html>




