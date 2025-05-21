<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <title>학생 정보 조회</title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active  mx-5" style="padding:5px;">  학적 정보 조회</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학적 정보 조회
     </div>
     <form action="student-history" name="f" method="post" accept-charset="UTF-8">
	      <div class="card-body" style="height:700px; background-image: linear-gradient(rgba(255, 255, 255, 0.7), rgba(255, 255, 255, 0.7)),  url('../assets/img/logo1.png'); 
     	background-repeat: no-repeat;  background-position: center center;   display: flex;  gap: 10px;  padding: 40px 60px; " >
	    	<div style="flex: 0.4; min-width: 300px; text-align: center;">
     	 <img src="../picture/${user_std.img }"  style="width: 200px !important; height: 300px !important; object-fit: cover;" id="pic"><br>
         <font size="1"><a href="javascript:win_upload()">사진수정</a></font>
     	</div>
     	<div style="flex: 2;">
    	<table class="table table-borderless" style=" border-collapse: separate; border-spacing: 5px 40px;  border: none; font-size: 20px; " >
	       		<tr>
	       			<th style="color: black;">이름</th>
	       			<td>${user_std.name}</td>
	       			<th style="color: black;">계열</th>
	       			<td>자연대학</td>
	       		</tr>
	       		<tr>
	       			<th style="color: black;">학번</th>
	       			<td>${user_std.id}</td>
	       			<th style="color: black;">전공</th>
	       			<td>${std.major}</td>
	       		</tr>
	       		<tr>
	       			<th style="color: black;">생년월일</th>
	       			<td>${user_std.birth}</td>
	       			<th style="color: black;">학년</th>
	       			<td>${std.grade}</td>
	       		</tr>
	       		<tr>
	       			<th style="color: black;">전화번호</th>
	       			<td>${user_std.phone}</td>
	       			<th style="color: black;">학점</th>
	       			<td>${std.tograde}</td>
	       		</tr>
	       		<tr>
	       			<th style="color: black;">이메일</th>
	       			<td>${user_std.email}</td>
	       			<th style="color: black;">졸업 요건 충족</th>
	       			<td>x</td>
	       		</tr>
	       		<tr>
	       			<th style="color: black;">주소</th>
	       			<td>${user_std.address}</td>
	       			<td colspan="2">
	       				  <input type="hidden" name="studno" value="${user_std.id}">
						  <input type="submit" class= "btn btn-secondary" value="지난 성적 조회">
	       			</td>
	       		</tr>
	       		
	    	</table>
	    </div>
	    </div>
    </form>
 </div>
  </body>
</html>>