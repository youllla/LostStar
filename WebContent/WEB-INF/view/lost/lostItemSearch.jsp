<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String lostId = CmmUtil.nvl((String) session.getAttribute("lostId"));
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
function get() {
	$.ajax({
		url: '/lost/lostItemFind.do',
		type: 'get',
		data:{
			itemCategory:$('#itemCategory').val(),
			itemCode:$('#itemCode').val()
		},
		dataType: 'json',
		success: function(get) {
			console.log(get);
			var content='';
			
			$.each(get, function(key, value){
				content += '<form action="/lost/lostItemDetail.do" method="post">';
				content += '<div class="table-row">';
				content += '<div class="serial"></div>';
				content += '<div class="country">' + value.GET_NAME + '</div>';
				content += '<div class="visit">' + value.GET_POSITION + '</div>';
				content += '<div class="percentage">' + value.GET_DATE + '</div>';
				content += '<div class="visit"><button type="submit" class="genric-btn link-border radius" value="detail">상세</button></div>';
				content += '<input type="hidden" id="id" name="id" value="' + value.ID + '"> <br />';
				content += '</div>';
				content += '</form>';
			$('#lostItem').html(content);
			})
		},
		error:function(){
			alert("조회된 결과가 없습니다.");
		}
	})
}
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
							분실물조회</a></p>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->
	<div class="container">
			<form action="/lost/lostItemFind.do" method="post">
				<div class="default-select" id="default-select" style="float:left;">
					<select id="itemCategory" name="itemCategory" onchange="document.getElementById('itemCategoryVal').value=this.options[this.selectedIndex].value" style="display: none;">
						<option value="">선택</option>
						<option value="가방">[가방]가방</option>
						<option value="기타">[기타]기타</option>
						<option value="베낭">[베낭]베낭</option>
						<option value="서류봉투">[서류봉투]서류봉투</option>
						<option value="쇼핑백">[쇼핑백]쇼핑백</option>
						<option value="옷">[옷]옷</option>
						<option value="장난감">[장난감]장난감</option>
						<option value="지갑">[지갑]지갑</option>
						<option value="책">[책]책</option>
						<option value="파일">[파일]파일</option>
						<option value="핸드폰">[핸드폰]핸드폰</option>
					</select>
					<div class="nice-select" tabindex="0">
						<span class="current">선택</span>
						<ul class="list">
							<li data-value="" class="option selected focus">선택</li>
							<li data-value="가방" class="option">[가방]가방</li>
							<li data-value="기타" class="option">[기타]기타</li>
							<li data-value="베낭" class="option">[베낭]베낭</li>
							<li data-value="서류봉투" class="option">[서류봉투]서류봉투</li>
							<li data-value="쇼핑백" class="option">[쇼핑백]쇼핑백</li>
							<li data-value="옷" class="option">[옷]옷</li>
							<li data-value="장난감" class="option">[장난감]장난감</li>
							<li data-value="지갑" class="option">[지갑]지갑</li>
							<li data-value="책" class="option">[책]책</li>
							<li data-value="파일" class="option">[파일]파일</li>
							<li data-value="핸드폰" class="option">[핸드폰]핸드폰</li>
						</ul>
					</div>
				</div>
				<br /><br />
				<div class="default-select" id="default-select" style="float:left;">
					<select id="itemCode" name="itemCode" onchange="document.getElementById('itemCodeVal').value=this.options[this.selectedIndex].value" style="display: none;">
						<option value="">선택</option>
						<option value="b1">[b1]버스</option>
						<option value="b2">[b2]마을버스</option>
						<option value="s1">[s1]지하철(1~4호선)</option>
						<option value="s2">[s2]지하철(5~8호선)</option>
						<option value="s3">[s3]코레일</option>
						<option value="s4">[s4]지하철(9호선)</option>
						<option value="t1">[t1]법인택시</option>
						<option value="t2">[t2]개인택시</option>
					</select>
					<div class="nice-select" tabindex="0">
						<span class="current">선택</span>
						<ul class="list">
							<li data-value="" class="option selected focus">선택</li>
							<li data-value="b1" class="option">[b1]버스</li>
							<li data-value="b2" class="option">[b2]마을버스</li>
							<li data-value="s1" class="option">[s1]지하철(1~4호선)</li>
							<li data-value="s2" class="option">[s2]지하철(5~8호선)</li>
							<li data-value="s3" class="option">[s3]코레일</li>
							<li data-value="s4" class="option">[s4]지하철(9호선)</li>
							<li data-value="t1" class="option">[t1]법인택시</li>
							<li data-value="t2" class="option">[t2]개인택시</li>
						</ul>
					</div>
					<button type="button" onclick="get();" class="genric-btn primary-border circle" style="line-height:30px;">검색</button>
				</div>
			</form>
		<br /><br /><br /><br />
			<div class="progress-table" style="margin-bottom:20px;">
				<div class="table-head">
					<div class="serial">No.</div>
					<div class="country">이름</div>
					<div class="visit">발견장소</div>
					<div class="percentage">발견날짜</div>
					<div class="visit"></div>
				</div>
				<div class="table_row" id="lostItem">
				</div>
			</div>
			<nav class="blog-pagination justify-content-center d-flex" style="padding-bottom:1px; padding-top:1px;">
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
		<input type="hidden" id="itemCategoryVal" name="itemCategoryVal" value="">
		<input type="hidden" id="itemCodeVal" name="itemCodeVal" value="">
	</div>
	
	<%@include file="/WEB-INF/view/mainFooter.jsp" %>
</body>
</html>