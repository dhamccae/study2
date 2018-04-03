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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>16 / jstlCore3.jsp</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/15/memberList.jsp">회원목록</a>
	<br>
	<a href="${pageContext.request.contextPath}/15/memberList.jsp">회원목록</a>
	<br>
	<a href='<c:url value="/15/memberList.jsp" />'>회원목록</a>
	<br>

	<img alt="" src="/image/morgan2.jpg" width="300px">
	<br>

	<img alt="" src='<c:url value="/image/morgan.png" />' width="200px">
	<br>


	<a href="/study/common/download.do?id=234&path=board"
		class="btn btn_sm btn-primary"> <span> down </span>
	</a>
	<br>

	<c:url value="/commom/download.do">
		<c:param name="id" value="234" />
		<c:param name="path" value="board" />
	</c:url>
	
	<a href="${downUrl}" class="btn btn-sm btn-primary" >
		<span class="glyphicon glyphicon-floppy-disk">Down</span>
	</a><br>




</body>
</html>

