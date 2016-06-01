<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
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
<style>
.imageBack{
    width: 80%;
    height: 500px;
    border:1px solid black;
    background-size: 100% 100%;
}

</style>
<script >
    $(document).ready(function() {
      $('#fileupload').fileupload({
        url: 'api/post/fileUpload',
        acceptFileTypes: /(\.|\/)(jpe?g|png)$/i,
        dataType: 'json',
        singleFileUploads: false,
        done: function (e, data) {
          $.each(data.result.files, function (index, file) {

            console.log(file);
            console.log(index);
            $(".imageBack").css('background-image', 'url('+file.url+')');

            var item = $('<li class="collection-item"/>');
            // $('<img/>').attr('src', file.thumbnailUrl).appendTo(item);
            // // $('<span/>').text(file.name).appendTo(item);
            // $('<div class="input-field col s12">' +
            //   `<input id="captions[${index}]" name="captions[]" type="text" required>` +
            //   `<label for="captions[${index}]">${file.name} 캡션</label>` +
            //   '</div>').appendTo(item);
            // item.appendTo('#files');
          });

          // $("#media").html(JSON.stringify(data.result.files));
        },
        progressall: function (e, data) {
          var progress = parseInt(data.loaded / data.total * 100, 10);
          $('#progress .determinate').css(
            'width',
            progress + '%'
          );
        }
      });
    }); 
</script>
</head>
<body>
<input type="file" name="files" id="upFile">
    <div id="progress">
        <div class="bar" style="width: 0%;"></div>
    </div>


         <span>작품 추가</span>
            <input id="fileupload" type="file" name="files[]" multiple>
          </div>
          <div id="progress" class="progress">
            <div class="determinate"></div>
          </div>
          <ul id="files" class="collection"></ul>
          <textarea id="media" name="media" type="text" style="display: none"></textarea>

    <div class="imageBack"></div>



</body>
</html>
