
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Clean Blog - Start Bootstrap Theme</title>

<!-- Bootstrap core CSS -->
<link href="homepage/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="homepage/vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="homepage/css/clean-blog.min.css" rel="stylesheet">

</head>

<body>


	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="${pageContext.request.contextPath }/">HOME</a>

			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>


			<!--Session ile kullanıcıyı user olup olmadığına bakıyorum  -->


			<c:if test="${not empty user}">
								---hello ${user}---
									<%
				String a = "user";
					HttpSession oturum = request.getSession();
					oturum.setAttribute("oturumAdı", a);
			%>
			</c:if>



			<%
				HttpSession oturum = request.getSession();

				String isim = (String) oturum.getAttribute("oturumAdı");
			%>



			<%
				if (isim == null) {
			%>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath }/login"><input
							type="submit" value="Login" /></a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath }/register"><input
							type="submit" value="Register" /></a></li>

				</ul>

			</div>

			<%
				}
			%>



			<%
				if (isim != null) {
			%>

			<c:url var="logoutUrl" value="/logout" />
			<form action="${logoutUrl}" method="post">
				<input type="submit" value="Log Out!"><input type="hidden"
					name="${_csrf.parameterName }" value="${_csrf.token }" />
			</form>

			<%
				}
			%>

		</div>
	</nav>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('homepage/img/home-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>BLOGY!</h1>
						<span class="subheading">A Blog Theme by Start Bootstrap</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->



	<!-- Articlepost form -->

	<%
		if (isim != null) {
	%>
	<form role="form"
		action="${pageContext.request.contextPath}/postArticle" method="post"
		class="share-form">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		<div class="form-group">
			<label for="exampleTextarea" for="title">Title </label>
			<textarea class="form-control" name="title" placeholder="TITLE..."
				id="exampleTextarea" rows="1"></textarea>
		</div>

		<div class="form-group">
			<label for="exampleTextarea" for="">Article</label>
			<textarea class="form-control" name="text" placeholder="comment..."
				id="exampleTextarea" rows="3"></textarea>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>

	</form>

	<%
		}
	%>



	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto">
				<c:if test="${not empty list}">
					<c:forEach items="${list}" var="article">
						<div class="post-preview">

							<h2 class="post-title">${article.title}</h2>
							<h3 class="post-subtitle">${article.text }</h3>

							</a>
							<p class="post-meta">Posted by ${article.author }

								${article.date }</p>
						</div>

					</c:forEach>

				</c:if>
				<hr>

				<hr>
				<!-- Pager -->
				<div class="clearfix">
					<a class="btn btn-primary float-right"
						href="${pageContext.request.contextPath}/">Older Posts &rarr;</a>
				</div>
			</div>
		</div>
	</div>


	<hr>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<ul class="list-inline text-center">
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-twitter fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-facebook fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<p class="copyright text-muted">Copyright &copy; Your Website
						2018</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="homepage/vendor/jquery/jquery.min.js"></script>
	<script src="homepage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="homepage/js/clean-blog.min.js"></script>




</body>

</html>
