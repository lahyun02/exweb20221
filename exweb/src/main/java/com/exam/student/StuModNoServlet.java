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


//폼 작성으로 회원수정를 할 수 있는 서블릿
@WebServlet("/student/modno.do")
public class StuModNoServlet extends HttpServlet {
	StudentDao studentDao = new StudentDao();	//한번만 실행해도 됨.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String stu_no = req.getParameter("stu_no"); 
		String stu_name = req.getParameter("stu_name"); 
		String stu_score = req.getParameter("stu_score"); 
		System.out.println(stu_no);
		System.out.println(stu_name);
		int num = studentDao.modifyNo( stu_no, stu_name, stu_score );
		System.out.println(num);
		resp.sendRedirect( req.getContextPath() + "/student/list.do");
		
		//출력
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
//		out.println("<h1>회원삭제</h1>");
//		out.println( num + "명의 회원이 삭제되었습니다.");
//		out.println("</body>");
//		out.println("</html>");
		
	}
}

