package model.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import gdu.mskim.MSLogin;
import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.attendance.Attendance;
import model.attendance.AttendanceDao;
import model.graduation.Graduation;
import model.graduation.GraduationDao;
import model.personality.Personality;
import model.personality.PersonalityDao;
import model.pratice.Practice;
import model.pratice.PracticeDao;
import model.service.Service;
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
	private PracticeDao pradao = new PracticeDao();
	private PersonalityDao perdao = new PersonalityDao();

	public String noticecheck(HttpServletRequest request, HttpServletResponse response ) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		System.out.println(id);
		if(id==null) {
			System.out.println("아이디가 널이다");
			request.setAttribute("msg", "접근 불가");
			System.out.println("메세지 입력");
			request.setAttribute("url", "/main/main");
			System.out.println("url 입력");
			return "/alert";
		}else {
			User user_std = dao.selectOne(id);
			if(user_std.getPosition()!=1) {
				request.setAttribute("msg", "접근 불가");
				request.setAttribute("url", "/main/main");
				return "/alert";
			}
			return null;
		}
	}

	@MSLogin("noticecheck")
	@RequestMapping("student-mypage-info") 
	public String MypageInfo(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		User user_std = dao.selectOne(id);
		Map<String, Object> student = dao.selectStudent(id);
		
		request.setAttribute("user_std", user_std); //user 테이블 정보
		request.setAttribute("std", student); //student 테이블 정보
		return "student-mypage-info";
	}
	@MSLogin("noticecheck")
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
	@MSLogin("noticecheck")
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
	

	@MSLogin("noticecheck")
	@RequestMapping("student-teach-practice") 
	public String TeachPractice(HttpServletRequest request,
			HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		Practice practice = pradao.selectparct(id);
		Teacher teacher = teadao.selectTeach(id);
		System.out.println(practice);
		if(practice!=null) {
			request.setAttribute("msg", "실습 일지 심사 중입니다");
			request.setAttribute("url", "student-teach-info" );
			
			return "alert";
		}else{
			if(teacher.isPracice()) {
				request.setAttribute("msg", "실습 일지가 통과 되었습니다");
				request.setAttribute("url", "student-teach-info" );
				
				return "alert";
				
			}
			return "student-teach-practice";
		}
		
	}
	@MSLogin("noticecheck")
	@RequestMapping("praticesubmit")
	public String praticesubmit(HttpServletRequest request,
			HttpServletResponse response) {
		String path=request.getServletContext().getRealPath("/")+"/upload/practice/";
		File f= new File(path);
		if(!f.exists()) f.mkdirs(); //폴더 생성.
		//mkdir() :  한단계 폴더만 생성
		//mkdirs() : 여러단계 폴더 생성
		int size=10*1024*1024;	//10M. 업로드 파일의 최대 크기
		MultipartRequest multi = null; //파일 업로드 클래스
		try {
			multi = new MultipartRequest(request,path,size,"UTF-8"); //파일 업롣,
		}catch(IOException e) {
			e.printStackTrace();
		}
		Integer id = (Integer) request.getSession().getAttribute("login");
		Practice practice = new Practice();
		practice.setStudno(id);
		practice.setActivename(multi.getParameter("activename"));
		practice.setDay(multi.getParameter("date"));
		practice.setContent(multi.getParameter("content"));
		practice.setEmotion(multi.getParameter("emotion"));
		practice.setFile1(multi.getFilesystemName("file1"));

		request.setAttribute("url", "student-teach-practice" );
		if(pradao.prasubmit(practice)) {
			request.setAttribute("msg", "일지가 등록되었습니다");
		}else {
			request.setAttribute("msg", "일지 등록 실패");	
		}
		System.out.println("파일 저장 경로: " + path);

		return "alert";
		
	}

	@MSLogin("noticecheck")
	@RequestMapping("student-teach-service") 
	public String TeachService(HttpServletRequest request,
			HttpServletResponse response) {
		return "student-teach-service";
	}

	@MSLogin("noticecheck")
	@RequestMapping("servicesubmit")
	public String servicesubmit(HttpServletRequest request,
			HttpServletResponse response) {      
		try {
		         request.setCharacterEncoding("UTF-8");
		      } catch (UnsupportedEncodingException e) {
		         e.printStackTrace();
		      }
		Integer id = (Integer) request.getSession().getAttribute("login");
		Service service = new Service();
		service.setStudno(id);
		service.setServicename(request.getParameter("servicename"));
		service.setGroupname(request.getParameter("groupname"));
		service.setDay(request.getParameter("date"));
		int time= Integer.parseInt(request.getParameter("time"));
		service.setTime(time);
		service.setContent(request.getParameter("content"));
		service.setEmotion(request.getParameter("emotion"));

		request.setAttribute("url", "student-teach-service" );
		if(pradao.servsubmit(service)) {
			request.setAttribute("msg", "일지가 등록되었습니다");
		}else {
			request.setAttribute("msg", "일지 등록 실패");	
		}
		return "alert";
		
	}
	

	@MSLogin("noticecheck")
	@RequestMapping("student-teach-personality") 
	public String TeachPerson(HttpServletRequest request,
			HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		Personality person = perdao.selectper(id);
		Teacher teacher = teadao.selectTeach(id);
		System.out.println(person);
		if(person!=null) {
			request.setAttribute("msg", "제출 완료 되었습니다");
			request.setAttribute("url", "student-teach-info" );
			
			return "alert";
		}else{
			if(teacher.isPersonsubmit()) {
				request.setAttribute("msg", "심사 완료 되었습니다");
				request.setAttribute("url", "student-teach-info" );
				
				return "alert";
				
			}
			return "student-teach-personality";
		}
		
	}

	@MSLogin("noticecheck")
	@RequestMapping("persubmit")
	public String persubmit(HttpServletRequest request,
			HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		Student student = dao.selectStu(id);
		Personality person = new Personality();
		person.setStudno(id);
		person.setProfno(student.getProfno());
		person.setSelf1(Integer.parseInt(request.getParameter("num1")));
		person.setSelf2(Integer.parseInt(request.getParameter("num2")));
		person.setSelf3(Integer.parseInt(request.getParameter("num3")));
		
		request.setAttribute("url","student-teach-personality");

		if(perdao.persubmit(person)) {
			request.setAttribute("msg", "등록되었습니다");
		}else {
			request.setAttribute("msg", "등록 실패");	
		}
		
		return "alert"; 
			
	}

	@MSLogin("noticecheck")
	@RequestMapping("student-teach-info") 
	public String TeachInfo(HttpServletRequest request,
			HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		Teacher teach_info = teadao.selectTeach(id);
		
		request.setAttribute("teacher", teach_info);
		
		return "student-teach-info";
	}
}
