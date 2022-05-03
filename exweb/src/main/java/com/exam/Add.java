package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add.do")
public class Add extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String xv = req.getParameter("x");
		String yv = req.getParameter("y");	
		
		String opv = req.getParameter("op");

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
		out.println("	<h1>파라미터 테스트</h1>");
		
		int nx = Integer.parseInt(xv);
		int ny = Integer.parseInt(yv);
		
		int add = nx+ny;
		int multiple = nx*ny;
		
		switch (opv) {
		case "p" :
			out.println("<h1>" + xv + "+" + yv + " = " + add + "<h1>");
		case "m" :
			out.println("<h1>" + xv + "x" + yv + " = " + multiple + "<h1>");
		}
		
		
//		
//		switch (opv) {
//		case "p": 
//			out.println("<h1>" + xv + "+" + yv + " = " + (nx+ny) + "<h1>");
//			break;
//		case "m": 
//			out.println("<h1>" + xv + "x" + yv + " = " + (nx*ny) + "<h1>");
//			break;
//		}
		
		
		
		
		
		
//		if(op.equals("p"))
//			out.println("<h1>" + x + "+" + y + " = " + p + "<h1>");
//			
//		if(op.equals("m"))
//			out.println("<h1>" + x + "+" + y + " = " + m + "<h1>");
		
		
		
//		out.println("<h1>" + x + "+" + y + " = " + (nx+ny) + "<h1>");
		
		
		out.println("</body>");
		out.println("</html>");
		
//http://localhost:8000/exweb/add.do?x=258&y=120
			
 		
	}
}
