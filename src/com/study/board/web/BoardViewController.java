package com.study.board.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.servlet.IController;

public class BoardViewController implements IController {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		BoardServiceImpl boardService = new BoardServiceImpl();


		String bo_no = request.getParameter("bo_no");
		// 아이디가 널이거나 비어있으면 회원목록으로 리다이렉트
		if (bo_no == null || bo_no.trim().equals("")) {
			return "redircet:/board/boardList.do";
		}

		Board board = boardService.getBoard(Integer.parseInt(bo_no));
		request.setAttribute("board", board);

		String viewPage = "/WEB-INF/view/board/boardView.jsp";

		return viewPage;
	}

}
