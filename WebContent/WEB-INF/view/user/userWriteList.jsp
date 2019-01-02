<%@page import="poly.dto.CommDTO"%>
<%@page import="poly.dto.NoticeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<NoticeDTO> nList = (List<NoticeDTO>)request.getAttribute("nList");
	List<CommDTO> cList = (List<CommDTO>)request.getAttribute("cList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/view/cssjs.jsp" %>

<script>
$(function(){
	var userNo = $('#userNo').val();
	var select = $('select[name=select]');
	
	select.change(function(){
		var selected=$('select[name=select] option:selected').val();
		
		if(userNo==1) {
			$.ajax({
				url:"/user/userWriteListAjax.do",
				method:'get',
				data:{'userNo':userNo},
				success:function(data){
					console.log(data);
					var content = '';
					var nList= data.nList;
					var cList= data.cList;
					
					if(selected=="notice"){
						content += '<div class="table-head">';
						content += '<div class="serial">No.</div>';
						content += '<div class="country">제목</div>';
						content += '<div class="visit">작성자</div>';
						content += '<div class="percentage">작성일</div>';
						content += '</div>';
						
						for(var i = 0 ; i < nList.length; i++){
							if(nList[i].ntWriter=="권유라"){
							content += '<a href="/notice/noticeDetail.do?ntNo=' + nList[i].ntNo + '">';
							content += '<div class="table-row">';
							content += '<div class="serial">' + nList[i].ntNo + '</div>';
							content += '<div class="country">' + nList[i].ntTitle + '</div>';
							content += '<div class="visit">' + nList[i].ntWriter + '</div>'; 
							content += '<div class="percentage">' + nList[i].ntRegDate + '</div>';
							content += '</div>'
							}
						}
					}else if(selected=="community"){
						content += '<div class="table-head">';
						content += '<div class="serial">No.</div>';
						content += '<div class="country">제목</div>';
						content += '<div class="visit">작성자</div>';
						content += '<div class="percentage">작성일</div>';
						content += '</div>';
						
						for(var i = 0 ; i < cList.length; i++){
							if(cList[i].commWriter=="권유라"){
							content += '<a href="/community/commDetail.do?commNo=' + cList[i].commNo + '">';
							content += '<div class="table-row">';
							content += '<div class="serial">' + cList[i].commNo + '</div>';
							content += '<div class="country">' + cList[i].commTitle + '</div>';
							content += '<div class="visit">' + cList[i].commWriter + '</div>'; 
							content += '<div class="percentage">' + cList[i].commRegDate + '</div>';
							content += '</div>'
							}
						}
					}
					content += '</div>';
					console.log(content);
					$('#writeList').html(content);
				},
				error:function(error){
					alert(error);
				}
			})
		}
	})
});
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
						내가 작성한 글 보기
					</h1>
					<p class="text-white link-nav"><a href="/main.do">Home </a> <span class="lnr lnr-arrow-right"></span> <a href="/about.do">
							MyWriting</a></p>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->
	
	<section class="latest-news-area section-gap">
		<div class="container">
			<%if(userNo.equals("1")) {%>
			<select name="select" id="select">
				<option value="notice" id="notice">공지사항</option>
				<option value="community" id="community">자유게시판</option>
			</select>
			<%} else { %>
			<select name="select" id="select">
				<option value="community" id="community">자유게시판</option>
			</select>
			<%} %>
			<div class="progress-table" id="writeList">
				<div class="table-head">
					<div class="serial">No.</div>
					<div class="country">제목</div>
					<div class="visit">작성자</div>
					<div class="percentage">작성일</div>
				</div>
				<%for(int i=0; i<cList.size(); i++) {%>
				<%if(commWriter.equals("송진수")) {%>
				<a href="/community/commDetail.do?commNo=<%=cList.get(i).getCommNo()%>">
					<div class="table-row">
						<div class="serial"><%=cList.get(i).getCommNo()%></div>
						<div class="country"><%=cList.get(i).getCommTitle() %></div>
						<div class="visit"><%=cList.get(i).getCommWriter() %></div>
						<div class="percentage"><%=cList.get(i).getCommRegDate() %></div>
					</div>
				</a>
				<%} %>
				<%} %>
			</div>
		</div>
	</section>
	
	<input type="hidden" value="<%=userNo %>" id="userNo">
	<input type="hidden" value="<%=commWriter %>" id="commWriter">

	<%@include file="/WEB-INF/view/mainFooter.jsp" %>
	
</body>
</html>