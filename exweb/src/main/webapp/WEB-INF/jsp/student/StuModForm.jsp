<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
<style>
a {text-decoration : none}
table {
	width: 500px;
	border: 1px solid #333;
	border-collapse: collapse;
	text-align: center;
}
th, tr, td {
	border: 1px solid #333;
	padding: 10px;
}
.ipbox {
	width: 100%;
	height: 100%;
	border: 0;
}
.ipbox:focus {
	outline: none;
}
</style>
</head>
<body>
<h1>학생정보 수정</h1>

<form action='${pageContext.request.contextPath}/student/mod.do' method='post'>
<table>
		<tr>
			<td>학번 </td> <td><input class='ipbox' type='text' name='stu_no' value="${vo.stu_no}" readonly /></td>
		</tr>
		<tr>
			<td>이름 </td> <td><input class='ipbox' type='text' name='stu_name' value="${vo.stu_name}" /></td>
		</tr>
		<tr>
			<td>점수 </td> <td><input class='ipbox' type='text' name='stu_score' value="${vo.stu_score}" /></td>
		</tr>
</table>

<%-- <input type='hidden' name="stu_no" value='${vo.stu_no}' /> --%>
<input type='submit' value='수정' />
</form>
<button><a href='${pageContext.request.contextPath}/student/list.do'/>취소</a></button><br>
</body>
</html>