<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" 
  	 integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
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
       			<th style="background-color: #2c3e50 !important;">학번</th>
       			<td>${list.studno}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">이름</th>
       			<td>${user.name}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">실습 일시</th>
       			<td>${list.day}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">활동명</th>
       			<td>${list.activename}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">활동 내역</th>
       			<td>${list.content}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">활동 소감</th>
       			<td>${list.emotion}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">증명서</th>
       			<td><a href="../upload/practice/${list.file1}">${list.file1}</a></td>
       		</tr>
       	</table>
       	&nbsp;&nbsp;&nbsp;
       	<form action="practiceaccept?studno=${list.studno }" method="post" accept-charset="UTF-8"  name="f">
	       	<div class="text-center">
	       	<input type="radio" name="accept" value="1" class="btn-check" id="success-outlined" autocomplete="off"/>
	       	<label class="btn btn-outline-success" for="success-outlined">&nbsp;승인&nbsp;</label>
	       	&nbsp;&nbsp;
	       	<input type="radio" name="accept" value="0" class="btn-check"  id="danger-outlined" autocomplete="off"/>
	       	<label class="btn btn-outline-danger" for="danger-outlined">&nbsp;반려&nbsp;</label>
	       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	       	<button type="submit" class="btn btn-primary" style=" text-align: center;width:150px">제출</button>
	       	</div> 
       	</form>
    	
    </div>
 </div>
 <button onclick = "history.back()" class="btn btn-secondary" style="width:50px">←</button>
  </body>
</html>>