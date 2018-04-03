package com.study.board.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.study.board.dao.BoardDaoMyBatis;
import com.study.board.dao.IBoardDao;
import com.study.board.vo.Board;
import com.study.board.vo.BoardSearch;

public class BoardServiceImpl {

	private IBoardDao boardDao = new BoardDaoMyBatis();
	//
	public int getBoardCount(BoardSearch boardSearch) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			int cnt = boardDao.getBoardCount(conn, boardSearch);
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("게시판 조회 오류", e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}

	public List<Board> getBoardList(BoardSearch boardSearch) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			List<Board> list = boardDao.getBoardList(conn, boardSearch);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("게시판 조회 오류", e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}

	public Board getBoard(int bo_no) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			Board board = boardDao.getBoard(conn, bo_no);
			return board;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("게시판 상세보기 오류", e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}
		}
	}

	public int modifyBoard(Board board) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			int cnt = boardDao.updateBoard(conn, board);
			return cnt;
		} catch (SQLException e) {
			throw new RuntimeException("게시판 수정오류", e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}

		}
	}

//	public int registBoard(Board board) {
//		Connection conn = null;
//		try {
//			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
//			int cnt = boardDao.insertBoard(conn, board);
//			return cnt;
//		} catch (SQLException e) {
//			throw new RuntimeException("게시판 등록 오류", e);
//		} finally {
//			if (conn != null)
//				try {
//					conn.close();
//				} catch (Exception e) {
//				}
//
//		}
//	}

	public int deleteBoard(Board board) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			int cnt = boardDao.deleteBoard(conn, board);
			return cnt;
		} catch (SQLException e) {
			throw new RuntimeException("게시판 삭제 오류", e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (Exception e) {
				}

		}

	}

	public int insertBoard(Board board) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			int cnt = boardDao.insertBoard(conn, board);
			return cnt;
		}catch (SQLException e) {
			throw new RuntimeException("게시판 등록 오류" , e);
		}finally {
			if(conn != null) try{conn.close();}catch(Exception e){}
			
		}
	}
}
