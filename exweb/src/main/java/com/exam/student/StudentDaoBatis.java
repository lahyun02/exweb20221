package com.exam.student;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.exam.member.MemberVo;

public class StudentDaoBatis implements StudentDao {
	
	SqlSessionFactory sqlSessionFactory = null;
	
	public StudentDaoBatis() {
		try {
			String resource = "mybatis/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public List<StudentVo> selectStudentList() {
		List<StudentVo> list = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			list = session.selectList("com.exam.student.StudentDao.selectStudentList");
			}
		return list;
	}


	@Override
	public StudentVo detailStudent(String stu_no) {
		StudentVo vo = null;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			vo = session.selectOne("com.exam.student.StudentDao.detailStudent", stu_no);
			}
		return vo;
	}


	@Override
	public int insertStudent(StudentVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			num = session.insert("com.exam.student.StudentDao.insertStudent", vo);
			session.commit();
			}
		return num;
	}


	@Override
	public int deleteStudent(String stu_no) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			num = session.insert("com.exam.student.StudentDao.deleteStudent", stu_no);
			session.commit();
			}
		return num;
	}



	@Override
	public int modifyStudent(StudentVo vo) {
		int num = 0;
		try (SqlSession session = sqlSessionFactory.openSession()) {
			num = session.insert("com.exam.student.StudentDao.modifyStudent", vo);
			session.commit();
			}
		return num;
	}
	
	




}
