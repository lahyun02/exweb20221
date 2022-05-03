<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.exam.member.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<%@include file="menu.jsp" %>
<h1>JSP(Java Server Page)</h1>
HTML 문서 내에 JAVA 코드를 삽입 = HTML의 탈을 쓴 서블릿 <br/>
hello.jsp 파일을 요청하면, 톰캣은 hello.jsp 파일을 서블릿으로 변환하여 실행

<%-- 
JSP 구성요소
 - 디렉티브 : page(현재JSP페이지에 대한 설정), include(다른 JSP파일 포함), taglib(태그라이브러리사용)
 	<%@ 디렉티브명 속성명="속성값" 속성명="속성값" %>
 - 스크립트요소
 	- 스크립트릿 : <% 자바코드 %>
 		요청이 올때마다 반복해서 실행해야할때.
 	- 표현식 : <%= 현재위치에 결과값을 출력할 자바코드 %>
 	- 선언부 : <%! 서블릿의 service() 외부에 들어갈 자바코드 %>
 		요청에 상관없이 딱 한번만 실행해야될때
 	- 주석
 - 액션태그 : 자주 사용하는 자바코드를 대체할 수 있는 태그
 - EL
 - 커스텀태그 :액션태그 외에 자바코드를 태그로 대체해서 사용.
 --%>
 <h2>스크립트릿</h2>
 <%
 	// 서블릿의 service() 메서드 내부에 작성하는 것처럼 자유롭게 자바 코드 작성 
 	String local = "지역변수";
 	//System.out.println( local );
 	
 	// 변수 선언 없이 사용가능한 JSP 기본객체들
//	request(요청객체), response(응답객체), session(세션객체), application(서블릿컨텍스트객체)
//	out(응답객체에 출력하는 응답출력스트림), config(ServletConfig객체-LifeServlet참고), 
//	pageContext (현재 JSP파일에 대한 모든 정보를 포함) - jsp에 새로 추가된 기능.
//	page(현재JSP객체), Exception(발생한 예외 객체)
	out.println("브라우저에 출력할 내용");
	out.println( session == request.getSession() );
	out.println( application == request.getServletContext() );
	out.println( config == getServletConfig() );
 	pageContext.setAttribute("pa", "pv");	//현재 JSP파일에서만 사용가능한 데이터 저장
 	// pageContext에는 다른 JSP 기본객체들이 모두 저장되어 있다.
 	out.println( request == pageContext.getRequest() ); //el사용시 우측과 같은 방법으로 사용.
 	out.println( response == pageContext.getResponse() );
 	out.println( session == pageContext.getSession() );
 	out.println( application == pageContext.getServletContext() );
 	out.println( page == this );	
 %>
 <h2>표현식</h2>
 <% out.print(local); %>
 <%= local %>
 <%-- 위에것과 아래것이 완전히 똑같다고 할 순 없지만 같은 기능을 함. --%>
 
 <h2>선언부</h2>
 <%=global %> 
 <%-- 원랜 변수 선언전에 출력해서 오류가 떠야하지만 변수 선언시에 느낌표가 들어간 선언부(전역변수)를 사용해서 오류가 안뜸..--%>
 <%! String global = "전역변수"; %> 
 <%-- 서비스 메서드 바깥쪽에 들어가는 코드를 작성. 서비스 메서드는 요청이 들어올떄마다 실행. 바깥쪽에는 한번 실행하면 계속 남아있음.  --%>
 
 <h2>액션태그</h2>
 <%
 	MemberVo v = (MemberVo)pageContext.getAttribute("m");
 	if(v==null){
 		v = new MemberVo();
 		pageContext.setAttribute("m", v);
 	}
 	v.setMemId("a001");
 	out.print( v.getMemId() );
 %>
