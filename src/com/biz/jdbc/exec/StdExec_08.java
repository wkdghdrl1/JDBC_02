package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.StudentVO;
import com.biz.service.StdService;
import com.biz.service.StdServiceImp_01;

public class StdExec_08 {

	public static void main(String[] args) {

		StdService ss = new StdServiceImp_01();
		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.print("학번(종료:-e>>");
			String strNo = scan.nextLine();
			if (strNo.equals("-e")) {
				break;
			}

			StudentVO vo = ss.findByNum(strNo);

			if (vo == null) {
				System.out.println("학생정보 없음");
				continue;
			}

			System.out.println(vo);
			System.out.println("=====================================");

			System.out.print("주소 >>");
			String strAddr = scan.nextLine();
			if(strAddr.isEmpty()) continue;
			vo.setSt_addr(strAddr);
			ss.update(vo);
		}
	}

}
