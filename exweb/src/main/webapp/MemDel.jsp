<%@page import="com.exam.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
	MemberDao memberDao = new MemberDao();
%>

<%
	request.setCharacterEncoding("UTF-8");
	String memId = request.getParameter("memId"); 
	int num = memberDao.delete( memId );
	
	response.sendRedirect( request.getContextPath() + "/MemList.jsp");
%>