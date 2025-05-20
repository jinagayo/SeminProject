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
  <h2 class="breadcrumb-item active  mx-5">  강의 개설</h2>
  <div class="card mb-4  mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              강의 개설
     </div>
     <div class="card-body">
     <form action="subjectInsert" name="f" method="post" accept-charset="UTF-8" enctype="multipart/form-data">
    	<table id="datatablesSimple" border="1" style="width: 100%;height:100%;">
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">과목코드</th>
       			<td><input type="text" name="subcode" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">과목명</th>
       			<td><input type="text" name="subname" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">	
       			<th style="background-color: #2c3e50 !important;">학점</th>
       			<td><input type="text" name="time" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">강의 시작 시간</th>
       			<td><input type="text" name="starttime" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">요일</th>
       			<td><input type="text" name="day" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">강의실</th>
       			<td><input type="text" name="location" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">교수번호</th>
       			<td><input type="text" name="profno" style="width:100%;" class="input-group-text"></td>
       		</tr>
       		<tr class="text-center">
       			<th style="background-color: #2c3e50 !important;">교직이수</th>
       			<td>
					<input type="checkbox" name="teachsub" value="1" class="btn-check" id="sub1" autocomplete="off">
					<label class="btn btn-outline-success" for="sub1">&nbsp;O&nbsp;</label>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="checkbox" name="teachsub" value="2" class="btn-check" id="sub2" autocomplete="off"> 
					<label class="btn btn-outline-danger" for="sub2">&nbsp;X&nbsp;</label>
       			</td>
       		</tr>
       		<tr>
       			<td colspan="2">
       				<button type="submit" class="btn btn-primary text-center" style=" text-align: center;width:150px">등록</button>
       			</td>
       		</tr>
    	</table>
    	
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