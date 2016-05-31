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
	<link rel="stylesheet" type="text/css" href="/resources/css/post.css">
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

		<!-- Intro -->
			<section id="intro" class="main style1 dark fullscreen">
				<div class="content container 75%">
					<header>
						<h2>Hey</h2>
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
				</div><div id="b">Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nam nibh. Nunc varius facilisis eros. Sed erat. In in velit quis arcu ornare laoreet. Curabitur adipiscing luctus massa. Integer ut purus ac augue commodo commodo. Nunc nec mi eu justo tempor consectetuer. Etiam vitae nisl. In dignissim lacus ut ante. Cras elit lectus, bibendum a, adipiscing vitae, commodo et, dui. Ut tincidunt tortor. Donec nonummy, enim in lacinia pulvinar, velit tellus scelerisque augue, ac posuere libero urna eget neque. Cras ipsum. Vestibulum pretium, lectus nec venenatis volutpat, purus lectus ultrices risus, a condimentum risus mi et quam. Pellentesque auctor fringilla neque. Duis eu massa ut lorem iaculis vestibulum. Maecenas facilisis elit sed justo. Quisque volutpat malesuada velit.Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Nam nibh. Nunc varius facilisis eros. Sed erat. In in velit quis arcu ornare laoreet. Curabitur adipiscing luctus massa. Integer ut purus ac augue commodo commodo. Nunc nec mi eu justo tempor consectetuer. Etiam vitae nisl. In dignissim lacus ut ante. Cras elit lectus, bibendum a, adipiscing vitae, commodo et, dui. Ut tincidunt tortor. Donec nonummy, enim in lacinia pulvinar, velit tellus scelerisque augue, ac posuere libero urna eget neque. Cras ipsum. Vestibulum pretium, lectus nec venenatis volutpat, purus lectus ultrices risus, a condimentum risus mi et quam. Pellentesque auctor fringilla neque. Duis eu massa ut lorem iaculis vestibulum. Maecenas facilisis elit sed justo. Quisque volutpat malesuada velitLorem ipsum dolor sit amet, consectetuer adipiscing elit. Nam nibh. Nunc varius facilisis eros. Sed erat. In in velit quis arcu ornare laoreet. Curabitur adipiscing luctus massa. Integer ut purus ac augue commodo commodo. Nunc nec mi eu justo tempor consectetuer. Etiam vitae nisl. In dignissim lacus ut ante. Cras elit lectus, bibendum a, adipiscing vitae, commodo et, dui. Ut tincidunt tortor. Donec nonummy, enim in lacinia pulvinar, velit tellus scelerisque augue, ac posuere libero urna eget neque. Cras ipsum. Vestibulum pretium, lectus nec venenatis volutpat, purus lectus ultrices risus, a condimentum risus mi et quam. Pellentesque auctor fringilla neque. Duis eu massa ut lorem iaculis vestibulum. Maecenas facilisis elit sed justo. Quisque volutpat malesuada velitLorem ipsum dolor sit amet, consectetuer adipiscing elit. Nam nibh. Nunc varius facilisis eros. Sed erat. In in velit quis arcu ornare laoreet. Curabitur adipiscing luctus massa. Integer ut purus ac augue commodo commodo. Nunc nec mi eu justo tempor consectetuer. Etiam vitae nisl. In dignissim lacus ut ante. Cras elit lectus, bibendum a, adipiscing vitae, commodo et, dui. Ut tincidunt tortor. Donec nonummy, enim in lacinia pulvinar, velit tellus scelerisque augue, ac posuere libero urna eget neque. Cras ipsum. Vestibulum pretium, lectus nec venenatis volutpat, purus lectus ultrices risus, a condimentum risus mi et quam. Pellentesque auctor fringilla neque. Duis eu massa ut lorem iaculis vestibulum. Maecenas facilisis elit sed justo. Quisque volutpat malesuada velitLorem ipsum dolor sit amet, consectetuer adipiscing elit. Nam nibh. Nunc varius facilisis eros. Sed erat. In in velit quis arcu ornare laoreet. Curabitur adipiscing luctus massa. Integer ut purus ac augue commodo commodo. Nunc nec mi eu justo tempor consectetuer. Etiam vitae nisl. In dignissim lacus ut ante. Cras elit lectus, bibendum a, adipiscing vitae, commodo et, dui. Ut tincidunt tortor. Donec nonummy, enim in lacinia pulvinar, velit tellus scelerisque augue, ac posuere libero urna eget neque. Cras ipsum. Vestibulum pretium, lectus nec venenatis volutpat, purus lectus ultrices risus, a condimentum risus mi et quam. Pellentesque auctor fringilla neque. Duis eu massa ut lorem iaculis vestibulum. Maecenas facilisis elit sed justo. Quisque volutpat malesuada velit<br><br></div>
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
			<section id="contact" class="main style3 secondary">
				<div class="qna-comment">
					<div class="qna-comment-slipp">
						<p class="qna-comment-count"><strong>${question.countOfComment}</strong>개의 의견</p>
						<div class="qna-comment-slipp-articles">
							<c:forEach items="${answers}" var="each">
							<article class="article">
								<div class="article-header">
									<div class="article-header-thumb">
										<img src="https://scontent.xx.fbcdn.net/v/t1.0-1/p40x40/12122962_909412652472761_8335595914871932582_n.jpg?oh=2de53344b0cee6bf9f187eecb7e5c07c&oe=57E78312" class="article-author-thumb" alt="">
									</div>
									<div class="article-header-text">
										${each.writer}
										<div class="article-header-time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${each.createdDate}" /></div>
									</div>
								</div>
								<div class="article-doc comment-doc">
									<p>${each.contents}</p>
								</div>
								<div class="article-util">
									<ul class="article-util-list">
										<li>
											<a class="link-modify-article" href="/api/questions/${question.questionId}/answers/${each.answerId}/edit">수정</a>
										</li>
										<li>
											<form class="form-delete" action="/api/questions/${question.questionId}/answers/${each.answerId}">
												<button type="submit" class="link-delete-article">삭제</button>
											</form>
										</li>
									</ul>
								</div>
							</article>
                            </c:forEach>
							<div class="answerWrite">
                            <form name="answer" action="/api/questions/${question.questionId}/answers" method="post">
								<div class="form-group col-lg-12">
									<textarea name="contents" id="contents" class="form-control" placeholder=""></textarea>
								</div>
							
								<input class="btn btn-success pull-right sumbits" type="submit" value="댓글달기" />
								<!-- <input class="submit_button" type="submit" value="댓글달기" /> -->
								<div class="clearfix" />
							</form>
							</div>
						</div>
					</div>
				</div>
			</section>

		<!-- Footer -->
			<footer id="footer">

				<!-- Icons -->
					<ul class="actions">
						<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
						<li><a href="#" class="icon fa-pinterest"><span class="label">Pinterest</span></a></li>
						<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
					</ul>

			</footer>

		<!-- Scripts -->
		<script src="/resources/js/jquery.min.js"></script> 
			<script src="/resources/js/jquery.poptrox.min.js"></script>
			<script src="/resources/js/jquery.scrolly.min.js"></script>
			<script src="/resources/js/jquery.scrollex.min.js"></script>
			<script src="/resources/js/skel.min.js"></script>
			<script src="/resources/js/util.js"></script>
			<script src="/resources/js/main.js"></script>
			<script src="/resources/js/post.js">

	</body>
</html>