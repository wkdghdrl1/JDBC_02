package com.biz.jdbc.exec;

import com.biz.jdbc.model.StudentVO;
import com.biz.service.StdService;
import com.biz.service.StdServiceImp_01;

public class StdExec_04 {

	public static void main(String[] args) {
		
		
		StdService ss = new StdServiceImp_01();
		
		StudentVO stdVO = new StudentVO();
		
		
		stdVO.setSt_no("103");
		stdVO.setSt_name("장구");
		stdVO.setSt_grade(4);
		stdVO.setSt_dept("실용음악과");
		
		ss.insert(stdVO);
	}

}
