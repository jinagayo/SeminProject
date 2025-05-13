<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내강의실</title>
</head>
<body>
<br>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              내강의실
     </div>
     <div class="card-body">
       <table id="datatablesSimple" border="1" style="border-collapse: collapse;">
	  <c:forEach var="s" items="${sublist}" varStatus="vs">
	    	<tr> 
	    	<td style="border-top: 1px solid #ccc; border-bottom: 1px solid #ccc; border-left: none; border-right: none; padding: 8px;">${s.subname} (${s.subcode})  </td>
	    	<td style="border-top: 1px solid #ccc; border-bottom: 1px solid #ccc; border-left: none; border-right: none; padding: 8px;"> Q&A </td>
	    	<td style="border-top: 1px solid #ccc; border-bottom: 1px solid #ccc; border-left: none; border-right: none; padding: 8px;"><button onclick="location.href='professor-classHome?subcode=${s.subcode}'">강의홈 바로가기</button></td>
	      </tr>
	  </c:forEach>
      </table>
   </div>
 </div>
</body>
</html>
