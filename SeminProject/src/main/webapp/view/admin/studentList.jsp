<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	table {
	    width: 700px;
	    text-align: center;
	    border: 1px solid #fff;
	    border-spacing: 1px;
	    font-family: 'Cairo', sans-serif;
	  margin: auto;
	}

	caption {
	    font-weight: bold;
	}
	
	table td {
	    padding: 10px;
	    background-color: #eee;
	}
	
	table th {
	    background-color: #333;
	    color: #fff;
	    padding: 10px;
	}
	
	img {
	    width: 90px;
	    height: 90px;
	}
	
	.view,
	.delete {
	    border: none;
	    padding: 5px 10px;
	    color: #fff;
	    font-weight: bold;
	}
	
	.view {
	    background-color: #03A9F4;
	}
	
	.delete {
	    background-color: #E91E63;
	}
	
	.tablefoot {
	    padding: 0;
	    border-bottom: 3px solid #009688;
	}
</style>
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
	     	<select id="select" name="select">
	     		<option value="studno" selected>학번</option>
	     		<option value="major">전공</option>
	     		<option value="name">이름</option>
	     	</select>
	     	<input type="text" name="searchList" placeholder="(검색어입력)">
	     	<button type="submit" id="searchbtn">검색</button>
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