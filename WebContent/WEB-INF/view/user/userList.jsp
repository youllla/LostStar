<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<UserDTO> uList = (List<UserDTO>)request.getAttribute("uList");
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
	
	<!--######## start banner Area ########-->
	<section class="banner-area relative" id="home">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white text-uppercase">
						회원목록
					</h1>
					<p class="text-white link-nav"><a href="/main.do">Home </a> <span class="lnr lnr-arrow-right"></span> <a href="/about.do">
							MemberList</a></p>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->

	<div class="container" style="margin-top:20px;">
		<div class="typography" style="align: center">
			<h2 class="typo-list" style="margin-bottom: 50px; text-align: center;">
				<span class="lnr lnr-user"></span>&nbsp;MemberList
			</h2>
		</div>
		<div style="width:100%; text-align:center;">
			<div class="comments-area" style="width:75%; margin:0 auto;">
				<div class="comment-list">
					<%for(int i=0; i<uList.size(); i++) {%>
					<div class="single-comment justify-content-between d-flex">
						<div class="user justify-content-between d-flex">
							<div class="thumb">
								<span class="lnr lnr-user"></span>
							</div>
							<div>
								<h5><%=uList.get(i).getName() %></h5>
								<p class="date"><%=uList.get(i).getId() %></p>
							</div>
						</div>
						<div class="reply-btn">
							<a href="/user/userDetail.do?userNo=<%=uList.get(i).getUserNo() %>" class="btn-reply text-uppercase">상세보기</a>
						</div>
					</div>
					<%} %>
				</div>
			</div>
		</div>
	</div>
	
	<nav class="blog-pagination justify-content-center d-flex" style="padding-bottom:1px; padding-top:20px;">
		<ul class="pagination">
			<li class="page-item">
				<a href="#" class="page-link" aria-label="Previous">
					<span aria-hidden="true">
						<span class="lnr lnr-chevron-left"></span>
					</span>
				</a>
			</li>
			<li class="page-item active"><a href="#" class="page-link">01</a></li>
			<li class="page-item"><a href="#" class="page-link">02</a></li>
			<li class="page-item"><a href="#" class="page-link">03</a></li>
			<li class="page-item"><a href="#" class="page-link">04</a></li>
			<li class="page-item"><a href="#" class="page-link">09</a></li>
			<li class="page-item">
				<a href="#" class="page-link" aria-label="Next">
					<span aria-hidden="true">
						<span class="lnr lnr-chevron-right"></span>
					</span>
				</a>
			</li>
		</ul>
	</nav>
	
	<%@include file="/WEB-INF/view/mainFooter.jsp" %>

</body>
</html>