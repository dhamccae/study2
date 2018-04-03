package com.study.member.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberDeleteController implements IController{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		MemberServiceImpl memberService = new MemberServiceImpl();
		String deletePage ="/WEB-INF/view/member/memberDelete.jsp";
		
		String mem_id = request.getParameter("mem_id");

		//MemberServiceImpl memService = new MemberServiceImpl();


		if(mem_id==null || mem_id.trim().equals("")) {
			return "redircet:/member/memberList.do";
		}
		
		Member member = new Member();
		
		member.setMem_id(mem_id);

		
		int cnt = memberService.deleteMember(member);
		if(cnt>0) {
			request.setAttribute("message", "회원탈퇴 완료.");
		}else {
			request.setAttribute("message", "회원탈퇴 실패.");
		}
		
		return deletePage;
	}

}
