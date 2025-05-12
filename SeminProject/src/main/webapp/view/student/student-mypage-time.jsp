<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
  
    
<!DOCTYPE html>
<html>
<head> 
<meta charset="UTF-8">
<title>내 시간표 조회</title>
</head>
<body>
  <br>
  <div class="card mb-4">
     <div class="card-header">
         <i class="fas fa-table me-1"></i>
              내 시간표 조회
     </div>
     <div class="card-body">
       <table id="datatablesSimple" border="1">
         <tr>
            <th></th><th>월</th><th>화</th><th>수</th><th>목</th><th>금</th>
         </tr>
         <tr id="time9"> </tr>
         <tr id="time10"> </tr>
         <tr id="time11"> </tr>
         <tr id="time12"> </tr>
         <tr id="time13"> </tr>
         <tr id="time14"> </tr>
         <tr id="time15"> </tr>
         <tr id="time16"> </tr>
         <tr id="time17"> </tr>
         <tr id="time18"> </tr>
         
         
      </table>
   </div>
 </div>
 <script>
 const subjects = [
	  <c:forEach var="s" items="${sub}" varStatus="vs">
	    {
	      day: "${s.day}", 
	      starttime: "${s.starttime}", 
	      name: "${s.subname}", 
	      location: "${s.location}"
	    }<c:if test="${!vs.last}">,</c:if>
	  </c:forEach>
	];
let time9 = "<td>09:00</td>";
for (let i = 2; i <= 6; i++) { // 월(2) ~ 금(6)
	let found = subjects.find(sub => sub.day === String(i) && sub.starttime === "9");

    if (found) {
    	for (let key in found) {
    		  console.log(`${key}: ${found[key]}`);
    		}

        time9 += `<td>${found.name}<hr>0${found.starttime}:00<hr>${found.location}</td>`;
        console.log(time9);
    } else {
        time9 += "<td></td>";
    }
}


let time10 = "<td>10:00</td>";
for (let i = 2; i <= 6; i++) { 
    let found = subjects.find(sub => sub.day === i && sub.starttime === 10);
    if (found) {
    	console.log(found);
        time10 += `<td rowspan="${found.time}">${found.name}<hr>${found.starttime}:00<hr>${found.location}</td>`;
    } else {
        time10 += "<td></td>";
    }
}
let time11 = "<td>11:00</td>";
for (let i = 2; i <= 6; i++) { 
    let found = subjects.find(sub => sub.day === i && sub.starttime === 11);
    if (found) {
        time11 += `<td rowspan="${found.time}">${found.name}<hr>${found.starttime}:00<hr>${found.location}</td>`;
    } else {
        time11 += "<td></td>";
    }
}
let time12 = "<td>12:00</td>";
for (let i = 2; i <= 6; i++) { 
    let found = subjects.find(sub => sub.day === i && sub.starttime === 12);
    if (found) {
        time12 += `<td rowspan="${found.time}">${found.name}<hr>${found.starttime}:00<hr>${found.location}</td>`;
    } else {
        time12 += "<td></td>";
    }
}

let time13 = "<td>13:00</td>";
for (let i = 2; i <= 6; i++) { 
    let found = subjects.find(sub => sub.day === i && sub.starttime === 13);
    if (found) {
        time13 += `<td rowspan="${found.time}">${found.name}<hr>${found.starttime}:00<hr>${found.location}</td>`;
    } else {
        time13 += "<td></td>";
    }
}
let time14 = "<td>14:00</td>";
for (let i = 2; i <= 6; i++) { 
    let found = subjects.find(sub => sub.day === i && sub.starttime === 14);
    if (found) {
        time14 += `<td rowspan="${found.time}">${found.name}<hr>${found.starttime}:00<hr>${found.location}</td>`;
    } else {
        time14 += "<td></td>";
    }
}
let time15 = "<td>15:00</td>";
for (let i = 2; i <= 6; i++) { 
    let found = subjects.find(sub => sub.day === i && sub.starttime === 15);
    if (found) {
        time15 += `<td rowspan="${found.time}">${found.name}<hr>${found.starttime}:00<hr>${found.location}</td>`;
    } else {
        time15 += "<td></td>";
    }
}
let time16 = "<td>16:00</td>";
for (let i = 2; i <= 6; i++) { 
    let found = subjects.find(sub => sub.day === i && sub.starttime === 16);
    if (found) {
        time16 += `<td rowspan="${found.time}">${found.name}<hr>${found.starttime}:00<hr>${found.location}</td>`;
    } else {
        time16 += "<td></td>";
    }
}
let time17 = "<td>17:00</td>";
for (let i = 2; i <= 6; i++) { 
    let found = subjects.find(sub => sub.day === i && sub.starttime === 17);
    if (found) {
        time17 += `<td rowspan="${found.time}">${found.name}<hr>${found.starttime}:00<hr>${found.location}</td>`;
    } else {
        time17 += "<td></td>";
    }
}
let time18 = "<td>18:00</td>";
for (let i = 2; i <= 6; i++) { 
    let found = subjects.find(sub => sub.day === i && sub.starttime === 18);
    if (found) {
        time18 += `<td rowspan="${found.time}">${found.name}<hr>${found.starttime}:00<hr>${found.location}</td>`;
    } else {
        time18 += "<td></td>";
    }
}
window.onload = function () {
	console.log("콘솔로그"+JSON.stringify(subjects));
    document.getElementById("time9").innerHTML = time9;
    document.getElementById("time10").innerHTML = time10;
    document.getElementById("time11").innerHTML = time11;
    document.getElementById("time12").innerHTML = time12;
    document.getElementById("time13").innerHTML = time13;
    document.getElementById("time14").innerHTML = time14;
    document.getElementById("time15").innerHTML = time15;
    document.getElementById("time16").innerHTML = time16;
    document.getElementById("time17").innerHTML = time17;
    document.getElementById("time18").innerHTML = time18;
};
</script>
 
</body>
</html>