package com.exam.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//과제 : (1)번부터 구현 
//(1)변경하려는 회원아이디가 로그인한 회원의 아이디와 다르다면 변경되지 않도록 구현
//(2)회원정보변경 화면에서도, 화면의 회원아이디가 로그인한 회원의 아이디와 다르다면,
//   이름, 포인트 값 변경이 불가능하고 submit 버튼도 출력되지 않도록 구현

//폼 작성으로 회원추가를 할 수 있는 서블릿
@WebServlet("/member/edit.do")
public class MemEditServlet extends HttpServlet {
	MemberDao memberDao = MemberDaoBatis.getInstance();	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//화면에 출력하기 전에 데이터베이스에서 해당회원의 정보를 꺼내와야함.
		String memId = req.getParameter("memId");
		
		// 회원정보를 꺼내올 메소드 (MemberDao에서)
		MemberVo vo = memberDao.selectMember(memId);
		
		req.setAttribute("memVo", vo);
		
		// 변경하려는 회원아이디가 로그인한 회원의 아이디와 다르다면 
		HttpSession session = req.getSession(); 
		MemberVo userVo = (MemberVo) session.getAttribute("loginUser");
		
		System.out.println(vo.getMemId());
		System.out.println(userVo.getMemId());
		req.setAttribute("userId", userVo.getMemId()); 
		
		req.getRequestDispatcher("/WEB-INF/jsp/member/MemEdit.jsp").forward(req, resp);	
		//jsp에 출력할 정보가 없기 때문에 add에선 이것만 했었음.
		// 여기에선 db에서 꺼내온 정보-vo-를 출력해야함. -> 요청객체에 속성으로 적당에서 jsp에서 요청객체에 저장된 걸 꺼내씀.
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//db에 추가 
//		req.setCharacterEncoding("UTF-8"); // 웹애플리케이션을 post방식으로 할때 항상 해줘야 하는 작업 -> 필터에서 해줌.
		MemberVo vo = new MemberVo();
		vo.setMemId( req.getParameter("memId") ); 
//		vo.setMemPass( req.getParameter("memPass") ); 
		vo.setMemName( req.getParameter("memName") ); 
		vo.setMemPoint( Integer.parseInt( req.getParameter("memPoint") ) ); 
		int num = memberDao.updateMember(vo);
		
		//resp.sendRedirect("이동할사이트주소"); 명령을 사용하여, 웹브라우저에게 특정 사이트로 이동하라는 명령을 담은 응답을 전송.
		// 서버 주소가 다를 수 있으니까 주소 앞에 http://localhost:8000는 생략 
		resp.sendRedirect( req.getContextPath() + "/member/list.do");
		
		//결과 출력 
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
//		out.println("<h1>회원추가</h1>");
//		out.println( num + "명의 회원이 추가되었습니다.");
//		out.println("</body>");
//		out.println("</html>");
		
	}
}

