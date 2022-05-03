package com.exam.student;

public class StudentVo {
	//Value Object. 
	//테이블에 레코드 하나(한 행)을 담을 수 있는 객체.
	
	private int stu_no;
	private String stu_name;
	private int stu_score;
	
	
	public int getStu_no() {
		return stu_no;
	}
	public void setStu_no(int stu_no) {
		this.stu_no = stu_no;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public int getStu_score() {
		return stu_score;
	}
	public void setStu_score(int stu_score) {
		this.stu_score = stu_score;
	}
	
	
	public String toString() {
		return stu_no + " : " + stu_name + " : " + stu_score;
	}
	
	
	
	
	
	//변수를 private으로 만들어 밖에서 직접 접근못하게 하고, (캡슐화) 
	// 메서드로 접근할 수 있게 함. 
	// 실무에선 변수를 private으로 만든 후, get, set 메소드를 활용하는 경우가 대부분.
//	public void setMemId(String id) {
//		this.memId = id;
//	}
	// id를 검사해서 유효한 값인지 검사한 후 저장하는 식으로 활용 가능
	
//	public String getMemId() {
//		return this.memId;
//	}
	
}
