<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>과목 공지사항</title>
</head>
<body>

  <div class="card mb-4">
     
         <i class="fas fa-table me-1"></i>
             <div style="text-align: center;">
  				<h1>${boardName}</h1>
			 </div>
     
     <div style="display: flex;align-items: center;justify-content: space-between;flex-direction: column;">
	
<table class="table" style="padding-top:40px;">
	<c:if test="${boardCount==0}">
		<tr>
			<td colspan="5">등록된 게시글이 없습니다.</td>
		</tr>
	</c:if>
		<tr>	
			<td></td>
		</tr>
		<tr>
			<th width="10%" style="color:black;">제목</th>
			<th width="15%" style="color:black;">등록일</th>
			<th width="18%" style="color:black;">작성자</th>
		</tr>
	<c:forEach var="b" items="${list}" varStatus="status">
		<tr>
			<td width="23%" style="text-align:center">
			<a href="professor-subject-board-info?num=${b.num}">${b.title}</a>
			</td>
			<td style="text-align:center"><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd" var="rdate" />
			<fmt:formatDate value="${today}" pattern="yyyy-MM-dd HH:mm:ss" var="tdate" />
			<c:if test="${rdate==tdate}">
				<fmt:formatDate value="${b.regdate}" pattern="HH:mm:ss"/>
			</c:if>
			<c:if test="${rdate!=today}">
				<fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd"/>
			</c:if></td>
			<td width="18%" style="text-align:center" >
				${b.writer }
			</td>
		</tr>
	
	</c:forEach>
	<%--페이지 처리하기 --%>
	<tr><td colspan="5" align="center">  </td></tr>
	<tr><td colspan="5" align="center">  </td></tr>
	<tr><td colspan="5" align="center">  </td></tr>
	<tr>
		<td colspan="5" align="center">
			<c:if test="${pageNum > 1 }">
			  <a href="javascript:listsubmit(${pageNum-1})">[이전]</a>
			</c:if>
			
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
			  <c:if test="${a==pageNum}">[${a}]</c:if>
			  <c:if test="${a!=pageNum}">
			    <a href="javascript:listsubmit(${a})">[${a}]</a>
			  </c:if>
			</c:forEach>
			
			<c:if test="${pageNum<maxpage}">
			  <a href="javascript:listsubmit(${pageNum+1})">[다음]</a>
			</c:if>
		</td>
	</tr>
			<tr>
				<td colspan="5" style="text-align:right">
					<form action="professor-subject-board" method="get" accept-charset="UTF-8"  name="sf" >
					  <input type="hidden" name="pageNum" />
					  <input type="hidden" name="subcode" value="${param.subcode}" />
					  <input type="hidden" name="boardid" value="${boardid}" />
					  <input type="hidden" name="subcode" value="${param.subcode}" />
					<button type="button" onclick="goFullPage()" class="btn-primary text-center">더보기</button>
					<input type="hidden" name="subcode" value="${param.subcode}"/>
					<input type="hidden" name="boardid" value="${boardid}"/>
				</form>
				</td>
			</tr>
</table>
</div>
</div>
<script type="text/javascript">
	function listsubmit(page){
		f=document.sf;
		f.pageNum.value=page;
		f.submit();
	}
</script>
<script>
  function goFullPage() {
    const subcode = '${param.subcode}';
    const boardid = '${boardid}';
    window.top.location.href = 'professor-subject-Mboard?subcode=' + subcode + '&boardid=' + boardid;
  }
</script>
</body>

</html>