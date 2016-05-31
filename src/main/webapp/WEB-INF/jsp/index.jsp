<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <%@ include file="/include/tags.jspf"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Travel DB</title>
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="/resources/css/index.css">
 <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="/resources/js/jquery.vide.js"></script>
<style>
.facebook_login{

  width: 150px;
  height: 30px;
  border: 1px solid white;
  margin-top: -200px;
  color: white;
  cursor: pointer;
}

.facebook_login:hover{
  background-color: white;
}

.logins{
  width: 200px;
  height: 50px;
}

</style>

</head>
<body class="video" data-vide-bg="/resources/video/nightsky.mp4">

<!-- <c:set value="${sessionScope.user.userId}" var="userId" /> -->

	<div class="background">
		<div class="intro_wrapper">

			<div class="headerText">
					이상적인 여행사가 존재한다면 <br /> 
					우리에게 어디를 가고 싶으냐가 아니라 <br /> 
					어떤 삶의 변화가 필요하느냐고 물어볼 것이다. <br />

			</div>

<%
    Object userId = session.getAttribute("userId");
%>

<!--       <div class="btn_area">
          <c:choose>
                <c:when test="${not empty userId}">
                    <div id="story">Story</div> 
                    <div id="logout">LogOut</div>
                </c:when>
                <c:otherwise>
                    <div id="login">Login</div>
                    <div id="about">about</div>
                </c:otherwise>
          </c:choose> 
       </div>  -->



      <div class="btn_area">
        <div id="login">Login</div>
         <div id="story">Story</div> 
      </div> 

       <div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="true" data-auto-logout-link="true" ></div>
   <!--     onlogin="checkLoginState()" -->

 <!-- 			<div class="btn_area">
				<div id="login">Login</div>
				 <div id="story">Story</div> 
			</div>  -->

         <form:form cssClass="userCreateForm" name="user" modelAttribute="user" action="/users/createUser" method="post">
                <div class="form-group">
                    <form:input path="userId" cssClass="facebookId"/>
                </div>
                <div class="form-group">
                    <form:input path="name" cssClass="facebookName"/>
                </div>
                <button type="submit" class="submit btn btn-success clearfix pull-right"></button>
                <div class="clearfix" />
         </form:form>


		
			<div class="login_box animated fadeInUp">
				<div class="headerbox">Login</div>
<!-- 
          <div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="true" data-auto-logout-link="true" onlogin="checkLoginState()"></div> -->
           <div class="facebook_login">페이스북으로 로그인</div>
          <p>사용자정보 출력</p>
          <div align="left">
              <img id="image"/>
              <div id="name"></div>
              <div id="id"></div>
          </div>
         
          
          <div class="twitter_login">트위터로 로그인</div>
          <div class="naver_login">네이버로 로그인</div>
			
			</div>
		</div>
	</div>
	</div>

