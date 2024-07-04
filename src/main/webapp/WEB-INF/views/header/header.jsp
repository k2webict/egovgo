<!DOCTYPE html>
<%@page import="org.springframework.http.server.reactive.ContextPathCompositeHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
	String contextPath = request.getContextPath();
	String pageUri =request.getRequestURI();
	
	String BBS="boardPage.jsp";
	String UMS="dataManagePage.jsp";
	String pageName = "";
	String title = "";
	if(pageUri==null) pageUri = "";
	pageName = pageUri.substring(pageUri.lastIndexOf("/")+1);
	if(pageName.equals(BBS)) {
		title = "# 게시판 서비스";
	} else if(pageName.equals(UMS)) {
		title = "# 사용자 서비스";
	} else {
		title = "--";
	}
	System.out.println("pageUri :"+pageUri);
	System.out.println("pageName:"+pageName);
	System.out.println("title   :"+title);
%>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0" />

  <link rel="stylesheet" href="<%=contextPath %>/resources/css/reset.css">
  <link rel="stylesheet" href="<%=contextPath %>/resources/css/font.css">
  <link rel="stylesheet" href="<%=contextPath %>/resources/css/common.css">
  <link rel="stylesheet" href="<%=contextPath %>/resources/css/main.css">
  <link rel="stylesheet" href="<%=contextPath %>/resources/css/jquery-ui.css">
   <link rel="stylesheet" href="<%=contextPath %>/resources/css/plugin/jquery.mCustomScrollbar.css">

  <script src="<%=contextPath %>/resources/js/jquery-3.2.1.min.js"></script>
  <script src="<%=contextPath %>/resources/js/vender/jquery.easing.1.3.js"></script>
  <script src="<%=contextPath %>/resources/js/vender/html5shiv.js"></script>
  <script src="<%=contextPath %>/resources/js/vender/respond.min.js"></script>
  <script src="<%=contextPath %>/resources/js/jquery-ui.js"></script> 
  <script src="<%=contextPath %>/resources/js/common.js"></script>
  <script src="<%=contextPath %>/resources/js/plugin/jquery.mCustomScrollbar.concat.min.js"></script>
  <script>
  
  				$(function() {
					$(window).on("load", function() {
						$(".cm-table-bx.scroll").mCustomScrollbar({
							theme : "dark"
						});
						$(".cm-table-bx.vrscroll").mCustomScrollbar({
							axis : "x",
							theme : "dark",
							scrollbarPosition : "outside",
							advanced : {
								autoExpandHorizontalScroll : true
							}
						});
						$(".cm-table-bx.vertical").mCustomScrollbar({
							axis : "yx",
							theme : "dark",
							scrollbarPosition : "outside",
							advanced : {
								autoExpandHorizontalScroll : true
							}
						});
						$(".survey-bx").mCustomScrollbar({
							axis : "yx",
							theme : "dark",
							scrollbarPosition : "outside",
							advanced : {
								autoExpandHorizontalScroll : true
							}
						});
					});
  				});
	</script>
  
  <title><%=title %></title>
<meta charset="UTF-8">
</head>
<body>
<input type ="hidden" id= session_user_id  value="${loginSession.user_id}"> 
<input type ="hidden" id= session_user_nm  value="${loginSession.user_nm}"> 
