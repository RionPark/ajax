<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
List<String> nameList = new ArrayList<>();
nameList.add("김철수");
nameList.add("이철수");
nameList.add("한철수");
String json = "[";
for(String name:nameList){
	json += "\"" + name + "\",";
}
json = json.substring(0,json.length()-1);
json += "]";
%>
<%=json%>