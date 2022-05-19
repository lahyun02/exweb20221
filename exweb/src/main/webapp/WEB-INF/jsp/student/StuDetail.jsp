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
#wrap { display: flex; }
form { margin-right: 10px; }
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
<h2>상세페이지</h2>
<table>
	<thead>
		<tr>
			<th> 학번</th>
			<th> 이름</th>
			<th> 점수</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${vo.stu_no}</td>
			<td>${vo.stu_name}</td>
			<td>${vo.stu_score}</td>
		</tr>
	
	</tbody>
</table>



<div id="wrap">
<form action='<c:url value="/student/mod.do"/>?stu_no=${vo.stu_no}' method='get'>
<input type='hidden' name='stu_no' value='${vo.stu_no}' />
<input type='submit' value='수정' />
</form>

<form action='<c:url value="/student/del.do"/>' method='post'>
<input type='hidden' name='stu_no' value='${vo.stu_no}' />
<input type='submit' value='삭제' />
</form>

<button><a href='<c:url value="/student/list.do"/>'>목록</a></button><br>
</div>


</body>
</html>