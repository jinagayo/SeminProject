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
  <h2 class="breadcrumb-item active  mx-5">  과목명</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              공지사항
     </div>
     <div style="display: flex;align-items: center;justify-content: space-between;flex-direction: column;">
		
       					<form action="student-subject-board" method="get">
			                <input type="hidden" name="subcode" value="${param.code}">
			                <input type="hidden" name="boardid" value="1">
			                <button type="submit" class="btn btn-primary text-right">전체보기</button>
			        	</form>
     </div>
   </div>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              Q&A
     </div>
     <div style="display: flex;align-items: center;justify-content: space-between;flex-direction: column;">
       					<form action="student-subject-board" method="get">
			                <input type="hidden" name="subcode" value="${param.code}">
			                <input type="hidden" name="boardid" value="2">
			                <button type="submit" class="btn btn-primary text-right">전체보기</button>
			        	</form>
		
     </div>
   </div>
  </body>
</html>