<%-- <jsp:useBean id="m" class="com.exam.member.MemberVo" scope="page"></jsp:useBean> --%>
<%-- page안에m 이라는 이름으로 MemberVo가 저장된 객체가 있으면 불러오고, 없으면 m으로 만들어서 가져와라. --%>
<%-- <jsp:setProperty property="memId" name="m" value="a001"/> --%>
<%--  속성, 객체이름(id써주면 됨) m이라는 이름으로 저장된 memId의 속성값을 내가 원하는 것으로. 
value는 내가 직접 써주는 것. param은 파라미터 값을 불러올 수 있음. --%>
<%-- <jsp:getProperty property="memId" name="m"/> --%>
<%-- 저장된 걸 꺼내서 출력함 out.print( v.getMemId() );랑 똑같음. --%>
 
 <%
 	//forward : 현재 서블릿(JSP) 실행을 중단하고 다른 서블릿(JSP)를 실행
 	//include : 다른 서블릿(JSP)의 실행 결과를 현재 위치에 포함 
 	/* request.getRequestDispatcher("menu.jsp").forward(request, response); */
 	/* 점프해서 가져와서 */
 	/* request.getRequestDispatcher("menu.jsp").include(request, response); */
 	/* 점프해서 가져온 다음 다시 돌아와서 나머지 실행 */
 %>
<%--  <jsp:forward page="menu.jsp"></jsp:forward> --%>
<%-- <jsp:include page="menu.jsp"></jsp:include> --%>

 <h1>EL(Expression Language)</h1>
 JSP 표현식과 유사
 ${123} ${"문자열1"} ${'문자열2'} ${3+4}
 EL에서 xxx라고 쓰면, 
 변수이름이 아니라  pageContext, request, session, application에 저장된 속성을 의미 <br/>
 <%
 	String s = "야채피자";
 	pageContext.setAttribute("pcs", s);
 	int[] arr = { 3, 6, 9 };
 	pageContext.setAttribute("ar", arr);
 	HashMap map = new HashMap();
 	map.put("k", "v");
 	pageContext.setAttribute("ma", map);
 	// ma라는 이름으로 map값을 저장.
 %>
 <%=s %> ${pcs} <br/>
배열의 1번칸의 값 : <%=arr[1] %> ${ar[1]} <br/>
맵에 "k"라는 이름으로 저장된 값 : <%=map.get("k") %> ${ma.get("k")} ${ma.k} ${ma["k"]} ${ma['k']} <br/>
객체의 getXxx() 속성값 : <%=v.getMemId() %> ${m.getMemId()} ${m.memId} ${m["memId"]} ${m['memId']}  <br/>
<!-- 속성이름에 특수분자가 들어가있을떄 따옴표를 쓴다.  -->

<%
	pageContext.setAttribute("pa", 12);
	request.setAttribute("ra", 34);
	session.setAttribute("sa", 56);
	application.setAttribute("aa", 78);
%>
<!-- 데이터저장하고 꺼내쓸떄 사용  -->
<%=pageContext.getAttribute("pa") %> ${pageScope.pa} ${pageScope['pa']}	${pa}<br/>
<%=request.getAttribute("ra") %> ${requestScope.ra} ${requestScope['ra']} ${ra}	<br/>
<%=session.getAttribute("sa") %> ${sessionScope.sa} ${sessionScope['sa']} ${sa}	<br/>
<%=application.getAttribute("aa") %> ${applicationScope.aa} ${applicationScope['aa']} ${aa}	<br/>
xxxScope을 생략하면, (${aa})
pageScope > requestScope > sessionScope > applicationScope 순서로 탐색하여
먼저 발견되는 속성값을 사용.

EL 사용시, null 값은 오류를 발생시키지 않고 화면에 출력이 없음
<%-- <%=request.getAttribute("xxx") %>  --%>
<%-- <%=request.getAttribute("xxx").equals() %>  nullpointexception--%>
${requestScope.xxx}
${requestScope.xxx.yyy}
EL에서 별도의 변수선언 없이 사용 가능한 기본객체 (JSP 기본객체와 다르다 )
<br/>
파라미터값 : <%=request.getParameter("x") %> ${param.x} ${param['x']} <br/>
파라미터값 : <%=request.getParameterValues("x")[0] %> ${paramValues.x[1]} ${paramValues['x'][2]} <br/>
헤더값 :  <%=request.getHeader("User-Agent") %> ${header['User-Agent'] } <br/>
헤더값이 여러개인 경우 : headerValues 사용 <br/>
쿠키값 : 
<%=request.getCookies()[0].getName() %> ${cookie.JSESSIONID.name }
<%=request.getCookies()[0].getValue() %> ${cookie.JSESSIONID.value } <br/>
초기화파라미터값: <%=config.getInitParameter("x") %> ${InitParam.x } <br/>
EL에서 JSP 기본객체를 사용하고 싶은 경우, pageContext를 통해서 사용 <br/>
<%=request.getContextPath() %>
${pageContext.request.contextPath} 
<%-- el에선 메소드없이 그냥 호출 가능 --%>

