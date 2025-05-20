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
  <h2 class="breadcrumb-item active  mx-5">  학적 정보 조회</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학적 정보 조회
     </div>
     <form action="student-history" name="f" method="post" accept-charset="UTF-8">
	     <div class="card-body">
	    	<table id="datatablesSimple" border="1">
	    		
	       		<tr>
	    			<td rowspan=7><img src="../picture/${user_std.img }" style="width:200px; height:300px; padding-left:0px"></td>
	       			<th style="background-color: #2c3e50 !important;">이름</th>
	       			<td>${user_std.name}</td>
	       			<th style="background-color: #2c3e50 !important;">계열</th>
	       			<td>자연대학</td>
	       		</tr>
	       		<tr>
	       			<th style="background-color: #2c3e50 !important;">학번</th>
	       			<td>${user_std.id}</td>
	       			<th style="background-color: #2c3e50 !important;">전공</th>
	       			<td>${std.major}</td>
	       		</tr>
	       		<tr>
	       			<th style="background-color: #2c3e50 !important;">생년월일</th>
	       			<td>${user_std.birth}</td>
	       			<th style="background-color: #2c3e50 !important;">학년</th>
	       			<td>${std.grade}</td>
	       		</tr>
	       		<tr>
	       			<th style="background-color: #2c3e50 !important;">전화번호</th>
	       			<td>${user_std.phone}</td>
	       			<th style="background-color: #2c3e50 !important;">학점</th>
	       			<td>${std.tograde}</td>
	       		</tr>
	       		<tr>
	       			<th style="background-color: #2c3e50 !important;">이메일</th>
	       			<td>${user_std.email}</td>
	       			<th style="background-color: #2c3e50 !important;">졸업 요건 충족</th>
	       			<td>x</td>
	       		</tr>
	       		<tr>
	       			<th style="background-color: #2c3e50 !important;">주소</th>
	       			<td  colspan="3">${user_std.address}</td>
	       		</tr>
	       		<tr>
	       			<td colspan="4">
	       				  <input type="hidden" name="studno" value="${user_std.id}">
						  <input type="submit" class= "btn btn-secondary" value="지난 성적 조회">
	       			</td>
	       		</tr>
	    	</table>
	    </div>
    </form>
 </div>
  </body>
</html>>