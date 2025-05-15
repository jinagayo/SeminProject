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
  <h2 class="breadcrumb-item active">  교수 조회</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교수 조회
     </div>
     <form action="professorList" name="f" method="post" accept-charset="UTF-8">
	     <div class="card-body" style="position:relative;align-items:center;">
	     	<select id="select" name="select" style="position:absolute;align-items:center;left:30%">
	     		<option value="profno" selected>교수번호</option>
	     		<option value="major">전공</option>
	     		<option value="name">이름</option>
	     	</select>
	     	<input type="text" name="searchList" placeholder="(검색어입력)" style="position:absolute;left:38%;width:400px;">
	     	<button type="submit" id="searchbtn" class="btn btn-primary" style="position:absolute;left:64%;height:35px">검색</button>
	    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;margin-top:50px">
		       		<tr>
		       			<th>교수번호</th>
		       			<th>전공</th>
		       			<th>이름</th>
		       		</tr>
		       		
		       		<c:forEach var="row" items="${list}">
		       			<tr onclick="location.href='../admin/professorInfo?profno=${row.profno}'">	
		       				<td>${row.profno}</td>
		       				<td>${row.major}</td>
		       				<td>${row.name}</td>
		       			</tr>
		       		</c:forEach>
	    	</table>
	    </div>
    </form>
 </div>
  </body>
</html>
