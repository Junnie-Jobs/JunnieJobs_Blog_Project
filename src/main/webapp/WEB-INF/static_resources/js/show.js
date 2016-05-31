var SHOW_POST = (function(window) {

  var baseURL = "http://localhost:8080";
  var url = $('input[name="url"]').val();
  console.log("url주소는 " + url);

  var comment = "<div class='post_comment'>" +
                    "<div class='comment_about_this_post'>" +

                        "<div class='comment_user_Info'>" +
                          "<div class='comment_user_thumb'></div> " +
                          "<div class='comment_user_Id'>{{userId}}</div>" +
                        "</div>" +

                        "<div class='comment_contents'>" +
                            "<p>{{contents}}</p>" +
                        "</div>" +

                    "</div>" +
                 "</div>";

  var comment_template = Handlebars.compile(comment);

  function init() {

     $(".answer").on("click", addComment);

  }

  function addComment(e){
    e.preventDefault();

     var $commentForm = $("form[name=comment]");
     var data = {};
     data.contents = $(".comment_input").val()
     console.log(data.contents);

     $.ajax({
          "url" : (baseURL + url),
          "type" : 'POST',
          "data" : data

    }).done(function(values){
        console.log(values);
        console.log(values.comment.contents);
        var str = comment_template({"userId":values.comment.writer, "contents":values.comment.contents})
        $(".comment_write_area").before(str);
        $(".comment_input").val("");



    }).fail(function(status){
        console.log(status);
    });

  }

  return {
      "init" : init
    }


})(window);

$(document).ready(function() {
  SHOW_POST.init();
}); 


 