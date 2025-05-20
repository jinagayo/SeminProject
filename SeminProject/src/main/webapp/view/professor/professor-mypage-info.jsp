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
  <h2 class="breadcrumb-item active  mx-5">  교수 정보 조회</h2>
  <div class="card mb-4 mx-5">

     <div class="card-header">
         <i class="fas fa-table me-1"></i>
             교수 정보 조회
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" >
       		<tr>
       			<th style="background-color: #2c3e50 !important;">이름</th>
       			<td>${user_prof.name}</td>
       			<th style="background-color: #2c3e50 !important;">계열</th>
       			<td>자연대학</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">교수번호</th>
       			<td>${user_prof.id}</td>
       			<th style="background-color: #2c3e50 !important;">소속학과</th>
       			<td>${prof.major}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">생년월일</th>
       			<td>${user_prof.birth}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">전화번호</th>
       			<td>${user_prof.phone}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">이메일</th>
       			<td>${user_prof.email}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">주소</th>
       			<td>${user_prof.address}</td>
       		</tr>
    	</table>
    </div>
 </div>
  </body>
</html>>