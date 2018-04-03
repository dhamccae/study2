<%@page import="com.study.member.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>타이틀을 입력하세요~^^v</title>
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
mem_id = <%=request.getParameter("mem_id") %><br>
el mem_id = ${param.mem_id }<br>

${1000 + "4" } <br>
${20 % 4 } <br>
${20 mod 4 } <br>

${ 4>3 }<br>
${ 4 gt 3 }<br>

${ 4 gt 3 and 1 eq 1 }<br>
${ 4 > 3 && 1 == 1 }<br>
<%
	//String abc = "hello";
	request.setAttribute("abc", "hello");
%>
\${abc} = ${abc}<br>
\${empty abc} = ${empty abc}<br>
\${empty param.mem_id} = ${empty param.mem_id}<br>



<%
	Member member = new Member("duly","둘리개객기","1111","111-1111-1111","duly@naver.com",1000);
	Member member2 = new Member("gildong","소드마스터","2222","222-2222-2222","GoGilDong@naver.com",2000);
	
	request.setAttribute("member", member);
	session.setAttribute("member", member2);
%>
\${member.mem_id} = ${member.mem_id}<br>
\${requestScope.member.mem_id} = ${requestScope.member.mem_id}<br>
\${sessionScope.member.mem_id} = ${sessionScope.member.mem_id}<br>
${member.mem_name}의 마일리지는 ${member.mem_mileage} 입니다. <br>
${member.mem_name += '의 마일'+="리지는" += member.mem_mileage +="입니다."}<br>

${arr =[1,2,3,4,5]; ''}<br />
\${arr[2] } = ${arr[2] }<br>
<hr>
${var1 = 1004; var2=100}<br>
값은  =${var1}, ${var1+var2}<br>
<hr>
<%=member.getMem_name() %>
<%=member2.getMem_name() %>
<hr>
${arr1= ["길동애비","소향마덜","놀자"]; ''}<br>
${arr2={'name':'홍길동','age':20}; '' }<br>

\${arr1[2]} = ${arr1[2]}<br>
\${arr2['name']}= ${arr2.name}<br>


</body>
</html>







