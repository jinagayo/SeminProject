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

import com.oreilly.servlet.MultipartRequest;

import gdu.mskim.MSLogin;
import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.admin.AdminDao;
import model.major.Major;
import model.major.MajorDao;
import model.practice.Practice;
import model.practice.PracticeDao;
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
	private MajorDao major_dao = new MajorDao();
	
	//관리자체크
	public String noticecheck(HttpServletRequest request, HttpServletResponse response ) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		String path = request.getContextPath();
		if(id==null) {
			System.out.println("아이디가 널이다");
			request.setAttribute("msg", "접근 불가");
			System.out.println("메세지 입력");
			request.setAttribute("url", path+"/main/main");
			System.out.println("url 입력");
			return "/alert";
		}else {
			User user_std = user_dao.selectOne(id);
			if(user_std.getPosition()!=3) {
				request.setAttribute("msg", "접근 불가");
				request.setAttribute("url", path+"/main/main");
				return "/alert";
			}
			return null;
		}
	}
	


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
	
	//학생 정보
	@RequestMapping("pictureForm")
	public String pictureForm(HttpServletRequest request,HttpServletResponse response) {
		return "pictureForm";
	}

	@RequestMapping("picture")
	public String pircture(HttpServletRequest request,HttpServletResponse response) {
		String path=request.getServletContext().getRealPath("")+"picture/" ;
		String fname=null ;
		File f = new File(path) ;	//업로드 되는 폴더 정보
		if(!f.exists()) f.mkdir() ;//폴더 생성
		MultipartRequest multi =null ;
		try {
			multi= new MultipartRequest(request,path,10*1024*1024,"UTF-8") ;
		}catch(IOException e) {
			e.printStackTrace() ;
		}
		fname=multi.getFilesystemName("picture") ;
		request.setAttribute("fname", fname) ;
	    System.out.println("업로드된 파일명: " + fname);  
		return "picture";
	}
	//학생 정보
	@MSLogin("noticecheck")
	@RequestMapping("studentInfo")
	public String adminStudentInfo(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("studno"));
		User user_std = user_dao.selectOne(id);
		Map<String, Object> student = dao.selectStudent(id);
		
		
		request.setAttribute("user_std", user_std); //user 테이블 정보
		request.setAttribute("std", student); //student 테이블 정보
		return "studentInfo";
	}
	@RequestMapping("updateStudentForm")
	public String updateStudent(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("studno"));
		User user=dao.selectOne(id);
		Map<String, Object> student = dao.selectStudent(id);
		List<Major> college = major_dao.allccode();
		List<Major> major = major_dao.allMajor();
		request.setAttribute("major", major);
		request.setAttribute("college", college);
		request.setAttribute("user_std", user);
		request.setAttribute("std", student);
		
	
		return "updateStudentForm";
	}

	@RequestMapping("updateStudent")
	public String update(HttpServletRequest request, HttpServletResponse response) {     
		try {
	        request.setCharacterEncoding("UTF-8");
	     } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	     }
		int id = Integer.parseInt(request.getParameter("studno") ); // 
		User user = new User();
		Student student = new Student();
		String name = request.getParameter("name") ;
		String email = request.getParameter("email") ;
		int mcode =Integer.parseInt( request.getParameter("major")) ;
		int grade = Integer.parseInt(request.getParameter("grade") );
		String phone = request.getParameter("phone") ;
		String address = request.getParameter("address") ;
		user.setName(name);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setName(name);
		user.setId(id);
		user.setImg(request.getParameter("img")) ;
		student.setMcode(mcode);
		student.setGrade(grade);
		student.setStudno(id);
		if(user_dao.updateUser(user)&&dao.updateStudent(student)) {
			request.setAttribute("msg", "수정 완료");
			request.setAttribute("url", "studentInfo?studno="+user.getId());
		}else {
			request.setAttribute("msg", "수정 실패");
			request.setAttribute("url", "updateStudentForm?studno="+user.getId());
			
		}
		return "alert" ;
	}

	
	// 학생 등록
	@MSLogin("noticecheck")
	@RequestMapping("studentInsert")
	public String adminStudentInsert(HttpServletRequest request,HttpServletResponse response){
		
		return "studentInsert";
	}
	@MSLogin("noticecheck")
	@RequestMapping("studentInsertaction")
	public String adminStudentInsertaction(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String path=request.getServletContext().getRealPath("/")+"/picture/";
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
		User user = new User();
		Student std = new Student();
		String msg = "";
		String url = "";
		
		String name = multi.getParameter("name");
		String birth = multi.getParameter("birth");
		String phone = multi.getParameter("phone");
		String  address = multi.getParameter("address");
		String email = multi.getParameter("email");
		String entry = multi.getParameter("entry");
		String majorcode = multi.getParameter("majorcode");
		String profcode = multi.getParameter("profcode");
		String file1 = multi.getFilesystemName("file1");
		
		if(entry == null || majorcode == null||file1==null) {
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
		user.setImg(file1);
		
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
	@MSLogin("noticecheck")
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
		
		//한 페이지에 보여줄 개수
		int pagesize = 10;
		//페이지파라미터가없으면 현재페이지  1
		String pageNumStr = request.getParameter("pageNum");
		int pageNum = 1;
		
		if (pageNumStr != null && !pageNumStr.trim().equals("")) {
		    try {
		        pageNum = Integer.parseInt(pageNumStr);
		    } catch (NumberFormatException e) {
		    	e.printStackTrace();
		    }
		}
		
		
	    //현재 페이지에서 가지고올 데이터의 시작 행
		int startRow = (pageNum-1)*pagesize;
		
		param.put("select", select);
		param.put("keyword", keyword);
		param.put("startRow", startRow);
		param.put("pagesize", pagesize);
		
		if(keyword != null && !keyword.trim().equals("")) { //검색이 존재
			map = admin_dao.list(param);
		}else {
			map = admin_dao.list(param);	//검색어 존재 안할때
		}
		
		int totalpage = admin_dao.studentCount(param);
		int maxpage = (int)(totalpage + pagesize -1) / pagesize;//3.9
	    // 현재 페이지가 포함될 시작 페이지 번호
	    int startpage = ((pageNum - 1) / 10) * 10 + 1;
	    // 현재 페이지가 포함될 끝 페이지 번호
	    int endpage = startpage + 9;
	    if (endpage > maxpage) endpage = maxpage;
		
	    request.setAttribute("list", map);
		request.setAttribute("pageNum", pageNum);//현재페이지
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("maxpage", maxpage);
		return "studentList";
	}
	
	
	
	//교수 등록
	@MSLogin("noticecheck")
	@RequestMapping("professorInsert")
	public String professorInsert(HttpServletRequest request,HttpServletResponse response) {
		return "professorInsert";
	}
	@MSLogin("noticecheck")
	@RequestMapping("professorInsertaction")
	public String adminProfessorInsert(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String path=request.getServletContext().getRealPath("/")+"/picture/";
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
		User user = new User();
		Professor pro = new Professor();
		String msg = "";
		String url = "";
		

		
		String name = multi.getParameter("name");
		String birth = multi.getParameter("birth");
		String phone = multi.getParameter("phone");
		String address = multi.getParameter("address");
		String email = multi.getParameter("email");
		String major = multi.getParameter("majorcode");
		String sub = multi.getParameter("subcode");
		String img = multi.getFilesystemName("file1");
						
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
		user.setImg(img);
		
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

	@RequestMapping("updateProfessorForm")
	public String updateProfessorForm(HttpServletRequest request,HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("profno"));
		User user=user_dao.selectOne(id);
		Map<String, Object> professor = pro_dao.selectProfessor(id);
		List<Major> college = major_dao.allccode();
		List<Major> major = major_dao.allMajor();
		System.out.println(professor);
		System.out.println(user);
		
		request.setAttribute("major", major);
		request.setAttribute("college", college);
		request.setAttribute("user", user);
		request.setAttribute("prof", professor);
		
	
		return "updateProfessorForm";
	}

	@RequestMapping("updateProfessor")
	public String updateProfessor(HttpServletRequest request, HttpServletResponse response) {     
		System.out.println("1updateProfessor==================");
		try {
	        request.setCharacterEncoding("UTF-8");
	     } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	     }
		int id= Integer.parseInt(request.getParameter("profno"));
		System.out.println(id);
		User user = new User();
		Professor professor = new Professor();
		String name = request.getParameter("name") ;
		String email = request.getParameter("email") ;
		String major = request.getParameter("major");
		int mcode;
		if(major ==null||major.equals("")) {
			Map<String, Object> prof = pro_dao.selectProfessor(id);
			mcode=(int) prof.get("mcode");
		}else {
			 mcode =Integer.parseInt( request.getParameter("major")) ;
			
		}
		System.out.println(mcode);
		String phone = request.getParameter("phone") ;
		String birth = request.getParameter("birth") ;
		String address = request.getParameter("address") ;
		user.setName(name);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setBirth(birth);
		user.setName(name);
		user.setId(id);
		user.setImg(request.getParameter("img")) ;
		professor.setMcode(mcode);
		professor.setProfno(id);
		if(user_dao.updateUser(user)&&pro_dao.updateProfessor(professor)) {
			request.setAttribute("msg", "수정 완료");
			request.setAttribute("url", "professorInfo?profno="+user.getId());
		}else {
			request.setAttribute("msg", "수정 실패");
			request.setAttribute("url", "updateStudentForm?studno="+user.getId());
			
		}
		return "alert" ;
	}

	//교수 리스트
	@MSLogin("noticecheck")
	@RequestMapping("professorList")
	public String adminProfessorList(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String select = request.getParameter("select");
		String keyword = request.getParameter("searchList");
		
		//한 페이지에 보여줄 개수
		int pagesize = 10;
		//페이지파라미터가없으면 현재페이지  1
		String pageNumStr = request.getParameter("pageNum");
		int pageNum = 1;
		
		if (pageNumStr != null && !pageNumStr.trim().equals("")) {
		    try {
		        pageNum = Integer.parseInt(pageNumStr);
		    } catch (NumberFormatException e) {
		    	e.printStackTrace();
		    }
		}
		
	    //현재 페이지에서 가지고올 데이터의 시작 행
		int startRow = (pageNum-1)*pagesize;
		List<Map<String, Object>> map;
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("select", select);
		param.put("keyword", keyword);
		param.put("startRow", startRow);
		param.put("pagesize", pagesize);
		
		if(keyword != null && !keyword.trim().equals("")) { //검색이 존재
			map = admin_dao.listPrno(param);
		}else {
			map = admin_dao.listPrno(param);	//검색어 존재 안할때
		}
		
		int totalpage = admin_dao.professorCount(param);
		int maxpage = (int)(totalpage + pagesize -1) / pagesize;
	    // 현재 페이지가 포함될 시작 페이지 번호
	    int startpage = ((pageNum - 1) / 10) * 10 + 1;
	    // 현재 페이지가 포함될 끝 페이지 번호
	    int endpage = startpage + 9;
	    if (endpage > maxpage) endpage = maxpage;
		
	    request.setAttribute("list", map);
		request.setAttribute("pageNum", pageNum);//현재페이지
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("maxpage", maxpage);
		return "professorList";
	}
	
	//교수정보
	@MSLogin("noticecheck")
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
	@MSLogin("noticecheck")
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
	@MSLogin("noticecheck")
	@RequestMapping("subjectList")
	public String adminSubjectList(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String select = request.getParameter("select");
		String keyword = request.getParameter("searchList");
		
		//한 페이지에 보여줄 개수
		int pagesize = 10;
		//페이지파라미터가없으면 현재페이지  1
		String pageNumStr = request.getParameter("pageNum");
		int pageNum = 1;
		
		if (pageNumStr != null && !pageNumStr.trim().equals("")) {
		    try {
		        pageNum = Integer.parseInt(pageNumStr);
		    } catch (NumberFormatException e) {
		    	e.printStackTrace();
		    }
		}
		
	    //현재 페이지에서 가지고올 데이터의 시작 행
		int startRow = (pageNum-1)*pagesize;
		
		List<Map<String, Object>> map;
		Map<String, Object> param = new HashMap<String, Object>();
		
		param.put("select", select);
		param.put("keyword", keyword);
		param.put("startRow", startRow);
		param.put("pagesize", pagesize);
		
		if(keyword != null && !keyword.trim().equals("")) {
			map = sub_dao.listSubject(param);
		}else {
			map = sub_dao.listSubject(param);
		}
		int totalpage = admin_dao.subjectCount(param);
		System.out.println("totalpage " + totalpage);
		int maxpage = (int)(totalpage + pagesize -1) / pagesize;
	    // 현재 페이지가 포함될 시작 페이지 번호
	    int startpage = ((pageNum - 1) / 10) * 10 + 1;
	    // 현재 페이지가 포함될 끝 페이지 번호
	    int endpage = startpage + 9;
	    if (endpage > maxpage) endpage = maxpage;
		
	    request.setAttribute("list", map);
		request.setAttribute("pageNum", pageNum);//현재페이지
		request.setAttribute("endpage", endpage);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("maxpage", maxpage);
		return "subjectList";
	}
	
	//교육 실습 일지
	@MSLogin("noticecheck")
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
	@MSLogin("noticecheck")
	@RequestMapping("serviceList")
	public String adminServiceList(HttpServletRequest request,HttpServletResponse response) {		
		List<Map<String, Object>> map = ser_dao.ServiceList();
		request.setAttribute("list", map);
		return "serviceList";
	}
	
	//교육봉사 리스트
	@MSLogin("noticecheck")
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