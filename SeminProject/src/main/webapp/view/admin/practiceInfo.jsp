<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <title>교육 실습 일지 </title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active">  교육 실습 일지</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교육 실습 일지
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
       		<tr>
       			<th>학번</th>
       			<td>${list.studno}</td>
       		</tr>
       		<tr>
       			<th>이름</th>
       			<td>${user.name}</td>
       		</tr>
       		<tr>
       			<th>실습 일시</th>
       			<td>${list.day}</td>
       		</tr>
       		<tr>
       			<th>활동명</th>
       			<td>${list.activename}</td>
       		</tr>
       		<tr>
       			<th>활동 내역</th>
       			<td>${list.content}</td>
       		</tr>
       		<tr>
       			<th>활동 소감</th>
       			<td>${list.emotion}</td>
       		</tr>
       		<tr>
       			<th>증명서</th>
       			<td><a href="../upload/practice/${list.file1}">${list.file1}</a></td>
       		</tr>
    	</table>
    </div>
 </div>
  </body>
</html>>