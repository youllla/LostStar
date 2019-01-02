<%@page import="poly.dto.CommDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<CommDTO> cList = (List<CommDTO>)request.getAttribute("cList");
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx" class="no-js">

<script>
	$(function(){
		
		if(cList.get(i).userNo()==1){
			document.getElementById('commList').style.background="#f2f2f2";
		}
	})
	
</script>

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="/resource/img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="colorlib">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Blog Details</title>

	<%@include file="/WEB-INF/view/cssjs.jsp" %>
	
	<script type="text/javascript">
	function CommDetail(commNo){
		location.href="/community/commDetail.do?commNo="+commNo;
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
						자유게시판
					</h1>
					<p class="text-white link-nav"><a href="/main.do">Home </a> <span class="lnr lnr-arrow-right"></span> <a href="/about.do">
							Community</a></p>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->
	
	<!--######## Start Latest News Area ########-->
	<section class="latest-news-area" style="padding-top:30px;">
		<div class="container">
			<div style="width:100%; text-align:right;  padding-bottom:10px;">
				<%if(!userNo.equals("")) {%>
				<a href="/community/commWriteView.do" class="genric-btn success radius">글쓰기</a>
				<%} %>
			</div>
			<div class="progress-table">
				<div class="table-head">
					<div class="serial">No.</div>
					<div class="country">제목</div>
					<div class="visit">작성자</div>
					<div class="percentage">작성일</div>
				</div>
				<%for(int i=0; i<cList.size(); i++) {%>
				<a href="/community/commDetail.do?commNo=<%=cList.get(i).getCommNo()%>">
					<%if(cList.get(i).getCommWriter().equals("권유라")) {%>
					<div class="table-row" id="commList" style="font-weight:bold; color:black;">
						<div class="serial"><%=cList.get(i).getCommNo()%></div>
						<div class="country"><%=cList.get(i).getCommTitle() %></div>
						<div class="visit"><%=cList.get(i).getCommWriter() %></div>
						<div class="percentage"><%=cList.get(i).getCommRegDate() %></div>
					</div>
					<%}else{ %>
					<div class="table-row" id="commList" style="color:#5B6781;">
						<div class="serial"><%=cList.get(i).getCommNo()%></div>
						<div class="country"><%=cList.get(i).getCommTitle() %></div>
						<div class="visit"><%=cList.get(i).getCommWriter() %></div>
						<div class="percentage"><%=cList.get(i).getCommRegDate() %></div>
					</div>
					<%} %>
				</a>
				<%} %>
			</div>
		</div>
	</section>
	<!--######## End Latest News Area ########-->
	
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
			<li class="page-item"><a href="#" class="page-link">05</a></li>
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