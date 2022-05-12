<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%-- isErrorPage:true 오류가 난 객체에 접근 가능해서 어떤 오류가 났는지 알려줌.  --%>
<!-- page 디렉티브의 isErrorPage 속성을 "true"로 설정하면,
현재 JSP 파일이 에러 발생시 실행되는 JSP 파일이라는 것을 의미하고, 
JSP의 exception 기본객체에서 발생한 에러정보에 접근이 가능하다. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
	<h1>넌 내게 NULL을 줬어</h1>
	${pageContext.exception}
</body>
</html>