package com.biz.service;

import java.util.List;

import com.biz.jdbc.model.ScoreVO;

public interface ScoreService {
	
	public List<ScoreVO> selectALL();
	public List<ScoreVO> findById(String st_no);
	public int insert(ScoreVO vo);
	public int update(ScoreVO vo);
	public void delete(long sc_seq);
	public ScoreVO findById(long longNum);
	
		
}
