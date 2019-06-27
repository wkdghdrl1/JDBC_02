package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.StudentVO;
import com.biz.service.StdService;
import com.biz.service.StdServiceImp_01;

public class StdExec_07 {

	public static void main(String[] args) {
			
		Scanner scan = new Scanner(System.in);
		StdService ss = new StdServiceImp_01();
		
		
		System.out.print("학번 >>");
		String strNo = scan.nextLine();
		System.out.print("이름 >>");
		String strName = scan.nextLine();
		System.out.print("학년 >>");
		String strGrade = scan.nextLine();
		int intGrade = Integer.valueOf(strGrade);
		System.out.print("학과 >>");
		String strDept = scan.nextLine();
		
		
		StudentVO vo = new StudentVO();
		vo.setSt_no(strNo);
		vo.setSt_name(strName);
		vo.setSt_grade(intGrade);
		vo.setSt_dept(strDept);
		
		ss.insert(vo);
		
		
	}

}
