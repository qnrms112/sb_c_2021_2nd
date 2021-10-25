package com.jbg.exam.demo.service;

import org.springframework.stereotype.Service;

import com.jbg.exam.demo.repository.BoardRepository;
import com.jbg.exam.demo.vo.Board;

@Service
public class BoardService {
	private BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	public Board getBoardById(int id) {
		return boardRepository.getBoardById(id);
	}
}
