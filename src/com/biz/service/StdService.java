package com.biz.service;

import java.util.List;

import com.biz.jdbc.model.StudentVO;

//1. DB Connection을 설정하기
//2. SELECT를 구현해보기
//3. INSERT를 구현해보기
//4. UPDATE, DELETE 구현해보기 

public interface StdService {
	
	//전체 리스트를 가져올 method
	//DBMS에게 SELECT * FROM [table]을 실행하여
	// 전체 리스트를 가져오는 일을 수행할 예정
	// 가져온 리스트를 java의 List 자료구조로 변환시켜서
	// 요청한 곳에 return
	public List<StudentVO> selectAll();
	

	//학번을 기준으로 한 학생의 정보를 가져올 method
	// 학번을 매개변수로 전달하고
	// 학번을 WHERE로 하여 SELECT를 수행한 후
	// 한 학생의 정보를 가져와서 VO에 담아
	// 요청한 곳에 return
	public StudentVO findByNum(String st_num);
	
	//학생정보를 DB insert할 method
	//추가(create)하고자 하는 학생의 정보를
	//VO에 담아서 매개변수로 전달해주고
	// INSERT를 수행하도록 한다.
	public void insert(StudentVO vo);
	
	//학생정보를 수정(Update)할 method
	//(수정)UPDATE를 수행할 때는
	// 1. 학생정보(한 사람의)를 조회하고
	// 2. 수정할 칼럼(항목)이 있으면 그 칼럼의 값만 병경을 하고
	// 3. 나머지 값은 그대로 유지하여
	// 4. VO에 담겨있는 값을 매개변수로 전달하여
	// 5. Update 수행
	public void update(StudentVO vo);
	
	//학생정보를 삭제(Delete)할 method
	public void delete(String st_num);
	
	
	
}
