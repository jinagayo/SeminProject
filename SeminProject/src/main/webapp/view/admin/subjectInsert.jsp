<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
  	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
    <title>강의 관리</title>
    
  </head>
  <body>
  <br>
  <h2 class="breadcrumb-item active">  강의 개설</h2>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              DataTable Example
     </div>
     <div class="card-body">
     <form action="subjectInsert" name="f" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;text-align:left;">
       		<tr>
       			<th>과목코드</th>
       			<td><input type="text" name="subcode"></td>
       		</tr>
       		<tr>
       			<th>과목명</th>
       			<td><input type="text" name="subname"></td>
       		</tr>
       		<tr>	
       			<th>학점</th>
       			<td><input type="text" name="time"></td>
       		</tr>
       		<tr>
       			<th>강의 시작 시간</th>
       			<td><input type="text" name="starttime"></td>
       		</tr>
       		<tr>
       			<th>요일</th>
       			<td><input type="text" name="day"></td>
       		</tr>
       		<tr>
       			<th>강의실</th>
       			<td><input type="text" name="location"></td>
       		</tr>
       		<tr>
       			<th>교수번호</th>
       			<td><input type="text" name="profno"></td>
       		</tr>
       		<tr>
       			<th>교직이수</th>
       			<td><input type="checkbox" name="teachsub" value="1" id="sub1"> O </td>
       			<td><input type="checkbox" name="teachsub" value="2" id="sub2"> X </td>
       		</tr>
    	</table>
    	<button type="submit" onclick="chk()">등록</button>
    	</form>
    </div>
 </div>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     <script>
      $(document).ready(function () {
        $("#sub1").click(function () {
          if ($(this).is(":checked")) {
            $("#sub2").prop("checked", false);
          }
        });
        $("#sub2").click(function () {
          if ($(this).is(":checked")) {
            $("#sub1").prop("checked", false);
          }
        });
      });
    </script>
  </body>
</html>