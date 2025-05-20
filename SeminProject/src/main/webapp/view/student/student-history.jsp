<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <title>학생 정보 조회</title>
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active  mx-5">  수강 신청 내역</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              수강 신청 내역
     </div>
     <form action="student-history" name="f" method="post" accept-charset="UTF-8">
	     <div class="card-body" style="position:relative;align-items:center;">
	     	<select id="year-select" name="year-select" style="position:absolute;align-items:center;left:40%; width:150px;height:35px">
	     		<option value="14" <c:if test="${option == '14'}">selected="selected"</c:if>>2014년</option>
	     		<option value="15" <c:if test="${option == '15'}">selected="selected"</c:if>>2015년</option>
	     		<option value="16" <c:if test="${option == '16'}">selected="selected"</c:if>>2016년</option>
	     		<option value="17" <c:if test="${option == '17'}">selected="selected"</c:if>>2017년</option>
	     		<option value="18" <c:if test="${option == '18'}">selected="selected"</c:if>>2018년</option>
	     		<option value="19" <c:if test="${option == '19'}">selected="selected"</c:if>>2019년</option>
	     		<option value="20" <c:if test="${option == '20'}">selected="selected"</c:if>>2020년</option>
	     		<option value="21" <c:if test="${option == '21'}">selected="selected"</c:if>>2021년</option>
	     		<option value="22" <c:if test="${option == '22'}">selected="selected"</c:if>>2022년</option>
	     		<option value="23" <c:if test="${option == '23'}">selected="selected"</c:if>>2023년</option>
	     		<option value="24" <c:if test="${option == '24'}">selected="selected"</c:if>>2024년</option>
	     		<option value="25" <c:if test="${option == '25'}">selected="selected"</c:if>>2025년</option>
	     	</select>
	     	<select id="semester-select" name="semester-select" style="position:absolute;align-items:center;left:50%;height:35px">
	     		<option value="1" <c:if test="${semester == '1'}">selected="selected"</c:if>>1학기</option>
	     		<option value="2" <c:if test="${semester == '2'}">selected="selected"</c:if>>2학기</option>
	     	</select>
	     	<button type="submit" id="searchbtn" class="searchbtn btn btn-primary" style="position:absolute;left:55%;height:35px">검색</button>
	     	
	    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align: center;margin-top:50px">
	       		<tr>

	       			<th style="background-color: #2c3e50 !important;">학기</th>
	       			<th style="background-color: #2c3e50 !important;">강의명</th>
	       			<th style="background-color: #2c3e50 !important;">성적</th>
	       		</tr>
	       		<c:if test="${empty list}">
				   	<tr><td colspan="2">조회 결과가 없습니다.</td></tr>
				</c:if>
	       		<c:forEach var="row" items="${list}">
	       		<c:set var="test" value="${row.year}" />
	       		<c:set var="length" value="${fn:length(row.year)}"/>
		       		<tr>
						<td>
						    ${fn:substring(test, 0, 2)}년도 
						    ${fn:substring(test, length-1,length)}학기
						</td>
		       			<td>${row.subject}</td>
		       			<td>
						  <c:choose>
						    <c:when test="${row.grade >= 4.0}">
						      A
						    </c:when>
						    <c:when test="${row.grade >= 3.0}">
						      B
						    </c:when>
						    <c:when test="${row.grade >= 2.0}">
						      C
						    </c:when>
						    <c:when test="${row.grade >= 1.0}">
						      D
						    </c:when>
						    <c:otherwise>
						      F
						    </c:otherwise>
						  </c:choose>
						</td>

		       		</tr>
		       	</c:forEach>
	    	</table>
	    </div>
	    <input type="hidden" name="studno" value="${sessionScope.studno}">
    </form>
 </div>
  </body>
</html>