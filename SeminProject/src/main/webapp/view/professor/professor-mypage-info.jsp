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
  <h2 class="breadcrumb-item active">  교수 정보 조회</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              DataTable Example
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" border="1">
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
  </body>
</html>>