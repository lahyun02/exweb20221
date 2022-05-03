package com.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/photo.do")
public class PhotoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String animal = req.getParameter("img");
		
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
		
		
		if ("bear".equals(animal)) 
			out.println("<img src='https://picsum.photos/id/1020/200/300' />");
		
		else if ("eagle".equals(animal)) 
			out.println("<img src='https://picsum.photos/id/1024/200/300' />");
		
		else if ("dog".equals(animal)) 
			out.println("<img src='https://picsum.photos/id/1025/200/300' />");
		
		else 
			out.println("<h1>알 수 없는 동물입니다</h1>");		
		
		out.println("</body>");
		out.println("</html>");
		
	}
}



// http://localhost:8000/exweb/photo.do 창을 열었을때 파라미터 값에는 null 이 들어가는데,
// if- else if문을 거쳐(null은 비어있는 것이므로 equals 명령어를 호출할 수 없기 때문에 if문이 성립할 수 없음.) 
// 그래서 else문에 이르렀을때 초기화면에 "알 수없는 동물입니다"가 나와야함.
//
//
// 근데 if문 조건식에 
// if (animal.equals("bear")) 
// 		out.println("<img src='https://picsum.photos/id/1020/200/300' />");
// 라고 썼을 경우, 
// animal에 null값이 들어가는데 animal이 비어있는 값이 되므로 오류가 발생한다.
//
// 따라서 첫화면에 "알 수없는 동물입니다"가 나와야 하는데 초기화면에 나오지 않는 이유는 
// 톰캣이 html을 쫘르륵 읽어내리면서 출력하다가 
// if (animal.equals("bear")) 
//		out.println("<img src='https://picsum.photos/id/1020/200/300' />");
// 이 조건식에서 오류를 만난다. 위에서 말했듯이 animal에 null값이 들어가므로 존재하지 않는 객체에서 메소드를 호출해서 "bear"이라는 문자열과 비교하려니 컴퓨터는 오류 발생.
//
// html문을 먼저 쓰고 그 다음 if 조건문을 썼기 때문에 톰캣이 html을 읽어내리다가 오류가 발생한 부분을 만났을 때,
// 톰캣은 '이미 html문을 읽어내려서 출력중인데 오류를 만났군. 어쩌지? 그냥 하고 있던거 내보내자.'하고 오류부분 전까지 출력하므로
// 빈 창이 뜬다. 
// 초기화면에서 오류메시지가 뜨지 않더라도 CONSOLE창에서 컴퓨터 내부 처리과정을 확인해보면 오류 메시지가 떠있는 걸 볼 수 있다.
//
// console 내부의 이런 오류메시지를 없애려면
// if ("bear".equals(animal)) 와 같이
// null값이 들어있는 animal을 뒤로 보내 순서를 바꿔서 작성하면, 
// 컴퓨터는 "bear"이라는 문자열을 null값과 비교하므로 오류가 나지 않고 해당if 조건문을 패스하고 다음 else if문으로 넘어간다. 
// (그 결과 초기화면에 "알 수없는 동물입니다"가 뜸.) 



//http://localhost:8000/exweb/photo.do?img=동물이름
//동물이름이 "bear" 이면
//	화면에 https://picsum.photos/id/1020/200/300 이미지 출력
//동물이름이 "eagle" 이면
//	화면에 https://picsum.photos/id/1024/200/300 이미지 출력
//동물이름이 "dog" 이면
//	화면에 https://picsum.photos/id/1025/200/300 이미지 출력
//그 밖에 다른 이름이면,
//	"알 수 없는 동물입니다" 라고 출력


//정수 123과 456이 같은가? 123===456
//문자열 "abc"와 "def"가 같은가? "abc".equals("def")
