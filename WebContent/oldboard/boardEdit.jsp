
<%@page import="com.study.board.vo.Board"%>
<%@page import="com.study.board.service.BoardServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>타이틀을 입력하세요~^^v</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	
	</head>
<body>
<div class="container">
<div class="page-header">
	<h1>게시판 정보 수정</h1>
</div>
<form action="boardUpdate.jsp" method="post">
<div class="row">
<%
	String bo_no = request.getParameter("bo_no");
	BoardServiceImpl boardService = new BoardServiceImpl();
	Board board = boardService.getBoard(Integer.parseInt(bo_no));
	request.setAttribute("board", board);
%>
<table class="table">
	<tbody>
		<%
		if(board !=null){
		%>
		<tr>
			<th>번호</th>
			<td>${board.bo_no}
			<input type="hidden" name="bo_no" value="${board.bo_no}">
			</td>
		 </tr>
		<tr>
			<th>제목</th>
			<td>
			<input type="text" name="bo_title" value="${board.bo_title}">
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
			<input type="text" name="bo_email" value="${board.bo_email}">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
			<input type="text" name="bo_content" value="${board.bo_content}">
			</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${board.bo_reg_date}
			</td>
		</tr>
		<%
		}else{
		%>
		<tr>
			<td>해당 게시판이 존재하지 않습니다.</td>
		</tr>
		<%
		}
		%>
	</tbody>
	
</table>
</div>

<div class="row">
	<div class="col-md-6 col-xs-4">
		<a href="boardList.jsp" class="btn-sm btn-warning">목록으로</a>
	</div>
	<div class="col-md-6">
	<button type="submit" class="btn-sm btn-primary">저장</button>
	</div>
</div>
</form>


</div>
</body>
</html>