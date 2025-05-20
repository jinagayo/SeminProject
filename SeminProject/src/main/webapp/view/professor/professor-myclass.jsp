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
  <h2 class="breadcrumb-item active  mx-5">  내 강의실</h2>
  <div class="card mb-4 mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              강의 목록
     </div>
     <div class="card-body">
       <table id="datatablesSimple" border="1" style="border-collapse: collapse ; ">
	  <c:forEach var="s" items="${sublist}" varStatus="vs">
	    	<tr> 
	    	<td style="border-top: 1px solid #ccc; border-bottom: 1px solid #ccc; border-left: none; border-right: none; padding: 8px; ">${s.subname} (${s.subcode})  </td>
	    	<td style="border-top: 1px solid #ccc; border-bottom: 1px solid #ccc; border-left: none; border-right: none; padding: 8px;"> Q&A </td>
	    	<td style="border-top: 1px solid #ccc; border-bottom: 1px solid #ccc; border-left: none; border-right: none; padding: 8px;"><button onclick="location.href='professor-classHome?subcode=${s.subcode}'">강의홈 바로가기</button></td>
	      </tr>
	  </c:forEach>
      </table>
   </div>
 </div>
   		<div aria-label="Page navigation example" class="d-flex justify-content-center sticky-bottom">
  			<ul class="pagination sticky-xl-bottom">
				<c:if test="${pageNum > 1}">
				    <li class="page-item">
				    	<a href="javascript:listsubmit(${pageNum-1})" class="page-link" aria-label="Previous">
				    		<span aria-hidden="true">&laquo;</span>
				    	</a>
				    </li>
				</c:if>
				<c:if test="${pageNum <= 1}">
				   	<li class="page-item">
				   		<a class="page-link" aria-label="Previous">
				    		<span aria-hidden="true">&laquo;</span>
				    	</a>
				    </li>
				</c:if>
				
				<c:forEach var="a" begin="${startpage}" end="${endpage}">
				    <c:if test="${a == pageNum}">
				    	<li class="page-item"><a class="page-link">${a}</a></li>
				    </c:if>
				    <c:if test="${a != pageNum}">
				        <li class="page-item"><a href="javascript:listsubmit(${a})" class="page-link">${a}</a></li>
				    </c:if>
				</c:forEach>
				
				<c:if test="${pageNum < maxpage}">
				    <li class="page-item">
				    	<a href="javascript:listsubmit(${pageNum+1})" class="page-link" aria-label="Next">
				    		<span aria-hidden="true">&raquo;</span>
				    	</a>
				    </li>
				</c:if>
				<c:if test="${pageNum >= maxpage}">
				   	<li class="page-item">
				   		<a class="page-link" href="#" aria-label="Next">
				    		<span aria-hidden="true">&raquo;</span>
				    	</a>	
				    </li>
				</c:if>
			</ul>
		</div>
 	<script type="text/javascript">
	    function listsubmit(page) {
	        document.getElementById("pageNum").value = page;
	        document.sf.submit();
	    }
	</script>
</body>
</html>
