<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>로그인</title>
	
    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="../css/sb-admin-2.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT" crossorigin="anonymous">
  </head>
</head>

<body style="background-image: url('../assets/img/bgimg.jpg');background-repeat: no-repeat; background-size : cover;">

    <form action="login" method="POST" name="f">
    	<div class="container d-flex justify-content-center align-items-center">
            
        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9" style="padding-top: 200px;">

<div class="card o-hidden border-0 shadow-lg d-flex justify-content-center align-items-center"
     style="width: 500px; height: 500px; margin: auto;">

  <div class="card-body d-flex flex-column justify-content-center align-items-center text-center w-100">

    <h1 class="h4 text-gray-900 mb-4">구디대학교</h1>

    <form class="w-75">
    <div class="user">
      <div class="form-group">
        <input type="text" class="form-control mb-2" name="id" placeholder="ID">
      </div>
      <div class="form-group">
        <input type="password" class="form-control mb-2" name="pass" placeholder="Password">
      </div>
    
      <button type="submit" class="btn btn-primary w-100 mx-auto">Login</button>
        <div class="form-check text-start mb-2">
   
        </div>
      <a href="p_searchForm" class="small d-block">Forgot Password?</a>
      <a href="id_searchForm" class="small d-block">Forgot Id?</a>
      </div>
    </form>

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
    
    </form>
    <script type="text/javascript">
    	function inputcheck(){
    		f = document.f;
    		if(f.id.value == ""){
    			alert("아이디를 입력하세요");
    			f.id.focus();
    			return;
    		}
    		if(f.pass.value == ""){
    			alert("비밀번호를 입력하세요");
    			f.pass.focus();
    			return;
    		}
    		f.submit();
    	}
    </script>

</body>

</html>