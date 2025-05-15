package model.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.admin.AdminDao;
import model.pratice.Practice;
import model.pratice.PracticeDao;
import model.professor.Professor;
import model.professor.ProfessorDao;
import model.service.Service;
import model.service.ServiceDao;
import model.student.Student;
import model.student.StudentDao;
import model.subject.Subject;
import model.subject.SubjectDao;
import model.teacher.Teacher;
import model.teacher.TeacherDao;
import model.user.User;
import model.user.UserDao;

@WebServlet(urlPatterns= {"/admin/*"},
initParams= {@WebInitParam(name="view",value="/view/admin/")})
public class AdminController extends MskimRequestMapping {
	private StudentDao dao = new StudentDao();
	private UserDao user_dao = new UserDao();
	private AdminDao admin_dao = new AdminDao();
	private ProfessorDao pro_dao = new ProfessorDao();
	private SubjectDao sub_dao = new SubjectDao();
	private PracticeDao pra_dao = new PracticeDao();
	private TeacherDao tea_dao = new TeacherDao();
	private ServiceDao ser_dao = new ServiceDao();
	
	//학번 랜덤생성
	public String StudentId(String entry, String majorcode) {
	    int random = (int)(Math.random() * 900) + 100;
	    return entry + majorcode + random;
	}
	
