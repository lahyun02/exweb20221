package com.exam.comm;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//리스너
//웹 애플리케이션에 특정 사건(event)이 발생했을 떄 자동으로 실행되는 클래스 
//- ServletContextListener, ServletContextAttributeListener //실행시 1번만. 실행시 set attribute 속성을 추가해서 어떤것들 실행되도록.
//- SessionListener, SessionAttributeListener
//- RequestListener, RequestAttributeListener
//- 기타 등등

//ServletContextListener
//== ServletContext 객체의 생성과 소멸시에 자동 실행 . 
//== 웹 애플리케이션이 처음 실행될 때와 종료될때 자동 실행.
//listener : 귀를 기울이고 있다가 어떤 이벤트가 발생할때 바로 반응하는 것.

//리스너를 등록하는 방법
// - web.xml 에 <listener>를 사용하여 등록 (많이 사용)
// - 리스너 클래스에 @WebListener를 적용하여 등록 

public class MyListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 웹 애플리케이션이 처음 시작될 때 실행
		System.out.println("MyListener : contextInitialized");
		
		ServletContext sc = sce.getServletContext();
		String jd = sc.getInitParameter("jdbcDriver");
		
		//초기화블럭때문에 넣어놨던 괄호는 삭제함.
		try {
			Class.forName(jd);	//"oracle.jdbc.OracleDriver"
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// 웹 애플리케이션이 종료될 때 실행
		System.out.println("MyListener : contextDestroyed");
	}

}
