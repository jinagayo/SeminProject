package model.controller;

import java.util.Map;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.student.Student;
import model.student.StudentDao;
import model.user.User;

@WebServlet(urlPatterns= {"/student/*"},
initParams= {@WebInitParam(name="view",value="/view/student/")})
public class StudentController extends MskimRequestMapping{
	private StudentDao dao = new StudentDao();
	
	@RequestMapping("student-mypage-info") 
	public String MypageInfo(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		User user_std = dao.selectOne(id);
		Map<String, Object> student = dao.selectStudent(id);
		
		request.setAttribute("user_std", user_std); //user 테이블 정보
		request.setAttribute("std", student); //student 테이블 정보
		return "student-mypage-info";
	}
	@RequestMapping("student-mypage-grad") 
	public String MypageGrade(HttpServletRequest request,
			HttpServletResponse response) {
		return "student-mypage-grad";
	}
	@RequestMapping("student-mypage-time") 
	public String MypageTime(HttpServletRequest request,
			HttpServletResponse response) {
		return "student-mypage-time";
	}
	@RequestMapping("student-teach-personality") 
	public String TeachPerson(HttpServletRequest request,
			HttpServletResponse response) {
		return "student-teach-personality";
	}
	@RequestMapping("student-teach-practice") 
	public String TeachPractice(HttpServletRequest request,
			HttpServletResponse response) {
		return "student-teach-practice";
	}
	@RequestMapping("student-teach-info") 
	public String TeachInfo(HttpServletRequest request,
			HttpServletResponse response) {
		return "student-teach-info";
	}
	@RequestMapping("student-teach-service") 
	public String TeachService(HttpServletRequest request,
			HttpServletResponse response) {
		return "student-teach-service";
	}
	
	
}
