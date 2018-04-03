package com.study.member.web;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.member.service.MemberServiceImpl;
import com.study.member.vo.Member;
import com.study.member.vo.MemberSearch;
import com.study.servlet.IController;

public class MemberListController implements IController{
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		MemberServiceImpl memberService = new MemberServiceImpl();
		
		MemberSearch memberSearch = new MemberSearch();
		
		int currentPage = 1; 
				
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));			
		}
		
		memberSearch.setCurrentPage(currentPage);
		
		memberSearch.setting(memberService.getMemberCount(memberSearch));
		
		System.out.println("currentPage");
		
		List<Member> list = memberService.getMemberList(memberSearch);
		request.setAttribute("search", memberSearch);
		request.setAttribute("list", list);
		
		String viewPage ="/WEB-INF/view/member/memberList.jsp";
		
		return viewPage;
	}

}
