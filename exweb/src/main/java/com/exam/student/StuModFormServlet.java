package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//폼 작성으로 회원추가를 할 수 있는 서블릿
@WebServlet("/student/modform.do")
public class StuModFormServlet extends HttpServlet {
	StudentDao studentDao = new StudentDao();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stu_no = req.getParameter("stu_no"); 
		StudentVo vo = studentDao.detail(stu_no);
		
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/WEB-INF/jsp/student/StuModForm.jsp").forward(req, resp);
		
		
		// "http://localhost:8000/exweb/member/list.do"로 요청을 보내면,
		// 웹브라우저에 회원목록이 출력되도록 구현 
		
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<title>Insert title here</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>학생추가</h1>");
//		
//		// /exweb -> 고유경로를 명령어를 통해 사용. 나중에 경로를 바꿔도 사용 가능하도록.
//		out.println("<form action='" + req.getContextPath() + "/student/add.do' method='post'>");
//		out.println("학번 : <input type='text' name='stu_no'/><br>");
//		out.println("이름 : <input type='text' name='stu_name'/><br>");
//		out.println("점수 : <input type='text' name='stu_score'/><br>");
//		out.println("<input type='submit' />");
//		out.println("</form>");
//		
//		out.println("</body>");
//		out.println("</html>");
		
	}
}

