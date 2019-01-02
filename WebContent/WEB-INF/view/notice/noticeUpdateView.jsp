<%@page import="poly.dto.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	NoticeDTO nDTO = (NoticeDTO)request.getAttribute("nDTO");
%>
<html lang="zxx" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="colorlib">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>About Us</title>

	<%@include file="/WEB-INF/view/cssjs.jsp" %>
	
	<style>
.myButton {
	-moz-box-shadow:inset 0px 1px 0px 0px #bbdaf7;
	-webkit-box-shadow:inset 0px 1px 0px 0px #bbdaf7;
	box-shadow:inset 0px 1px 0px 0px #bbdaf7;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #79bbff), color-stop(1, #378de5));
	background:-moz-linear-gradient(top, #79bbff 5%, #378de5 100%);
	background:-webkit-linear-gradient(top, #79bbff 5%, #378de5 100%);
	background:-o-linear-gradient(top, #79bbff 5%, #378de5 100%);
	background:-ms-linear-gradient(top, #79bbff 5%, #378de5 100%);
	background:linear-gradient(to bottom, #79bbff 5%, #378de5 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#79bbff', endColorstr='#378de5',GradientType=0);
	background-color:#79bbff;
	-moz-border-radius:6px;
	-webkit-border-radius:6px;
	border-radius:6px;
	border:1px solid #84bbf3;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:15px;
	font-weight:bold;
	padding:6px 24px;
	text-decoration:none;
	text-shadow:0px 1px 0px #528ecc;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #378de5), color-stop(1, #79bbff));
	background:-moz-linear-gradient(top, #378de5 5%, #79bbff 100%);
	background:-webkit-linear-gradient(top, #378de5 5%, #79bbff 100%);
	background:-o-linear-gradient(top, #378de5 5%, #79bbff 100%);
	background:-ms-linear-gradient(top, #378de5 5%, #79bbff 100%);
	background:linear-gradient(to bottom, #378de5 5%, #79bbff 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#378de5', endColorstr='#79bbff',GradientType=0);
	background-color:#378de5;
}
.myButton:active {
	position:relative;
	top:1px;
}
	</style>
</head>

<body>
	<%@include file="/WEB-INF/view/mainTop.jsp" %>
	
	<!--######## start banner Area ########-->
	<section class="banner-area relative" id="home">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white text-uppercase">
						공지사항
					</h1>
					<p class="text-white link-nav"><a href="/main.do">Home </a> <span class="lnr lnr-arrow-right"></span> <a href="/about.do">
							Notice</a></p>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->
	
	<div class="container">
		<div class="comment-form" style="width:80%; margin-left:100px; margin-bottom:70px;">
			<h4>공지사항 글쓰기</h4>
			<form action="/notice/noticeUpdate.do?ntNo=<%=nDTO.getNtNo() %>" method="post">
				<div class="form-group">
					<input type="text" class="form-control" id="ntTitle" name="ntTitle" placeholder="Title" value="<%=nDTO.getNtTitle() %>">
				</div>
				<div class="form-group">
					<textarea class="form-control mb-10" rows="10" id="ntContent" name="ntContent" placeholder="Content"><%=nDTO.getNtContent() %></textarea>
				</div>
				<button type="submit" class="myButton">등록</button>
				<button type="reset" class="myButton">취소</button>
			<input type="hidden" name="ntWriter" value="<%=name %>" />
			<input type="hidden" name="ntRegNo" value="<%=userNo %>"/>
			</form>
		</div>
	</div>
	<%@include file="/WEB-INF/view/mainFooter.jsp" %>

</body>

</html>