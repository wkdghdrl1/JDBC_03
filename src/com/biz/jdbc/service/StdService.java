package com.biz.jdbc.service;

import java.util.List;

import com.biz.jdbc.model.StudentVO;

public interface StdService {

	
	 //CRUD 메서드
	
	public List<StudentVO> selectAll();
	
	// Select를 실행해서 데이터를 조회할 때
	// 부명히 1개의 데이터만 조회될 것이다.
	// 라고 하면 return으로 vo를 사용
	public StudentVO findByNum(String stNo);
	
	// 확률적으로 대부분 1개의 데이터가 조회될 것이다.
	// 어쩌다 한번이라도 1개 이상의 데이터가 조회 될 것 같다.
	// 라고 하면 retrun type은 무조건 List를 사용
	public List<StudentVO> findByName(String stName);
	
	public int insert(StudentVO vo);
	public int update(StudentVO vo);
	public int delete(String stNo);
	
	public String makeStNum();
	
}
