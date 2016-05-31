<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="/resources/ckeditor/samples/css/sample.css">
<script src="/resources/js/materialize.js"></script>

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

	<div class="main_photo_wrapper">
		<div class="defualt_message">메인 이미지를 업로드 해주세요</div>
		<div class="photo_uploader">
			<form action="#">
			    <div class="file-field input-field">
			      <div class="btn">
			        <span>File</span>
			        <input type="file" multiple>
			      </div>
			      <div class="file-path-wrapper">
			        <input class="file-path validate" type="text" placeholder="Upload one or more files">
			      </div>
			    </div>
	   		</form>
		</div>
	</div>

	<div class="header_text">
			<input type="text"  class="title" size="80" maxlength="100" placeholder="제목을 입력해주세요" autocomplete="off"/>
	</div>


	<form:form name="post" modelAttribute="post" action="/write/postProcess" method="post" onsubmit="return postWriteCheck();">
		<div class="buttons">
			<input type="button" value="목록" onclick="goUrl('/post');" />
			<input type="submit" value="저장하기" />
		</div>
		<div class="line"></div>
		<input type="hidden" name="mode" value="W" />
		<table summary="게시판 등록 폼">
		
	
		<div class="header">
			<form:input path="title" cssClass="title" size="80" maxlength="100" placeholder="제목을 입력해주세요" autocomplete="off"/>
		</div>

		<div class="line"></div>	

		<div class="writeArea">
			<form:textarea path="contents" cssClass="writeContents" cols="150" rows="30" />			
				<script>
				CKEDITOR.replace('contents',{
				filebrowserUploadUrl: '/imageUpload', 
				customConfig: '/resources/ckeditor/ckwriter.js',
			    skin:'minimalist',
			    width:'100%',
	            height:'500px',});
				</script>
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