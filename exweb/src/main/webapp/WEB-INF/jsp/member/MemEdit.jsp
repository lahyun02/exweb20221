<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>Insert title here</title>
</head>
<body>
<h1>회원정보변경</h1>

<form action='${pageContext.request.contextPath}/member/edit.do' method='post'>
<%-- 아이디 : <input type='text' name='memId' value="${requestScope.memVo.memId}" /> requestScrope는 생략가능<br>--%>
아이디 : <input type='text' name='memId' value="${memVo.memId}" readonly/><br>
<%-- 아이디는 변경안되게 해야함. readonly:고치지 못하고 파라미터로 전송 | disable : 고치지 못하고 파라미터로 전송되 안됨. --%>
비밀번호 : <input type='password' name='memPass' value="${memVo.memPass}"/><br>
이름 : <input type='text' name='memName' value="${memVo.memName}"/><br>
포인트 : <input type='text' name='memPoint' value="${memVo.memPoint}"/><br>
<input type='submit' />
</form>

</body>
</html>
