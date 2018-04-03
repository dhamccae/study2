package com.study.board.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.servlet.IController;

public class BoardInsertController implements IController{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		BoardServiceImpl boardService = new BoardServiceImpl();
		
		String bo_title    = request.getParameter("bo_title");
		String bo_writer   = request.getParameter("bo_writer");
		String bo_passwd   = request.getParameter("bo_passwd");
		String bo_email    = request.getParameter("bo_email");
		String bo_content  = request.getParameter("bo_content");
		String bo_ip       = request.getParameter("bo_ip");
	
		Board board = new Board();
	
		board.setBo_title(bo_title);
		board.setBo_writer(bo_writer);
		board.setBo_passwd(bo_passwd);
		board.setBo_email(bo_email);
		board.setBo_content(bo_content);
		board.setBo_ip(request.getRemoteAddr());


		
		int cnt = boardService.insertBoard(board);
		request.setAttribute("cnt", cnt);
		
		if(cnt>0) {
		String insertPage ="/WEB-INF/view/board/boardInsert.jsp";
		return insertPage;
		
		}else {
			return "redircet:/board/boardList.do";
		}
	}

}
