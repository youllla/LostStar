<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/view/cssjs.jsp" %>

<script type="text/javascript">
	/* var idChk = false; */
	 $(function(){
		$('#idCheck').click(function(){
			idCheck();
		});
	}); 
	
	function idCheck(){
		var id = $('#id').val();
		$.ajax({
			url : '/user/idCheck.do',
			method : 'post',
			data : {'id' : id},
			success : function(data){
				/* alert(data); */
				if(data==0){
					alert("아이디 사용이 가능합니다.");
				}else{
					alert("아이디 사용이 불가능합니다.");
				}
				
			}
		});
	};
	</script>
</head>
<body>

	<%@include file="/WEB-INF/view/mainTop.jsp" %>

	<div class="container" style="margin-top:20px;">
		<div class="typography" style="align:center">
		<h2 class="typo-list" style="margin-bottom:50px; text-align:center; ">회원가입</h2>
		</div>
			<form action="/user/userRegProc.do" method="post">
				<div style="margin-bottom:100px; padding:0px 10px 0px 10px; text-align:center; margin: 0 auto; width:60%; /* min-width:100% */">
					<div class="mt-10">
						<input type="text" id="name" name="name" placeholder="NAME" required="" class="single-input">
					</div>
					<div class="mt-10">
						<input type="text" id="tel" name="tel" placeholder="TEL" required="" class="single-input">
					</div>
					<div class="mt-10" style="margin-bottom:10px;">
						<input type="email" id="id" name="id" placeholder="ID" required="" class="single-input" style="float:left; width:80%;">
						<button type="submit" class="single-input genric-btn primary-border medium" id="idCheck" name="idCheck" style="float:right; width:17%; ">중복확인</button>
					</div>
					<div class="mt-10">
						<input type="password" id="password" style="margin-bottom:10px" name="password" placeholder="PASSWORD" required="" class="single-input">
					</div>
					<div class="mt-10">
						<input type="password" id="password" style="margin-bottom:30px" name="password" placeholder="PASSWORD CHECK" required="" class="single-input">
					</div>
					<div class="mt-10">
						<button type="submit" class="genric-btn success circle arrow" style="margin-bottom:200px">JOIN<span class="lnr lnr-arrow-right"></span></button>
					</div>
				</div>
			</form>
		</div>

	<%@include file="/WEB-INF/view/mainFooter.jsp" %>

</body>
</html>