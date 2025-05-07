package model.controller;

import java.io.IOException;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	    if (user == null || id != user.getId() || !pass.equals(user.getPassword())) {
	        request.setAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
	        request.setAttribute("url", "login");
	        return "alert";
	    }else {
	    	request.setAttribute("msg", user.getName()+"님 로그인되었습니다.");
	        request.setAttribute("url", "main");
	        request.getSession().setAttribute("login", id); // 세션에 아이디 등록
	        return "alert";
	    }
	}
	
	//로그아웃
	@RequestMapping("logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		return "redirect:main";
	}
}
