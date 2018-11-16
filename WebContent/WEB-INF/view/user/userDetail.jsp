<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	UserDTO uDTO=(UserDTO)request.getAttribute("uDTO");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/view/cssjs.jsp" %>

<script type="text/javascript">

</script>
</head>
<body>

	<%@include file="/WEB-INF/view/mainTop.jsp" %>

	<div class="container" style="margin-top:20px;">
		<div class="typography" style="align:center">
			<h2 class="typo-list" style="margin-bottom:50px; text-align:center;"><span class="lnr lnr-user"></span>&nbsp;회원정보</h2>
		</div>
		<form action="/user/userDelete.do" method="post">
			<div style="margin-bottom:100px; padding:0px 10px 0px 10px; text-align:center; margin: 0 auto; width:60%; /* min-width:100% */">
				<div class="mt-10">
					<b style="color:black; float:left;">NAME</b>
					<input type="text" id="name" name="name" placeholder="NAME" required="" class="single-input" style="float:right;" value="<%=uDTO.getName() %>" readonly>
				</div>
				<div class="mt-10">
					<b style="color:black; float:left;">TEL</b>
					<input type="text" id="tel" name="tel" placeholder="TEL" required="" class="single-input" value="<%=uDTO.getTel()%>" readonly>
				</div>
				<div class="mt-10">
					<b style="color:black; float:left;">ID</b>
					<input type="text" id="id" name="id" placeholder="ID" required="" class="single-input" value="<%=uDTO.getId()%>" readonly>
				</div>
				<div class="mt-10" style="margin-bottom:200px;">
					<a href="/user/userUpdateView.do?userNo=<%=userNo %>" class="genric-btn info-border medium">수정</a>
					<button type="submit" class="genric-btn danger-border medium">탈퇴</button>
				</div>
			</div>
		</form>
	</div>
	
	<%@include file="/WEB-INF/view/mainFooter.jsp" %>

</body>
</html>