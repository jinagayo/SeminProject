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
  <h2 class="breadcrumb-item active  mx-5">  교육 봉사</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교육 봉사
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
       		<tr>
       			<th>학번</th>
       			<td>${list.studno}</td>
       		</tr>
       		<tr>
       			<th>이름</th>
       			<td>${list.name}</td>
       		</tr>
       		<tr>
       			<th>봉사 일시</th>
       			<td>${list.day}</td>
       		</tr>
       		<tr>
       			<th>봉사 시간</th>
       			<td>${list.service}</td>
       		</tr>
       		<tr>
       			<th>활동 이름</th>
       			<td>${list.active}</td>
       		</tr>
    	</table>
    	<button onclick = "history.back()" class="btn btn-secondary" style="width:50px">←</button>
    </div>
 </div>
  </body>
</html>>