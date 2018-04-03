package com.study.board.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.servlet.IController;

public class BoardEditController implements IController{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		BoardServiceImpl boardService = new BoardServiceImpl();
		String editPage ="/WEB-INF/view/board/boardEdit.jsp";
		
		String bo_no= request.getParameter("bo_no");
		//
		if(bo_no ==null || bo_no.trim().equals("")) {
			return "redirect:/board/boardList.do";
		}
		
		Board board = boardService.getBoard(Integer.parseInt(bo_no));
		request.setAttribute("board", board);
		
		return editPage;
	}

}
