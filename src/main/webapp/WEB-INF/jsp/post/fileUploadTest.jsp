<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<!DOCTYPE html>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/resources/css/materialize.css">
<script src="/resources/js/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> 
<script src="/resources/js/materialize.js"></script>
<script src="/resources/js/jquery.fileupload.js"></script>

<script >
    $(document).ready(function() {

        var baseURL= "http://localhost:8080"

        $('#fileupload').fileupload({
        url: baseURL+ '/write/postTest',
        acceptFileTypes: /(\.|\/)(jpe?g|png)$/i,
        dataType: 'json',
        singleFileUploads: false,
        done: function (e, data) {
          $.each(data.result.files, function (index, file) {
            console.log("이미지 업로드 완료");
          // $(".main_photo_wrapper").css('background-image', 'url('+baseURL+'/images/upload/'+file.url+')');
          // $(".defualt_message").css('color','rgba(255,255,255,0)');
          // $(".defualt_message").css('display','none');
          // $(".main_cover_uploader").css('display', 'none');
          // $(".main_photo_wrapper .header_text").css('display','block');
          // $("input[name='first_page_image_url']").val(file.url);
  
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
        // $('#upFile').fileupload({
        //     url : '/fileUpload', 
        //     dataType: 'json',
        //     //replaceFileInput: false,
        //     add: function(e, data){
        //         var uploadFile = data.files[0];
        //         var isValid = true;
        //         if (!(/png|jpe?g|gif/i).test(uploadFile.name)) {
        //             alert('png, jpg, gif 만 가능합니다');
        //             isValid = false;
        //         } else if (uploadFile.size > 5000000) { // 5mb
        //             alert('파일 용량은 5메가를 초과할 수 없습니다.');
        //             isValid = false;
        //         }
        //         if (isValid) {
        //             data.submit();              
        //         }
        //     }, progressall: function(e,data) {
        //         var progress = parseInt(data.loaded / data.total * 100, 10);
        //         $('#progress .bar').css(
        //             'width',
        //             progress + '%'
        //         );
        //     }, done: function (e, data) {
        //         var code = data.result.code;
        //         var msg = data.result.msg;
        //         if(code == '1') {
        //             alert(msg);
        //         } else {
        //             alert(code + ' : ' + msg);
        //         } 
        //     }, fail: function(e, data){
        //         // data.errorThrown
        //         // data.textStatus;
        //         // data.jqXHR;
        //         alert('서버와 통신 중 문제가 발생했습니다');
        //         foo = data;
        //     }
        // });
    }); 
</script>
</head>
<body>

    <form:form name="image" modelAttribute="image" action="http://localhost:8080/write/postTest" method="post">
        <form:input path="fileData" type="file" name="fileData" id="upFile" />
    <div id="progress">
        <div class="bar" style="width: 0%;"></div>
    </div>

    <button type="submit"></button>

    </form:form>

</body>
</html>
