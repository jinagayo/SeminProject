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

    <title>SB Admin 2 - Forgot Password</title>

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
                                        <h1 class="h4 text-gray-900 mb-2">비밀번호 찾기</h1>
                   
                                    </div>
                                    <form action="pw" method="post" onsubmit="return input_check(this)">
                                    <div class="user">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name = "id" id="id" placeholder="ID">
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name = "email" id="email" placeholder="Email">
                                        </div>
                                         <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name = "tel" id="tel" placeholder="Tel">
                                        </div>
                                       
                                        <button class="btn btn-primary btn-user btn-block" id="btn_login" >
                                            Search
                                        </button>
                                    </div>
                                    </form>
                                     <hr>
                                    <div class="text-center">
                                        <a class="small" onclick="location.href='../main/id_searchForm'">Forgot ID?</a>
                                    </div>
                                    <div class="text-center">
                                        <a class="small" href="login">login</a>
                                    </div>
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
    <script type="text/javascript">
   function input_check(f) {
	   if(f.id.value.trim() == "") {
		   alert("아이디를 입력하세요");
		   f.id.focus();
		   return false;
	   }
	   if(f.email.value.trim() == "") {
		   alert("이메일을 입력하세요");
		   f.email.focus();
		   return false;
	   }
	   if(f.tel.value.trim() == "") {
		   alert("전화번호를 입력하세요");
		   f.tel.focus();
		   return false;
	   }
	
	   if(!isValidEmail(f.email.value.trim())) {
		   alert("이메일형식이 아닙니다");
		   f.email.focus();
		   return false;
	   }
	  
   }
	//정규식을 이용한 이메일,전화번호 형식 검증 
   function isValidEmail(email) {
	   const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	   /*
	     /^   ... $/ => 정규표현식 시작과 끝
	     [a-zA-Z0-9._%+-]+ => 소문자 대문자 숫자 _ % + - 중 문자가 한개 이상
	     @  : @문자
	     [a-zA-Z0-9.-]+ => 소문자 대문자 숫자 . - 중 문자한개 이상
	     \. : . 문자
	   [a-zA-Z]{2,} => 소문자 대문자 2자 이상
	   */
	   return regex.test(email); // 정규식표현식일치 : true 리턴, 불일치 : false 리턴
    }

   
   
</script>

</body>

</html>