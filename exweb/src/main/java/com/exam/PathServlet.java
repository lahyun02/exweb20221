package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청을 받았을때 실행되는 서블릿으로 등록하고,
//"/bye.do" 주소로 요청이 오면 실행
//톰캣 6 이하는 이 방식 사용 불가. 남이 만들어놓은 클래스는 보통 컴파일한 파일을 배포하기 때문에 이 방식 사용 불가. 

//서블릿 주소(경로) 지정 방법
// 경로는 반드시 / 또는 *.로 시작
//@WebServlet("/abc/def/ghi")  //경로를 파일명까지 정확하게 지정. (괄호 안에 주소는 /로 시작하는 절대경로 주소로 작성.)
//@WebServlet("/abc/*") // 특정 디렉토리(폴더) 아래의 모든 경로 지정 (* : 이 뒤에는 뭐가 오든지 상관없음! 아무 문자나 와도 실행됨.)
@WebServlet("*.action") // 특정 확장자로 끝나는 모든 경로 지정 (* : 이 뒤에는 뭐가 오든지 상관없음! 아무 문자나 와도 실행됨.)
public class PathServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); 
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>PathServlet실행</h1>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
