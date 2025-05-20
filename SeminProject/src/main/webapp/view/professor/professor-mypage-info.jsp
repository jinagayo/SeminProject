<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
   	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">

    <title>교수 정보 조회</title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active  mx-5" style="padding:5px;">  교수 정보 조회</h2>
  <div class="card mb-4 mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
             교수 정보 조회
     </div>
     <div class="card-body" style="height:700px; background-image: linear-gradient(rgba(255, 255, 255, 0.7), rgba(255, 255, 255, 0.7)),  url('../assets/img/logo1.png'); 
     	background-repeat: no-repeat;  background-position: center center;   display: flex;  gap: 10px;  padding: 40px 60px; " >
     	<div style="flex: 0.4; min-width: 300px; text-align: center;">
     	 <img src="../picture/${user_prof.img}"  style="width: 200px !important; height: 300px !important; object-fit: cover;" id="pic"><br>
         <font size="1"><a href="javascript:win_upload()">사진수정</a></font>
     	</div>
     	<div style="flex: 2;">
    	<table class="table table-borderless" style=" border-collapse: separate; border-spacing: 5px 40px;  border: none; font-size: 20px; " >
       		<tr>
       			<th>이름</th>
       			<td>${user_prof.name}</td>
       			<th>계열</th>
       			<td>자연대학</td>
       		</tr>
       		<tr>
       			<th>교수번호</th>
       			<td>${user_prof.id}</td>
       			<th>소속학과</th>
       			<td>${prof.major}</td>
       		</tr>
       		<tr>
       			<th>생년월일</th>
       			<td>${user_prof.birth}</td>
       		</tr>
       		<tr>
       			<th>전화번호</th>
       			<td>${user_prof.phone}</td>
       		</tr>
       		<tr>
       			<th>이메일</th>
       			<td>${user_prof.email}</td>
       		</tr>
       		<tr>
       			<th>주소</th>
       			<td>${user_prof.address}</td>
       		</tr>
    	</table>
    	</div>
    </div>
 </div>
 
 <script type="text/javascript">
 function win_upload(){
	   var op = "width=500,height=400,left=50, top=150";
	   open("pictureForm","",op);
 }
 </script>
  </body>
</html>>