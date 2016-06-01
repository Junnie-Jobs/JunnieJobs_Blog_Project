<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
<title>Post</title>
<head>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/writeForm.css">
<link rel="stylesheet" type="text/css" href="/resources/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/resources/css/materialize.css">
<script src="/resources/js/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script> 
<script src="/resources/js/jquery.fileupload.js"></script>
<script src="/resources/js/writeForm.js"></script>
<script src="/resources/js/materialize.js"></script>

<script>
    $(function(){
         
        CKEDITOR.replace( 'second_page_long_text', {//해당 이름으로 된 textarea에 에디터를 적용
           customConfig: '/resources/ckeditor/ckwriter.js',
							    skin:'minimalist',
							    width:'100%',
					            height:'500px',
					        	toolbar :
							        [
							            ['Styles', 'Format'],
							            ['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', '-',]
							        ]});

         
         
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

<form name="post" action="/write/postProcess" method="post">

<div class="buttons">
	<button onclick="goUrl('/post');" value="목록">목록</button>
	<button type="submit" value="저장">저장</button>
</div>

<div class="first_page">
	<div class="main_photo_wrapper">
		<div class="defualt_message">메인 이미지를 업로드 해주세요</div>
		<div class="header_text">
			<input name="title" class="title" size="80" maxlength="100" placeholder="제목을 입력해주세요" autocomplete="off" />
			<input name="first_page_image_url" type="hidden" />
		</div>
		<div class="photo_uploader main_cover_uploader">
			    <div class="file-field input-field">
				      <div class="btn grey lighten-5">
				        <span>File</span>
				        <input type="file" id="fileupload" name="files[]">
				      </div>
				      <div class="file-path-wrapper">
				        <input class="file-path validate" type="text">
				      </div>
    			</div>
		</div>
	</div>
</div>
	
		<div class="line"></div>


		<div class="second_page">
			<div class="left_page">
				<div class="left_page_img z-depth-2">
					<div class="empty_block"></div> 
		 				<div class="file-field input-field btn_field second_page_uploader">
						      <div class="btn grey lighten-5">
						       		 <span>File</span>
						       		 <input id="fileupload2" type="file" name="files[]" />
						       		 <input name="second_page_image_url" type="hidden" />
						      </div>
						       <div class="file-path-wrapper">
						       		 <input id="file-path validate" type="text" placeholder="중요한 사진 1장만 업로" />
						      </div>  
						
					</div>		
			    </div>
				
				<div class="left_page_short_text">
					<textarea name="second_page_short_text" placeholder="가장 중요한 한 문장을 적어주세요"></textarea>
				</div>
			</div>
			<div class="right_page">
				
				<div class="text_form z-depth-1">
					<div class="writeArea">
						<textarea name="second_page_long_text" class="writeContents" cols="150" rows="30" />			
							
					
				
							</textarea>
		
					</div> 
				</div>
			</div>
		</div>


		<div class="third_page">

			<div class="image_area z-depth-2">
				<div class="thumb thumb1"></div>
				<input name="third_page_thumb1_image_url" type="hidden" />
				<div class="thumb thumb2"></div>
				<input name="third_page_thumb2_image_url" type="hidden" />
				<div class="thumb thumb3"></div>
				<input name="third_page_thumb3_image_url" type="hidden" />
				<div class="thumb thumb4"></div>
				<input name="third_page_thumb4_image_url" type="hidden" />
				<div class="thumb thumb5"></div>
				<input name="third_page_thumb5_image_url" type="hidden" />
				<div class="thumb thumb6"></div>
				<input name="third_page_thumb6_image_url" type="hidden" />
			</div>

				<div class="file-field input-field btn_field third_page_uploader">
					      <div class="btn grey lighten-5">
					       		 <span>File</span>
					       		 <input id="fileupload3" type="file" name="files[]" multiple />
					      </div>
					      <div class="file-path-wrapper">
					       		<input class="file-path validate" type="text" placeholder="추가로 6장의 사진을 업로드 하여 주세요" />
					      </div>
				</div> 			
		</div>	
	</form>
</body>
</html>