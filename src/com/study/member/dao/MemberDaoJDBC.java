package com.study.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.member.vo.Member;
import com.study.member.vo.MemberSearch;

public class MemberDaoJDBC {
	
	//페이징
	public int getMemberCount(Connection conn, MemberSearch memberSearch) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT count(*) FROM tb_member2 ");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}finally {if (rs != null)try {rs.close();} catch (Exception e) {}
				if (pstmt != null)try {pstmt.close();} catch (Exception e) {}
			}
		}

	// 회원목록
	public List<Member> getMemberList(Connection conn, MemberSearch memberSearch) throws SQLException { // getMemberList()
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<Member> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT *		");
		sb.append("FROM (SELECT rownum rn, a.*	");
		sb.append("				FROM (			");

		sb.append("SELECT ");
		sb.append(" mem_id ");
		sb.append(" ,mem_name ");
		sb.append(" ,mem_pwd ");
		sb.append(" ,mem_phone ");
		sb.append(" ,mem_email ");
		sb.append(" ,TO_CHAR(reg_date,'YYYY/MM/DD') AS reg_date ");
		sb.append("  FROM tb_member2 ");
		sb.append("  ORDER BY mem_id ASC ");
		
		sb.append("					)a	");
		sb.append("		) b				");
		sb.append("	WHERE rn between ? and  ? ");

		System.out.println(memberSearch.getStartRow());
		System.out.println(memberSearch.getEndRow());
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, memberSearch.getStartRow());
			pstmt.setInt(2, memberSearch.getEndRow());
			rs = pstmt.executeQuery();
			Member member = null;
			while (rs.next()) {
				member = new Member();
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_pwd(rs.getString("mem_pwd"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_email(rs.getString("mem_email"));
				member.setReg_date(rs.getString("reg_date"));
				
				list.add(member); // 리스트에 저장
			}
			return list;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}

	// 회원상세
	public Member getMember(Connection conn, String mem_id) throws SQLException {

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		StringBuilder sb = new StringBuilder();

		sb.append("SELECT ");
		sb.append(" mem_id ");
		sb.append(" ,mem_name ");
		sb.append(" ,mem_pwd ");
		sb.append(" ,mem_phone ");
		sb.append(" ,mem_email ");
		sb.append(" ,TO_CHAR(reg_date,'YYYY/MM/DD') AS reg_date ");
		sb.append("  FROM tb_member2 ");
		sb.append("  WHERE mem_id = ? ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			Member member = null;
			if (rs.next()) {
				member = new Member();
				member.setMem_id(rs.getString("mem_id"));
				member.setMem_name(rs.getString("mem_name"));
				member.setMem_pwd(rs.getString("mem_pwd"));
				member.setMem_phone(rs.getString("mem_phone"));
				member.setMem_email(rs.getString("mem_email"));
				member.setReg_date(rs.getString("reg_date"));
			}
			return member;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}

	// 회원등록
	public int insertMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO tb_member2 ");
		sb.append("    (  mem_id ");
		sb.append("     , mem_pwd ");
		sb.append("     , mem_name ");
		sb.append("     , mem_phone ");
		sb.append("     , mem_email ");
		sb.append("     , reg_date ) ");
		sb.append(" VALUES ( ?,?,?,?,?, SYSDATE ) ");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// 구문객체 생성후 파라미터 설정
			pstmt.setString(1, member.getMem_id());
			pstmt.setString(2, member.getMem_pwd());
			pstmt.setString(3, member.getMem_name());
			pstmt.setString(4, member.getMem_phone());
			pstmt.setString(5, member.getMem_email());

			int cnt = pstmt.executeUpdate();
			return cnt;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}

	// 회원수정
	public int updateMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE tb_member2    ");
		sb.append("   SET mem_name  = ?");
		sb.append("     , mem_phone = ?");
		sb.append("     , mem_email = ?");
		sb.append(" WHERE mem_id =   ? ");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// 구문객체 생성후 파라미터 설정
			pstmt.setString(1, member.getMem_name());
			pstmt.setString(2, member.getMem_phone());
			pstmt.setString(3, member.getMem_email());
			pstmt.setString(4, member.getMem_id());

			int cnt = pstmt.executeUpdate();
			return cnt;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}
	
	//회원삭제(탈퇴)
	public int deleteMember(Connection conn, Member member) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM tb_member2    ");
		sb.append(" WHERE mem_id =   ? ");
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// 구문객체 생성후 파라미터 설정
			pstmt.setString(1, member.getMem_id());

			int cnt = pstmt.executeUpdate();
			return cnt;
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (Exception e) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception e) {
				}
		}
	}
}
