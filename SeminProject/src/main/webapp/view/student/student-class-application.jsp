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
  <h2 class="breadcrumb-item active  mx-5">졸업 사정표</h2>
  <div class="card mb-4 mx-5">
    <div class="card-header">
      <i class="fas fa-table me-1"></i> 수강신청
    </div>

    <div class="card-body" style="position:relative;align-items:center;">
      <form action="student-class-application" method="get" name="sf">
        <input type="hidden" name="pageNum" value="1">
        <select id="select" name="column" style="position:absolute;left:28%;width:150px" class="form-select form-select-m mb-3">
          <option value="profname" selected>교수명</option>
          <option value="subname">과목명</option>
        </select>
        <div class="container-fluid">
          <input type="text" name="find" class="form-control" placeholder="(검색어입력)" value="${param.find}" style="position:absolute;left:38%;width:400px;">
          <button type="submit" id="searchbtn" class="btn btn-outline-success" style="position:absolute;left:64%;height:35px">검색</button>
        </div>
      </form>

      <table id="datatablesSimple" border="1" style="width: 100%; text-align: center; margin-top: 50px">
        <thead>
          <tr>
            <th style="background-color: #2c3e50 !important;">교직이수</th>
            <th style="background-color: #2c3e50 !important;">과목명</th>
            <th style="background-color: #2c3e50 !important;">요일</th>
            <th style="background-color: #2c3e50 !important;">강의시간</th>
            <th style="background-color: #2c3e50 !important;">학점</th>
            <th style="background-color: #2c3e50 !important;">교수명</th>
            <th style="background-color: #2c3e50 !important;"></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="list" items="${classList}" varStatus="status">
            <tr>
              <td>
                <c:if test="${list.teachsub=='1'}">Y</c:if>
              </td>
              <td>${list.subname}</td>
              <td>
                <c:if test="${list.day==2}">월</c:if>
                <c:if test="${list.day==3}">화</c:if>
                <c:if test="${list.day==4}">수</c:if>
                <c:if test="${list.day==5}">목</c:if>
                <c:if test="${list.day==6}">금</c:if>
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
        </tbody>
      </table>

      <!-- ✅ 페이지네이션은 테이블 밖에서 표시 -->
      <div aria-label="Page navigation example" class="d-flex justify-content-center mt-4">
        <ul class="pagination">
          <c:if test="${pageNum <= 1}">
            <li class="page-item disabled">
              <a class="page-link" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
          </c:if>
          <c:if test="${pageNum > 1}">
            <li class="page-item">
              <a href="javascript:listsubmit(${pageNum-1})" class="page-link" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
              </a>
            </li>
          </c:if>

          <c:forEach var="a" begin="${startpage}" end="${endpage}">
            <c:choose>
              <c:when test="${a == pageNum}">
                <li class="page-item active"><a class="page-link">${a}</a></li>
              </c:when>
              <c:otherwise>
                <li class="page-item"><a href="javascript:listsubmit(${a})" class="page-link">${a}</a></li>
              </c:otherwise>
            </c:choose>
          </c:forEach>

          <c:if test="${pageNum >= maxpage}">
            <li class="page-item disabled">
              <a class="page-link" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </c:if>
          <c:if test="${pageNum < maxpage}">
            <li class="page-item">
              <a href="javascript:listsubmit(${pageNum+1})" class="page-link" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
              </a>
            </li>
          </c:if>
        </ul>
      </div>

    </div>
  </div>

<script type="text/javascript">
  function listsubmit(page) {
    const f = document.sf;
    f.pageNum.value = page;
    f.submit();
  }
</script>

</body>
</html>
