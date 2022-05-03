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
</style>
</head>
<body> 
상세페이지<br>
${vo.stu_no} :${vo.stu_name}:${vo.stu_score}


<div id="wrap">
<form action='<c:url value="/student/modform.do"/>?stu_no=${vo.stu_no}' method='post'>
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