<div id="fb-root"></div>
<!--<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); 
  js.id = id;
  js.src = "http://connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.6&appId=260091451012404";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>-->
  
  <script language="javascript" src="http://connect.facebook.net/ko_KR/all.js"></script>
  <script src="/resources/js/index.js"></script>

  <script>
    // This is called with the results from from FB.getLoginStatus().

    var fbAsyncInit = function() {
      FB.init({
        appId      : '260091451012404',
        cookie     : true,  // 쿠키가 세션을 참조할 수 있도록 허용
        xfbml      : true,  // 소셜 플러그인이 있으면 처리
        version    : 'v2.1' // 버전 2.1 사용
      });

          // 자바스크립트 SDK를 초기화 했으니, FB.getLoginStatus()를 호출한다.
          //.이 함수는 이 페이지의 사용자가 현재 로그인 되어있는 상태 3가지 중 하나를 콜백에 리턴한다.
          // 그 3가지 상태는 아래와 같다.
          // 1. 앱과 페이스북에 로그인 되어있다. ('connected')
          // 2. 페이스북에 로그인되어있으나, 앱에는 로그인이 되어있지 않다. ('not_authorized')
          // 3. 페이스북에 로그인이 되어있지 않아서 앱에 로그인이 되었는지 불확실하다.
          // 위에서 구현한 콜백 함수는 이 3가지를 다루도록 되어있다.

        FB.getLoginStatus(function(response) {
          statusChangeCallback(response);
        });
   };


  function statusChangeCallback(response) {

    var baseURL = "http://localhost:8080";
    console.log('statusChangeCallback');
    console.log(response);
    // response 객체는 현재 로그인 상태를 나타내는 정보를 보여준다. 
    // 앱에서 현재의 로그인 상태에 따라 동작하면 된다.
    // FB.getLoginStatus().의 레퍼런스에서 더 자세한 내용이 참조 가능하다.
    if (response.status === 'connected') {
      // 페이스북을 통해서 로그인이 되어있다.
      console.log("페이스북을 통해 로그인 되어있다.");
       // window.location.href = ("/post");
       // testAPI();
       //유저의 id와 이름을 가져오는 api, 이를 데이타베이스에 저장한다. 유저 아이디는 중복되지 않으므로 키가 된다.
           FB.api('/me', function(user) {
                 if (user) {
                            var image = document.getElementById('image');
                            image.src = 'http://graph.facebook.com/' + user.id + '/picture'                    
                            // $("#image").html()
                            // var name = document.getElementById('name');
                            console.log(user.name);
                            console.log(user.id);
                            $("#name").html(user.name);
          
                            $("#id").html(user.id);

                            var userId = user.id;
                            var name = user.name;
                         
                            var user = {};
                            user.userId = userId;
                            user.name = name;
                            // user.imageLink = image.src;
                            console.log(user);
                            
                            $.ajax({

                              "url" : (baseURL + "/users/createUser"),
                              "type" : "POST",
                              "data" : user
                            }).done(function(){
                               $(".headerText").text(name +"님 여행이 시작됩니다.");
                               $(".headerText").addClass("enrolled");
                               $(".facebookId").val(userId);
                               $(".facebookName").val(name);
                               console.log("이것은 form태그에 텍스트 넣기");
                               console.log($(".facebookId").val());
                               console.log($(".facebookName").val());
                               $(".btn_area #login").css('display','none');
                         


                               if(!$(".headerText").hasClass("enrolled")){
                                   $(".btn_area #login").css('display','none');
                                   $(".userCreateForm button").trigger('click');
                               }
                              



                                // if(user){
                                //   window.location.href = ("/post");
                                // }else{
                                //   return;
                                // }
                            }).fail(function(){

                            });
                        }
                    });    
                     
              




    } else if (response.status === 'not_authorized') {
      // 페이스북에는 로그인 했으나, 앱에는 로그인이 되어있지 않다.
      // document.getElementById('status').innerHTML = 'Please log ' +
      //   'into this app.';
        console.log("페이스북에는 로그인 되어있지만, 앱에는 로그인 되어있지 않음");
    } else {
      // 페이스북에 로그인이 되어있지 않다. 따라서, 앱에 로그인이 되어있는지 여부가 불확실하다.
      // document.getElementById('status').innerHTML = 'Please log ' +
      //   'into Facebook.';
        console.log("페이스북에 로그인이 되어있지 않다. 따라서, 앱에 로그인이 되어있는지 여부가 불확실하다.");
    }
  }

  // 이 함수는 누군가가 로그인 버튼에 대한 처리가 끝났을 때 호출된다.
  // onlogin 핸들러를 아래와 같이 첨부하면 된다.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }





  // SDK를 비동기적으로 호출
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // 로그인이 성공한 다음에는 간단한 그래프API를 호출한다.
  // 이 호출은 statusChangeCallback()에서 이루어진다.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }



  </script>
	

</body>
</html>