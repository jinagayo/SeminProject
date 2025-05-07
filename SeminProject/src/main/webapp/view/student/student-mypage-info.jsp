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
  <h2 class="breadcrumb-item active">  학적 정보 조회</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              DataTable Example
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" border="1">
       		<tr>
       			<th>이름</th>
       			<td>${user_std.name}</td>
       			<th>계열</th>
       			<td>자연대학</td>
       		</tr>
       		<tr>
       			<th>학번</th>
       			<td>${user_std.id}</td>
       			<th>전공</th>
       			<td>${std.major}</td>
       		</tr>
       		<tr>
       			<th>생년월일</th>
       			<td>${user_std.birth}</td>
       			<th>학년</th>
       			<td>${std.grade}</td>
       		</tr>
       		<tr>
       			<th>전화번호</th>
       			<td>${user_std.phone}</td>
       			<th>학점</th>
       			<td>${std.tograde}</td>
       		</tr>
       		<tr>
       			<th>이메일</th>
       			<td>${user_std.email}</td>
       			<th>졸업 요건 충족</th>
       			<td>x</td>
       		</tr>
       		<tr>
       			<th>주소</th>
       			<td>${user_std.address}</td>
       		</tr>
    	</table>
    </div>
 </div>
  </body>
</html>>