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
table {
	width: 70%;
	border: 1px solid #333;
	border-collapse: collapse;
	text-align: center;
}
th, tr, td {
	border: 1px solid #333;
	padding: 10px;
	
}
</style>
</head>
<body>
<h1>학생목록</h1>
<button><a href='<c:url value="/student/addform.do" />'>학생추가</a></button><br>

<table>
	<thead>
		<tr>
			<th> 학번</th>
			<th> 이름</th>
			<th> 점수</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="vo" items="${stuList}">
			<tr>
				<td><a href="<c:url value='/student/detail.do'/>?stu_no=${vo.stu_no}"> ${vo.stu_no}</a></td>
				<td><a href="<c:url value='/student/detail.do'/>?stu_no=${vo.stu_no}">${vo.stu_name}</a></td>
				<td><a href="<c:url value='/student/detail.do'/>?stu_no=${vo.stu_no}">${vo.stu_score}</a></td>
			</tr>
		</c:forEach>
	</tbody>


</table>		
</body>
</html>