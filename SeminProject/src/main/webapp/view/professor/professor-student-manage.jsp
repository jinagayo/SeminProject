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
  <h2 class="breadcrumb-item active  mx-5" style="padding:5px;">  학생 관리</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학생 목록
     </div>
     <form name="sf" method="post" accept-charset="UTF-8" action="professor-student-manage">
     <input type="hidden" name="pageNum" id="pageNum" value="${pageNum}" />
     <div class="card-body">
       <table border="1">
         <tr>
            <th style="background-color: #2c3e50 !important;">학번</th><th style="background-color: #2c3e50 !important;">이름</th>
         </tr>
   
	  <c:forEach var="s" items="${studentList}" varStatus="vs">
	    	<tr onclick="location.href='professor-student-info?studno=${s.studno}'"> 
	    	<td>${s["studno"]}</td>
	    		<c:forEach var="u" items="${user}" varStatus="vs">
	    				<c:if test="${s.studno == u.id }">
	    					<td onclick="location.href='professor-student-info?studno=${s.studno}'">
	    							<u>${u.name}</u>
	    					</td>
	    				</c:if>
	    		</c:forEach>
	        </tr>
	  </c:forEach>
      </table>
   </div>
   </form>
 </div>
 <ul class="pagination">
  <c:forEach var="i" begin="${startpage}" end="${endpage}">
    <li class="page-item">
      <a href="javascript:listsubmit(${i})" class="page-link">${i}</a>
    </li>
  </c:forEach>
</ul>
 <script>
  function listsubmit(page) {
    document.getElementById("pageNum").value = page;
    document.sf.submit();
  }
</script>
</body>
</html>


