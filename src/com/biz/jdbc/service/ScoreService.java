package com.biz.jdbc.service;

import java.util.List;

import com.biz.jdbc.model.ScoreVO;

public interface ScoreService {
	
	public List<ScoreVO> SelectAll();
	public ScoreVO findBySeq(long seq);
	
	public List<ScoreVO> findByNum(String stNum);
	
	public int insert(ScoreVO vo);
	public int update(ScoreVO vo);
	public int delete(long seq);
}
