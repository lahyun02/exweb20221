package com.exam.member;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MemberDaoBatis implements MemberDao {
	
	SqlSessionFactory sqlSessionFactory = null; 
	//sqlSessionFactory가 try문 안에 있으면 
	public MemberDaoBatis() {
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

	@Override
	public List<MemberVo> selectMemberList() {
		List<MemberVo> list = null;
		// 마이바티스를 통한 데이터베이스와의 세션(연결)을 가져와서
		try (SqlSession session = sqlSessionFactory.openSession()) {
			//해당 세션을 통해 마이바티스에 등록된 SQL문을 실행 
			//실행할 SQL문의 종류에 따라서 메서드를 선택
			//"namespace.id"로 실행할 SQL문을 지정 
			//com.exam.member.MemberDao 집합 안에 있는 selectMemberList문을 실행!
			list = session.selectList("com.exam.member.MemberDao.selectMemberList");
			}
		return list;
	}
	
	@Override
	public MemberVo selectMember(String memId) {
		MemberVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			vo = session.selectOne("com.exam.member.MemberDao.selectMember", memId);
			// 결과가 하나로 나올땐 selectOne메소드. 결과가 여러개 나올땐 selectList
			}
		return vo;
	}

	@Override
	public int insertMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			// insert, delete, update는 보통 반환값이 숫자임.
			//SQL문 실행에 필요한 데이터는 두번째 인자로 전달 
			num = session.insert("com.exam.member.MemberDao.insertMember", vo);
			session.commit();
			// insert, update, delete 후에는 커밋 필요. 커밋완료해야 남들이 변경된 데이터를 볼 수 있음.
			//jdbc에선 기본설정이 오토커밋이 true, mybatis에선 기본설정이 오토커밋이 false로 되어 있어 직접 커밋해야함.
			} 
		return num;
	}

	@Override
	public int delMember(String memId) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			num = session.delete("com.exam.member.MemberDao.delMember", memId);
			//insert, delete를 하는 메소드는 내부적으로 들어가면 MemberDaoJdbc에서처럼 pstmt.executeQuery();를 쓰기때문에 
			//둘중 뭐를 써도 에러는 안나지만 명확히 하기 위해 delete메소드명을 작성.
			session.commit();
			} 
		return num;
	}

	@Override
	public int updateMember(MemberVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			num = session.update("com.exam.member.MemberDao.updateMember", vo);
			session.commit();
			} 
		return num;
	}

	
}
