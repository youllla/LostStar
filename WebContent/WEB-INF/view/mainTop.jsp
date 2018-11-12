<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<div class="header-top-left">
							<a href="">
								<i class="fa fa-phone"></i>
								012-6532-568-9746
							</a>
						</div>
					</div>
					<div class="col-lg-6 col-sm-6 col-8 header-top-right no-padding">
						<ul>
							<!-- <li><a href="#"><i class="fa fa-facebook"></i></a></li>
							<li><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li><a href="#"><i class="fa fa-dribbble"></i></a></li> -->
							<li><a href="#"></a></li>
						</ul> 
						<ul>
							<li>
								<a href="javascript:login()" data-toggle="modal" onclick="openLoginModal();">login&nbsp;&nbsp;</a>
								<!-- class="btn big-login" -->
								
				<!-- 로그인 페이지 -->				
				<%@ include file="/WEB-INF/view/user/userLogin.jsp" %>
				
								
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<div class="container main-menu">
			<div class="row align-items-center justify-content-between d-flex">
				<div id="logo">
					<a href="/main.do"><img src="/resource/img/youlogo.png" alt="" title="" /></a>
				</div>
				<nav id="nav-menu-container">
					<ul class="nav-menu">
						<li class="menu-active"><a href="/main.do">home</a></li>
						<li><a href="/portfolio.do">분실물 조회</a></li>
						<li><a href="/notice/noticeList.do">notice</a></li>
						<li class="menu-has-children"><a href="">community</a>
							<ul>
								<li><a href="/blog_home.do">Blog Home</a></li>
								<li><a href="/blog_single.do">Blog Single</a></li>
							</ul>
						</li>
						<li class="menu-has-children"><a href="">Pages</a>
							<ul>
								<li><a href="/portfolio_detail.do">Portfolio Details</a></li>
								<li><a href="/elements.do">Elements</a></li>
							</ul>
						</li>
						<li><a href="/contact.do">Contact</a></li>
					</ul>
					
					<!-- <ul class="nav-menu">
						<li class="menu-active"><a href="/main.do">home</a></li>
						<li><a href="/portfolio.do">분실물 조회</a></li>
						<li><a href="/about.do">notice</a></li>
						<li class="menu-has-children"><a href="">community</a>
							<ul>
								<li><a href="/blog_home.do">Blog Home</a></li>
								<li><a href="/blog_single.do">Blog Single</a></li>
							</ul>
						</li>
					</ul> -->
					
				</nav>
				<!--######## #nav-menu-container -->
			</div>
		</div>
	</header>
	<!--######## End Header Area ########-->