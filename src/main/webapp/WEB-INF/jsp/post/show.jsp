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
<!-- 	<link rel="stylesheet" type="text/css" href="/resources/css/materialize.css"> -->
	 
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

		<!-- Intro -->
			<section id="intro" class="main style1 dark fullscreen">
				<div class="content container 75%">
					<header>
						<h2>${post.title}</h2>
					</header>
					<footer>
						<a href="#one" class="button style2 down">More</a>
					</footer>
				</div>
			</section>

		<!-- One -->
			<section id="one" class="main style2 right dark fullscreen">
				<div id="a">
					<div class="firstImage"></div>
					<div class="firstImageExplain">
						배가 항구에 머문다면</br>
						높은 파도에 시달릴 일도 </br>
						거친 비바람에 시달릴일도 없을 것이다.</br>
						하지만 그것이 배의 존재이유는 아니다.</br>
					</div>
				</div><div id="b">${post.contents}<br><br></div>
				<a href="#two" class="button style2 down anchored">Next</a>
			</section>
			
					<!-- Work -->
			<section id="work" class="main style3 primary">
				<div class="content container">
					<header>
						<h2>More Picture</h2>
					</header>

					<!-- Lightbox Gallery  -->
						<div class="container 75% gallery">
							<div class="row 0% images">
								<div class="6u 12u(mobile)"><a href="/resources/images/fulls/07.jpg" class="image fit from-left"><img src="/resources/images/thumbs/01.jpg" title="The Anonymous Red" alt="" /></a></div>
								<div class="6u 12u(mobile)"><a href="/resources/images/fulls/02.jpg" class="image fit from-right"><img src="/resources/images/thumbs/02.jpg" title="Airchitecture II" alt="" /></a></div>
							</div>
							<div class="row 0% images">
								<div class="6u 12u(mobile)"><a href="/resources/images/fulls/03.jpg" class="image fit from-left"><img src="/resources/images/thumbs/03.jpg" title="Air Lounge" alt="" /></a></div>
								<div class="6u 12u(mobile)"><a href="/resources/images/fulls/04.jpg" class="image fit from-right"><img src="/resources/images/thumbs/04.jpg" title="Carry on" alt="" /></a></div>
							</div>
							<div class="row 0% images">
								<div class="6u 12u(mobile)"><a href="/resources/images/fulls/05.jpg" class="image fit from-left"><img src="/resources/images/thumbs/05.jpg" title="The sparkling shell" alt="" /></a></div>
								<div class="6u 12u(mobile)"><a href="/resources/images/fulls/06.jpg" class="image fit from-right"><img src="/resources/images/thumbs/06.jpg" title="Bent IX" alt="" /></a></div>
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
					<!-- 		<button class="addComment btn waves-effect waves-light" type="submit" name="action">댓글달기</button> -->
					</div>
			
				
			</section>


		<!-- Scripts -->
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