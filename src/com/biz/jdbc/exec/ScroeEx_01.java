package com.biz.jdbc.exec;

import java.util.List;

import com.biz.jdbc.model.ScoreVO;
import com.biz.service.ScoreService;
import com.biz.service.ScoreServiceImp_01;

public class ScroeEx_01 {
	
	public static void main(String[] args) {
		
		ScoreService ss = new ScoreServiceImp_01();
		List<ScoreVO> sList = ss.selectALL();
		
		for(ScoreVO vo : sList) {
			System.out.println(vo);
		}
		
		
	}
}
