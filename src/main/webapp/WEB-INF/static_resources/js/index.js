var INTRO = (function(window) {


  function init() {

    // window.fbAsyncInit = function() {
    //   FB.init({
    //     appId      : '260091451012404',
    //     cookie     : true,  // 쿠키가 세션을 참조할 수 있도록 허용
    //     xfbml      : false,  // 소셜 플러그인이 있으면 처리
    //     version    : 'v2.1' // 버전 2.1 사용
    //  });
    // }

     $("#login").on("click", login);
     $("#logout").on("click", logout);
     $("#story").on("click", move_to_story);
     $('#logo').addClass('animated fadeInDown');
     $("input:text:visible:first").focus();
     $('input').attr('autocomplete', 'off');
     // $(".fb-login-button").on("click", fbAsyncInit);
  }


  // function checkLoginState(){
  //   console.log("들어옴")
  //    FB.getLoginStatus(function(response) {
  //     statusChangeCallback(response);
  //   })
  // }

  // function statusChangeCallback(response) {

  //   var baseURL = "http://localhost:8080";
  //   console.log('statusChangeCallback');
  //   console.log(response);
  //   // response 객체는 현재 로그인 상태를 나타내는 정보를 보여준다. 
  //   // 앱에서 현재의 로그인 상태에 따라 동작하면 된다.
  //   // FB.getLoginStatus().의 레퍼런스에서 더 자세한 내용이 참조 가능하다.
  //   if (response.status === 'connected') {
  //     // 페이스북을 통해서 로그인이 되어있다.
  //     console.log("페이스북을 통해 로그인 되어있다.");
  //      // window.location.href = ("/post");

  //      //유저의 id와 이름을 가져오는 api, 이를 데이타베이스에 저장한다. 유저 아이디는 중복되지 않으므로 키가 된다.
  //             FB.api('/me', function(user) {
  //                if (user) {
  //                           var image = document.getElementById('image');
  //                           image.src = 'http://graph.facebook.com/' + user.id + '/picture'                    
  //                           // $("#image").html()
  //                           // var name = document.getElementById('name');
  //                           console.log(user.name);
  //                           console.log(user.id);
  //                           $("#name").html(user.name);
          
  //                           $("#id").html(user.id);

  //                           var userId = user.id;
  //                           var name = user.name;
  //                           var user = {};
  //                           user.userId = userId;
  //                           user.userName = name;
  //                           console.log(user);
                            
  //                           $.ajax({

  //                             "url" : (baseURL + "/users/userInfo"),
  //                             "type" : "POST",
  //                             "data" : user
  //                           }).done(function(user){
  //                             console.log("이거 찍힐려나?");

  //                               // if(user){
  //                               //   window.location.href = ("/post");
  //                               // }else{
  //                               //   return;
  //                               // }
  //                           }).fail(function(){

  //                           });
  //                       }
  //                   });    
                
  //   } else if (response.status === 'not_authorized') {
  //     // 페이스북에는 로그인 했으나, 앱에는 로그인이 되어있지 않다.
  //     // document.getElementById('status').innerHTML = 'Please log ' +
  //     //   'into this app.';
  //       console.log("페이스북에는 로그인 되어있지만, 앱에는 로그인 되어있지 않음");
  //   } else {
  //     // 페이스북에 로그인이 되어있지 않다. 따라서, 앱에 로그인이 되어있는지 여부가 불확실하다.
  //     // document.getElementById('status').innerHTML = 'Please log ' +
  //     //   'into Facebook.';
  //       console.log("페이스북에 로그인이 되어있지 않다. 따라서, 앱에 로그인이 되어있는지 여부가 불확실하다.");
  //   }
  // }


  function move_to_story(){

    window.location.href = ("/write/postBook/15");
  }

  function login(){
    console.log("로그인 이벤트 실행");
        $(".intro_wrapper .login_box").css('display', 'block');
        $(".headerText").hide();
        $("#story").hide();
        $("#login").hide();
  }

  function logout(){
    console.log("logout");
     // $('.login-box').fadeIn(1000).css('display', 'block');
  }

  return {
      "init" : init
    }


})(window);

$(document).ready(function() {
  INTRO.init();
}); 


 