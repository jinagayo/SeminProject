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
<div class="card mb-4 mx-5">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
             ${subject.subname}
     </div>
 
 <div>
<div style="margin-left: 100px; margin-top: 30px;">
  <button onclick="openAttPopup()">출결관리</button>
</div>

<div style="margin-left: 100px; margin-top: 30px; margin-bottom: 30px;">
  <button onclick="openGradePopup()">성적관리</button>
</div>

<!-- 전체 wrapper: 화면 너비 기준 여백 포함 정렬 -->
<div
  style="
    position: fixed;
    bottom: 10%;
    left: 20vw;
    right: 20vw;
    display: flex;
    gap: 100px;
    justify-content: space-between;
    z-index: 1000;
  "
>
  <!-- 왼쪽 박스 -->
  <div
    style="
      flex: 1;
      height: 50vh;
      border: 2px solid #999;
      border-radius: 10px;
      box-shadow: 2px 2px 8px rgba(0,0,0,0.2);
      background-color: white;
      overflow: hidden;
      min-width: 600px;
    "
  >
    <iframe
      src="professor-subject-board?subcode=${subcode}"
      style="width: 100%; height: 100%; border: none;"></iframe>
  </div>

  <!-- 오른쪽 박스 -->
  <div
    style="
      flex: 1;
      height:50vh;
      border: 2px solid #999;
      border-radius: 10px;
      box-shadow: 2px 2px 8px rgba(0,0,0,0.2);
      background-color: white;
      overflow: hidden;
      min-width: 600px;
    "
  >
    <iframe
      src="professor-subject-board2?subcode=${subcode}"
      style="width: 100%; height: 100%; border: none;"  scrolling="auto"></iframe>
  </div>
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
