<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserDTO uDTO = (UserDTO)request.getAttribute("uDTO");
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
			<h2 class="typo-list" style="margin-bottom:50px; text-align:center;"><span class="lnr lnr-user"></span>&nbsp;회원목록</h2>
		</div>
		<div>
			
		</div>
	</div>
	
	<%@include file="/WEB-INF/view/mainFooter.jsp" %>

</body>
</html>