<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>게시판 등록 폼</title>
<head>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/materialize.css">
<link rel="stylesheet" type="text/css" href="/resources/css/writeForm.css">
<link rel="stylesheet" href="/resources/ckeditor/samples/css/samples.css">
<script src="/resources/js/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> 
<script src="/resources/js/jquery.fileupload.js"></script>
<script src="/resources/js/materialize.js"></script>

<style>
	/* label focus color */

   /* label underline focus color */


</style>

<script >
    $(document).ready(function() {

    	var baseURL = "http://localhost:8080";
    	var baseImagURL = "/"
    $('#fileupload').fileupload({
        url: baseURL+ '/api/post/fileUpload',
        acceptFileTypes: /(\.|\/)(jpe?g|png)$/i,
        dataType: 'json',
        singleFileUploads: false,
        done: function (e, data) {
          $.each(data.result.files, function (index, file) {

            console.log(file);
            console.log(index);
            $(".main_photo_wrapper").css('background-image', 'url('+baseURL+'/images/upload/'+file.url+')');
    
   
             $(".defualt_message").css('color','rgba(255,255,255,0)');
       		$(".defualt_message").css('display','none');
       		$(".main_cover_uploader").css('display', 'none');
       		$(".main_photo_wrapper .header_text").css('display','block');

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

	$('#fileupload2').fileupload({
        url: baseURL+ '/api/post/fileUpload2',
        acceptFileTypes: /(\.|\/)(jpe?g|png)$/i,
        dataType: 'json',
        singleFileUploads: false,
        done: function (e, data) {
          $.each(data.result.files, function (index, file) {

            console.log(file);
            console.log(index);
            $(".left_page_img").css('background-image', 'url('+baseURL+'/images/upload/'+file.url+')');
       		$(".second_page_uploader").css('display','none');s

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
</script>

<script type="text/javascript">
	function goUrl(url) {
		location.href=url;
	}
	// 등록 폼 체크
	function postWriteCheck() {
		var form = document.postWriteForm;
		if (form.subject.value == '') {
			alert('제목을 입력하세요.');
			form.subject.focus();
			return false;
		}
		if (form.writer.value == '') {
			alert('작성자을 입력하세요');
			form.writer.focus();
			return false;
		}
		return true;
	}
</script>

<script>
    $(function(){
         
        CKEDITOR.replace( 'contents', {//해당 이름으로 된 textarea에 에디터를 적용
            width:'100%',
            height:'800px',
           /*  filebrowserImageUploadUrl: '/imageUpload', */ //여기 경로로 파일을 전달하여 업로드 시킨다.
            skin:'flat'
            
        });
         
         
        CKEDITOR.on('dialogDefinition', function( ev ){
            var dialogName = ev.data.name;
            var dialogDefinition = ev.data.definition;
          
            switch (dialogName) {
                case 'image': //Image Properties dialog
                    //dialogDefinition.removeContents('info');
                    dialogDefinition.removeContents('Link');
                    dialogDefinition.removeContents('advanced');
                    break;
            }
        });
         
    });
</script>


</head>
<body>

<!-- 	<div class="navi"></div> -->
		<div class="buttons">
			<input type="button" value="목록" onclick="goUrl('/post');" />
			<input type="submit" value="저장" />
		</div>

<div class="first_page">
	<div class="main_photo_wrapper">
		<div class="defualt_message">메인 이미지를 업로드 해주세요</div>
		<div class="header_text">
			<input type="text"  class="title" size="80" maxlength="100" placeholder="제목을 입력해주세요" autocomplete="off"/>
		</div>
		<div class="photo_uploader main_cover_uploader">

			<form enctype="multipart/form-data">
			    <div class="file-field input-field">
			      <div class="btn">
			        <span>File</span>
			        <input id="fileupload" type="file" name="files[]" multiple>
			      </div>
			      <div class="file-path-wrapper">
			        <input class="file-path validate" type="text" placeholder="Upload one or more files">
			      </div>
			    </div>
	   		</form>
		</div>
	</div>
</div>

	<form:form name="post" modelAttribute="post" action="/write/postProcess" method="post" onsubmit="return postWriteCheck();">
	
		<div class="line"></div>
	<!-- 	<input type="hidden" name="mode" value="W" />
		<table summary="게시판 등록 폼">
		<div class="line"></div>	 -->

		<div class="second_page">
			<div class="left_page">
				<div class="left_page_img z-depth-1">
	 				<div class="file-field input-field second_page_uploader">
					      <div class="btn">
					       		 <span>File</span>
					       		 <input id="fileupload2" type="file" name="files[]" multiple>
					      </div>
					      <div class="file-path-wrapper">
					       		 <input class="file-path validate" type="text" placeholder="Upload one or more files">
					      </div>
				    </div>
			    </div>
				
				<div class="left_page_short_text">
					<textarea placeholder="가장 중요한 한 문장을 적어주세요"></textarea>
				</div>
			</div>
			<div class="right_page">
				
				<div class="text_form z-depth-1">
					<div class="writeArea">
						<form:textarea path="contents" cssClass="writeContents" cols="150" rows="30" />			
							<script>
							CKEDITOR.replace('contents',{
							filebrowserUploadUrl: '/imageUpload', 
							customConfig: '/resources/ckeditor/ckwriter.js',
						    skin:'minimalist',
						    width:'100%',
				            height:'500px',
				        	toolbar :
						        [
						            ['Styles', 'Format'],
						            ['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', '-',]
						        ]});
							</script>
					</div> 
				</div>
			</div>
		</div>


		<div class="third_page">

			<div class="image_area z-depth-2">
				<div class="thumb thumb1"></div>
				<div class="thumb thumb2"></div>
				<div class="thumb thumb3"></div>
				<div class="thumb thumb4"></div>
				<div class="thumb thumb5"></div>
				<div class="thumb thumb6"></div>
			</div>

				<div class="file-field input-field btn_field">
					      <div class="btn">
					       		 <span>File</span>
					       		 <input id="fileupload" type="file" name="files[]" multiple>
					      </div>
					      <div class="file-path-wrapper">
					       		 <input class="file-path validate" type="text" placeholder="추가로 6장의 사진을 업로드 하여 주세요">
					      </div>
				</div> 			
		</div>	
	</form:form>



<!-- 	<script type="text/javascript">
//<![CDATA[
CKEDITOR.replace( 'editor1',{
uiColor: '#14B8C4'
});
//]]> </script>-->


<!-- <script type="text/JavaScript">
 
      window.onload=function(){
            CKEDITOR.replace('contents',{enterMode:'2',shiftEnterMode:'3'});
      };
     
</script> -->
</body>
</html>