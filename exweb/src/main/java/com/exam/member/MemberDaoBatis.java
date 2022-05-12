package com.exam.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDaoBatis implements MemberDao {
	
	public MemberDaoBatis() {
		try {
			String resource = "mybatis-config.xml"; 	// 마이바티스 설정 파일 위치. 클래스패스니까 최상위패스 org/mybatis/example/ 삭제.
			InputStream inputStream = Resources.getResourceAsStream(resource);	// 마이바티스 설정 파일을 읽을 수 있는 스트림
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			// 마이바티스 설정 파일의 내용대로 마이바티스 본체(sqlSessionFactory)를 생성 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVo> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(MemberVo vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delMember(String memId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
