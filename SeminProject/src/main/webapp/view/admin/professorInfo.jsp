<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <title>교수 정보 조회</title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active  mx-5">  정보 조회</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              정보 조회 
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
       		<tr>
       			<th>이름</th>
       			<td>${user_pro.name}</td>
       		</tr>
       		<tr>	
       			<th>생년월일</th>
       			<td>${user_pro.birth}</td>
       		</tr>
       		<tr>	
       			<th>전화번호</th>
       			<td>${user_pro.phone}</td>
       		</tr>
       		<tr>	
       			<th>주소</th>
       			<td>${user_pro.address}</td>
       		</tr>
       		<tr>	
       			<th>이메일</th>
       			<td>${user_pro.email}</td>
       		</tr>
       		<tr>	
       			<th>교수번호</th>
       			<td>${user_pro.id}</td>
       		</tr>
       		<tr>	
       			<th>학과코드</th>
       			<td>${pro.major}</td>
       		</tr>
    	</table>
    	<button onclick = "history.back()" class="btn btn-secondary" style="width:50px">←</button>
    </div>
 </div>
  </body>
</html>>