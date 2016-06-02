<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%-- <%@ include file="/include/tags.jspf"%> --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Travel DB</title>
<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css'>
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/resources/css/postBook.css">
<link rel="stylesheet" type="text/css" href="/resources/css/materialize.css">
 <script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="/resources/js/postBook.js"></script>
</head>
<body>

<%
    Object userId = session.getAttribute("userId");
%>



  <nav class="header">
    <div class="nav-wrapper blue lighten-3">
<!--        <a href="#" class="brand-logo">${sessionScope.user.name}</a>  -->
      <ul id="nav-mobile" class="right hide-on-med-and-down">

        <li><a href="/post"><i class="material-icons">store</i></a></li>
        <li><a href="/postBook"><i class="material-icons">library_books</i></a></li>
        <li><a href="/write/new"><i class="material-icons">mode_edit</i></a></li>
      </ul>
    </div>
  </nav>
        
  <div class="postBook_wrapper">

    <ul class="postBook">
        <c:forEach items="${posts}" var="each">
          <li class="post"><a href="/write/postBook/${each.postId}">
            <div class="card small">
                <div class="card-image">
                  <img src="http://localhost:8080/images/upload/${each.first_page_image_url}">
                  <span class="card-title">${each.title}</span>
                </div>
                <div class="card-content">
                  <p>${each.writer}</p></br>
                   <span class="time"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${each.createdDate}" /></span>
                  <span class="point">${each.countOfComment}</span>
                 
                </div>
                <div class="card-action">
              <!--     <a href="#">This is a link</a> -->
            </div>
          </a></li>
        </c:forEach>
  

      </ul>
  </div>







<script src="/resources/js/postBook.js"></script>
<script src="/resources/js/materialize.js"></script>
</body>
</html>