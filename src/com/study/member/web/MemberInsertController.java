package com.study.member.web;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.servlet.IController;

public class MemberInsertController implements IController{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		MemberServiceImpl memberService = new MemberServiceImpl();
		
		String mem_id = request.getParameter("mem_id");
		String mem_pwd = request.getParameter("mem_pwd");
		String mem_name = request.getParameter("mem_name");
		String mem_phone = request.getParameter("mem_phone");
		String mem_email = request.getParameter("mem_email");
		String reg_date = request.getParameter("reg_date");
		
		System.out.println(mem_id);
		System.out.println(mem_pwd);
		System.out.println(mem_name);
		System.out.println(mem_phone);
		System.out.println(mem_email);
		System.out.println(reg_date);
		
		Member member = new Member();
		member.setMem_id(mem_id);
		member.setMem_pwd(mem_pwd);
		member.setMem_name(mem_name);
		member.setMem_phone(mem_phone);
		member.setMem_email(mem_email);
		member.setReg_date(reg_date);

		
		int cnt = memberService.insertMember(member);
		request.setAttribute("cnt", cnt);
		
		if(cnt>0) {
		String insertPage ="/WEB-INF/view/member/memberInsert.jsp";
		return insertPage;
		
		}else {
			return "redircet:/member/memberList.do";
		}
	}

}
