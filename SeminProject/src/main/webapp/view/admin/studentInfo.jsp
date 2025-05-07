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
  <h2 class="breadcrumb-item active">  학적 정보 조회</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              DataTable Example
     </div>
     <div class="card-body">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: right;">
       		<tr>
       			<td></td>
       			<th>이름</th>
       			<td>${user_std.name}</td>
       			<th>계열</th>
       			<td>자연대학</td>
       		</tr>
       		<tr>
       			<td></td>
       			<th>학번</th>
       			<td>${user_std.id}</td>
       			<th>전공</th>
       			<td>${std.major}</td>
       		</tr>
       		<tr>
       			<td></td>
       			<th>생년월일</th>
       			<td>${user_std.birth}</td>
       			<th>학년</th>
       			<td>${std.grade}</td>
       		</tr>
       		<tr>
       			<td></td>
       			<th>전화번호</th>
       			<td>${user_std.phone}</td>
       			<th>학점</th>
       			<td>${std.tograde}</td>
       		</tr>
       		<tr>
       			<td></td>
       			<th>이메일</th>
       			<td>${user_std.email}</td>
       			<th>졸업 요건 충족</th>
       			<td>x</td>
       		</tr>
       		<tr>
       			<td></td>
       			<th>주소</th>
       			<td>${user_std.address}</td>
       		</tr>
    	</table>
    </div>
 </div>
  </body>
</html>>