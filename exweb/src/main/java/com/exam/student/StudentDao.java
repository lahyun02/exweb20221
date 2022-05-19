package com.exam.student;

import java.util.List;

public interface StudentDao {
	
	List<StudentVo> selectStudentList();

	StudentVo detailStudent(String stu_no);
	
	int insertStudent(StudentVo vo);
	
	int deleteStudent(String stu_no);
	
	int modifyStudent(StudentVo vo);
	
}
