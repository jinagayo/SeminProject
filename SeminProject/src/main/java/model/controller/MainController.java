package model.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import gdu.mskim.MSLogin;
import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.user.User;
import model.user.UserDao;

@WebServlet(urlPatterns= {"/main/*"},
initParams= {@WebInitParam(name="view",value="/view/")})
public class MainController extends MskimRequestMapping {
	UserDao dao = new UserDao();
	//로그인
	@RequestMapping("login")
	public String login(HttpServletRequest request,HttpServletResponse response){
		String chkid = request.getParameter("id");	//아이디를 입력햇는지 확인하는 파라미터
		String pass = request.getParameter("pass");
		String position = request.getParameter("position");
		
		//첫페이지 로딩시 login창 띄워주기
		if(chkid == null || pass == null) {
			return "main/login";
		}
	
		//아이디랑 비밀번호입력하지 않았을 때
		if(chkid.isEmpty()) {
	        request.setAttribute("msg", "아이디를 입력하세요.");
	        request.setAttribute("url", "login");
	        return "alert";
		}
		if(pass.isEmpty()) {
	        request.setAttribute("msg", "비밀번호를 입력하세요.");
	        request.setAttribute("url", "login");
	        return "alert";
		}
		
		int id = Integer.parseInt(chkid);	//실제 db랑 비교할 파라미터
		User user = dao.selectOne(id);
		System.out.println(user);
	    if (user == null || id != user.getId() || !pass.equals(user.getPassword())) {
	        request.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
	        request.setAttribute("url", "login");
	        return "alert";
	    }
	    	request.setAttribute("msg", user.getName()+"님 로그인되었습니다.");
	        request.setAttribute("url", "main");
	        request.getSession().setAttribute("login", id); // 세션에 아이디 등록
	        request.getSession().setAttribute("user", user);
	        return "alert";
	   
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect:main";
	}
	
	@RequestMapping("main")
	public String main(HttpServletRequest request,HttpServletResponse response) {
		int login = (int) request.getSession().getAttribute("login");
		String user = (String)request.getSession().getAttribute("user");
		String position = (String)request.getParameter("positioin");
		request.setAttribute("login", login);
	    request.setAttribute("user", user);
	    request.setAttribute("position", position);
	    return "main/main";
	}
	
