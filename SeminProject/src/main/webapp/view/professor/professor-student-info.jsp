<%@page import="model.student.StudentDao"%>
<%@page import="model.student.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <title>학생 관리</title>
  </head>
  <body>
 
  <br>
  <h2 class="breadcrumb-item active  mx-5">  학생 관리</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학생 정보
     </div>
  
     <div class="card-body">
    	<table id="datatablesSimple" border="1">
       		<tr>
       			<th style="background-color: #2c3e50 !important;">이름</th>
       			<td>${user_s.name}</td>
       			<th style="background-color: #2c3e50 !important;">계열</th>
       			<td>자연대학</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">학번</th>
       			<td>${student.studno}</td>
       			<th style="background-color: #2c3e50 !important;">전공</th>

       			<td>${m.major}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">생년월일</th>
       			<td>${user_s.birth}</td>
       			<th style="background-color: #2c3e50 !important;">학년</th>
       			<td>${student.grade}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">전화번호</th>
       			<td>${user_s.phone}</td>
       			<th style="background-color: #2c3e50 !important;">학점</th>
       			<td>${student.tograde}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">이메일</th>
       			<td>${user_s.email}</td>
       			<th style="background-color: #2c3e50 !important;">졸업 요건 충족</th>
       			<td>${gradu.graduation}</td>
       		</tr>
       		<tr>
       			<th style="background-color: #2c3e50 !important;">주소</th>
       			<td>${user_s.address}</td>

       			<td  colspan="2"><a href="#" onclick="handleClick()">인성 및 적성 검사</a></td>
       		</tr>
    	</table>
    </div><button onclick = "history.back()" class="btn btn-secondary" style="width:50px">←</button>
 </div>    
 
 <script type="text/javascript">
 	function handleClick(){
 		const plist = [
 		    <c:forEach var="p" items="${plist}" varStatus="s">
 		      "${p.studno}"<c:if test="${!s.last}">,</c:if>
 		    </c:forEach>
 		  ];

 		  const currentStudno = "${student.studno}";
 		  
 		
 		let condition = false;

 	    for (let i = 0; i < plist.length; i++) {
 	      if (plist[i] === currentStudno) {
 	        condition = true;
 	        break;
 	      }
 	    }

 	    if (condition) {
 	    	window.open(
 	    			  "professor-Ckpersonality?studno="+${student.studno},  // 이동할 URL
 	    			  "popupWindow",              // 팝업창 이름
 	    			  "width=600,height=400,left=100,top=100" // 창 크기와 위치
 	    			);
 	    } else {
 	      alert("자가검사가 완료되지 않았습니다.");
 	    }
 	  }
 </script>
  </body>
</html>