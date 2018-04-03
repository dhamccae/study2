package com.study.board.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.study.board.service.BoardServiceImpl;
import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;
import com.study.servlet.IController;

public class BoardListController implements IController{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		BoardSearch boardSearch = new BoardSearch();
		
		try {
			BeanUtils.populate(boardSearch, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

//		int currentPage = 1;
//
//		if(request.getParameter("currentPage") != null) {
//			currentPage = Integer.parseInt(request.getParameter("currentPage"));			
//		}
//		
//		boardSearch.setCurrentPage(currentPage);
		
		BoardServiceImpl boardService = new BoardServiceImpl();
		boardSearch.setting(boardService.getBoardCount(boardSearch));

		List<Board> list = boardService.getBoardList(boardSearch);
		request.setAttribute("search", boardSearch);
		request.setAttribute("list", list);
		
		String listPage ="/WEB-INF/view/board/boardList.jsp";
		
		return listPage;
	}

}
