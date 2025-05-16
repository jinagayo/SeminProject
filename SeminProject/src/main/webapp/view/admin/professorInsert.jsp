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
  <h2 class="breadcrumb-item active  mx-5">  교수 등록</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              교수 등록
     </div>
     <div class="card-body">
     <form action="professorInsert" name="f" method="post" accept-charset="UTF-8">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align:left;">
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">이름</th>
       			<td><input type="text" name="name" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">생년월일</th>
       			<td><input type="text" name="birth" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">	
       			<th style="background-color: #2c3e50 !important;">전화번호</th>
       			<td><input type="text" name="phone" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">주소</th>
       			<td><input type="text" name="address" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">이메일</th>
       			<td><input type="email" name="email" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">학과코드</th>
       			<td><input type="text" name="majorcode" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">담당과목</th>
       			<td><input type="text" name="subcode" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr>
       			<td colspan="2">
       				<button type="submit" class="btn btn-primary text-center">등록</button>
       			</td>
       		</tr>
    	</table>
    	
    	</form>
    	
    </div>
 </div>
  </body>
</html>>