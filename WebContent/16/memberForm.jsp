<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="oracle.jdbc.OracleDriver"%>
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
	<h1>회원 등록</h1>
</div>

<form action="elTest.jsp" method="post">
<div class="row">

<table class="table">
	<tbody>
	
		<tr>
			<th>ID</th>
			<td>
			<input type="text" name="mem_id" value="">
			</td>
		 </tr>
		 <tr>
			<th>비밀번호</th>
			<td>
			<input type="password" name="mem_pwd" value="">
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
			<input type="text" name="mem_name" value="">
			</td>
		</tr>
		<tr>
			<th>연락처</th>
			<td>
			<input type="text" name="mem_phone" value="">
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
			<input type="text" name="mem_email" value="">
			</td>
		</tr>
	
	</tbody>
	
</table>
</div>

<div class="row">
	<div class="col-md-6 col-xs-4">
		<a href="memberList.jsp" class="btn-sm btn-warning">목록으로</a>
	</div>
	<div class="col-md-6">
	<button type="submit" class="btn-sm btn-primary">저장</button>
	</div>
</div>
</form>

</div>
</body>
</html>