<h1>JSTL(JSP Standard Tag Library)</h1>
프로젝트에 JSTL 라이브러리 추가
현재 JSP 파일에서 사용하고 싶은 태그라이브러리를 taglib 디렉티브로 지정 <br/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- html과 구분되는 접두어를 커스텀태그 앞에 붙임. 보통 core의 약자를 써서 c를 많이 사용 -->
<%
//	int score = 80;
//	pageContext.setAttribute("score", 80);
%>
pageContext(가장 저장기간이 짧음, scope지정 생략시-Default기본값), request, session, servletContext에 속성 저장  <br/>
<c:set scope="page" var="score" value="${80}"></c:set>
<%--value안에 숫자를 작성할 때는 el이나 표현식으로 작성 --%>
속성제거-> 위 4군데에 돌아가면서 다 지움(scope지정 생략시) <br/>
<c:remove scope="page" var="score"/>

<h3>조건문</h3>
<c:if test="${score>60 }" >통과</c:if>
<%-- 조건문 안에el이나 표현식을 사용하면 되지만 요즘은 거의 el사용.
	조건식이 참이면 통과가 나오고, 거짓이면 그냥 안나옴. --%>

<%-- if else문처럼 쓰고싶을경우 --%>
<c:choose>
	<c:when test="${score>=90}">최우수</c:when>
	<c:when test="${score>=80}">우수</c:when>	
	<c:otherwise>보통</c:otherwise>				
</c:choose>
<br/>

<h3>반복문</h3>
<%
	for(int num=1;num<=10;num+=1){
		out.print(num);
	}
%>
<c:forEach var="num" begin="1" end="10" step="2" varStatus="n">${num}, 
	${pageScope.num}, ${requestScope.num}, ${sessionScope.num}, ${applicationScope.num}<br/>
	${n.begin}, ${n.end}, ${n.step}<br/>
</c:forEach>
<ul>
<%-- <% for(int no:arr) out.print("<li>" + no + "</li>"); %> --%>
<%-- <c:forEach var="no" items="${ar}"> <li>${no}</li> </c:forEach>--%>
<c:forEach var="no" items="${ar}" varStatus="st" > 
	<li>
	${no} == ${st.current} 현재값,
	${st.index} 몇번째반복인지(0부터),
	${st.count} 몇번째반복인지(1부터),
	${st.first} 첫번째반복인지 여부,
	${st.last} 마지막반복인지 여부,
	${st.begin} 태그의 begin 속성값,
	${st.end} 태그의 end 속성값,
	${st.step} 태그의 step 속성값
	</li> 
</c:forEach>
</ul>
<c:forTokens var="tk" items="${'a,b:c,d'}" delims=",">[${tk}]</c:forTokens> <br/>
<c:forTokens var="tk" items="${'a,b:c,d'}" delims=",:">[${tk}]</c:forTokens> <br/>

<h3>출력</h3>
<% pageContext.setAttribute("str", "<h1>제목</h1>"); %>
${str}
<c:out value="${str}" ></c:out> <%-- html태그를 &lt; &gt;으로 자동 변환해서 출력-> html태그로 해석안됨. --%>

<h3>주소처리</h3>
상대경로: <a href="menu.jsp" target="_blank">메뉴JSP로 이동</a>
절대경로: <a href="<%=request.getContextPath()%>/menu.jsp" target="_blank">메뉴JSP로 이동</a> <%-- "/exweb/menu.jsp" --%>
절대경로: <a href="${pageContext.request.contextPath}/menu.jsp" target="_blank">메뉴JSP로 이동</a> <br/>
경로가 /로 시작하면 컨텍스트패스를 앞에 자동으로 붙여준다. 
<a href="<c:url value='/menu.jsp' />">메뉴 JSP로 이동</a>


