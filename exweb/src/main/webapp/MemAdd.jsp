<%@page import="com.exam.member.MemberVo"%>
<%@page import="com.exam.member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%! 
	MemberDao memberDao = new MemberDao(); 
%>

<% 
	request.setCharacterEncoding("UTF-8");
	MemberVo vo = new MemberVo();
	vo.setMemId( request.getParameter("memId") ); 
	vo.setMemPass( request.getParameter("memPass") ); 
	vo.setMemName( request.getParameter("memName") ); 
	vo.setMemPoint( Integer.parseInt( request.getParameter("memPoint") ) ); 
	int num = memberDao.insert(vo);
	
	//resp.sendRedirect("이동할사이트주소"); 명령을 사용하여, 웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송.
	// 서버 주소가 다를 수 있으니까 주소 앞에 http://localhost:8000는 생략 
	response.sendRedirect( request.getContextPath() + "/MemList.jsp");
%>
    