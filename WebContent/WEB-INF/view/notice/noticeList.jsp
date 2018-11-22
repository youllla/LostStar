<%@page import="java.util.List"%>
<%@page import="poly.dto.NoticeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<NoticeDTO> nList = (List<NoticeDTO>)request.getAttribute("nList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	
	<script type="text/javascript">
	function noticeDetail(ntNo){
		location.href="/notice/noticeDetail.do?ntNo="+ntNo;
	}
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
						Notice
					</h1>
					<p class="text-white link-nav"><a href="/main.do">Home </a> <span class="lnr lnr-arrow-right"></span> <a href="/about.do">
							Notice</a></p>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->
	

	<!--######## Start Latest News Area ########-->
	<section class="latest-news-area section-gap">
			<%if(userNo.equals("1")) {%>
			<a href="/notice/noticeWriteView.do" class="genric-btn success radius" style="float:right;">글쓰기</a>
			<%} %>
		<div class="container">
			<div class="progress-table">
				<div class="table-head">
					<div class="serial">No.</div>
					<div class="country">제목</div>
					<div class="visit">작성자</div>
					<div class="percentage">작성일</div>
				</div>
				<%for(int i=0; i<nList.size(); i++) {%>
				<a href="/notice/noticeDetail.do?ntNo=<%=nList.get(i).getNtNo()%>">
					<div class="table-row">
						<div class="serial"><%=nList.get(i).getNtNo()%></div>
						<div class="country"><%=nList.get(i).getNtTitle() %></div>
						<div class="visit"><%=nList.get(i).getNtWriter() %></div>
						<div class="percentage"><%=nList.get(i).getNtRegDate() %></div>
					</div>
				</a>
				<%} %>
			</div>
		</div>
	</section>
	<!--######## End Latest News Area ########-->

	<%@include file="/WEB-INF/view/mainFooter.jsp" %>

</body>

</html>