JSP 파일의 내용을 이곳에 복사한 후 하나의 서블릿으로 변환 (같은 어플리케이션 내의 내용 포함)
<%@ include file="menu.jsp" %> <%-- menu.jsp 소스내용을 갖다 붙여넣음 (하나의 파일로 합침) --%>
다른 서블릿 또는 JSP를 실행한 결과(출력내용)를 이곳에 포함 (같은 어플리케이션 내의 내용 포함)
<jsp:include page="menu.jsp" /> <%-- 기존jsp실행하다가 menu.jsp를 호출함 --%>
다른 서블릿 또는 JSP 를 실행한 결과를 포함 (프로젝트 외부의 사이트 내용 포함 가능)
<c:import url="menu.jsp" />
<%--<c:import url="http://google.com" />--%>

<%-- <% response.sendRedirect( request.getContextPath() + "/menu.jsp"); %> --%>
<%--<c:redirect url="/menu.jsp" />--%>

<%-- <c:param/> 태그를 사용하여 주소처리 태그들에 파라미터 추가 가능 --%>

<h3>예외처리</h3>
<c:catch var="e">
	<% int x = 5/0; %>
</c:catch>
예외발생 : ${e.message}

<h2>국제화/포맷팅</h2>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% pageContext.setAttribute("d", new Date() ); %>
현재시간 : ${d} <br/>
자바 Date 객체를 원하는 형태의 문자열로 변환 :
<fmt:formatDate value="${d}" pattern="yyyy/MM/dd HH:mm:ss" /> <br/>
날짜 시간 문자열을 자바 Date 객체로 변환 :
<fmt:parseDate value="2020/08/15 13:24:56" pattern="yyyy/MM/dd HH:mm:ss" var="d2" /> 
${d2}<br/>

숫자값을 문자열로 변환 : 
<% pageContext.setAttribute("n", 1234.56); %>
<fmt:formatNumber value="${n}" pattern="###,###.###" />
<fmt:formatNumber value="${n}" pattern="000,000.000" /> <br/> <%-- 자리에 값이 없으면 0으로 채움 --%>
숫자문자열을 숫자값으로 변환 : 
<fmt:parseNumber value="12,345.67" pattern="###,###.###" var="n2" />
${n2}

JSTL 국제화 태그들이 사용할 로케일 지정 
(미지정시 Accept-Language 요청 헤더 값 사용)
"언어코드_국가코드" 또는 "언어코드-국가코드" 또는 "언어코드" 또는 "국가코드"
<fmt:setLocale value="en_US" />

<br>
국제화 : 각 나라별로 접속했을 떄 해당 언어로 출력되는 것.
메시지를 저장한 프로퍼티 파일명이 "클래스패스/폴더명/번들명_언어_국가.properties"인 경우 
basename은 "폴더명.번들명" <br/>
<fmt:setBundle basename="msg" var="mb" />
<fmt:message bundle="${mb}" key="str" />

<h3>함수</h3>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<br> ${fn:length("aBcD")} <%="aBcD".length() %>
<br> ${fn:contains("aBcD","Bc")} <%="aBcD".contains("Bc") %>    
<br> ${fn:containsIgnoreCase("aBcD","bC")}  <%="aBcD".toLowerCase().contains("bC".toLowerCase()) %>
<br> ${fn:startsWith("aBcD","aB")} <%="aBcD".startsWith("aB") %>
<br> ${fn:endsWith("aBcD","cD")} <%="aBcD".endsWith("cD") %>
<br> ${fn:escapeXml("<h1>제목</h1>")} <c:out value="<h1>제목</h1>" />
<br> ${fn:indexOf("aBcD","Bc")} <%="aBcD".indexOf("Bc") %>
<br> ${fn:join(ar,"::")} <%=String.join("::", "3,6,9".split(",") )%>
<br> ${(fn:split("a,B:c,D",",:"))[2]} <%="a,B:c,D".split("[,:]")[2] %>
<br> ${fn:replace("aBcDBc","Bc","efg")} <%="aBcDBc".replace("Bc","efg") %>
<br> ${fn:substring("aBcD", 1, 2)} <%="aBcD".substring(1,2) %>
<br> ${fn:substringAfter("aBcD", "Bc")}
<br> ${fn:substringBefore("aBcD", "Bc")}
<br> ${fn:toLowerCase("aBcD")} <%="aBcD".toLowerCase() %>
<br> ${fn:toUpperCase("aBcD")} <%="aBcD".toUpperCase() %>
<br> [${fn:trim("   aB cD  ")}] [<%="   aB cD  ".trim() %>]


</body>
</html>