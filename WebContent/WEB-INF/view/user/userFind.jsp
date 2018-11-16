<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/view/cssjs.jsp" %>

<script type="text/javascript">
	//ID찾기
	$("#idFind").click(function(){
		var name=$("#name").val();
		var tel=$("#tel").val();
		
		if(name==''){
			alert("이름을 입력해주세요.");
			return false;
		} else if(tel==''){
			alert("전화번호를 입력해주세요.");
			return false;
		} else {
			$.ajax({
				url : "/user/idFind.do",
				type : 'POST',
				data : {
					'name' : name,
					'tel' : tel
				},
				success:function(data){
					console.log(data);
					alert("data : " + data);
					
					var content="";
					$.each(data, function(key, value){
						content+="value.id";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
					});
					$('#idFind').html(content);
				},
				error : function(error) {
					alert("조회된 결과가 없습니다.");
					var content="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						content+="";
						$('#idFind').html(contents);
				}
			});
		}
	});
</script>
</head>
<body>

	<%@include file="/WEB-INF/view/mainTop.jsp" %>


	<!--######## Start Recent Completed Project Area ########-->
	<section class="recent-completed-project section-gap">
		<div class="container">
			<!-- <div class="typography" style="align:center">
			<h2 class="typo-list" style="margin-bottom:50px; text-align:center; /* text-decoration:underline; */">ID/PW 찾기</h2>
			</div> -->
			<div class="row">
				<div class="col-lg-12">
					<div class="filters project-filter">
						<ul>
							<!-- <li class="active" data-filter=".all">All Categories</li> -->
							<li data-filter=".brand">아이디찾기</li>
							<li data-filter=".img-man">비밀번호찾기</li>
						<!-- 	<li data-filter=".creative">Creative Work</li>
							<li data-filter=".web">Web Design</li>
							<li data-filter=".print-mat">Print Material</li> -->
						</ul>
					</div>
					<div class="projects_inner row" id="">
						<div class="col-lg-4 col-sm-6 web all" data-src="#">
							<div class="projects_item">
						</div>
						<div class="projects_text">
						</div>
					</div>
					<div class="col-lg-4 col-sm-6 brand all creative" data-src="#">
						<div class="projects_item">
						</div>
					</div>
					<div class="col-lg-4 col-sm-6 all" data-src="#">
						<div class="projects_item">
						</div>
						<div class="projects_text">
						</div>
					</div>
					<div class="col-lg-4 col-sm-6 all print-mat" data-src="#">
						<div class="projects_item">
						</div>
						<div class="projects_text">
							<h4>
								<a href="portfolio-details.html"></a>
							</h4>
						</div>
					</div>
				<div class="col-lg-4 col-sm-6 brand img-man all" data-src="#">
					<div class="projects_item">
						<div class="icon"></div>
					</div>
					<div class="projects_text">
						<form action="/user/userRegProc.do" method="post">
							<div style="margin-bottom: 100px; padding: 0px 10px 0px 10px; text-align: center; margin: 0 auto; width: 60%;">
								<div class="mt-10">
									<input type="text" id="name" name="name" placeholder="NAME" required="" class="single-input">
								</div>
								<div class="mt-10">
									<input type="text" id="tel" name="tel" placeholder="TEL" required="" class="single-input">
								</div>
									<div class="mt-10">
									<button type="submit" class="genric-btn success circle arrow">
										FIND<span class="lnr lnr-arrow-right"></span>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="col-lg-4 col-sm-6 brand work img-man all" data-src="#">
					<div class="projects_item">
						<div class="icon"></div>
					</div>
					<div class="projects_text">
						<form action="/user/userRegProc.do" method="post">
							<div style="margin-bottom: 100px; padding: 0px 10px 0px 10px; text-align: center; margin: 0 auto; width: 60%;">
								<div class="mt-10">
									<input type="text" id="name" name="name" placeholder="NAME" required="" class="single-input">
								</div>
								<div class="mt-10">
									<input type="text" id="tel" name="tel" placeholder="TEL" required="" class="single-input">
								</div>
								<div class="mt-10">
									<button type="submit" class="genric-btn success circle arrow">
										FIND<span class="lnr lnr-arrow-right"></span>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
	</section>
	<!--######## End Recent Completed Project Area ########-->

	<%@include file="/WEB-INF/view/mainFooter.jsp" %>

</body>
</html>