package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.StudentVO;
import com.biz.service.StdService;
import com.biz.service.StdServiceImp_01;

public class StdExec_09 {

	/*
	 *  키보드에서 학생정보를 입력받아서
	 *  학번, 이름, 학년, 학과
	 *  계속해서 Insert를 작성
	 */
	public static void main(String[] args) {
		
		StdService ss = new StdServiceImp_01();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("학번(종료:-e>>");
			String strNo = scan.nextLine();
			System.out.print("이름 >>");
			String strName = scan.nextLine();
			System.out.print("학년 >>");
			strName = strName.trim();
			String strGrade = scan.nextLine();
			int intGrade = Integer.valueOf(strGrade);
			System.out.print("학과 >>");
			String strDept = scan.nextLine();
			if (strNo.equals("-e")) {
				break;
			}

			StudentVO vo = new StudentVO();
			
			vo.setSt_no(strNo);
			vo.setSt_name(strName);
			vo.setSt_grade(intGrade);
			vo.setSt_dept(strDept);
			
			ss.insert(vo);
		}
		
	}

}
