package com.exam.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 웹브라우저에서 "http://localhost:8000/exweb/student/list.do"로 접속하면
// 학생목록이 출력되도록 구현 

// 과제
// 지난주에 과제로 했던 학생목록에 학생추가, 학생삭제 기능을 추가

@WebServlet("/student/list.do")
public class StuListServlet extends HttpServlet {
	StudentDao studentDao = new StudentDaoBatis();	//한번만 실행해도 됨.
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<StudentVo> list = studentDao.selectStudentList(); //요청이 올때마다 실행해야 함. 테이블의 내용이 변경될 수 있기 때문.
		req.setAttribute("stuList", list);
		req.getRequestDispatcher("/WEB-INF/jsp/student/StuList.jsp").forward(req, resp);
		
		
		
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
//		out.println("<h1>학생목록</h1>");
//		out.println("<button><a href='" + req.getContextPath() + "/student/addform.do'>학생추가</a></button><br>");
//		out.println("학번 : 이름 : 점수<br>");
//		
//		for(int i=0; i < list.size(); i++) {
//			StudentVo vo = list.get(i);
//			out.println("<a href='" + req.getContextPath() + "/student/detail.do?stu_no=" + vo.getStu_no()+ "'>" + vo.toString() + "</a><br>");
//		}
//		
//		out.println("</body>");
//		out.println("</html>");
		
	}
}

