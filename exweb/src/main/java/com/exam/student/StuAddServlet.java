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
@WebServlet("/student/add.do")
public class StuAddServlet extends HttpServlet {
	StudentDao studentDao = new StudentDaoBatis();	//한번만 실행해도 됨.
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/student/StuAddForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//db에 추가 
				req.setCharacterEncoding("UTF-8");
				StudentVo vo = new StudentVo();
				vo.setStuNo( Integer.parseInt ( req.getParameter("stuNo") ) ); 
				vo.setStuName( req.getParameter("stuName") ); 
				vo.setStuScore( Integer.parseInt( req.getParameter("stuScore") ) ); 
				int num = studentDao.insertStudent(vo);
				
				//resp.sendRedirect("이동할사이트주소"); 명령을 사용하여, 웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송.
				// 서버 주소가 다를 수 있으니까 주소 앞에 http://localhost:8000는 생략 
				resp.sendRedirect( req.getContextPath() + "/student/list.do");
	}
	
}

