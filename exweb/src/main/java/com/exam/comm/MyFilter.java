package com.exam.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//필터 : 다수의 서블릿들의 실행 전후에 공통적으로 수행해야 하는 작업을 구현 
//필터를 등록하는 방법
// - web.xml에 <filter>를 사용하여 등록 (이 경우를 많이 씀. 전체에 적용하는 거라서.)
// - 필터 클래스에 @WebFilter를 적용하여 등록  

public class MyFilter implements Filter {
	
	private String cs;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// 필터 객체가 처음 생성된 후, 1회만 실행 : 보통 필터 초기화 작업 구현  
		System.out.println( "MyFilter : init" );
		//인코딩3.
		cs = filterConfig.getInitParameter("enc");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 필터와 연결된 주소로 요청이 올때마다 1번씩 반복적으로 실행
		System.out.println( "MyFilter : 서블릿 실행 전" );
//		인코딩1. request.setCharacterEncoding("UTF-8"); // 여기에 이 한줄을 넣으면 다른 서블릿에서 이 코드는 없어도 됨.
		// 인코딩2. web.xml에서 init-param 태그 안에 넣어줌.
		request.setCharacterEncoding(cs); // 인코딩4
		//누구게! 저 왔다가용!!!!!!!!!!!!!!!!!!!!ㅎ.ㅎ
		
		chain.doFilter(request, response); // 이후 실행될 다른 필터 또는 서블릿을 실행. 보안상 어떨 경우에 실행되도록 해라 하는 로직 추가 가능.
		
		System.out.println( "MyFilter : 서블릿 실행 후" );
		
	}

	@Override
	public void destroy() {
		// 필터 객체가 소멸되기 전에 1회만 실행 : 보통 필터가 사용하던 자원을 정리하고 반납하는 작업 구현 
		System.out.println( "MyFilter : destroy" );
	}
	
}
