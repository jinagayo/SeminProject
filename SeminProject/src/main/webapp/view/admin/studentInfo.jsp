<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <title>학생 정보 조회</title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active  mx-5">  학적 정보 조회</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학적 정보 조회
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
       		<tr>
       			<th style="background-color: #2c3e50 !important;">이름</th>
       			<td>${user_std.name}</td>
       			<th style="background-color: #2c3e50 !important;">계열</th>
       			<td>자연대학</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">학번</th>
       			<td>${user_std.id}</td>
       			<th style="background-color: #2c3e50 !important;">전공</th>
       			<td>${std.major}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">생년월일</th>
       			<td>${user_std.birth}</td>
       			<th style="background-color: #2c3e50 !important;">학년</th>
       			<td>${std.grade}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">전화번호</th>
       			<td>${user_std.phone}</td>
       			<th style="background-color: #2c3e50 !important;">학점</th>
       			<td>${std.tograde}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">이메일</th>
       			<td>${user_std.email}</td>
       			<th style="background-color: #2c3e50 !important;">졸업 요건 충족</th>
       			<td>x</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">주소</th>
       			<td>${user_std.address}</td>
       		</tr>
    	</table>
    </div>
    <button onclick = "history.back()" class="btn btn-secondary" style="width:50px">←</button>
 </div>
  </body>
</html>>