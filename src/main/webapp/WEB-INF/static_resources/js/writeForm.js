var writeForm = (function(window) {

  var baseURL = "http://localhost:8080";

  function init() {

    $('#fileupload').fileupload({
        url: baseURL+ '/api/post/fileUpload',
        acceptFileTypes: /(\.|\/)(jpe?g|png)$/i,
        dataType: 'json',
        singleFileUploads: false,
        done: function (e, data) {
          $.each(data.result.files, function (index, file) {
            console.log("업로드 성공");
            $(".main_photo_wrapper").css('background-image', 'url('+baseURL+'/images/upload/'+file.url+')');
            $(".main_cover_uploader").css('display','none');
            $(".defualt_message").css('display','none');
            $(".main_photo_wrapper .header_text").css('display','block');
            $("input[name='first_page_image_url']").val(file.url);

          });
        },
        progressall: function (e, data) {
          var progress = parseInt(data.loaded / data.total * 100, 10);
          $('#progress .determinate').css(
            'width',
            progress + '%'
          );
        }
      });
    $('#fileupload2').fileupload({
        url: "http://localhost:8080/api/post/fileUpload",
        acceptFileTypes: /(\.|\/)(jpe?g|png)$/i,
        dataType: 'json',
        singleFileUploads: false,
        done: function (e, data) {
          $.each(data.result.files, function (index, file) {
            $(".left_page_img").css('background-image', 'url('+baseURL+'/images/upload/'+file.url+')');
            $(".second_page_uploader").css('display','none');
            $("input[name='second_page_image_url']").val(file.url);

          });
        },
        progressall: function (e, data) {
          var progress = parseInt(data.loaded / data.total * 100, 10);
          $('#progress .determinate').css(
            'width',
            progress + '%'
          );
        }
      });
    $('#fileupload3').fileupload({
        url: "http://localhost:8080/api/post/fileUpload",
        acceptFileTypes: /(\.|\/)(jpe?g|png)$/i,
        dataType: 'json',
        singleFileUploads: false,
        done: function (e, data) {
          console.log(data);
          console.log(data.result.files[1]);
          
          $(".thumb").css('border','none');
          $(".third_page_uploader").css('display', 'none');

          $(".thumb1").css('background-image', 'url('+baseURL+'/images/upload/'+data.result.files[0].url+')');
          $(".thumb2").css('background-image', 'url('+baseURL+'/images/upload/'+data.result.files[1].url+')');
          $(".thumb3").css('background-image', 'url('+baseURL+'/images/upload/'+data.result.files[2].url+')');
          $(".thumb4").css('background-image', 'url('+baseURL+'/images/upload/'+data.result.files[3].url+')');
          $(".thumb5").css('background-image', 'url('+baseURL+'/images/upload/'+data.result.files[4].url+')');
          $(".thumb6").css('background-image', 'url('+baseURL+'/images/upload/'+data.result.files[5].url+')');
          
          //  $(".thumb1").css('background-image', 'url('+baseURL+data.result.files[0].url+')');
          // $(".thumb2").css('background-image', 'url('+baseURL+data.result.files[1].url+')');
          // $(".thumb3").css('background-image', 'url('+baseURL+data.result.files[2].url+')');
          // $(".thumb4").css('background-image', 'url('+baseURL+data.result.files[3].url+')');
          // $(".thumb5").css('background-image', 'url('+baseURL+data.result.files[4].url+')');
          // $(".thumb6").css('background-image', 'url('+baseURL+data.result.files[5].url+')');


          $("input[name='third_page_thumb1_image_url']").val(data.result.files[0].url);
          $("input[name='third_page_thumb2_image_url']").val(data.result.files[1].url);
          $("input[name='third_page_thumb3_image_url']").val(data.result.files[2].url);
          $("input[name='third_page_thumb4_image_url']").val(data.result.files[3].url);
          $("input[name='third_page_thumb5_image_url']").val(data.result.files[4].url);
          $("input[name='third_page_thumb6_image_url']").val(data.result.files[5].url);
        },
        progressall: function (e, data) {
          var progress = parseInt(data.loaded / data.total * 100, 10);
          $('#progress .determinate').css(
            'width',
            progress + '%'
          );
        }
      });
  }


 

  return {
      "init" : init
    }


})(window);

$(document).ready(function() {
  writeForm.init();
}); 



  // $(document).ready(function() {
    //     $('#upFile').fileupload({
    //         url : '/api/post/fileUpload2', 
    //         dataType: 'json',
    //         //replaceFileInput: false,
    //         add: function(e, data){
    //          console.log("이게 되는건가?");
    //             var uploadFile = data.files[0];
    //             var isValid = true;
    //             if (!(/png|jpe?g|gif/i).test(uploadFile.name)) {
    //                 alert('png, jpg, gif 만 가능합니다');
    //                 isValid = false;
    //             } else if (uploadFile.size > 5000000) { // 5mb
    //                 alert('파일 용량은 5메가를 초과할 수 없습니다.');
    //                 isValid = false;
    //             }
    //             if (isValid) {
    //                 data.submit();              
    //             }
    //         }, progressall: function(e,data) {
    //             var progress = parseInt(data.loaded / data.total * 100, 10);
    //             $('#progress .bar').css(
    //                 'width',
    //                 progress + '%'
    //             );
    //         }, done: function (e, data) {
    //             var code = data.result.code;
    //             var msg = data.result.msg;
    //             if(code == '1') {
    //                 alert(msg);
    //             } else {
    //                 alert(code + ' : ' + msg);
    //             } 
    //         }, fail: function(e, data){
    //             // data.errorThrown
    //             // data.textStatus;
    //             // data.jqXHR;
    //             alert('서버와 통신 중 문제가 발생했습니다');
    //             foo = data;
    //         }
    //     });
    // }); 


 