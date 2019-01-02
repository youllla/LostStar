<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/view/cssjs.jsp" %>

<script type="text/javascript">
$(function(){
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
				url : "/user/userIdFind.do",
				type : 'POST',
				data : {
					'name' : name,
					'tel' : tel
				},
				success:function(data){
					console.log(data);
					
					var content='';
					$.each(data, function(key, value){
						content+='<div class="container" style="text-align:center;">';
						content+='<div class="mt-10">';
						content+='<p>회원님의 아이디는 </p>';
						content+='<h1>' + value.id + '</h1>';
						content+='<p>입니다.</p>'
						content+='</div>';
						content+='</div>';
					});
					$('#idFindProc').html(content);
				},
				error : function(error) {
					alert("조회된 결과가 없습니다.");
					/* content+='<div class="">';
					content+='<div class="col-lg-12">';
					content+='<h1>' + value.name + '님의 아이디는' +'</h1>';
					content+='<h2>' + value.id + '</h2>';
					content+='<h1>입니다.</h1>'
					content+='</div>';
					content+='</div>';
					$('#idFindProc').html(content); */
				}
			});
		}
	});
	});
</script>
</head>
<body>

	<%@include file="/WEB-INF/view/mainTop.jsp" %>


	<div class="container" style="margin-top:20px;">
		<div class="typography" style="align:center">
			<h2 class="typo-list" style="margin-bottom:50px; text-align:center; ">아이디 찾기</h2>
		</div>
			<div style="margin-bottom:100px; padding:0px 10px 0px 10px; text-align:center; margin: 0 auto; width:60%; /* min-width:100% */">
				<div class="mt-10">
					<input type="text" id="name" name="name" placeholder="NAME" required="" class="single-input">
				</div>
				<div class="mt-10">
					<input type="text" id="tel" name="tel" placeholder="TEL" required="" class="single-input">
				</div>
				<div class="mt-10">
					<input type="button" id="idFind" name="idFind" class="genric-btn success circle arrow" style="margin-bottom:50px" value="FIND">
				</div>
			</div>
			
			<div class="" id="idFindProc">
				
			</div>
	</div>

	<%@include file="/WEB-INF/view/mainFooter.jsp" %>

</body>
</html>