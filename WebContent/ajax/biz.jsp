<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<String> strList = new ArrayList<>();
strList.add("서울");
strList.add("경기");
strList.add("부산");
strList.add("광주");
Gson g = new Gson();
out.println(g.toJson(strList));
%>