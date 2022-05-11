<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
</head>
<body>
<h1>학생정보 수정</h1>

<form action='${pageContext.request.contextPath}/student/mod.do' method='post'>

학번 : <input type='text' name='stu_no' value="${vo.stu_no}" /><br>
이름 : <input type='text' name='stu_name' value="${vo.stu_name}" /><br>
점수 : <input type='text' name='stu_score' value="${vo.stu_score}" /><br>
<input type='hidden' name='up_stu_no' value="${vo.stu_no}" />
<input type='submit' />
</form>

</body>
</html>