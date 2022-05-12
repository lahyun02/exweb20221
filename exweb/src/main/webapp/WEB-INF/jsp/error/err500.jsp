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
<title>500</title>
</head>
<body>
	<h1>500 오류 발생</h1>
	<%=exception %>
	<%-- 맨 위에 page 말고는 el태그를 사용. --%>
	${pageContext.exception}
	<%-- el안에는 기본 객체를 못씀. pageContext라는 기본 객체에서 접근해서 사용 가능. --%>
	<%-- exception.~ 예외객체 exception안의 다양한 메소드 접근 가능 --%>
</body>
</html>