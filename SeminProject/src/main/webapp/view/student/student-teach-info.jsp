<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>교원 자격 취득 조건 조회</title>
</head>
<body>
<br>
<h2 class="breadcrumb-item active  mx-5">  교원 자격 취득 조회</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교원 자격 취득 조회
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" border="1">
    		<tr>
       			<th style="background-color: #2c3e50 !important;"></th>
       			<th style="background-color: #2c3e50 !important;">기준값</th>
       			<th style="background-color: #2c3e50 !important;">계산값</th>
       			<th style="background-color: #2c3e50 !important;">결과</th>
    		</tr>
    		<tr>
    			<th style="background-color: #2c3e50 !important;">교육 실습 일지</th>
    			<td></td>
    			<td></td>
       			<c:if test="${teacher.practice == true}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${teacher.practice == false}">
       				<td>N</td>
				</c:if>  
    		</tr>
    		<tr>
    			<th style="background-color: #2c3e50 !important;">적성 검사</th>
    			<td></td>
    			<td></td>
       			<c:if test="${teacher.personsubmit == true}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${teacher.personsubmit == false}">
       				<td>N</td>
				</c:if>  
    		</tr>
    		<tr>
    			<th style="background-color: #2c3e50 !important;">교육봉사</th>
    			<td>8</td>
    			<td>${teacher.service}</td>
       			<c:if test="${teacher.service >= 8}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${teacher.service < 8}">
       				<td>N</td>
				</c:if>
    		</tr>
    		<tr>
    			<th style="background-color: #2c3e50 !important;">교원 자격 취득</th>
    			<td></td>
    			<td></td>
       			<c:if test="${teacher.teacherYN == true}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${teacher.teacherYN == false}">
       				<td>N</td>
				</c:if>  
    		</tr>
    	</table>
    	
     </div>
 </div>

</body>
</html>