	//교수번호 랜덤 생성
	public String ProfessorNo() {
		int random = (int)(Math.random() * 9000) + 1000;
		return random + "";
	}
	
	
	@RequestMapping("studentInfo")
	public String adminStudentInfo(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("studno"));
		User user_std = user_dao.selectOne(id);
		Map<String, Object> student = dao.selectStudent(id);
		
		
		request.setAttribute("user_std", user_std); //user 테이블 정보
		request.setAttribute("std", student); //student 테이블 정보
		return "studentInfo";
	}
	
	// 학생 등록
	@RequestMapping("studentInsert")
	public String adminStudentInsert(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		User user = new User();
		Student std = new Student();
		String msg = "";
		String url = "";
		
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String  address = request.getParameter("address");
		String email = request.getParameter("email");
		String entry = request.getParameter("entry");
		String majorcode = request.getParameter("majorcode");
		String profcode = request.getParameter("profcode");
		
		if(entry == null || majorcode == null) {
			return "studentInsert";
		}
		
		//학번 랜덤 생성번호
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
			msg = "학생등록이 완료되었습니다.";
			url = "studentList";
		}
		else {
			msg = "학생등록중 오류가 발생했습니다.";
			url = "studentInsert";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "alert";
	}
	
	//학생 리스트
	@RequestMapping("studentList")
	public String adminStudentList(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String select = request.getParameter("select");
		String keyword = request.getParameter("searchList");
		
		List<Map<String, Object>> map;
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("select", select);
		param.put("keyword", keyword);
		
		if(keyword != null && !keyword.trim().equals("")) { //검색이 존재
			map = admin_dao.list(param);
		}else {
			map = admin_dao.list(null);	//검색어 존재 안할때
		}
		request.setAttribute("list", map);
		return "studentList";
	}
	
	
	
	//교수 등록
	@RequestMapping("professorInsert")
	public String adminProfessorInsert(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		User user = new User();
		Professor pro = new Professor();
		String msg = "";
		String url = "";
		

		
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String major = request.getParameter("majorcode");
		String sub = request.getParameter("subcode");
						
	    if(name == null || birth == null || phone == null || address == null || email == null || major == null || sub == null) {
	        return "professorInsert";
	    }
	    
		//교수번호 랜덤생성
		int r_profno = Integer.parseInt(ProfessorNo());
	    
		user.setId(r_profno);
		user.setName(name);
		user.setBirth(birth);
		user.setPhone(phone);
		user.setAddress(address);
		user.setEmail(email);
		user.setPosition(2);
		
		pro.setProfno(r_profno);
		pro.setSub(sub);
		pro.setMcode(Integer.parseInt(major));
		
		
		if(admin_dao.insertUser(user) && admin_dao.insertProfessor(pro)) {
			msg = "교수 등록이 완료되었습니다.";
			url = "professorList";
		}
		else {
			msg = "교수 등록중 오류가 발생했습니다.";
			url = "professorInsert";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "alert";
	}
	
	//교수 리스트
	@RequestMapping("professorList")
	public String adminProfessorList(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String select = request.getParameter("select");
		String keyword = request.getParameter("searchList");
		
		List<Map<String, Object>> map;
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("select", select);
		param.put("keyword", keyword);
		
		if(keyword != null && !keyword.trim().equals("")) { //검색이 존재
			map = admin_dao.listPrno(param);
		}else {
			map = admin_dao.listPrno(null);	//검색어 존재 안할때
		}
		request.setAttribute("list", map);
		return "professorList";
	}
	
	//교수정보
	@RequestMapping("professorInfo")
	public String adminProfessorInfo(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("profno"));
		
		User user_pro = user_dao.selectOne(id);
		Map<String, Object> prof = pro_dao.selectProfessor(id);
		System.out.println("prof"+prof);
		
		
		request.setAttribute("user_pro", user_pro); //user 테이블 정보
		request.setAttribute("pro", prof); //professor 테이블 정보
		return "professorInfo";
	}
	
	//강의 개설
		@RequestMapping("subjectInsert")
		public String adminSubjectInsert(HttpServletRequest request,HttpServletResponse response) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
			Subject sub = new Subject();
			String msg = "";
			String url = "";
			
			String subcode = request.getParameter("subcode");
			String subname = request.getParameter("subname");
			String time = request.getParameter("time");
			String starttime = request.getParameter("starttime");
			String day = request.getParameter("day");
			String location = request.getParameter("location");
			String profno = request.getParameter("profno");
			String[] teachsub = request.getParameterValues("teachsub");
			
			
			
			if(subcode == null) {
				return "subjectInsert";
			}
			
			sub.setSubcode(Integer.parseInt(subcode));
			sub.setSubname(subname);
			sub.setTime(Integer.parseInt(time));
			sub.setStarttime(Integer.parseInt(starttime));
			sub.setDay(Integer.parseInt(day));
			sub.setLocation(location);
			sub.setProfno(Integer.parseInt(profno));
			
			if(teachsub[0].equals("1")) {
				sub.setTeachsub(true);
			}
			else {
				sub.setTeachsub(false);
			}
			
			System.out.println("sub"+sub);
			
			if(sub_dao.insertSubject(sub)) {
				msg = "강의 개설이 완료되었습니다.";
				url = "subjectList";
			}
			else {
				msg = "강의 개설 중 오류가 발생했습니다.";
				url = "subjectInsert";
			}
			request.setAttribute("msg", msg);
			request.setAttribute("url", url);
			return "alert";
	}
	
		
	//전체 강의 조회
	@RequestMapping("subjectList")
	public String adminSubjectList(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String select = request.getParameter("select");
		String keyword = request.getParameter("searchList");
		
		List<Map<String, Object>> map;
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("select", select);
		param.put("keyword", keyword);
		
		if(keyword != null && !keyword.trim().equals("")) {
			map = sub_dao.listSubject(param);
		}else {
			map = sub_dao.listSubject(null);
		}
		request.setAttribute("list", map);
		return "subjectList";
	}
	
	//교육 실습 일지
	@RequestMapping("practiceList")
	public String adminPraticeList(HttpServletRequest request,HttpServletResponse response) {		
		List<Map<String, Object>> map = pra_dao.listPratice();
		request.setAttribute("list", map);
		return "practiceList";
	}

	@RequestMapping("practiceInfo")
	public String adminPraticeInfo(HttpServletRequest request,HttpServletResponse response) {
		try {
        request.setCharacterEncoding("UTF-8");
     } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
     }
		int id = Integer.parseInt(request.getParameter("studno"));
		System.out.println(id);
		User user= user_dao.selectOne(id);
		Practice pra= pra_dao.InfoPracticeOne(id);
		request.setAttribute("user", user);
		request.setAttribute("list", pra);
		System.out.println("pra 출력:"+pra);
			
		
		return "practiceInfo";
	}
	@RequestMapping("practiceaccept")
	public String practiceaccept(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("studno"));
		String accept = request.getParameter("accept");
		
		if(accept.equals("1")) {
			if(tea_dao.teacherUpdate(id,accept)){
				request.setAttribute("msg", "등록 되었습니다.");
				request.setAttribute("url", "practiceList");
			}else {
				request.setAttribute("msg", "등록 실패.");
				request.setAttribute("url", "practiceInfo?studno="+id);
				
			}
		}else {
			if(pra_dao.praciceDelete(id)||tea_dao.teacherUpdate(id,accept)) {
				request.setAttribute("msg", "등록 되었습니다.");
				request.setAttribute("url", "practiceList");
			}else {
				request.setAttribute("msg", "등록 실패.");
				request.setAttribute("url", "practiceInfo?studno="+id);
				
			}
		}
		
		return "alert";
	}
	//교육 봉사
	@RequestMapping("serviceList")
	public String adminServiceList(HttpServletRequest request,HttpServletResponse response) {		
		List<Map<String, Object>> map = ser_dao.ServiceList();
		request.setAttribute("list", map);
		return "serviceList";
	}
	
	//교육봉사 리스트
	@RequestMapping("serviceInfo")
	public String adminServiceInfo(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("studno"));
		Service service = ser_dao.serviceInfo(id);
		User user = user_dao.selectOne(id);
		request.setAttribute("service", service);
		request.setAttribute("user", user);
		return "serviceInfo";
	}
	@RequestMapping("serviceaccept")
	public String serviceaccept(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("studno"));
		int time = Integer.parseInt(request.getParameter("time"));
		String accept = request.getParameter("accept");
		System.out.println("accept:"+accept);
		
		if(accept.equals("1")) {
			boolean delete =ser_dao.deleteservice(id);
			if(tea_dao.serviceUpdate(id,time)||delete){
				request.setAttribute("msg", "등록 되었습니다.");
				request.setAttribute("url", "serviceList");
			}else {
				request.setAttribute("msg", "등록 실패.");
				request.setAttribute("url", "ServiceInfo?studno="+id);
				
			}
		}else {
			if(ser_dao.deleteservice(id)) {
				request.setAttribute("msg", "등록 되었습니다.");
				request.setAttribute("url", "serviceList");
			}else {
				request.setAttribute("msg", "등록 실패.");
				request.setAttribute("url", "ServiceInfo?studno="+id);
				
			}
		}
		
	
		return "alert";
	}

	
}