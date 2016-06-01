<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="blog.model.User"%>
<!DOCTYPE HTML>

<html>
	<head>
		<title>Junnie Jobs Blog</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
	<link rel="stylesheet" type="text/css" href="/resources/css/show.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/styles.css">
	<link rel="stylesheet" type="text/css" href="/resources/css/font-awesome.min.css">
	 
	</head>
	<body>

		<!-- Header -->
			<header id="header">

				<!-- Logo -->
					<h1 id="logo">Jun's blog</h1>

				<!-- Nav -->
					<nav id="nav">
						<ul>
							 <li class="list-group-item userId">${sessionScope.user.name}</li>
							<li><a href="/post">Intro</a></li>
							<li><a href="/write/postBook">Story</a></li>
							<li class="write"><a href="/write/new">write</a></li>

						</ul>
					</nav>

			</header>

		<c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">${errorMessage}</div>
        </c:if>		


		<!-- First Page -->
			<section id="intro" class="main style1 dark fullscreen" style="background: url("${post.first_page_image_url}"); ">
				<div class="content container 75%">
					<header>
						<h2>${post.title}</h2>
					</header>
					<footer>
						<a href="#one" class="button style2 down">More</a>
					</footer>
				</div>
			</section>



			<!-- Second Page -->
			<section id="one" class="main style2 right dark fullscreen">
				<div id="a">
					<div class="firstImage">
						<img src="${post.second_page_image_url}">
					</div>
					<div class="firstImageExplain">
						${post.second_page_short_text}
					</div> 
				</div><div id="b">${post.second_page_long_text}<br><br></div>
				<a href="#two" class="button style2 down anchored">Next</a>
			</section>


			
			<!-- Third Page -->
			<section id="work" class="main style3 primary">
				<div class="content container">
					<header>
						<h2>More Picture</h2>
					</header>

					<!-- Lightbox Gallery  -->
						<div class="container 75% gallery">

							<div class="row 0% images">
								<div class="6u 12u(mobile)">
									<a href="${post.third_page_thumb1_image_url}" class="image fit from-left"><img src="${post.third_page_thumb1_image_url}" title="The Anonymous Red" alt="" /></a>
								</div>

								<div class="6u 12u(mobile)">
									<a href="${post.third_page_thumb2_image_url}" class="image fit from-right"><img src="${post.third_page_thumb2_image_url}" alt="" /></a>
								</div>
							</div>

							<div class="row 0% images">
								<div class="6u 12u(mobile)">
									<a href="${post.third_page_thumb3_image_url}" class="image fit from-left"><img src="${post.third_page_thumb3_image_url}" title="Air Lounge" alt="" /></a>
								</div>

								<div class="6u 12u(mobile)">
									<a href="${post.third_page_thumb4_image_url}" class="image fit from-right"><img src="${post.third_page_thumb4_image_url}" title="Carry on" alt="" /></a>
								</div>
							</div>

							<div class="row 0% images">
								<div class="6u 12u(mobile)">
									<a href="${post.third_page_thumb5_image_url}" class="image fit from-left"><img src="${post.third_page_thumb5_image_url}" title="The sparkling shell" alt="" /></a>
								</div>
								<div class="6u 12u(mobile)">
									<a href="${post.third_page_thumb6_image_url}" class="image fit from-right"><img src="${post.third_page_thumb6_image_url}" title="Bent IX" alt="" /></a>
								</div>
							</div>
						</div>

				</div>
			</section>

		<!-- Two -->
			<section id="two" class="main style2 left dark fullscreen">
				<div class="content box style2">
					<header>
						<h2>Current Map</h2>
					</header>
					<p>I'm Junnie Jobs</p>
				</div>
				<div class="style2_right"></div>
				<a href="#work" class="button style2 down anchored">Next</a>
			</section>



		<!-- reply -->
			<section id="comments" class="main style3 secondary">			
				<c:forEach items="${comment}" var="each">
					<div class="post_comment">
						<div class="comment_about_this_post">

							<div class="comment_user_Info">
								<div class="comment_user_thumb"></div>	
								<div class="comment_user_Id">${each.writer}</div>
							</div>

							<div class="comment_contents">
									<p>${each.contents}</p>
							</div>

						</div>
					</div>
				</c:forEach>
			
			    <input type="hidden" name="url" value="/api/post/${post.postId}/newComment" />
			
					<div class="comment_write_area">
							<textarea name="contents" class="comment_input" placeholder="글쓴이에게 말을 걸어주세요"></textarea>
							<button class="answer">댓글</button>
					</div>
			
				
			</section>



		    <script src="/resources/js/jquery.min.js"></script> 
		    <script src="/resources/js/handlebars-v4.0.5.js"></script>
			<script src="/resources/js/jquery.poptrox.min.js"></script>
			<script src="/resources/js/jquery.scrolly.min.js"></script>
			<script src="/resources/js/jquery.scrollex.min.js"></script>
			<script src="/resources/js/skel.min.js"></script>
			<script src="/resources/js/util.js"></script>
			<script src="/resources/js/main.js"></script>
			<script src="/resources/js/materialize.js"></script>
			 <script src="/resources/js/show.js"></script>



	</body>
</html>