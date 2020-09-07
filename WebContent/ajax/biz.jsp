<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<Map<String,String>> list = new ArrayList<>();
for(int i=1;i<=100;i++){
	Map<String,String> m = new HashMap<>();
	m.put("name","이름" + i);
	m.put("age", i + "");
	m.put("addr","주소" + i);
	list.add(m);
}
Gson g = new Gson();
out.println(g.toJson(list));
%>