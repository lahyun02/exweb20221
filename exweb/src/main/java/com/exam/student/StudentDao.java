package com.exam.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.exam.member.MemberVo;

public class StudentDao {
	// Data Access Object 
	// Java Object <-> DB Table . 자바 객체와 db와의 상호작용. 
	String url = "jdbc:oracle:thin:@localhost:1521:xe";	
	String user = "web";
	String password = "web01";
	
	//한번만 실행. 생성자를 만들거나 블록 안에 넣거나.
	{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//db관련 코드와 ui관련 코드 분리
	public ArrayList<StudentVo> selectList() {
		// 데이터베이스 member 테이블의 정보를 select하여 출력 
		ArrayList<StudentVo> list = new ArrayList<StudentVo>();
		
		String selectSql = "SELECT stu_no, stu_name, stu_score FROM student";	
		try (	Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(selectSql);
				ResultSet rs = pstmt.executeQuery();
		) {
			while (rs.next()) {	//다음 레코드가 있는 동안 반복 
				StudentVo vo = new StudentVo();
				vo.setStu_no( rs.getInt("stu_no") );
				vo.setStu_name( rs.getString("stu_name") );
				vo.setStu_score( rs.getInt("stu_score") );
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(StudentVo vo) {
		int num = 0; 
		String insertSql = "INSERT INTO student "
				+ "(stu_no, stu_name, stu_score) "
				+ "VALUES (?, ?, ?)"; 
		try (	
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(insertSql);				
		) {
			pstmt.setInt(1, vo.getStu_no());  
			pstmt.setString(2, vo.getStu_name());  
			pstmt.setInt(3, vo.getStu_score());  
			num = pstmt.executeUpdate();	//SQL문 실행결과 변경된 레코드 수를 반환 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	public int delete(String stu_no) {
		// 입력한 아이디의 회원을 student 테이블에서 삭제
		int num = 0;
		String delSql = "DELETE FROM student WHERE stu_no = ?"; 
		try (	
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(delSql);				
		) {
			pstmt.setString(1, stu_no);  
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
	public int modifyNo(String stu_no, String stu_name, String stu_score) {
		// 입력한 아이디의 회원의 이름을 student 테이블에서 수정
		int num = 0;
		String modSql = "UPDATE student SET stu_no = ?, stu_name = ?, stu_score= ? WHERE stu_no = ?"; 
		try (	
				Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(modSql);				
		) {
			pstmt.setString(1, stu_no);  
			pstmt.setString(2, stu_name);  
			pstmt.setString(3, stu_score);  
			pstmt.setString(4, stu_no);  
			num = pstmt.executeUpdate(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	
	
	public StudentVo detail(String stu_no) {
		// 입력한 아이디의 회원을 member 테이블에서 조회
		StudentVo vo = new StudentVo();
		String detailSql = "SELECT stu_no, stu_name, stu_score FROM student WHERE stu_no = ?"; 
		try (	Connection conn = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = conn.prepareStatement(detailSql);
		) {
			pstmt.setString(1, stu_no); 
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {	//다음 레코드가 있는 동안 반복 
				vo.setStu_no( rs.getInt("stu_no") );
				vo.setStu_name( rs.getString("stu_name") );
				vo.setStu_score( rs.getInt("stu_score") );
				System.out.println(vo.toString() );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		return vo.toString();
		return vo;
	}




}
