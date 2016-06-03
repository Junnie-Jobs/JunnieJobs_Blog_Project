var SHOW_POST = (function(window) {

  var localURL = "http://localhost:8080";
  var url = $('input[name="url"]').val();
  var first_page_img = $('input[name="first_page_image_url"]').val();
  var second_page_image_url = $('input[name="second_page_image_url"]').val();
  var third_page_thumb1_image_url = $('input[name="third_page_thumb1_image_url"]').val();
  var third_page_thumb2_image_url = $('input[name="third_page_thumb2_image_url"]').val();
  var third_page_thumb3_image_url = $('input[name="third_page_thumb3_image_url"]').val();
  var third_page_thumb4_image_url = $('input[name="third_page_thumb4_image_url"]').val();
  var third_page_thumb5_image_url = $('input[name="third_page_thumb5_image_url"]').val();
  var third_page_thumb6_image_url = $('input[name="third_page_thumb6_image_url"]').val();



  var comment = "<div class='post_comment'>" +
                    "<div class='comment_about_this_post'>" +

                        "<div class='comment_user_Info'>" +
                          "<div class='comment_user_thumb'>" +
                          "<img src='{{userPhoto}}'>" +
                          "</div> " +
                          "<div class='comment_user_Id'>{{userId}}</div>" +
                        "</div>" +

                        "<div class='comment_contents'>" +
                            "<p>{{contents}}</p>" +
                        "</div>" +

                    "</div>" +
                 "</div>";

  var comment_template = Handlebars.compile(comment);

  var thumb = "<a href='{{img_url}}' class='image fit from-left'><img src='{{img_url}}' title='The Anonymous Red' alt='' /></a>"
  var thumb_template = Handlebars.compile(thumb);

    var baseURL = "http://localhost:8080/images/upload/"
   // var baseURL = "http://125.209.195.244:7070/images/upload";

  function init() {

     viewResolver();
     $(".comment").on("click", addComment);
  }

  function viewResolver(){

     $("#intro").css("background-image",'url('+baseURL+first_page_img+')');
     $(".firstImage").css("background-image",'url('+baseURL+second_page_image_url+')');
     $(".thumb1_block").append(thumb_template({"img_url":baseURL+third_page_thumb1_image_url}));
     $(".thumb2_block").append(thumb_template({"img_url":baseURL+third_page_thumb2_image_url}))
     $(".thumb3_block").append(thumb_template({"img_url":baseURL+third_page_thumb3_image_url}))
     $(".thumb4_block").append(thumb_template({"img_url":baseURL+third_page_thumb4_image_url}))
     $(".thumb5_block").append(thumb_template({"img_url":baseURL+third_page_thumb5_image_url}))
     $(".thumb6_block").append(thumb_template({"img_url":baseURL+third_page_thumb6_image_url}))
     
      
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
        var str = comment_template({"userPhoto": values.comment.writerImage, "userId":values.comment.writer, "contents":values.comment.contents})
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


 