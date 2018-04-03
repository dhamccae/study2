package com.study.board.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.servlet.IController;

public class BoardDeleteController implements IController{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		BoardServiceImpl boardService = new BoardServiceImpl();
		String deletePage ="/WEB-INF/view/board/boardDelete.jsp";
		
		String bo_no = request.getParameter("bo_no");
	
		//BoardServiceImpl boardservice = new BoardServiceImpl();
		
		

		if(bo_no==null || bo_no.trim().equals("")) {
			return "redircet:/board/boardList.do";
		}
		
		Board board = new Board();
		
		board.setBo_no(Integer.parseInt(bo_no));

		int cnt = boardService.deleteBoard(board);
		if(cnt>0) {
			request.setAttribute("message", "게시판 삭제 완료.");
		}else {
			request.setAttribute("message", "게시판 삭제 실패.");
		}
		
		return deletePage;
	}

}
