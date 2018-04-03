
package com.study.member.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.study.member.dao.IMemberDao;
import com.study.member.dao.MemberDaoJDBC;
import com.study.member.dao.MemberDaoMyBatis;
import com.study.member.vo.Member;
import com.study.member.vo.MemberSearch;

public class MemberServiceImpl {
	
	private IMemberDao memberDao = new MemberDaoMyBatis(); //new MemberDaoJDBC();
	

	public List<Member> getMemberList(MemberSearch memberSearch){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			List<Member> list = memberDao.getMemberList(conn,memberSearch);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new  RuntimeException("회원조회 오류", e);
		}finally {
			if(conn != null) try{conn.close();}catch(Exception e){}
		}
	}
	
	public Member getMember(String mem_id) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			Member member = memberDao.getMember(conn, mem_id);
			return member;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new  RuntimeException("회원정보 상세보기 오류", e);
		}finally {
			if(conn != null) try{conn.close();}catch(Exception e){}
		}
	}
	
	public int modifyMember(Member member) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			int cnt = memberDao.updateMember(conn, member);
			return cnt;
		}catch (SQLException e) {
			throw new RuntimeException("회원정보 수정 오류" , e);
		}finally {
			if(conn != null) try{conn.close();}catch(Exception e){}
			
		}
	}
	
	public int insertMember(Member member) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			int cnt = memberDao.insertMember(conn, member);
			return cnt;
		}catch (SQLException e) {
			throw new RuntimeException("회원 등록 오류" , e);
		}finally {
			if(conn != null) try{conn.close();}catch(Exception e){}
			
		}
	}
	
	public int deleteMember(Member member) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			int cnt = memberDao.deleteMember(conn, member);
			return cnt;
		}catch (SQLException e) {
			throw new RuntimeException("회원삭제(탈퇴) 오류" , e);
		}finally {
			if(conn != null) try{conn.close();}catch(Exception e){}
			
		}
	}
	
	//페이징
	public int getMemberCount(MemberSearch memberSearch) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:apache:commons:dbcp:study");
			int cnt = memberDao.getMemberCount(conn, memberSearch);
			return cnt;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new  RuntimeException("회원 카운트(페이징) 오류", e);
		}finally {
			if(conn != null) try{conn.close();}catch(Exception e){}
		}
	}
	
	
}
