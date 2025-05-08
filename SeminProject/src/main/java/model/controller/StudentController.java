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
import model.student.Student;
import model.student.StudentDao;
import model.subject.Subject;
import model.subject.SubjectDao;
import model.teacher.Teacher;
import model.teacher.TeacherDao;
import model.user.User;

@WebServlet(urlPatterns= {"/student/*"},
initParams= {@WebInitParam(name="view",value="/view/student/")})
public class StudentController extends MskimRequestMapping{
	private StudentDao dao = new StudentDao();
	private GraduationDao graddao = new GraduationDao();
	private TeacherDao teadao = new TeacherDao();
	private SubjectDao subdao = new SubjectDao();
	private AttendanceDao attdao = new AttendanceDao();
	
	
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
		Integer id = (Integer) request.getSession().getAttribute("login");
		Graduation grad_info = graddao.selectGrad(id);
		Teacher teach_info = teadao.selectTeach(id);
		
		request.setAttribute("grad", grad_info);
		request.setAttribute("teach", teach_info);
		return "student-mypage-grad";
	}
	@RequestMapping("student-mypage-time") 
	public String MypageTime(HttpServletRequest request,
			HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		List<Attendance> attendList = attdao.selectAttend(id);
		request.setAttribute("attend", attendList);
		List<Integer> subcodes = attendList.stream()
                .map(Attendance::getSubcode)
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
