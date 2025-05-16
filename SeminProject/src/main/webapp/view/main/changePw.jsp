<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- /webapp/member/passwordForm.jsp
  로그인 한경우만 이페이지가 출력하도록 수정하기
  로그아웃상태 : 화면에 로그인하세요 메세지 출력 후 opener의 url을 loginForm.jsp로 페이지 이동하기. 
              현재 페이지 닫기 
--%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>password change</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">비밀번호 변경</h1>
                   
                                    </div>
     
                                     <form action="password" method="post" name="f" onsubmit="return input_check(this)">
                                    <div class="user">
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                name = "pass" id="pass" placeholder="현재비밀번호">
                                                
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                name = "chgpass" id="chgpass" placeholder="변경비밀번호">
                                        </div>
                                         <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                name = "chgpass2" id="chgpass2" placeholder="변경비밀번호 재입력">
                                        </div>
                                       
                                        <button class="btn btn-primary btn-user btn-block" id="btn_login" >
                                            Search
                                        </button>
                                    </div>
                                    </form>
                                   
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

        </div>

    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

  <script>
    function input_check(f) {
 	   if(f.chgpass.value != f.chgpass2.value) {
		   alert("변경비밀번호 와 변경비밀번호재입력이 다릅니다.");
		   f.chgpass2.value="";
		   f.chgpass2.focus();
		   return false;
	   }
 	   return true;
    }
  </script>  
</body>
</html>
                    
 
