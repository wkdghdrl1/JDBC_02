package com.biz.jdbc.exec;

import java.util.List;

import com.biz.jdbc.model.StudentVO;
import com.biz.service.StdService;
import com.biz.service.StdServiceImp_01;

public class StdExec_01 {
	
	public static void main(String[] args) {
		
		StdService ss = new StdServiceImp_01();
		
		List<StudentVO> stdList = ss.selectAll();
		if(stdList == null) System.out.println("데이터가 없음!!");
		else {
		for(StudentVO vo : stdList) {
			System.out.println(vo);
		}
		}
		
		
	}
}
