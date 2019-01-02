<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//String lostId = CmmUtil.nvl((String) session.getAttribute("lostId"));
	String lostId = (String)request.getAttribute("lostId");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="shortcut icon" href="/resource/img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="colorlib">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">

<title>Insert title here</title>
<%@include file="/WEB-INF/view/cssjs.jsp" %>

<script>

$.ajax({
	url: '/lost/lostItemInfo.do',
	type: 'get',
	data:{
		id: '<%=lostId%>'
	},
	dataType: 'json',
	success: function(get) {
		console.log(get);
		var content='';
		
		$.each(get, function(key, value){
			content += '<div>';
			content += '<div class="portfolio_right_text mt-30">';
			content += '<h4>상세정보</h4>';
			content += '<ul class="list">';
			content += '<li><span>분류</span>:' + value.CATE + '</li>';
			content += '<li><span>이름</span>' + value.GET_NAME + '</li>';
			content += '<li><span>습득날짜</span>:' + value.GET_DATE + '</li>';
			content += '<li><span>습득장소</span>:' + value.GET_POSITION + '</li>';
			content += '<li><span>현재상태</span>:' + value.STATUS + '</li>';
			content += '<li><span>보관장소</span>' + value.TAKE_PLACE + '</li>';
			content += '<li><span>차량번호</span>:' + value.DRIVE_NUM + '</li>';
			content += '<li><span>기사님 성명</span>:' + value.GET_NM + '</li>';
			content += '<li><span>전화번호</span>' + value.CONTACT + '</li>';
			content += '<li><span>습득place</span>' + value.GET_PLACE + '</li>';
			content += '</ul><br />';
			content += '<p>' + value.GET_THING + '</p>';
			content += '</div>';
			content += '</div>';
			content += '</div>';
			content += '<input type="hidden" id="id" name="id" value="' + value.ID + '"> <br />';
		$('#lostItem').html(content);
		})
	},
	error:function(){
		alert("조회된 결과가 없습니다.");
	}
})
</script>

<script>
$.ajax({
	url: '/lost/lostItemImage.do',
	type: 'get',
	data:{
		id: '<%=lostId%>'
	},
	dataType: 'json',
	success: function(get) {
		console.log(get);
		var content='';
		
		$.each(get, function(key, value){
			if(value.IMAGE_URL==""){
				alert("해당 분실물은 이미지가 존재하지 않습니다.");
			}else{
				content += '<div>';
				content += '<div class="left_img">';
				content += '<img class="img-fluid" src="' + value.IMAGE_URL + '" style="width:100%;">';
				content += '</div>';
				content += '</div>';
				content += '<input type="hidden" id="id" name="id" value="' + value.ID + '"> <br />';
			}
		$('#lostItemImage').html(content);
		})
	},
	error:function(){
		alert("조회된 결과가 없습니다.");
	}
})
</script>

</head>
<body>
	<%@include file="/WEB-INF/view/mainTop.jsp" %>
	<section class="banner-area relative" id="home">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white text-uppercase">
						분실물조회
					</h1>
					<p class="text-white link-nav"><a href="/main.do">Home </a> <span class="lnr lnr-arrow-right"></span> <a href="/about.do">
							분실물 상세정보</a></p>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->
	
	<!--######## Portfolio Details Area ########-->
	<section class="portfolio_details_area section-gap">
		<div class="container">
			<div class="portfolio_details_inner">
				<div class="row">
					<div class="col-md-6" id="lostItemImage">
						<div class="left_img">
						
						</div>
					</div>
					<div class="col-md-6" id="lostItem">
					
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--######## End Portfolio Details Area ########-->

	<%@include file="/WEB-INF/view/mainFooter.jsp" %>
</body>	

</html>