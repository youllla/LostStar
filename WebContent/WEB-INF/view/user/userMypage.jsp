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
					alert("여기까지 data : " + data);
					
					var content="";
					$.each(data, function(key, value){
						content+="<div class='container'"
						content+=""
						content+=""
						
					})
				}
			})
		}
	})
</script>
</head>
<body>

	<%@include file="/WEB-INF/view/mainTop.jsp" %>

	<div class="container" style="margin-top:20px;">
		<div class="typography" style="align:center">
		<h2 class="typo-list" style="margin-bottom:50px; text-align:center; /* text-decoration:underline; */">Register Account</h2>
		</div>
			<form action="/user/userRegProc.do" method="post">
				<div style="margin-bottom:100px; padding:0px 10px 0px 10px; text-align:center; margin: 0 auto; width:60%; /* min-width:100% */">
					<div class="mt-10">
						<input type="text" id="name" name="name" placeholder="NAME" onfocus="this.placeholder = ''" onblur="this.placeholder = 'First Name'" required="" class="single-input">
					</div>
					<div class="mt-10">
						<input type="text" id="tel" name="tel" placeholder="TEL" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Last Name'" required="" class="single-input">
					</div>
					<div class="mt-10">
						<input type="text" id="id" name="id" placeholder="ID" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Last Name'" required="" class="single-input">
						<!-- <button type="submit" id="idCheck" name="idCheck">중복확인</button> -->
						<input type="button" id="idChk" value="중복확인" >
					</div>
					<div class="mt-10">
						<input type="password" id="password" style="margin-bottom:30px" name="password" placeholder="PASSWORD" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Email address'" required="" class="single-input">
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