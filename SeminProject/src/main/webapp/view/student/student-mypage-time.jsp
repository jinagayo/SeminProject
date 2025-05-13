<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  
    
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>내 시간표 조회</title>
</head>
<body>


  <br>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              내 시간표 조회
     </div>
     <div class="card-body">
       <table id="datatablesSimple" border="1">
         <tr>
            <th></th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th>
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