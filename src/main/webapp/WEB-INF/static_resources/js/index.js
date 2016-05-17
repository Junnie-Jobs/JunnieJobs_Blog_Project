var INTRO = (function(window) {


  function init() {

     $("#login").on("click", login);
     $("#logout").on("click", logout);
     $("#story").on("click", move_to_story);

     $('#logo').addClass('animated fadeInDown');
     $("input:text:visible:first").focus();
     $('input').attr('autocomplete', 'off');
  }

  function move_to_story(){

    window.location.href = ("/post");
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


 