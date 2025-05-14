<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청</title>
</head>
<body>

  <br>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              수강신청
     </div>
     <div class="card-body">
	     <div class="card-body">
	     
			<form action="student-class-application" method="get" name="sf">
				<input type="hidden" name="pageNum" value="1">
	     
		     	<select id="select" name="column" class="select">
		     		<option value="profname" selected>교수명</option>
		     		<option value="subname">과목명</option>
		     	</select>
		     	<input type="text" name="find" class="searchList" placeholder="(검색어입력)" value="${param.find}">
		     	<button type="submit" id="searchbtn" class="searchbtn" class="btn btn-secondary text-center">검색</button>
		     </form>
    	<table id="datatablesSimple" border="1">
       		<tr>
       			<th>교직이수</th><th>과목명</th><th>요일</th><th>강의시간</th><th>학점</th
       			><th>교수명</th><th> </th>
       		</tr>
       		
       		<c:forEach var="list" items="${classList}" varStatus="status">
       			<tr>
       				<td>
       					<c:if test="${list.teachsub=='1'}">
       						Y
       					</c:if>
       				</td>
       				<td>${list.subname}</td>
       				<td>
       					<c:if test ="${list.day==2}">
       						월
       					</c:if>
       					<c:if test ="${list.day==3}">
       						화
       					</c:if>
       					<c:if test ="${list.day==4}">
       						수
       					</c:if>
       					<c:if test ="${list.day==5}">
       						목
       					</c:if>
       					<c:if test ="${list.day==6}">
       						금
       					</c:if>
       				</td>
       				<td>${list.starttime}:00~${list.starttime+list.time}:00</td>
       				<td>${list.time}</td>
       				<td>${list.profname}</td>
       				<td> 
       					<form action="applicate" method="get">
			                <input type="hidden" name="subcode" value="${list.subcode}">
			                <button type="submit" class="btn btn-primary text-center">신청</button>
			        	</form>
			        </td>
       			</tr>
       		</c:forEach>
	<%--페이지 처리하기 --%>
			<tr>
				<td colspan="7" align="center">
				<c:if test="${pageNum <=1 }">[이전]</c:if>
				<c:if test="${pageNum > 1 }"><a href="list?pageNum=${pageNum-1}">[이전]</a></c:if>
				<c:forEach var="a" begin="${startpage}" end="${endpage}">
					<c:if test="${a==pageNum}">[${a}]</c:if>
					<c:if test="${a!=pageNum}">
						<a href="javascript:listsubmit(${a})">[${a}]</a>
					</c:if>
				</c:forEach>
				<c:if test="${pageNum>=maxpage}">다음</c:if>
				<c:if test="${pageNum<maxpage}">
					<a href="javascript:listsubmit(${pageNum+1})">다음</a>
				</c:if>
				</td>
			</tr>
       	</table>
    </div>
  </div>
  </div>
<script type="text/javascript">
	function listsubmit(page){
		f=document.sf;
		f.pageNum.value=page;
		f.submit();
	}
</script>
</body>
</html>