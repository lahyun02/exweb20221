<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
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
		<button><a href='${pageContext.request.contextPath}/member/addform.do'>회원추가</a></button><br>
		<button><a href='<c:url value="/member/addform.do" />'>회원추가</a></button><br>
		회원아이디 : 회원비밀번호 : 회원이름 : 회원포인트<br>
	
<c:forEach var="vo" items="${memList}">
 		${vo.memId} : ${vo.memPass} : ${vo.memName} : ${vo.memPoint}  
		<button><a href='${pageContext.request.contextPath}/member/del.do?memId=${vo.memId}'>삭제</a></button><br>
</c:forEach>

		</body>
		</html>
		
    
