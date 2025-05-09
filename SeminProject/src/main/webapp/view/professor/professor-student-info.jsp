<%@page import="model.student.StudentDao"%>
<%@page import="model.student.Student"%>
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
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학생정보
     </div>
  
     <div class="card-body">
    	<table id="datatablesSimple" border="1">
       		<tr>
       			<th>이름</th>
       			<td>${user_s.name}</td>
       			<th>계열</th>
       			<td>자연대학</td>
       		</tr>
       		<tr>
       			<th>학번</th>
       			<td>${student.studno}</td>
       			<th>전공</th>
       			<td>m.major</td>
       		</tr>
       		<tr>
       			<th>생년월일</th>
       			<td>${user_s.birth}</td>
       			<th>학년</th>
       			<td>${student.grade}</td>
       		</tr>
       		<tr>
       			<th>전화번호</th>
       			<td>${user_s.phone}</td>
       			<th>학점</th>
       			<td>${student.tograde}</td>
       		</tr>
       		<tr>
       			<th>이메일</th>
       			<td>${user_s.email}</td>
       			<th>졸업 요건 충족</th>
       			<td>${gradu.graduation}</td>
       		</tr>
       		<tr>
       			<th>주소</th>
       			<td>${user_s.address}</td>
       		</tr>
    	</table>
    </div>
 </div>
  </body>
</html>>