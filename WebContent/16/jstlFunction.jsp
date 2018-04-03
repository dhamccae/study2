<%@page import="com.study.member.vo.Member"%>
<%@page import="com.study.util.FileUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("utf-8");
%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>16/ jstlCore2.jsp</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>16/ jstlFunction.jsp</title>
</head>
<body>
	<c:set var="msg" value="Hello 오늘은 금요일 ~~ hoho" />

	${fn:length(msg)} <br>
	${fn:toUpperCase(msg)}<br>
	${fn:contains(msg,'금요일')}<br>
	${fn:replace(msg,'hoho','kara')}<br>
	
	<c:forEach items="${fn:split(msg,' ')}" varStatus="st">
		${st.count} , ${st.current} <br>
	</c:forEach>
	
	<c:set var="member"
			value='<%=new Member("hong", "길동", "1234", "000-0000-0001", "hong@daum.net", 10)%>' />
			
			id=${member.mem_id}<br>
			id=${member.getMem_id()}<br>
			
			${member.setMem_id("gildong")}<br>
			id=${member.mem_id}<br>
			
			${FileUtil.fancySize(12312515)}<br>
			
			<ul>회원구분
				<li>VIP</li>
				<li>초고교급</li>
				<li>일반</li>
				<li>블랙리스트</li>
			</ul>
			
			
			<!-- 문제 : 람다식으로 만들기 -->
			
			${gugu=(dan,i)-> dan += ' * ' += i += ' = ' +=  dan*i  }
			<c:set var="dan" value="7" />
			<ul>
			<c:forEach begin="1" end="9" var="i">
 				<li>${gugu(dan,i)}</li> 

				
			</c:forEach>


			</ul>
</body>
</html>



