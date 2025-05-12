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
  <h2 class="breadcrumb-item active">  교수 등록</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              DataTable Example
     </div>
     <div class="card-body">
     <form action="professorInsert" name="f" method="post" accept-charset="UTF-8">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align:left;">
       		<tr>
       			<th>이름</th>
       			<td><input type="text" name="name"></td>
       		</tr>
       		<tr>
       			<th>생년월일</th>
       			<td><input type="text" name="birth"></td>
       		</tr>
       		<tr>	
       			<th>전화번호</th>
       			<td><input type="text" name="phone"></td>
       		</tr>
       		<tr>
       			<th>주소</th>
       			<td><input type="text" name="address"></td>
       		</tr>
       		<tr>
       			<th>이메일</th>
       			<td><input type="email" name="email"></td>
       		</tr>
       		<tr>
       			<th>학과코드</th>
       			<td><input type="text" name="majorcode"></td>
       		</tr>
       		<tr>
       			<th>담당과목</th>
       			<td><input type="text" name="subcode"></td>
       		</tr>
    	</table>
    	<button type="submit" onclick="chk()">등록</button>
    	</form>
    	
    </div>
 </div>
  </body>
</html>>