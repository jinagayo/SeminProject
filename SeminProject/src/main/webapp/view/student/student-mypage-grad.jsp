<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <title>졸업 사정표</title>
  </head>
  <body>

  <br>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              졸업 사정표
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" border="1">
       		<tr>
       			<th></th>
       			<th>기준값</th>
       			<th>계산값</th>
       			<th>결과</th>
       		</tr>
       		<tr>
       			<th>졸업학점</th>
       			<td>130</td>
       			<td>${grad.comcredit}</td>
       			<c:if test="${grad.comcredit >= 130}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${grad.comcredit < 130}">
       				<td>N</td>
				</c:if>
       		</tr>
       		
       		<tr>
       			<th>교직이수 학점</th>
       			<td>30</td>
       			<td>${grad.teachcredit}</td>
       			<c:if test="${grad.teachcredit >= 30}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${grad.teachcredit < 30}">
       				<td>N</td>
				</c:if>
       		</tr>
       		<tr>
       			<th>실습 여부</th>
       			<td>Y</td>
       			<c:if test="${teach.practice == true}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${teach.practice == false}">
       				<td>N</td>
				</c:if>
       			<c:if test="${teach.practice == true}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${teach.practice == false}">
       				<td>N</td>
				</c:if>  
       		</tr>
       		
       		<tr>
       			<th>봉사활동</th>
       			<td>8</td>
       			<td>${teach.service}</td>
       			<c:if test="${teach.service >= 8}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${teach.service < 8}">
       				<td>N</td>
				</c:if>
       		</tr>
       		
       		<tr>
       			<th>교원 자격 취득</th>
       			<td>Y</td>
       			<c:if test="${teach.teacherYN == true}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${teach.teacherYN == false}">
       				<td>N</td>
				</c:if>
       			<c:if test="${teach.teacherYN == true}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${teach.teacherYN == false}">
       				<td>N</td>
				</c:if>  
       		</tr>
       		<tr>
       			<th>졸업 사정 결과</th>
       			<td></td>
       			<td></td>
       			<c:if test="${grad.graduation == true}">
       				<td>Y</td>
				</c:if>
       			<c:if test="${grad.graduation == false}">
       				<td>N</td>
				</c:if>  
       			
       		</tr>
    	</table>
    </div>
 </div>

  </body>
</html>>