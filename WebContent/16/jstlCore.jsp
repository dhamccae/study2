<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.study.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>16 / jstlCore.jsp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<!-- //jstl에서 var로 시작하는 속성에는 EL표기법 사용ㄴㄴ -->

	<c:set var="msg" value="1000" />
	${msg}
	<br>

	<c:set var="msg2" value="${msg+4}" />
	${msg2}
	<br>

	<c:set var="msg3" value="${msg2+4}" />
	${msg3}
	<br>

	<c:set var="member" value="<%=new Member()%>" />
<%-- 	<c:set target="${member}" property="mem_name" value="수리비ㅅㅂ" /> --%>
<%-- 	<c:set target="${member}" property="mem_name" value="내돈ㅅㅂ" /> --%>
<%-- 	<c:set target="${member}" property="mem_name" value="놋북ㅅㅂ" /> --%>
	<c:set target="${member}" property="mem_name" value="돈 아까워" />

	<c:set target="${member}" property="mem_id" value="gildong" />

	${member.mem_name }
	<br>

	<c:forEach var="i" begin="1" end="10" step="2">
	${i} 배고픔 <br>
	</c:forEach>

	<c:set var="sum" value="0" />
	<c:forEach var="i" begin="1" end="100">
		<c:set var="sum" value="${sum+i }" />
	</c:forEach>
	1부터 100까지의 합 = ${sum}
	<br>


	<%
		List<Member> list = new ArrayList();
		list.add(new Member("hong", "소드마스터", "1111", "222-2222-2222", "GoGilDong@naver.com", 1111));
		list.add(new Member("lenovo", "레노버", "2222", "222-2222-2222", "GoGilDong@naver.com", 2222));
		list.add(new Member("samsung", "삼성", "3333", "333-3333-3333", "samsung@naver.com", 3333));

		request.setAttribute("members", list);
	%>
	<ul>
		<c:forEach var="user" items="${members}">
			<li>${user.mem_id}= ${user.mem_name}</li>
		</c:forEach>
	</ul>
	
	

	<hr style="border-color: red; border-style:dotted; " >

	<ul>
		<c:forEach var="user" items="${members}" begin="1" varStatus="st">
		
			<li>${st.count},${st.index},${st.first},${st.current.mem_id},${user.mem_id}</li>
			
		</c:forEach>
	</ul>
	
	
</body>

</html>






