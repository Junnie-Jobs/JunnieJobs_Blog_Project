<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ include file="/include/tags.jspf"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Travel DB</title>
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="/resources/css/intro.css">
<script src="/resources/js/juqery-2.2.0.min.js"></script>
 <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="/resources/js/vide.min.js"></script>
<style>
</style>

</head>
<body class="video" data-vide-bg="/resources/video/nightsky.mp4">

	<div class="background">
		<div class="intro_wrapper">
			<div class="headerText">
					이상적인 여행사가 존재한다면 <br /> 
					우리에게 어디를 가고 싶으냐가 아니라 <br /> 
					어떤 삶의 변화가 필요하느냐고 물어볼 것이다. <br />
			</div>
				<div class="btn_area">
					<div id="signUp">Sign Up</div>
					<!-- <div id="login">Login</div> -->
					 <div id="story"><a href="/post">story</a>
				 </div> 
			</div>

		
		<div class="SignUp-box animated fadeInUp">
			<div class="headerbox">Register</div>
			<div onclick="facebooklogin()" class="facebook_login_btn"> 
			facebook login 
    
		</div>  
			
		<!-- 	<div class="SignUpForm">
				<form autocomplete="off" class="form" action="/users/save"
					method="post">
					<label for="userId">Username</label> <br /> <input
						autocomplete="off" type="text" id="userId" name="userId">
					<br /> <label for="password">Password</label> <br /> <input
						autocomplete="off" type="password" id="password" name="password">
					<br />
					<button type="submit">Sign Up</button>
					<br />
				</form>
			</div> -->
		</div>


		<div class="login-box animated fadeInUp">
			<div class="headerbox">Login</div>
			<div class="loginForm">
				<form class="form" action="/users/login" method="post"
					autocomplete="off">
					<label for="username">Username</label> <br /> <input type="text"
						id="userId" name="userId" autocomplete="off"> <br /> <label
						for="password">Password</label> <br /> <input type="password"
						id="password" name="password" autocomplete="off"> <br />
					<button type="submit">Login</button>
					<br />
				</form>
			</div>
		</div>


		</div>

			
	

	</div>
	</div>
	
	<script type="text/javascript">  
//페이스북 SDK 초기화   
window.fbAsyncInit = function() {  
    FB.init({appId: '1019536518137994', status: true, cookie: true,xfbml: true});      
};  
      
(function(d){  
   var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];  
   if (d.getElementById(id)) {return;}  
   js = d.createElement('script'); js.id = id; js.async = true;  
   js.src = "//connect.facebook.net/en_US/all.js";  
   ref.parentNode.insertBefore(js, ref);  
 }(document));     
              
function facebooklogin() {  
    //페이스북 로그인 버튼을 눌렀을 때의 루틴.  
        FB.login(function(response) {  
            var fbname;  
            var accessToken = response.authResponse.accessToken;  
        }, {scope: 'publish_stream,user_likes'});  
}  
</script>  


	
	<script type="text/javascript">
		$(function() {
			$("#signUp").on("click", function() {
				$('.SignUp-box').fadeIn(1000).css('display', 'block');
				$(".headerText").hide();
				$("#signUp").hide();
				$("#login").hide();
				$("#story").hide();
			});

			$("#login").on("click", function() {
				$('.login-box').fadeIn(1000).css('display', 'block');
				$(".headerText").hide();
				$("#signUp").hide();
				$("#login").hide();
			});

			/* $("#logout").on("click", function() {
				$('.login-box').fadeIn(1000).css('display', 'block');
			}); */

			$('#logo').addClass('animated fadeInDown');
			$("input:text:visible:first").focus();

			$('input').attr('autocomplete', 'off');
		});
	</script>

</body>
</html>