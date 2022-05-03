<%@page import="com.exam.member.MemberVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.exam.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	MemberDao memberDao = new MemberDao();
%>
<%
		ArrayList<MemberVo> list = memberDao.selectList(); //요청이 올때마다 실행해야 함. 테이블의 내용이 변경될 수 있기 때문.
%>		
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset='UTF-8'>
		<title>Insert title here</title>
		<style>
		a {text-decoration : none}
		</style>
		</head>
		<body>
		<h1>회원목록</h1>
		<button><a href='<%=request.getContextPath()%>/MemAddForm.jsp'>회원추가</a></button><br>
		회원아이디 : 회원비밀번호 : 회원이름 : 회원포인트<br>
<%		
		for(int i=0; i < list.size(); i++) {
			MemberVo vo = list.get(i);
%>		

<%-- 	<%= vo.getMemId()%> : <%=vo.getMemPass() %> : <%=vo.getMemName() %> : <%=vo.getMemPoint() %>  --%>
		<%=vo.toString() %>
			
			<button><a href='<%=request.getContextPath() %>/MemDel.jsp?memId=<%=vo.getMemId()%>'>삭제</a></button><br>
<%	
		}
%>		
		</body>
		</html>
		
    
