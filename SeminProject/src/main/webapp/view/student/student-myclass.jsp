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
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              내 강의실
     </div>
     <div style="display: flex;align-items: center;justify-content: space-between;flex-direction: column;">
		<c:forEach var="row" items="${list}">
		        <div style="display: flex; align-items: center; justify-content: space-between; border: 1px solid #ccc;margin-left: 50px; padding: 10px; margin-bottom: 10px;width:1600px">
		            <div style="flex: 2;">${row.subname} (${row.subcode})</div>
		            <div style="flex: 3; display: flex; justify-content: space-around;">
		                <div><strong>${row.week}</strong><br>출결</div>
		                <div><strong>0</strong><br>공지</div>
		            </div>
		            <div style="flex: 1; text-align: right;">
		                <button onclick="location.href='student-subject-board?subcode=${row.subcode}&boardid=1'" class="btn btn-secondary">공지사항</button>
		                <button onclick="location.href='student-subject-board?subcode=${row.subcode}&boardid=2'" class="btn btn-secondary"> Q&A  </button>
		                <button onclick="location.href='student-subject-task?subcode=${row.subcode}'" class="btn btn-secondary">  과제제출 </button>
		            </div>
		        </div>
		    </c:forEach>
    </div>
    </div>
  </body>
</html>