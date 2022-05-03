package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order.do")
public class OrderServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userv = req.getParameter("user");
		String[] ordv = req.getParameterValues("ord");
		
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
//		out.println("	<h1>파라미터 테스트</h1>");
		
		
		int count=0; //주문 반복횟수 변수 선언 및 초기화
		count = ordv.length;
		out.println("<ul>");						
		if(ordv != null) {								//입력값이 null값이 아닐때
			for(int i=0; i < ordv.length; i++) {			//ordv배열의 길이(주문받은 갯수)만큼 반복
				switch(ordv[i]) {						//switch의 조건식에 배열 이름만 적으면 오류.(배열 이름은 배열에 대한 주소값이니까.) 배열 요소를 직접 비교해야 함.
				case "p001" : 							//ordv배열 i번째가 피자의 value값 "p001"일 경우
					out.println("<li>피자</li>");		//주문한 목록 화면에 출력
					break;
				case "p002" : 							//햄버거
					out.println("<li>햄버거</li>");
					break;
				case "p003" :  							//돈까스
					out.println("<li>돈까스</li>");
					break;
				case "p101" :   						//딸기쥬스
					out.println("<li>딸기쥬스</li>");
					break;
				case "p102" :    						//키위쥬스
					out.println("<li>키위쥬스</li>");
					break;
				}
			}
			out.println("</ul>");
		}
		
		out.println("	<h2>" + userv +  "님은 총 " + count + "개의 음식을 주문했습니다. </h2>");
		
		
		
		
	
//		int i=0; //주문 반복횟수 변수 선언 및 초기화
//		
//		if(ordv != null) {								//입력값이 null값이 아닐때
//			out.println("<ul>");						
//			for(i=0; i < ordv.length; i++) {			//ordv배열의 길이(주문받은 갯수)만큼 반복
//				switch(ordv[i]) {						//switch의 조건식에 배열 이름만 적으면 오류.(배열 이름은 배열에 대한 주소값이니까.) 배열 요소를 직접 비교해야 함.
//				case "p001" : 							//ordv배열 i번째가 피자의 value값 "p001"일 경우
//					out.println("<li>피자</li>");		//주문한 목록 화면에 출력
//					break;
//				case "p002" : 							//햄버거
//					out.println("<li>햄버거</li>");
//					break;
//				case "p003" :  							//돈까스
//					out.println("<li>돈까스</li>");
//					break;
//				case "p101" :   						//딸기쥬스
//					out.println("<li>딸기쥬스</li>");
//					break;
//				case "p102" :    						//키위쥬스
//					out.println("<li>키위쥬스</li>");
//					break;
//				}
//			}
//			out.println("</ul>");
//		}
//		
//		out.println("	<h2>" + userv +  "님은 총 " + i + "개의 음식을 주문했습니다. </h2>");
		//i개수 -> 배열의 길이만큼 반복횟수= 주문받은 총량. 

//		out.println("<ul>");
//		int sum = 0;
//		int i = 0;
//		if(ordv != null) {
//			for(String od : ordv) {
//				if(od.equals("p001"))
//					out.println("<li>피자</li>");
//				
//				else if(od.equals("p002"))
//					out.println("<li>햄버거</li>");
//				
//				else if(od.equals("p003"))
//					out.println("<li>돈까스</li>");
//				
//				else if(od.equals("p101"))
//					out.println("<li>딸기쥬스</li>");
//				
//				else if(od.equals("p102"))
//					out.println("<li>키위쥬스</li>");
//			}
//		}
		
//		out.println("</ul>");
//		out.println("	<h2>" + userv +  "님은 총 " + ordv.length + "개의 음식을 주문했습니다. </h2>");
		
		
		out.println("</body>");
		out.println("</html>");
		
	}
}
