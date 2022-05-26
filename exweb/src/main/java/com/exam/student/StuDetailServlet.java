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

// 웹브라우저에서 "http://localhost:8000/exweb/student/list.do"로 접속하면
// 학생목록이 출력되도록 구현 

// 과제
// 지난주에 과제로 했던 학생목록에 학생추가, 학생삭제 기능을 추가

@WebServlet("/student/detail.do")
public class StuDetailServlet extends HttpServlet {
	StudentDao studentDao = new StudentDaoBatis();	//한번만 실행해도 됨.
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stuNo = req.getParameter("stuNo"); 
		
		StudentVo vo = studentDao.detailStudent( stuNo );
		
		req.setAttribute("vo", vo);
		
		req.getRequestDispatcher("/WEB-INF/jsp/student/StuDetail.jsp").forward(req, resp);
		
//		resp.setCharacterEncoding("UTF-8");
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<meta charset='UTF-8'>");
//		out.println("<title>Insert title here</title>");
//		out.println("<style>");
//		out.println("a {text-decoration : none}");
//		out.println("</style>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("상세페이지<br>");
//		out.println(vo.toString());
//		out.println("<form action=" + req.getContextPath() + "/student/del.do method='post'>");
//		out.println("<input type='hidden' name='stu_no' value='" + stu_no + "' />");
//		out.println("<input type='submit' value='삭제' />");
//		out.println("<button><a href='" + req.getContextPath() + "/student/list.do'>목록</a></button><br>");
//		out.println("</form>");
		
//		out.println("&nbsp;&nbsp;<button><a href='" + req.getContextPath() + "/student/del.do?stu_no=" + list + "'>삭제</a></button><br>");
//		for(int i=0; i < list.size(); i++) {
//			StudentVo vo = list.get(i);
//			out.println(vo.toString());
//			out.println("&nbsp;&nbsp;<button><a href='" + req.getContextPath() + "/student/del.do?stu_no=" + vo.getStu_no() + "'>삭제</a></button><br>");
//		}
		
//		System.out.println(studentDao.detail( stu_no ));
//		out.println("</body>");
//		out.println("</html>");
		
	}
}

