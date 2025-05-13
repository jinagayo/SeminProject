package model.controller;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.attendance.Attendance;
import model.attendance.AttendanceDao;
import model.graduation.Graduation;
import model.graduation.GraduationDao;
import model.professor.ProfessorDao;
import model.student.Student;
import model.student.StudentDao;
import model.subject.Subject;
import model.subject.SubjectDao;
import model.user.User;
import model.user.UserDao;

@WebServlet(urlPatterns= {"/professor/*"},
initParams= {@WebInitParam(name="view",value="/view/professor/")})

public class ProfessorController extends MskimRequestMapping {
	private ProfessorDao dao = new ProfessorDao();
	private SubjectDao subdao = new SubjectDao();
	private StudentDao stddao = new StudentDao();
	private UserDao userdao = new UserDao();
	private GraduationDao graddao = new GraduationDao();
	private AttendanceDao attdao = new AttendanceDao();
	
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
		Integer id = (Integer) request.getSession().getAttribute("login");
		
		List<Subject> lcodeList = subdao.selectLcode(id);
		request.setAttribute("lcodeList", lcodeList);
		List<Integer> subcodes = lcodeList.stream()
                .map(Subject::getSubcode)
                .collect(Collectors.toList());
		
		List<Subject>  sub_info = subdao.selectSub(subcodes);
		request.setAttribute("sub", sub_info);
		
	    String[] time = new String[10];
	    int[] count = {5,5,5,5,5,5,5,5,5,5};
	    for(int i=0;i<10;i++) {
			time[i]="<td>"+(i+9)+":00</td>";
			    	for(int j=2;j<=6;j++) {
				    	for(Subject sub : sub_info) {
				    		if(sub.getDay()==j&&sub.getStarttime()==(i+9)) {
				    			time[i]+="<td rowspan="+sub.getTime()+">"
				    		+sub.getSubname()+"<hr>"+(i+9)+":00~"+(i+9+sub.getTime())+":00<hr>"+sub.getLocation()+"</td>";
				    			for(int k=(i+1);k<=(i+sub.getTime()-1);k++) {
				    				--count[k];
				    			}
				    			count[i]--;
				    		}
				    	}
				    if(count[i]>0) {
				    	time[i]+="<td></td>";
				    	count[i]--;
				    }
			    	
	    		}
	    
			
		}
	    request.setAttribute("time", time);
		
