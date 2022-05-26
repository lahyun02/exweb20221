package com.exam.comm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.exam.member.MemberVo;

//필터 : 다수의 서블릿들의 실행 전후에 공통적으로 수행해야 하는 작업을 구현 
//필터를 등록하는 방법
// - web.xml에 <filter>를 사용하여 등록 (이 경우를 많이 씀. 전체에 적용하는 거라서.)
// - 필터 클래스에 @WebFilter를 적용하여 등록  

//로그인 한 사람만 변경가능하도록. 로그인 안 한 사람의 접근 막음.

public class LoginFilter implements Filter {
	private ArrayList<String> whiteList = new ArrayList<String>();	//로그인없이 사용가능한 경로들을 저장할 목록 (배열,list,set 자료구조 가능)
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터 객체가 처음 생성된 후, 1회만 실행 : 보통 필터 초기화 작업 구현  
		whiteList.add( "/member/login.do" );
		whiteList.add( "/member/add.do" );
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 필터와 연결된 주소로 요청이 올때마다 1번씩 반복적으로 실행
		//ServletRequest는 HttpServletRequest의 상위클래스. 여기엔 getSession()메소드가 없음. 
		//-> 우린 req가 HttpServletRequest에 있다는 걸 알고있으니까   이 메소드 쓰려면 강제형변환해야함.
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//ServletRequest엔 주소꺼내오는 메소드가 없어서 형변환이 위로 가있어야.
		String reqUri = req.getRequestURI(); //현재 요청주소(경로) 
		reqUri = reqUri.substring( req.getContextPath().length() ); //요청주소에서 컨텍스트패스 제거(uri주소 앞쪽에 ContextPath의 길이만큼을 빼고 uri주소를 취함)
		if( !whiteList.contains(reqUri) ) {
			// 로그인정보 검사
			HttpSession session = req.getSession();
			MemberVo vo = (MemberVo) session.getAttribute("loginUser"); //로그인한 사용자정보를 가져오기
			// login서블릿에서 세션객체에서  loginUser이름으로 저장했던 애를 가져와라
			// 컴퓨터에 세션에 저장된 loginUser에는 컴퓨터에선 온갖게 저장될 수 있으니까 (우린 알고 있지만) 컴퓨터가 알수 있도록 강제형변환
			if(vo==null) {	//로그인한 적이 없다면
				resp.sendRedirect( req.getContextPath() + "/member/login.do");	//다시 로그인 페이지로 이동 
				return;
			}
		}
		
		chain.doFilter(request, response); // 이후 실행될 다른 필터 또는 서블릿을 실행. 보안상 어떨 경우에 실행되도록 해라 하는 로직 추가 가능.
		
	}

	@Override
	public void destroy() {
		// 필터 객체가 소멸되기 전에 1회만 실행 : 보통 필터가 사용하던 자원을 정리하고 반납하는 작업 구현 
		System.out.println( "MyFilter : destroy" );
	}
	
}
