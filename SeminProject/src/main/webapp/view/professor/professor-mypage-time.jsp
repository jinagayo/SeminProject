<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


  <br>
  <div class="card mb-4 mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              내 시간표 조회
     </div>
     <div class="card-body">
       <table id="datatablesSimple" border="1">
         <tr>
            <th style="background-color: #2c3e50 !important;"></th><th style="background-color: #2c3e50 !important;">월</th><th style="background-color: #2c3e50 !important;">화</th>
            <th style="background-color: #2c3e50 !important;">수</th><th style="background-color: #2c3e50 !important;">목</th><th style="background-color: #2c3e50 !important;">금</th>
         </tr>
         <c:forEach var="t" items="${time}">
		    <tr>
		        <c:out value="${t}" escapeXml="false"/>
		    </tr>
		</c:forEach>
      </table>
   </div>
 </div>
 

</body>
</html>