		return "professor-mypage-time";
	}
	
	@RequestMapping("professor-student-manage") 
	public String StudentManage(HttpServletRequest request,
			HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		
		List<Student> studentList = stddao.selectStudentId(id);
		request.setAttribute("studentList",studentList);
		List<Integer> studno = studentList.stream()
				.map(Student::getStudno)
				.collect(Collectors.toList());
		
		List<User> user_info = userdao.selectMany(studno);
		request.setAttribute("user",user_info);
		
		return "professor-student-manage";
	}
	
	@RequestMapping("professor-student-info")
	public String MypageInfo2(HttpServletRequest request,HttpServletResponse response) {
		String studno = request.getParameter("studno");
		int id = Integer.parseInt(studno);
		Student student = stddao.pickStudent(id);
		request.setAttribute("student", student);	
		User user_s = dao.selectOne(id);
		request.setAttribute("user_s", user_s);
		Graduation graduation = graddao.selectGrad(id);
		request.setAttribute("gradu", graduation);
		Map<String, Object> major = stddao.selectStudent(id);
		request.setAttribute("m",major);
		return "professor-student-info";
	}
	
	@RequestMapping("professor-myclass")
	public String MyClass(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		List<Subject>sublist = subdao.selectPsubject(id);
		request.setAttribute("sublist",sublist);
		return "professor-myclass";
	}
	
	@RequestMapping("professor-classHome")	
	public String ClassHome(HttpServletRequest request,HttpServletResponse response) {
		String sub = request.getParameter("subcode");
		Subject subject =  subdao.selectSubject(sub);
		request.setAttribute("subject",subject);
		return "professor-classHome";
	}
	

	@RequestMapping("professor-CkAtt")	
	public String CkAtt(HttpServletRequest request,HttpServletResponse response) {
		String sub = request.getParameter("subcode");
		request.setAttribute("subcode",sub);
		Integer subcode = Integer.parseInt(sub);
		List<Student> studentlist = attdao.select_sub_stdno(subcode);
		request.setAttribute("studentlist", studentlist);
		List<Integer> stdnos = studentlist.stream()
                .map(Student::getStudno)
                .collect(Collectors.toList());
		
		List<User> std_list = userdao.selectMany(stdnos);
		request.setAttribute("std_list", std_list);
		
		List<Attendance> att = attdao.fixatt(subcode);
		request.setAttribute("att",att);
		
		
		return "professor-CkAtt";
	}
	
	@RequestMapping("professor-CkAtt-fix")	
	public String CkAttFix(HttpServletRequest request,HttpServletResponse response) {
		String[] values = request.getParameterValues("att");
		Integer subcode = Integer.parseInt(values[1].substring(11));
		Integer[] id = new Integer[values.length];
		Integer[] att = new Integer[values.length];
		for(int i=0; i<values.length; i++) {
			id[i] =  Integer.parseInt(values[i].substring(0, 8));
			att[i] = Integer.parseInt(values[i].substring(9,10));
		}
		for(int i=14; i<id.length; i+=15) {
			System.out.println(id[i]);
			System.out.println(subcode);
			Attendance attendance = attdao.selectAtt(id[i],subcode);
			attendance.setWEEK1(att[i-14]);
			attendance.setWEEK2(att[i-13]);
			attendance.setWEEK3(att[i-12]);
			attendance.setWEEK4(att[i-11]);
			attendance.setWEEK5(att[i-10]);
			attendance.setWEEK6(att[i-9]);
			attendance.setWEEK7(att[i-8]);
			attendance.setWEEK8(att[i-7]);
			attendance.setWEEK9(att[i-6]);
			attendance.setWEEK10(att[i-5]);
			attendance.setWEEK11(att[i-4]);
			attendance.setWEEK12(att[i-3]);
			attendance.setWEEK13(att[i-2]);
			attendance.setWEEK14(att[i-1]);
			attendance.setWEEK15(att[i-0]);
			
			boolean a = attdao.updateAttendance(attendance);
			System.out.println(a);
			
		}
		
		
		return "professor-CkAtt-fix";
	}
	
	@RequestMapping("professor-InGrade")	
	public String InGrade(HttpServletRequest request,HttpServletResponse response) {
		String sub = request.getParameter("subcode");
		request.setAttribute("subcode",sub);
		Integer subcode = Integer.parseInt(sub);
		List<Student> studentlist = attdao.select_sub_stdno(subcode);
		request.setAttribute("studentlist", studentlist);
		List<Integer> stdnos = studentlist.stream()
                .map(Student::getStudno)
                .collect(Collectors.toList());
		
		List<User> std_list = userdao.selectMany(stdnos);
		request.setAttribute("std_list", std_list);
		
		return "professor-InGrade";
	}
	
	@RequestMapping("professor-InGrade-fix")	
	public String InGradeFix(HttpServletRequest request,HttpServletResponse response) {
		String sub = request.getParameter("subcode");
		Integer subcode = Integer.parseInt(sub);
		String[] studnoList = request.getParameterValues("studno");
		String[] gradeList = request.getParameterValues("grade");
		for(int i=0; i<studnoList.length; i++) {
			int studno = Integer.parseInt(studnoList[i]);
			Attendance attendance = attdao.selectAtt(studno,subcode);
			attendance.setGrade(gradeList[i]);
			boolean a = attdao.updateGrade(attendance);
			System.out.println(a);
		}
		
		
		
		return "professor-InGrade-fix";
	}

}

