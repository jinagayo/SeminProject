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
  <h2 class="breadcrumb-item active">  학생 조회</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              DataTable Example
     </div>
     <form action="studentList" name="f" method="post" accept-charset="UTF-8">
	     <div class="card-body">
	     	<select id="select" name="select" class="select">
	     		<option value="studno" selected>학번</option>
	     		<option value="major">전공</option>
	     		<option value="name">이름</option>
	     	</select>
	     	<input type="text" name="searchList" class="searchList" placeholder="(검색어입력)">
	     	<button type="submit" id="searchbtn" class="searchbtn" style>검색</button>
	    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
		       		<tr>
		       			<th>학번</th>
		       			<th>전공</th>
		       			<th>이름</th>
		       		</tr>
		       		
		       		<c:forEach var="row" items="${list}">
		       			<tr onclick="location.href='../admin/studentInfo?studno=${row.studno}'">	
		       				<td>${row.studno}</td>
		       				<td>${row.major}</td>
		       				<td>${row.name}</td>
		       			</tr>
		       		</c:forEach>
	    	</table>
	    </div>
    </form>
 </div>
  </body>
</html>>