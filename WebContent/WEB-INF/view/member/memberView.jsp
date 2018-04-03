
<%@page import="com.study.member.vo.Member"%>
<%@page import="com.study.member.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원상세보기</title>
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
	<div class="container">
		<div class="page-header">
			<h1>회원 상세 정보</h1>
		</div>
		<div class="row">

			<table class="table">
				<tbody>
					<c:if test="${not empty member}">
						<tr>
							<th>ID</th>
							<td>${member.mem_id}</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>${member.mem_name}</td>
						</tr>
						<tr>
							<th>연락처</th>
							<td>${member.mem_phone}</td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${member.mem_email}</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td>${member.reg_date}</td>
						</tr>
					</c:if>

					<c:if test="${empty member }">
						<tr>
							<td>해당 회원이 존재하지 않습니다.</td>
						</tr>
					</c:if>

				</tbody>

			</table>
		</div>

		<div class="row">
			<div class="col-md-6">
				<a href="memberList.do" class="btn-sm btn-warning">목록으로</a>
			</div>
			<div class="col-md-6 text-right">
				<a href="memberEdit.do?mem_id=${member.mem_id}" class="btn-sm btn-primary">수정</a>
				<a href="memberDelete.do?mem_id=${member.mem_id}" class="btn-sm btn-primary">삭제</a>
			</div>
		</div>

	</div>
</body>
</html>