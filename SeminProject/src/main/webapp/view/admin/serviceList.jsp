<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
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
     <form action="studentList" name="f" method="post" accept-charset="UTF-8">
	     <div class="card-body">
	    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
		       		<tr>
		       			<th>학번</th>
		       			<th>이름</th>
		       			<th>날짜</th>
		       			<th>봉사시간</th>
		       		</tr>
		       		<c:forEach var="row" items="${list}">
		       			<tr onclick="location.href='../admin/serviceInfo?studno=${row.studno}'">
		       				<td>${row.studno}</td>
		       				<td>${row.name}</td>
		       				<td>${row.day}</td>
		       				<td>${row.time}</td>
		       			</tr>
		       		</c:forEach>
	    	</table>
	    </div>
    </form>
 </div>
  </body>
</html>>