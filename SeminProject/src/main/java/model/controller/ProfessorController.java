package model.controller;
import java.util.Map;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.professor.ProfessorDao;
import model.user.User;

@WebServlet(urlPatterns= {"/professor/*"},
initParams= {@WebInitParam(name="view",value="/view/professor/")})

public class ProfessorController extends MskimRequestMapping {
	private ProfessorDao dao = new ProfessorDao();
	
	@RequestMapping("professor-mypage-info")
	public String MypageInfo(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		User user_prof = dao.selectOne(id);
		Map<String, Object> professor = dao.selectProfessor(id);
		
		request.setAttribute("user_prof", user_prof); //user 테이블 정보
		request.setAttribute("prof", professor); //professor 테이블 정보
		System.out.println(professor);
		return "professor-mypage-info";
	}
	
	@RequestMapping("professor-mypage-time") 
	public String MypageTime(HttpServletRequest request,
			HttpServletResponse response) {
		return "professor-mypage-time";
	}
}


