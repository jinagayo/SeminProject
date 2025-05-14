<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
    <title>성적관리</title>
<style>
      .container {
    max-width: 100%;
    padding: 20px;
}

table {
    width: 100%;
    border-collapse: collapse;
    table-layout: fixed;  /* 핵심: 열 너비 균등 배분 */
}

th, td {
    border: 1px solid black;
    padding: 5px;
    text-align: center;
    font-size: 14px;
    word-wrap: break-word;  /* 긴 텍스트 줄바꿈 */
    white-space: nowrap;
}

select {
    width: 100%;  /* 드롭다운이 셀 안에서 꽉 차게 */
    max-width: 100%;
    box-sizing: border-box;
}

@media screen and (max-width: 600px) {
    th, td {
        font-size: 12px;
    }
}
    </style>
</head>
<body>
    <div class="container">
        <h2>성적관리</h2>
        <form action="professor-InGrade-fix" method="post">
            <table border="1" style="border-collapse: collapse; width: 100%;" class="table table-hover" table-layout: fixed>
                <tr> 
                        <th style="border: 1px solid black; padding: 5px;">이름</th>	
                    	<th style="border: 1px solid black; padding: 5px;">학점</th>	
                </tr>
                   <c:forEach var="u" items="${std_list}" varStatus="s">
                   <tr>
                        <td style="border: 1px solid black; padding: 5px;">${u.name}</td>
                         <td style="border: 1px solid black; padding: 5px;">
                         	<input type="hidden" name="subcode" value="${subcode}">
                         	<input type="hidden" name="studno" value="${u.id}">
                         	<select name="grade">
  								<option value="A">A</option>
  								<option value="A+">A+</option>
 								<option value="B">B</option>
 								<option value="B+">B+</option>
  								<option value="C">C</option>
  								<option value="C+">C+</option>
  								<option value="F">F</option>
							</select>
                         </td>
                    </tr>
                    </c:forEach>
            </table>
 
            <div style="padding: 20px 20px;"><button onclick="fixing()">확인</button></div>
        </form>
    </div>
    
     <script type="text/javascript">
   		function fixing() {
   			alert("저장되었습니다.")
 		}
   
    </script>
</body>
</html>