<%@page import="poly.util.CmmUtil"%>
<%@page import="poly.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<% 
	String id = CmmUtil.nvl((String) session.getAttribute("id"));
	String name = CmmUtil.nvl((String) session.getAttribute("name"));
	String userNo = CmmUtil.nvl((String) session.getAttribute("userNo"));
	String commWriter = CmmUtil.nvl((String) session.getAttribute("commWriter"));
%>
<script>

	function login() {
		openLoginModal();
	};

	function openLoginModal() {
		showLoginForm();
		setTimeout(function() {
			$('#loginModal').modal('show');
		}, 230);

	}

	function showLoginForm() {
		$('#loginModal .registerBox').fadeOut('fast', function() {
			$('.loginBox').fadeIn('fast');
			$('.register-footer').fadeOut('fast', function() {
				$('.login-footer').fadeIn('fast');
			});

			$('.modal-title').html('Login with');
		});
		$('.error').removeClass('alert alert-danger').html('');
	}

	function shakeModal() {
		$('#loginModal .modal-dialog').addClass('shake');
		$('.error').addClass('alert alert-danger').html(
				"Invalid email/password combination");
		$('input[type="password"]').val('');
		setTimeout(function() {
			$('#loginModal .modal-dialog').removeClass('shake');
		}, 1000);
	}
</script>
<script>
	function logout() {
		alert("로그아웃 하셨습니다.")
		location.href = "/user/logout.do"
	}
</script>

	<!--################ Start Header Area ########-->
	<header id="header" id="home">
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-sm-6 col-4 no-padding">
					</div>
					
					<!-- id가 공백이 아니면 로그인 성공 -->
					<% if (!id.equals("")) { %>
					<!-- 로그인 성공 -->
					<div class="col-lg-6 col-sm-6 col-8 header-top-right no-padding">
						<ul>
							<li><a href="#"></a></li>
						</ul> 
						<ul>
							<li>
								<b>
									<a><%=name%></a>님 환영합니다.
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<button type="submit" onclick="logout();" class="genric-btn info-border circle medium" value="로그아웃">LOGOUT</button>
								</b>
							</li>
						</ul>
					</div>
					<%} else { %>
					<!-- 로그인 전 or 실패 -->
					<div class="col-lg-6 col-sm-6 col-8 header-top-right no-padding">
						<ul>
							<li><a href="#"></a></li>
						</ul> 
						<ul>
							<li>
								<a href="javascript:login()" data-toggle="modal" onclick="openLoginModal();">login&nbsp;&nbsp;</a>
				<!-- 로그인 페이지 -->				
				<%@ include file="/WEB-INF/view/user/userLogin.jsp" %>
							</li>
						</ul>
					</div>
					
					<%} %>
					
				</div>
			</div>
		</div>
		<hr>
		<div class="container main-menu">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="/main.do"><img src="/resource/img/youlogo.png"/></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li class="menu-active"><a href="/main.do">home</a></li>
						<li><a href="/lost/lostItemSearch.do">분실물 조회</a></li>
						<li class="menu-has-children"><a href="">community</a>
							<ul>
								<li><a href="/notice/noticeList.do">공지사항</a></li>
								<li><a href="/community/commList.do">자유게시판</a></li>
							</ul>
						</li>
						<li class="menu-has-children"><a href="#">MYPAGE</a>
							<ul>
								<li><a href="/user/userDetail.do?userNo=<%=userNo%>">내 정보</a></li>
								<li><a href="/user/userWriteList.do?userNo=<%=userNo%>">내가 쓴 글 보기</a></li>
							</ul>
						</li>
						<% if (userNo.equals("1")) { %>
						<li><a href="/user/userList.do">회원 관리</a></li>
						<%} %>
					</ul>
				</nav>
				<!--######## #nav-menu-container -->
			</div>
		</div>
	</header>
	<!--######## End Header Area ########-->
	
