package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.StudentVO;
import com.biz.service.StdService;
import com.biz.service.StdServiceImp_01;

public class StdExec_10 {
	
	public static void main(String[] args) {
		
		StdService ss = new StdServiceImp_01();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("==============================");
			// String strNo = ss.makeStNo();
			
			// StdService 인터페이스에 미처 선언하지 못한
			// makeStNo() 메서드를
			// StdServiceImp_01 클래스에 생성하고
			// 사용하려고 한다.
			
			// 이럴때는 다소 복잡하지만 ss(StdService 형)의 객체를
			// StdServiceImp_01로 Cascading(형변환)을 실행해서 
			// 메서드를 호출해야 한다.
			String strNo = ((StdServiceImp_01)ss).makeStNo();
			System.out.println(strNo + " 학생 정보 등록 ");
			System.out.println("------------------------------");
			System.out.print("이름 (종료:-e)>>");
			String strName = scan.nextLine();
			
			System.out.print("학년>>");
			String strGrade = scan.nextLine();
			int inGrade = Integer.valueOf(strGrade);
			
			System.out.print("학과>>");
			String strDept = scan.nextLine();
			
			StudentVO vo = new StudentVO();
			
			vo.setSt_no(strNo);
			vo.setSt_name(strName);
			vo.setSt_grade(inGrade);
			vo.setSt_dept(strDept);
			
			ss.insert(vo);
		}
		
	}
}
