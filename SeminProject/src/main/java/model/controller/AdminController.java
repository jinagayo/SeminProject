package model.controller;

import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.admin.AdminDao;
import model.student.Student;
import model.student.StudentDao;
import model.user.User;
import model.user.UserDao;

@WebServlet(urlPatterns= {"/admin/*"},
initParams= {@WebInitParam(name="view",value="/view/admin/")})
public class AdminController extends MskimRequestMapping {
	private StudentDao dao = new StudentDao();
	private UserDao user_dao = new UserDao();
	private AdminDao admin_dao = new AdminDao();
	
	//학번 랜덤생성
	public String StudentId(String entry, String majorcode) {
	    int random = (int)(Math.random() * 900) + 100;
	    return entry + majorcode + random;
	}
	
	@RequestMapping("studentInfo")
	public String adminStudentInfo(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		User user_std = user_dao.selectOne(id);
		Map<String, Object> student = dao.selectStudent(id);
		
		
		request.setAttribute("user_std", user_std); //user 테이블 정보
		request.setAttribute("std", student); //student 테이블 정보
		return "studentInfo";
	}
	
	// 학생 등록
	@RequestMapping("studentInsert")
	public String adminStudentInsert(HttpServletRequest request,HttpServletResponse response) {
		User user = new User();
		Student std = new Student();
		
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String  address = request.getParameter("address");
		String email = request.getParameter("email");
		String entry = request.getParameter("entry");
		String majorcode = request.getParameter("majorcode");
		String profcode = request.getParameter("profcode");
		//학번 랜덤 생성번호
		if(entry == null || majorcode == null) {
			return "studentInsert";
		}
		int r_stdno = Integer.parseInt(StudentId(entry, majorcode));
		user.setId(r_stdno);
		user.setName(name);
		user.setBirth(birth);
		user.setPhone(phone);
		user.setAddress(address);
		user.setEmail(email);
		user.setPosition(1);
		
		std.setStudno(r_stdno);
		std.setEntry(entry);
		std.setProfno(Integer.parseInt(profcode));
		std.setMcode(Integer.parseInt(majorcode));
		
		if(admin_dao.insertUser(user) && admin_dao.insertStudent(std)) {
			request.setAttribute("msg", "학생등록이 완료되었습니다.");
			request.setAttribute("url", "studentInfo");
		}
		else {
			request.setAttribute("msg", "학생 등록 중 오류가 발생했습니다.");
			request.setAttribute("url", "studentInsert");
		}
		return "alert";
	}
}
