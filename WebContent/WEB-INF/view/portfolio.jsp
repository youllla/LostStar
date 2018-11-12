<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx" class="no-js">

<head>
	<!-- Mobile Specific Meta -->
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Favicon-->
	<link rel="shortcut icon" href="/resource/img/fav.png">
	<!-- Author Meta -->
	<meta name="author" content="colorlib">
	<!-- Meta Description -->
	<meta name="description" content="">
	<!-- Meta Keyword -->
	<meta name="keywords" content="">
	<!-- meta character set -->
	<meta charset="UTF-8">
	<!-- Site Title -->
	<title>Portfolio</title>

	<%@include file="/WEB-INF/view/cssjs.jsp" %>
</head>

<body>
	<%@include file="/WEB-INF/view/mainTop.jsp" %>

	<!--######## start banner Area ########-->
	<section class="banner-area relative" id="home">
		<div class="container">
			<div class="row d-flex align-items-center justify-content-center">
				<div class="about-content col-lg-12">
					<h1 class="text-white text-uppercase">
						Portfolio
					</h1>
					<p class="text-white link-nav"><a href="/main.do">Home </a> <span class="lnr lnr-arrow-right"></span> <a href="/portfolio.do">
							Portfolio</a></p>
				</div>
			</div>
		</div>
	</section>
	<!--######## End banner Area ########-->

	<!--######## Start Recent Completed Project Area ########-->
	<section class="recent-completed-project section-gap">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-lg-12">
					<div class="main-title text-center">
						<h1>Our Recent Completed Projects</h1>
						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna
							aliqua.
						</p>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12">
					<div class="filters project-filter">
						<ul>
							<li class="active" data-filter=".all">All Categories</li>
							<li data-filter=".brand">Branding</li>
							<li data-filter=".img-man">Image Manipulation</li>
							<li data-filter=".creative">Creative Work</li>
							<li data-filter=".web">Web Design</li>
							<li data-filter=".print-mat">Print Material</li>
						</ul>
					</div>
					<div class="projects_inner row" id="lightgallery">
						<div class="col-lg-4 col-sm-6 web all" data-src="/resource/img/project/p1.jpg">
							<div class="projects_item">
								<img class="img-fluid w-100" src="/resource/img/project/p1.jpg" alt="">
								<div class="icon">
									<img class="img-fluid" src="/resource/img/icon.png" alt="">
								</div>
							</div>
							<div class="projects_text">
								<h4>
									<a href="portfolio-details.html">3D Helmet Design</a>
								</h4>
								<p>Client Project</p>
							</div>
						</div>
						<div class="col-lg-4 col-sm-6 brand all creative" data-src="/resource/img/project/p2.jpg">
							<div class="projects_item">
								<img class="img-fluid w-100" src="/resource/img/project/p2.jpg" alt="">
								<div class="icon">
									<img class="img-fluid" src="/resource/img/icon.png" alt="">
								</div>
							</div>
							<div class="projects_text">
								<h4>
									<a href="portfolio-details.html">2D Vinyl Design</a>
								</h4>
								<p>Client Project</p>
							</div>
						</div>
						<div class="col-lg-4 col-sm-6 all" data-src="/resource/img/project/p3.jpg">
							<div class="projects_item">
								<img class="img-fluid w-100" src="/resource/img/project/p3.jpg" alt="">
								<div class="icon">
									<img class="img-fluid" src="/resource/img/icon.png" alt="">
								</div>
							</div>
							<div class="projects_text">
								<h4>
									<a href="portfolio-details.html">Creative Poster Design</a>
								</h4>
								<p>Client Project</p>
							</div>
						</div>
						<div class="col-lg-4 col-sm-6 all print-mat" data-src="/resource/img/project/p4.jpg">
							<div class="projects_item">
								<img class="img-fluid w-100" src="/resource/img/project/p4.jpg" alt="">
								<div class="icon">
									<img class="img-fluid" src="/resource/img/icon.png" alt="">
								</div>
							</div>
							<div class="projects_text">
								<h4>
									<a href="portfolio-details.html">Embosed Logo Design</a>
								</h4>
								<p>Client Project</p>
							</div>
						</div>
						<div class="col-lg-4 col-sm-6 brand img-man all" data-src="/resource/img/project/p5.jpg">
							<div class="projects_item">
								<img class="img-fluid w-100" src="/resource/img/project/p5.jpg" alt="">
								<div class="icon">
									<img class="img-fluid" src="/resource/img/icon.png" alt="">
								</div>
							</div>
							<div class="projects_text">
								<h4>
									<a href="portfolio-details.html">3D Disposable Bottle</a>
								</h4>
								<p>Client Project</p>
							</div>
						</div>
						<div class="col-lg-4 col-sm-6 brand work img-man all" data-src="/resource/img/project/p6.jpg">
							<div class="projects_item">
								<img class="img-fluid w-100" src="/resource/img/project/p6.jpg" alt="">
								<div class="icon">
									<img class="img-fluid" src="/resource/img/icon.png" alt="">
								</div>
							</div>
							<div class="projects_text">
								<h4>
									<a href="portfolio-details.html">3D Logo Design</a>
								</h4>
								<p>Client Project</p>
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