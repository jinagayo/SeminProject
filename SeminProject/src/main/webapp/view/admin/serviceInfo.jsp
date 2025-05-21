<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
  	  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" 
  	 integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <title>교육 봉사</title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active  mx-5">  교육 봉사</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교육 봉사 조회
     </div>
     <div class="card-body">
     
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
       		<tr>
       			<th style="background-color: #2c3e50 !important;">학번</th>
       			<td>${user.id}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">이름</th>
       			<td>${user.name}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">봉사 일시</th>
       			<td>${service.day}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">봉사명</th>
       			<td>${service.servicename}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">봉사 단체명</th>
       			<td>${service.groupname}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">봉사 시간</th>
       			<td>${service.time}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">봉사 내용</th>
       			<td>${service.content}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">소감</th>
       			<td>${service.emotion}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">증명서</th>
       			<td><a href="../upload/service/${service.file1}">${service.file1}</a></td>
       		</tr>
    	</table>
       &nbsp;&nbsp;&nbsp;
		<form action="serviceaccept?studno=${service.studno }" method="post" accept-charset="UTF-8"  name="f" >
       		<div class="text-center">
       		<input type="radio" name="accept" value="1" class="btn-check" name="options-outlined" id="success-outlined" autocomplete="off"/>
	       	<label class="btn btn-outline-success" for="success-outlined">&nbsp;승인&nbsp;</label>
	       	&nbsp;&nbsp;
	       	<input type="radio" name="accept" value="0" class="btn-check" name="options-outlined" id="danger-outlined" autocomplete="off"/>
	       	<label class="btn btn-outline-danger" for="danger-outlined">&nbsp;반려&nbsp;</label>
	       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       		<input type="hidden" name="time" value="${service.time}"/>
			<button type="submit" class="btn btn-primary" style="width:150px;">제출</button>
			</div>
       	</form>
    </div>
 </div>
 <button onclick = "history.back()" class="btn btn-secondary" style="width:50px">←</button>
  </body>
</html>>