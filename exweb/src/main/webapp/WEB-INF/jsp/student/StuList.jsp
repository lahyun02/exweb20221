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
	width: 800px;
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
<button><a href='<c:url value="/student/add.do" />'>학생추가</a></button><br>

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
				<td><a href="${pageContext.request.contextPath}/student/detail.do?stuNo=${vo.stuNo}"><c:out value="${vo.stuNo}" /></a></td>
				
				<td><c:out value="${vo.stuName}" /></td>
				<td><c:out value="${vo.stuScore}" /></td>
			</tr>
		</c:forEach>
	</tbody>


</table>		
</body>
</html>