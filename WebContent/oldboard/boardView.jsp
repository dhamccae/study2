<%@page import="com.study.board.vo.Board"%>
<%@page import="com.study.board.service.BoardServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
  <!DOCTYPE html>
    <html lang="ko">
    <fmt:bundle basename="resource.message">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title><fmt:message key="MEMBER.TITLE" /></title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	</head>
<body>
<div class="container">
<div class="page-header">
	<h1>게시판 상세보기</h1>
</div>
<div class="row">
<%
	String bo_no = request.getParameter("bo_no");
	BoardServiceImpl boardService = new BoardServiceImpl();
	Board board = boardService.getBoard(Integer.parseInt(bo_no));
	request.setAttribute("board", board);
	
%>
<table class="table">
	<tbody>
		<c:if test="${!empty board}">
		<tr>
			<th>게시판 번호</th>
			<td>${board.bo_no}</td>
		 </tr>
		<tr>
			<th>제목</th>
			<td>${board.bo_title}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${board.bo_email}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${board.bo_content}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.bo_read_cnt}</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${board.bo_reg_date}</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>${board.bo_mod_date}</td>
		</tr>
		</c:if>
		
		<c:if test="${empty board}">
		
		<tr>
			<td><fmt:message key="BOARD.NOTFOUND" /></td>
		</tr>
		</c:if>
	</tbody>
	
</table>
</div>

<div class="row">
	<div class="col-md-6">
		<a href="boardList.jsp" class="btn-sm btn-warning">게시판목록으로 돌아가기</a>
	</div>
	<div class="col-md-6 text-right">
		<a href="boardEdit.jsp?bo_no=${board.bo_no}" class="btn-sm btn-primary">수정</a>
	</div>
</div>

</div>
</fmt:bundle>
</body>
</html>