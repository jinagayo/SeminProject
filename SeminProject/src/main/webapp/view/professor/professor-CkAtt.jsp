<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>출결관리</title>
<style>
    html, body {
        margin: 0;
        padding: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        font-family: sans-serif;
        box-sizing: border-box;
    }

    .container {
        max-width: 100%;
        padding: 20px;
        overflow-x: auto; /* 테이블이 넘치면 스크롤 */
    }

    table {
        width: 100%;
        border-collapse: collapse;
        table-layout: auto; /* 칸의 크기를 글자에 맞게 자동 조정 */
    }

    th, td {
        border: 1px solid black;
        padding: 5px;
        text-align: center;
        font-size: 14px;
        white-space: normal;    /* 줄바꿈 허용 */
        overflow: visible;      /* 넘치는 글자 표시 */
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
        <h2>출결관리</h2>
        <form action="professor-CkAtt-fix" method="post">
            <table border="1" style="border-collapse: collapse; width: 100%;" >
                <tr> 
                	<th style="border: 1px solid black; padding: 5px;"></th>
                    <c:forEach var="i" begin="1" end="15">
                        <th style="border: 1px solid black; padding: 5px;">WEEK${i}</th>	
                    </c:forEach>
                </tr>
                   <c:forEach var="u" items="${std_list}" varStatus="s">
                   <tr>
                   <c:forEach var="a" items="${att}" varStatus="as">
                   		<c:if test="${u.id == a.studno}">
                        <th style="border: 1px solid black; padding: 5px;">${u.name}</th>
                        	<c:forEach var="i" begin="1" end="15">
                        		<td style="border: 1px solid black; padding: 5px;">
										<!-- 체크 안됐을 때 넘길 값 -->
										<input type="hidden" name="att" value="${u.id}_0_${subcode}">
										<!-- 체크됐을 때 덮어쓰기 됨 -->
                        				<input type="checkbox" name="att" value="${u.id}_1_${subcode}" checked}>
                        		</td>	
                    		</c:forEach>
                    	</c:if>
                    </c:forEach>
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