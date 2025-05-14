<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
    <title>Professor Class Home</title>
</head>
<body>

<br>
<div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
             ${subject.subname}
     </div>
 
 <div>
<div style="margin-left: 100px; margin-top: 30px;">
  <button onclick="openAttPopup()">출결관리</button>
</div>

<div style="margin-left: 100px; margin-top: 30px;">
  <button onclick="openGradePopup()">성적관리</button>
</div>
</div>
</div>

   <script type="text/javascript">
   		function openAttPopup() {
   			const url = "professor-CkAtt?subcode="+${subject.subcode};
     	  	window.open( url, "professor-CkAtt", "width=350,height=400, left=500,top=100, scrollbars=yes");
 		}
   
        function openGradePopup() {
        	const url = "professor-InGrade?subcode="+${subject.subcode};
            window.open( url, "professor-InGrade", 'width=350,height=400, left=500,top=100, scrollbars=yes');
        }
        
    </script>
    
</body>
</html>
