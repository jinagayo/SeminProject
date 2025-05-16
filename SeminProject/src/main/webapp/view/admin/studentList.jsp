<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
  	<style type="text/css">
  		.page{
  			position:relative;
  			left:45%;
  		}
  	</style>
    <title>학생 정보 조회</title>
  </head>
  
  <body>
  <br>
  <h2 class="breadcrumb-item active  mx-5">  학생 조회</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              학생 조회
     </div>

     <form action="studentList" name="sf" method="post" accept-charset="UTF-8">
     		<c:if test="${empty pageNum}">
			  	<c:set var="pageNum" value="1"/>
			</c:if>
     		<input type="hidden" name="pageNum" id="pageNum" value="${pageNum}">
	     <div class="card-body">
	     	<select id="select" name="select" style="position:absolute;align-items:center;left:30%">
	     		<option value="studno" selected>학번</option>
	     		<option value="major">전공</option>
	     		<option value="name">이름</option>
	     	</select>
	     	<input type="text" name="searchList" class="searchList" placeholder="(검색어입력)" style="position:absolute;left:38%;width:400px;">
	     	<button type="submit" id="searchbtn" class="searchbtn btn btn-primary" style="position:absolute;left:64%;height:35px">검색</button>
	    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;margin-top:50px">
		       		<tr>
		       			<th>학번</th>
		       			<th>전공</th>
		       			<th>이름</th>
		       		</tr>
		       		
		       		<c:forEach var="row" items="${list}">
		       			<tr onclick="location.href='../admin/studentInfo?studno=${row.studno}'">	
		       				<td>${row.studno}</td>
		       				<td>${row.major}</td>
		       				<td>${row.name}</td>
		       			</tr>
		       		</c:forEach>
	    	</table>
	    </div>
    </form>
 </div>
 		<div class="text-xxl-center text-secondary">
			<c:if test="${pageNum > 1}">
		    <a href="javascript:listsubmit(${pageNum-1})" class="text-decoration-none">◀️</a>
			</c:if>
			<c:if test="${pageNum <= 1}">
			    ◀️
			</c:if>
			
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
			    <c:if test="${a == pageNum}">
			    	<span class="num text-decoration-none">[${a}]</span>
			    </c:if>
			    <c:if test="${a != pageNum}">
			        <a href="javascript:listsubmit(${a})" class="num text-decoration-none">${a}</a>
			    </c:if>
			</c:forEach>
			
			<c:if test="${pageNum < maxpage}">
			    <a href="javascript:listsubmit(${pageNum+1})" class="text-decoration-none">▶️</a>
			</c:if>
			<c:if test="${pageNum >= maxpage}">
			    ▶️
			</c:if>
		</div>
	<script type="text/javascript">
	    function listsubmit(page) {
	        document.getElementById("pageNum").value = page;
	        document.sf.submit();
	    }
	    
	    const emojiMap = ['0️⃣','1️⃣','2️⃣','3️⃣','4️⃣','5️⃣','6️⃣','7️⃣','8️⃣','9️⃣','🔟'];
	    document.querySelectorAll('.num').forEach(el => {
	      const n = el.textContent.replace(/\D/g, ''); // 숫자만 추출
	      const i = parseInt(n, 10);
	      if (i >= 0 && i <= 10) {
	        el.textContent = emojiMap[i];
	      }
	    });
	</script>
  </body>

</html>