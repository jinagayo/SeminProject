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
  <h2 class="breadcrumb-item active">  교육 실습 일지</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교육 실습 일지
     </div>
     <form action="studentList" name="f" method="post" accept-charset="UTF-8">
	     <div class="card-body" style="position:relative;align-items:center;">
	    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
		       		<tr>
		       			<th>학번</th>
		       			<th>이름</th>
		       			<th>날짜</th>
		       			<th>실습일지</th>
		       			<th>승인여부</th>
		       		</tr>
		       		<c:forEach var="row" items="${list}">
		       			<tr>
		       				<td>${row.studno}</td>
		       				<td>${row.name}</td>
		       				<td>${row.day}</td>
		       				<td><a class="nav-link">실습일지</a></td>
							<td>
								<c:choose>
							        <c:when test="${row.teacher eq true}">
						    			Y
						            </c:when>
						            <c:otherwise>
						                 N
						      		</c:otherwise>
								</c:choose>
							</td>
		       			</tr>
		       		</c:forEach>
	    	</table>
	    </div>
    </form>
 </div>
  </body>
</html>>