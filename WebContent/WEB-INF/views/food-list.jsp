<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<Map<String,String>> foodList = (List<Map<String,String>>)request.getAttribute("foodList");
%>
<form>
	<input type="text" name="fi_name">
	<button>검색</button>
</form>
<table border="1">
	<thead>
		<tr>
			<th>번호</th>
			<th>메뉴</th>
			<th>가격</th>
			<th>종류</th>
			<th>등록일</th>
			<th>등록시간</th>
		</tr>
	</thead>
	<tbody id="tBody">
<%
	for(Map<String,String>food : foodList){
%>
		<tr>
			<td><%=food.get("fi_num") %></td>
			<td><%=food.get("fi_name") %></td>
			<td><%=food.get("fi_price") %></td>
			<td><%=food.get("fi_type") %></td>
			<td><%=food.get("fi_credat") %></td>
			<td><%=food.get("fi_cretim") %></td>
		</tr>
<%
	}
%>
	</tbody>
</table>
</body>
</html>