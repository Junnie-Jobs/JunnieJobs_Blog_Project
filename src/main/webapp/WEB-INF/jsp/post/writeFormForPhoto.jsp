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
<link rel="stylesheet" href="/resources/ckeditor/samples/css/sample.css">
<script src="/resources/js/materialize.js"></script>
<style type="text/css">
	* {
	
	font-size: 9pt;
	}
	
	body{
	
	
	}
	.buttons {
	
	width: 200px; 
	height: 50px;
	text-align: right;
	float: right;
	margin-right:20px;
	margin-top: 10px;
		
	}
	
	.buttons input {
		
		width:66px;
		height: 30px;
		line-height: 25px;
		background-color:rgba(255,255,255,0);
		border-radius:15px;
		transition-duration: 0.5s;
		transition-timing-function: ease;
		margin-left:5px;
		margin-right:5px;
		border:1px solid;
		border-color:rgba(0,0,0,0.2);
		color:rgba(0,0,0,0.5);
	
	}
	
	.buttons input:hover {
		
		outline:none;
		background-color:rgba(0,0,0,0.1);
	
	}
		
	.header{	
		width:80%;
		height:100px;
		margin:10px auto 0 auto;

		
	}
	
	.header input{
	
		font-size:30px;
		border-top:none;
		border-left:none;
		border-right:none;
		border-bottom:1px dotted;
		border-bottom-color:rgba(0,0,0,0.5);
		width:100%;
		line-height:100px;
		
	}
	
	.header input:focus, .writer input:focus{
	
		outline:none;
		autocomplete:off;
	}
	
	
	.writer{
	
		width:20%;
		margin-left:10%;
		width:140px;
		hieght:50px;
		margin-top:20px;

	}
	
	.writer input{
	
		border:none;
		height:40px;
		border-top:none;
		border-left:none;
		border-right:none;
		border-bottom:1px dotted;
		border-bottom-color:rgba(0,0,0,0.3);
		background-color:rgba(255,255,255,0);
		
	
	}
	
	.line{
	
	clear:both;
	height:1px;
	}
	
	
	.writeArea{
	
		width:80%;
		height:300px;
		margin:30px auto 0 auto;
	
	}
	
	textarea{
	
	clear:both;
	width:80%;
	
	}
</style>

</head>
<body>

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

	<!-- <form:form name="post" modelAttribute="post" action="/write/postProcess" method="post" onsubmit="return postWriteCheck();">
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
   </form> -->

</body>
</html>