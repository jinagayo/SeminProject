<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 관리</title>
</head>
<body>
<br>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학생관리
     </div>
     <div class="card-body">
       <table id="datatablesSimple" border="1">
         <tr>
            <th>학번</th><th>이름</th>
         </tr>
   
	  <c:forEach var="s" items="${studentList}" varStatus="vs">
	    	<tr> 
	    	<td>${s.studno}</td>
	    		<c:forEach var="u" items="${user}" varStatus="vs">
	    				<c:if test="${s.studno == u.id }">
	    					<td>
	    						<form>
	    							${u.name}
	    						</form>
	    					</td>
	    				</c:if>
	    		</c:forEach>
	        </tr>
	  </c:forEach>
      </table>
   </div>
 </div>
</body>
</html>