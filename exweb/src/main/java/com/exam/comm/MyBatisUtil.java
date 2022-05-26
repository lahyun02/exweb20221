package com.exam.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	// 객체를 만들때마다 인스턴스가 여러개 생기는 게 아닌, 하나만 만들어 전체가 공유 ==> static (객체, 인스턴스 생성않고 사용 가능)
	// 메모리에 MyBatisUtil가 로드될 때 sqlSessionFactory 변수가 생기고, static {} 실행 
	
	private static SqlSessionFactory sqlSessionFactory = null; 
	
	// 생성자 대신 초기화 블록 
	static {
		try {
			// 마이바티스 설정 파일 위치. 클래스패스니까 최상위패스 org/mybatis/example/ 삭제.-> mybatis폴더 만들었으니까 추가.
			String resource = "mybatis/mybatis-config.xml"; 	
			// 마이바티스 설정 파일의 내용대로 마이바티스 본체(sqlSessionFactory)를 생성 
			InputStream inputStream = Resources.getResourceAsStream(resource);	// 마이바티스 설정 파일을 읽을 수 있는 스트림
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	
	
	
}
