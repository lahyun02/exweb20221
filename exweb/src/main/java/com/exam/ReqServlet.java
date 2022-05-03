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
@WebServlet("/req.do")  //괄호 안에 주소는 각자 정하는 부분.
public class ReqServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		// 클라이언트(웹브라우저)가 보낸 모든 정보(내용)는 
		// 요청객체(HttpServletRequest)에 저장되어 있으므로,
		// 요청객체 .getXXX() 메서드를 사용하여 필요한 정보를 읽어서 사용 가능
		
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
		out.println("<h1>요청주소 : " + req.getRequestURI() + "</h1>");
		out.println("<h1>요청주소 : " + req.getRequestURL() + "</h1>");
		out.println("<h1>요청방식 : " + req.getMethod() + "</h1>");
		out.println("<h1>요청방식 : " + req.getProtocol() + "</h1>");
		out.println("<h1>User-Agent 헤더 : " + req.getHeader("User-Agent") + "</h1>");
		String agent = req.getHeader("User-Agent");
		
		if (agent.contains("Edg/") || agent.contains("Edge/")) {
			out.println("<h1>MS Edge 사용자</h1>");
		}else if (agent.contains("Chrome/")) {
			out.println("<h1>Chrome 사용자</h1>");
		}else if (agent.contains("Firefox/")) {
			out.println("<h1>Firefox 사용자</h1>");
		}else {
			out.println("<h1>알 수 없는 웹브라우저 사용자</h1>");
		}
		
		
		
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
