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
<h1>학생목록</h1>
<button><a href='<c:url value="/student/addform.do" />'>학생추가</a></button><br>
학번 : 이름 : 점수<br>

<c:forEach var="vo" items="${stuList}">
	<a href="<c:url value='/student/detail.do'/>?stu_no=${vo.stu_no}"> ${vo.stu_no}</a> : 
	<a href="<c:url value='/student/detail.do'/>?stu_no=${vo.stu_no}">${vo.stu_name}</a> : 
	<a href="<c:url value='/student/detail.do'/>?stu_no=${vo.stu_no}">${vo.stu_score}</a> <br>
</c:forEach>

		<!-- for(int i=0; i < list.size(); i++) {
			StudentVo vo = list.get(i);
			out.println("<a href='" + req.getContextPath() + "/student/detail.do?stu_no=" + vo.getStu_no()+ "'>" + vo.toString() + "</a><br>");
		} -->
		
</body>
</html>