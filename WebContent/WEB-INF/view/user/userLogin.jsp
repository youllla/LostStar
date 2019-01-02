<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!-- 로그인 css -->
<link rel="stylesheet" href="/resource/css/login.css">

	<div class="container">
		<div class="modal fade login" id="loginModal">
			<div class="modal-dialog login animated">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body">
						<div class="box">
							<div class="content">
								<div class="social">
									<h1>LOGIN</h1>
								</div>
								<div class="division">
									<div class="line l"></div>
									<span>go</span>
									<div class="line r"></div>
								</div>
								<div class="error"></div>
								<div class="form loginBox">
									<form method="post" action="/user/loginProc.do"	accept-charset="UTF-8">
										<input id="id" class="form-control" type="email" placeholder="ID" name="id">
										<input id="password" class="form-control" type="password" placeholder="PASSWORD" name="password">
										<button type="submit" class="genric-btn info radius" value="로그인">LOGIN</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<div class="forgot login-footer">
							<span>
							<a href="/user/userReg.do">회원가입</a> 
							<a href="/user/userIdFind.do">ID찾기</a>
							<a href="/user/userPwFind.do">PW찾기</a>  
							</span>
						</div>
						<div class="forgot register-footer" style="display: none">
							<span>Already have an account?</span> 
							<a href="javascript: showLoginForm();">Login</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>