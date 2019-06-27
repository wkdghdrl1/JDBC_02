package com.biz.jdbc.exec;

import com.biz.jdbc.model.StudentVO;
import com.biz.service.StdService;
import com.biz.service.StdServiceImp_01;

public class StdExec_06 {

	public static void main(String[] args) {
		StdService ss = new StdServiceImp_01();

		String stNo = "101";

		StudentVO vo = ss.findByNum(stNo);
		
		if(stNo == null) System.out.println("데이터 없음");
		else {
			
			ss.delete(vo.getSt_no());
			
			ss.delete(stNo);
		}
		
	}
}
