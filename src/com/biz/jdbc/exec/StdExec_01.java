package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.ScoreVO;
import com.biz.jdbc.service.ScoreService;
import com.biz.jdbc.service.ScoreServiceImp_01;

public class StdExec_01 {

	public static void main(String[] args) {
		
		ScoreService ss = new ScoreServiceImp_01();
		Scanner scan = new 	Scanner(System.in);
		ScoreVO vo = new ScoreVO();
		
		
		vo.setSc_st_no("001");
		vo.setSc_date("2018-01-02");
		vo.setSc_subject("국어");
		
		ss.insert(vo);
		
//		while(true) {
//			
//			StudentVO vo = new StudentVO();
//			
//			System.out.print("학번 입력 >>");
//			vo.setSt_no(scan.nextLine());
//			System.out.print("이름 입력 >>");
//			vo.setSt_name(scan.nextLine());
//			System.out.print("학년 입력 >>");
//			vo.setSt_grade(Integer.valueOf(scan.nextLine()));
//			System.out.print("학과 입력 >>");
//			vo.setSt_dept(scan.nextLine());
//			
//			if(ss.insert(vo) > 0) System.out.println("추가완료");
//			else System.out.println("추가 실패");
//		}
//		
		
	}

}