	/* 비밀번호 찾기
	  1. 파라미터(id,email,tel) 저장.
	  2. db에서 id,email과 tel 을 이용하여 pass값을 리턴
	       pass = MemberDao.pwSearch(id,email,tel)
	  3. 비밀번호 검증 
	     비밀번호 찾은 경우 :메일로 인증번호 보냄
	     비밀번호 못찾은 경우: 정보에 맞는 비밀번호를 찾을 수 없습니다.  메세지 출력후
	                     현재 페이지를 pwForm로 페이지 이동. 
	  4. 사용자가 메일로 보내진 인증번호 4자리를 입력
	  		올바른 인증번호 : 비밀번호 알려줌
	  		틀린 인증번호 : 인증에 실패하였습니다.
	 */
		   @RequestMapping("pw")
		   public String pw(HttpServletRequest request,
					   HttpServletResponse response) {
			   String id = request.getParameter("id");
			   String email = request.getParameter("email");
			   String tel = request.getParameter("tel");
			   String pass = dao.pwSearch(id,email,tel);
			
			   if(pass != null) { //비밀번호 검색 성공
				   String sender = "jinayoon90@gmail.com";
				   String s_pass = "uwwj qpgl gmpd wntc";
				   String recipient = email;
				   System.out.println(email);
				   System.out.println(recipient);
				   int num = (int)(Math.random() * 9000) + 1000;
				   String number = ""+num;
				
				   HttpSession session = request.getSession();
				   session.setAttribute("number", number);
				   session.setAttribute("pass", pass);
				   String result = "메일 전송시 오류가 발생했습니다.";
				   Properties prop = new Properties(); //이메일 전송을 위한 환경설정값
				   
				   try {
					   String path = request.getServletContext().getRealPath("/") 
							     + "WEB-INF/mail.properties";
					   FileInputStream fis = new FileInputStream(path);
					   prop.load(fis); //fis가 참조하는 파일의 내용을 Properties객체의 요소로 저장
					   prop.put("mail.smtp.user", sender); //전송이메일 주소
				   } catch(IOException e) {
					   e.printStackTrace();
				   }
				   
				   //메일 전송을 위한 인증 객체
				   MyAuthenticator auth = new MyAuthenticator(sender, s_pass);
				   //prop : 메일 전송을 위한 시스템 환경 설정
				   //auth : 인증객체
				   //메일 전송을 위한 연결 객체
				   Session mailSession = Session.getInstance(prop, auth);
				 //msg : 메일로 전송되는 데이터 객체
				   MimeMessage msg = new MimeMessage(mailSession);
				    //new String(이메일주소,인코딩코드)
					//email.getBytes("UTF-8") : byte[] 배열
					//8859_1 : 웹의 기본인코딩방식
				   InternetAddress addr = new InternetAddress();
				   try {
				   try {
					addr = (new InternetAddress
							(new String(email.getBytes("UTF-8"),"8859_1")));
				   }catch(UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				   
				   InternetAddress from = new InternetAddress(sender);
				   msg.setFrom(from);  //보내는 이메일 주소
					//Message.RecipientType.TO : 수신자
					//Message.RecipientType.CC : 참고인
				   msg.setRecipients(Message.RecipientType.TO, email);
				   msg.setSubject("비밀번호찾기 인증번호");  //제목
				   msg.setSentDate(new Date()); //전송일자
				   msg.setText(number);  //내용
				   
				   MimeMultipart multipart = new MimeMultipart();
					MimeBodyPart body = new MimeBodyPart();
					body.setContent(number,"text/html;charset=UTF-8");  //내용
					multipart.addBodyPart(body);
					msg.setContent(multipart);
					
				   Transport.send(msg);  //메일 전송
		
				   }catch(MessagingException e) {
						e.printStackTrace();
						System.out.println("실패!");
					}
				   request.setAttribute("msg", "메일로 인증번호를 보냈습니다. 인증을 완료해 주십시오");
				   request.setAttribute("url", "mVerify");
				   return "alert";
				   
			   } else { //비밀번호 검색 실패
				   request.setAttribute("msg", "비밀번호를 찾을 수 없습니다.");
				   request.setAttribute("url", "p_searchForm");
				   return "alert";
			   }
		   }
		   
		   
		   @RequestMapping("mVerify")
		   public String mverify(HttpServletRequest request,
					   HttpServletResponse response) {

			   return "main/mVerify";
		   }
		   
		   @RequestMapping("verify")
		   public String verify(HttpServletRequest request,
					   HttpServletResponse response) {
			   String myanswer = request.getParameter("verify");
			   HttpSession session = request.getSession();
			   String number = (String) session.getAttribute("number");
			   String pass = (String) session.getAttribute("pass");
			   
			   if(number.equals(myanswer)) {
				   request.setAttribute("msg", "인증에 성공하셨습니다. 비밀번호 = " + pass );
				   request.setAttribute("url", "login");
				   return "alert";
			   }else {
				   request.setAttribute("msg", "인증에 실패하셨습니다." );
				   request.setAttribute("url", "verify");
				   return "alert";
			   }
			
		   }
		   
		   @RequestMapping("id")
		   public String idSearch(HttpServletRequest request,
					   HttpServletResponse response) {
			      try {
			          request.setCharacterEncoding("UTF-8");
			       } catch (UnsupportedEncodingException e) {
			          e.printStackTrace();
			       }
			   String name = request.getParameter("name");
			   String email = request.getParameter("email");
			   String id = dao.searchId(name,email);
			   System.out.println(id);
			   if(id != null) {
				   request.setAttribute("msg", "id = " + id );
				   request.setAttribute("url", "login");
				   return "alert";
			   }else {
				   request.setAttribute("msg", "등록된 회원정보가 없습니다." );
				   request.setAttribute("url", "id_searchForm");
				   return "alert";
			   }
		   }
		   
		   public final class MyAuthenticator extends Authenticator {
			     private String id;
			     private String pw;
			     public MyAuthenticator(String id, String pw) {
			         this.id = id;
			         this.pw = pw;
			     }
			     protected PasswordAuthentication getPasswordAuthentication() {
			         return new PasswordAuthentication(id, pw);
			     }
			 }
		   
		   public String passwordLoginCheck(HttpServletRequest request,
				   HttpServletResponse response) {
				String login = (String)request.getSession().getAttribute("login");
				if(login == null || login.trim().equals("")) {
					request.setAttribute("msg", "로그인 하세요");
					request.setAttribute("url", "loginForm");
					return "openeralert";
				}
			   return null;
		   }
		   
		   @RequestMapping("passwordForm")
		   @MSLogin("passwordLoginCheck")
		   public String passwordForm(HttpServletRequest request,
				   HttpServletResponse response) {
				String login = (String)request.getSession().getAttribute("login");
				if(login == null || login.trim().equals("")) {
					request.setAttribute("msg", "로그인 하세요");
					request.setAttribute("url", "login");
					return "openeralert";
				}
			   return "member/passwordForm";
		   }
	/*
	   1. 로그인한 사용자의 비밀번호 변경만 가능.=> 로그인부분 검증
	      로그아웃상태 : 로그인 하세요 메세지 출력후 
	                  opener 창을 loginForm 페이지로 이동. 현재페이지 닫기
	      =>passwordLoginCheck 메소드의 기능             
	   2. 파라미터 저장 (pass,chgpass)
	   3. 비밀번호 검증 : 현재비밀번호로 비교
	      비밀번호 오류 : 비밀번호 오류 메세지 출력 후 현재페이지를 passwordForm로 이동                
	   4. db에 비밀번호 수정
	       boolean MemberDao.updatePass(id,변경비밀번호)
	       - 수정성공 : 성공메세지 출력 후
	                 opener 페이지 info로 이동.현재 페이지 닫기
	       - 수정실패 : 수정실패 메세지 출력 후 현재 페이지 닫기      
	 */
		   @RequestMapping("password")
		   @MSLogin("passwordLoginCheck") //1
		   public String password(HttpServletRequest request,
				   HttpServletResponse response) {
			   //2
			   String pass = request.getParameter("pass");
			   String chgpass = request.getParameter("chgpass");
			   //3
			   Integer id = (Integer) request.getSession().getAttribute("login");
			   User user = dao.selectOne(id);
			   if(pass.equals(user.getPassword())) {//비밀번호가 맞는 경우
				   if(dao.updatePass(id, chgpass)) { //비밀번호 수정 완료
					   request.setAttribute("msg", "비밀번호가 변경되었습니다.");
					   request.setAttribute("url", "logout");
					   return "alert";
				   } else { //비밀번호 수정 실패
					   StringBuilder sb = new StringBuilder();
					   sb.append("alert('비밀번호 수정시 오류가 발생했습니다.');\n");
					   sb.append("self.close();");
					   request.setAttribute("script", sb.toString());
					   return "dumy"; //dumy.jsp 생성
				   }
			   } else {  //비밀번호 오류
				   request.setAttribute("msg","비밀번호가 틀렸습니다.");
				   request.setAttribute("url", "changePw");
				   return "alert";
			   }
		   }	   
		   
		   
}

