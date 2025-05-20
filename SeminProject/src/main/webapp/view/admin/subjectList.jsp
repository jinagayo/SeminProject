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
  <h2 class="breadcrumb-item active mx-5">  전체 강의 조회</h2>
  <div class="card mb-4 mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              전체 강의 조회
     </div>
     <form action="subjectList" name="sf" method="post" accept-charset="UTF-8">
	        <c:if test="${empty pageNum}">
			  	<c:set var="pageNum" value="1"/>
			</c:if>
     		<input type="hidden" name="pageNum" id="pageNum" value="${pageNum}">
	     <div class="card-body" style="position:relative;align-items:center;">
	     	<select id="select" name="select" style="position:absolute;align-items:center;left:28%;width:150px" class="form-select form-select-m mb-3">
	     		<option value="subname">강의 명</option>
	     		<option value="name">강사 이름</option>
	     	</select>
	     	<div class="container-fluid">
	     		<input type="text" name="searchList" placeholder="(검색어입력)"  style="position:absolute;left:38%;width:400px;" class="form-control me-2">
	     		<button type="submit" id="searchbtn" class="btn btn-outline-success" style="position:absolute;left:64%;height:35px">검색</button>
	    	</div>
	    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;margin-top:50px">
					<tr>
		       			<th style="background-color: #2c3e50 !important;">강의명</th>
		       			<th style="background-color: #2c3e50 !important;">강의시간</th>
		       			<th style="background-color: #2c3e50 !important;">학점</th>
		       			<th style="background-color: #2c3e50 !important;">교수</th>
		       			<th style="background-color: #2c3e50 !important;">교직이수</th>
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
  		<div aria-label="Page navigation example" class="d-flex justify-content-center sticky-bottom">
  			<ul class="pagination sticky-xl-bottom">
				<c:if test="${pageNum > 1}">
				    <li class="page-item">
				    	<a href="javascript:listsubmit(${pageNum-1})" class="page-link" aria-label="Previous">
				    		<span aria-hidden="true">&laquo;</span>
				    	</a>
				    </li>
				</c:if>
				<c:if test="${pageNum <= 1}">
				   	<li class="page-item">
				   		<a class="page-link" href="#" aria-label="Previous">
				    		<span aria-hidden="true">&laquo;</span>
				    	</a>
				    </li>
				</c:if>
				
				<c:forEach var="a" begin="${startpage}" end="${endpage}">
				    <c:if test="${a == pageNum}">
				    	<li class="page-item"><a class="page-link">${a}</a></li>
				    </c:if>
				    <c:if test="${a != pageNum}">
				        <li class="page-item"><a href="javascript:listsubmit(${a})" class="page-link">${a}</a></li>
				    </c:if>
				</c:forEach>
				
				<c:if test="${pageNum < maxpage}">
				    <li class="page-item">
				    	<a href="javascript:listsubmit(${pageNum+1})" class="page-link" aria-label="Next">
				    		<span aria-hidden="true">&raquo;</span>
				    	</a>
				    </li>
				</c:if>
				<c:if test="${pageNum >= maxpage}">
				   	<li class="page-item">
				   		<a class="page-link" href="#" aria-label="Next">
				    		<span aria-hidden="true">&raquo;</span>
				    	</a>	
				    </li>
				</c:if>
			</ul>
		</div>
	<script type="text/javascript">
	    function listsubmit(page) {
	        document.getElementById("pageNum").value = page;
	        document.sf.submit();
	    }
	</script>
  </body>
</html>