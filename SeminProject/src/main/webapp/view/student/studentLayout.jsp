<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
    	
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

	<!-- include summernote css/js -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    	
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title><sitemesh:write property="title"/></title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
       <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    
       	 <style>
          body {
              font-family: 'Noto Sans', sans-serif;
              margin: 20px;
               }
          h1 {
             font-weight: 700;
              }
          p {
            font-weight: 400;
             }
          .light {
            font-weight: 300;
              }
  </style>
  
    </head>
    <body class="sb-nav-fixed">
        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark" style="background-color: #2c3e50 !important;">
            <!-- 상단바-->
           <img src="${pageContext.request.contextPath}/assets/img/logo1.png" style="width:40px; height:40px; padding-left=5px;" onclick="location.href='../main/main'">
            <a class="navbar-brand ps-3" onclick="location.href='../main/main'" style="
    font-family: 'YeongamWolchulsanTTF';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/2410-1@1.0/YeongamWolchulsanTTF.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;">구디 대학교</a>
            <!-- Sidebar Toggle-->
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
                
                    <button class="btn btn-primary" id="btnNavbarSearch" type="button" onclick="location.href='../main/logout'">Logout</button>
                
            </form>
   <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    	<li><a class="dropdown-item" onclick="location.href='../main/changePw'">password change</a></li>
                        <li><a class="dropdown-item" onclick="location.href='../main/logout'">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion" style="background-color: #2c3e50 !important;">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseMypage" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                마이페이지
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseMypage" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="student-mypage-info">학적 정보 조회</a>
                                    <a class="nav-link" href="student-mypage-grad">졸업 사정표</a>
                                    <a class="nav-link" href="student-mypage-time">내 시간표 조회</a>
                                </nav>
                            </div>
                            <a class="nav-link" href="../board/notice">
                                <div class="sb-nav-link-icon"><i class="fas fa-chart-area"></i></div>
                                알림마당
                            </a>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseClass" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                내 강의실
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseClass" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="student-class-application">수강신청</a>
                                    <a class="nav-link" href="student-myclass">내 강의 목록</a>
                                </nav>
                            </div>
                            <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseTeach" aria-expanded="false" aria-controls="collapseLayouts">
                                <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                                교원자격
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <div class="collapse" id="collapseTeach" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                                <nav class="sb-sidenav-menu-nested nav">
                                    <a class="nav-link" href="student-teach-practice">교육 실습</a>
                                    <a class="nav-link" href="student-teach-personality">교직 적성 검사</a>
                                    <a class="nav-link" href="student-teach-service">교육 봉사</a>
                                    <a class="nav-link" href="student-teach-info">교원 자격 취득 조건 조회</a>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer" style="background-color: #2c3e50 !important;">
                        <div class="small">Logged in as:</div>
                         ${session.name}
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                   <sitemesh:write property="body"/>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/datatables-simple-demo.js"></script>
    </body>
</html>
