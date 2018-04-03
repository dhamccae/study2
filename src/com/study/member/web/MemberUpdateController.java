package com.study.member.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberUpdateController implements IController{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		MemberServiceImpl memberService = new MemberServiceImpl();
		String updatePage ="/WEB-INF/view/member/memberUpdate.jsp";
		
		String mem_id = request.getParameter("mem_id");
		String mem_pwd = request.getParameter("mem_pwd");
		String mem_name = request.getParameter("mem_name");
		String mem_phone = request.getParameter("mem_phone");
		String mem_email = request.getParameter("mem_email");
		
		if(mem_id==null || mem_id.trim().equals("")) {
			return "redircet:/member/memberList.do";
		}
		
		Member member = new Member();
		
		member.setMem_id(mem_id);
		member.setMem_pwd(mem_pwd);
		member.setMem_name(mem_name);
		member.setMem_phone(mem_phone);
		member.setMem_email(mem_email);
		
		int cnt = memberService.modifyMember(member);
		if(cnt>0) {
			request.setAttribute("message", "회원수정 완료.");
		}else {
			request.setAttribute("message", "회원수정 실패.");
		}
		
		return updatePage;
	}

}
