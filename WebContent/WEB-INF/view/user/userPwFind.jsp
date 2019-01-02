<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/view/cssjs.jsp" %>

<!-- <script type="text/javascript">
$(function(){
	//PW찾기
	$("#pwFind").click(function(){
		var name=$("#name").val();
		var id=$("#id").val();
		
		if(name==''){
			alert("이름을 입력해주세요.");
			return false;
		} else if(id==''){
			alert("아이디를 입력해주세요.");
			return false;
		} else {
			$.ajax({
				url : "/user/userPwFind.do",
				type : 'POST',
				data : {
					'name' : name,
					'id' : id
				},
				success:function(data){
					console.log(data);
					
					var content='';
					$.each(data, function(key, value){
						content+='<div class="container" style="text-align:center;">';
						content+='<div class="mt-10">';
						content+='<p>회원님의 비밀번호는 </p>';
						content+='<h1>' + value.password + '</h1>';
						content+='<p>입니다.</p>'
						content+='</div>';
						content+='</div>';
					});
					$('#pwFindProc').html(content);
				},
				error : function(error) {
					alert("조회된 결과가 없습니다.");
				}
			});
		}
	});
	});
</script> -->
<!-- <script>
//패스워드 찾기
function doSubmit(){
	var name = $("#namePw");
	var email= $("#email");
	var f =$("#f"); 
	console.log(name.val());
	console.log(email.val());
	
	if(name.val()==""){
		alert("이름을 입력해주세요");
		name.focus();
		return false;
	}else if(email.val()==""){
		alert("이메일을 입력해주세요");
		email.focus();
		return false;
	}else {
		f.attr("action", "/user/pwFindProc.do");//id 가 f 인 폼태그에 속성이 action인 값 user/pwFindProc.do 실행 
		f.submit();//전송
		return true;
	}
};
</script> -->
</head>
<body>

	<%@include file="/WEB-INF/view/mainTop.jsp" %>


	<div class="container" style="margin-top:20px;">
		<div class="typography" style="align:center">
			<h2 class="typo-list" style="margin-bottom:50px; text-align:center; ">비밀번호 찾기</h2>
		</div>
		<form action="/user/userPwFindProc.do", method="post">
			<div style="margin-bottom:100px; padding:0px 10px 0px 10px; text-align:center; margin: 0 auto; width:60%; /* min-width:100% */">
				<div class="mt-10">
					<input type="text" id="id" name="id" placeholder="ID" required="" class="single-input">
				</div>
				<div class="mt-10">
					<input type="text" id="name" name="name" placeholder="NAME" required="" class="single-input">
				</div>
				<div class="mt-10">
					<input type="text" id="tel" name="tel" placeholder="TEL" required="" class="single-input">
				</div>
				<div class="mt-10">
					<button type="submit" id="pwFind" name="pwFind" class="genric-btn success circle arrow" style="margin-bottom:50px">FIND</button>
					<!-- <a href= "javascript:doSubmit();" id="submitLink" class="genric-btn success circle arrow" style="margin-bottom:50px">패스워드 찾기</a> -->
				</div>
			</div>
		</form>
	</div>

	<%@include file="/WEB-INF/view/mainFooter.jsp" %>

</body>
</html>