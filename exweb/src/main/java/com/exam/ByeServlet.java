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
@WebServlet("/bye.do")  //괄호 안에 주소는 각자 정하는 부분.
public class ByeServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ByeServlet 실행!");
		
		//출력스트림을 가져오기 전에 응답객체의 문자인코딩 설정
//		resp.setCharacterEncoding("UTF-8"); //컴퓨터는 문자를 숫자로 저장하기 때문에 한글은 깨짐. 한글이 잘 보일수 있도록 해줌.
		//응답내용이 HTML 문서 텍스트임을 클라이언트에게 알려줌
//		resp.setContentType("text/html");
		//응답내용의 문자인코딩과 문서형식을 동시에 설정 가능
		resp.setContentType("text/html;charset=UTF-8");
		
		
		//응답객체에 응답내용을 쓸 수 있는 출력스트림(파이프) 가져오기
		PrintWriter out = resp.getWriter();
		//응답객체에 출력한 내용이 클라이언트(웹브라우저)에게 전송
//		out.println("Hello Servlet!"); //응답객체에 프린트하는 명령
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Insert title here</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("	<h1>Bye Bye</h1>");
		out.println("	<h2>안녕히</h2>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
