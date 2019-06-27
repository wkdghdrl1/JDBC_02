package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.ScoreVO;
import com.biz.service.ScoreService;
import com.biz.service.ScoreServiceImp_01;

public class ScoreExec_02 {
	
	public static void main(String[] args) {
		
		ScoreService ss = new ScoreServiceImp_01();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("학번 입력: >> 종료 : end");
			String strEnd = scan.nextLine();
			if(strEnd.equals("end")) break;
			String strNum = scan.nextLine();
			long longNum = Integer.valueOf(strNum);
			
			
			ScoreVO vo = ss.findById(longNum);
			if(vo == null) System.out.println("점수정보 없음");
			else System.out.println(vo);
			
			
		}
		
	}
}
