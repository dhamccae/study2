
<%@page import="com.study.member.vo.Member"%>
<%@page import="java.util.List"%>
<%@page import="com.study.member.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	request.setCharacterEncoding("utf-8");
%>
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
<body>
	<c:set var="msg">서지연 나혜진 조아라 이민경 김경인 남솔 한재은</c:set>
	<c:set var="msg2">
		<h4>김영진 당구 꼴찌 샤샷~!</h4>
	</c:set>
	<b style="color: blue; font-size: 130%;">ㅋㅋ</b>
	<script>
		alert("불금이닷!"); //location.href="http://www.naver.com";
	</script>
	<pre>
	${msg }
	<c:forTokens items="${msg}" delims="," var="m" varStatus="st">
	${st.count },${m}
	</c:forTokens>
	${msg2}
	<c:out value="${msg2}" />
	
	msg3=<c:out value="${msg3 }" default="N/A" />
	
<%
		//Member member = new Member("hong","길동","1234","000-0000-0001","hong@daum.net",10);
	%>

<c:set var="member"
			value='<%=new Member("hong", "길동", "1234", "000-0000-0001", "hong@daum.net", 10)%>' />

<c:catch>
${member.mem_name}
${member.mem_id3}
${member.mem_pwd}
</c:catch>
휴~~~~
</pre>

<c:if test="${not empty ex }">
예외발생 : ${ex.message }
</c:if>


</body>
</html>




