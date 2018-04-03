package com.study.board.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.servlet.IController;

public class BoardUpdateController implements IController{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		BoardServiceImpl boardService = new BoardServiceImpl();
		String bo_no       = request.getParameter("bo_no");
		String bo_title    = request.getParameter("bo_title");
		String bo_email    = request.getParameter("bo_email");
		String bo_content  = request.getParameter("bo_content");
		String bo_ip       = request.getParameter("bo_ip");
		
		if(bo_no==null || bo_no.trim().equals("")) {
			return "redircet:/board/boardList.do";
		}
		
		Board board = new Board();
		
		board.setBo_no(Integer.parseInt(bo_no));
		board.setBo_title(bo_title);
		board.setBo_email(bo_email);
		board.setBo_content(bo_content);
		board.setBo_ip(request.getRemoteAddr());
		
		int cnt = boardService.modifyBoard(board);
		if(cnt>0) {
			request.setAttribute("message", "게시판 수정 완료.");
		}else {
			request.setAttribute("message", "게시판 수정 실패.");
		}
		
		String updatePage ="/WEB-INF/view/board/boardUpdate.jsp";
		return updatePage;
	}

}
