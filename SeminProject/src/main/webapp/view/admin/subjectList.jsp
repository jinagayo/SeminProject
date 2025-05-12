<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <title>강의 조회</title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active">  전체 강의 조회</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              DataTable Example
     </div>
     <form action="subjectList" name="f" method="post" accept-charset="UTF-8">
	     <div class="card-body">
	     	<select id="select" name="select">
	     		<option value="subname">강의 명</option>
	     		<option value="name">강사 이름</option>
	     	</select>
	     	<input type="text" name="searchList" placeholder="(검색어입력)">
	     	<button type="submit" id="searchbtn">검색</button>
	    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;">
					<tr>
		       			<th>강의명</th>
		       			<th>강의시간</th>
		       			<th>학점</th>
		       			<th>교수</th>
		       			<th>교직이수</th>
		       		</tr>   		
		       		<c:forEach var="row" items="${list}">
		       			<tr>	
		       				<td>${row.subname}</td>
		       				<td>${row.starttime} : 00 ~ ${row.starttime + row.time} : 00 </td>
		       				<td>${row.time}</td>
		       				<td>${row.name}</td>
							<td>
					            <c:choose>
					                <c:when test="${row.teachsub eq true}">
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
</html>