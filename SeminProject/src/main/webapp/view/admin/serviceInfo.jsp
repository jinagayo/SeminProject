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
  <h2 class="breadcrumb-item active">  교육 봉사</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교육 봉사
     </div>
     <div class="card-body">
     
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
       		<tr>
       			<th>학번</th>
       			<td>${user.id}</td>
       		</tr>
       		<tr>
       			<th>이름</th>
       			<td>${user.name}</td>
       		</tr>
       		<tr>
       			<th>봉사 일시</th>
       			<td>${service.day}</td>
       		</tr>
       		<tr>
       			<th>봉사명</th>
       			<td>${service.servicename}</td>
       		</tr>
       		<tr>
       			<th>봉사 단체명</th>
       			<td>${service.groupname}</td>
       		</tr>
       		<tr>
       			<th>봉사 시간</th>
       			<td>${service.time}</td>
       		</tr>
       		<tr>
       			<th>봉사 내용</th>
       			<td>${service.content}</td>
       		</tr>
       		<tr>
       			<th>소감</th>
       			<td>${service.emotion}</td>
       		</tr>
       		<tr>
       			<th>증명서</th>
       			<td><a href="../upload/service/${service.file1}">${service.file1}</a></td>
       		</tr>
    	</table>
       	<form action="serviceaccept?studno=${service.studno }" method="post" accept-charset="UTF-8"  name="f" >
       		<table>
	       		<tr>
	       			<td colspan=2>
	       				<input type="radio" name="accept" value="1"/>승인
	       				<input type="radio" name="accept" value="0"/>반려
	       			</td>
	       		</tr>
	       		<tr>
				    <td class="text-center">
       				<input type="hidden" name="time" value="${service.time}"/>
				      <button type="submit" class="btn btn-secondary">제출</button>
				    </td>
	       		</tr>
       		</table>
       	</form>
    	<button onclick = "history.back()" class="btn btn-secondary" style="width:50px">←</button>
    </div>
 </div>
  </body>
</html>>