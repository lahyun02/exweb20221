package com.exam.student;

import java.util.List;

public interface StudentDao {
	
	List<StudentVo> selectStudentList();

	StudentVo detailStudent(String stuNo);
	
	int insertStudent(StudentVo vo);
	
	int deleteStudent(String stuNo);
	
	int modifyStudent(StudentVo vo);
	
}
