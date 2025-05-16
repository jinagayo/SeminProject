package model.controller;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.nio.file.spi.FileSystemProvider;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;

import gdu.mskim.MSLogin;
import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.attendance.Attendance;
import model.attendance.AttendanceDao;
import model.board.Board;
import model.board.BoardDao;
import model.comment.Comment;
import model.comment.CommentDao;
import model.graduation.Graduation;
import model.graduation.GraduationDao;
import model.history.History;
import model.history.HistoryDao;
import model.major.Major;
import model.major.MajorDao;

import model.personality.Personality;
import model.personality.PersonalityDao;
import model.practice.Practice;
import model.practice.PracticeDao;
import model.service.Service;

import model.service.ServiceDao;
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
	private ServiceDao serdao= new ServiceDao(); 
	private MajorDao majdao=new MajorDao();
	private BoardDao boadao=new BoardDao();
	private CommentDao commdao=new CommentDao();
	private HistoryDao his_dao = new HistoryDao();
	
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
		if(grad_info.getComcredit()>=130&&
			grad_info.getTeachcredit()>=30&&teach_info.isTeacherYN()){
				grad_info.setGraduation(true);
				graddao.updateGrad(grad_info);
					
				
			}
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
	    boolean[][] printed = new boolean[10][5]; // [시간][요일] -> true면 이미 rowspan으로 채워짐

	    for (int i = 0; i < 10; i++) {
	        time[i] = "<td>" + (i + 9) + ":00</td>";
	        int tdCount = 0;

	        for (int j = 2; j <= 6; j++) {
	            int dayIdx = j - 2; // 월~금 → 0~4

	            // 이전 시간에서 rowspan으로 이미 채워진 경우
	            if (printed[i][dayIdx]) continue;

	            boolean hasSubject = false;
	            for (Subject sub : sub_info) {
	                if (sub.getDay() == j && sub.getStarttime() == (i + 9)) {
	                    time[i] += "<td rowspan=" + sub.getTime() + ">" +
	                            sub.getSubname() + "<hr>" +
	                            (i + 9) + ":00~" + (i + 9 + sub.getTime()) + ":00<hr>" +
	                            sub.getLocation() + "</td>";
	                    hasSubject = true;

	                    // rowspan 동안 나머지 시간 칸에 대해 printed 처리
	                    for (int k = 1; k < sub.getTime(); k++) {
	                        if (i + k < 10)
	                            printed[i + k][dayIdx] = true;
	                    }
	                    break;
	                }
	            }

	            if (!hasSubject) {
	                time[i] += "<td></td>";
	            }

	            tdCount++;
	            if (tdCount == 5) break;
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
		if(teacher != null) {
			if(practice!=null) {
				request.setAttribute("msg", "실습 일지 심사 중입니다");
				request.setAttribute("url", "student-teach-info" );
				
				return "alert";
			}else{
				if(teacher.isPractice()) {
					request.setAttribute("msg", "실습 일지가 통과 되었습니다");
					request.setAttribute("url", "student-teach-info" );
					return "alert";
				}
			}
		}
		else {
			request.setAttribute("msg", "실습 일지가 존재하지 않습니다.");
			request.setAttribute("url", "student-teach-info" );
			return "alert";
		}
		return "student-teach-practice";
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
		Integer id = (Integer) request.getSession().getAttribute("login");
		Service service = serdao.serviceInfo(id);
		if(service!=null) {
			request.setAttribute("msg", "봉사 확인 중입니다");
			request.setAttribute("url", "student-teach-info" );
			
			return "alert";
		}
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
		String path=request.getServletContext().getRealPath("/")+"/upload/service/";
		File f= new File(path);
		if(!f.exists()) f.mkdirs(); 
		int size=10*1024*1024;	//10M. 업로드 파일의 최대 크기
		MultipartRequest multi = null; //파일 업로드 클래스
		try {
			multi = new MultipartRequest(request,path,size,"UTF-8"); //파일 업롣,
		}catch(IOException e) {
			e.printStackTrace();
		}
		Integer id = (Integer) request.getSession().getAttribute("login");
		Service service = new Service();
		service.setStudno(id);
		service.setServicename(multi.getParameter("servicename"));
		service.setGroupname(multi.getParameter("groupname"));
		service.setDay(multi.getParameter("date"));
		int time= Integer.parseInt(multi.getParameter("time"));
		service.setTime(time);
		service.setContent(multi.getParameter("content"));
		service.setEmotion(multi.getParameter("emotion"));
		service.setFile1(multi.getFilesystemName("file1"));

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

		if(teach_info.isPractice()&&teach_info.isPersonsubmit()&&teach_info.getService()>=8) {
			teach_info.setTeacherYN(true);
			teadao.updateTeach(teach_info);
				
			}
		request.setAttribute("teacher", teach_info);
		
		return "student-teach-info";
	}

	//내강의실
	@MSLogin("noticecheck")
	@RequestMapping("student-myclass")
	public String Myclass(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		List<Map<String,Object>> map = dao.MyclassInfo(id);
		System.out.println("stdmpa " + map);
		request.setAttribute("list", map);
		return "student-myclass";
	}
	//과목홈
	@RequestMapping("student-subject-home")
	public String SubjectHome(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		int code = Integer.parseInt(request.getParameter("code"));
	
		List<Map<String,Object>> map = dao.MyclassSubjectHome(code);
		System.out.println("map" + map);
		request.setAttribute("list", map);
		return "student-subject-home";
	}
	@MSLogin("noticecheck")
	@RequestMapping("student-class-application")
	public String classApplication(HttpServletRequest request,HttpServletResponse response) {
		 try {
	         request.setCharacterEncoding("UTF-8");
	      } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	      }
		int pageNum=1;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}catch(NumberFormatException e) {}
		
		String column = request.getParameter("column");
		String find = request.getParameter("find");
		
		if(column==null || column.trim().equals("") ||
				find==null || find.trim().equals("")) {
					column=null;
					find=null;
				
			}
			
		int limit=10;
		int classcount=subdao.classCount(pageNum,limit,column,find);
	
		List<Map<String,Object>> classList = subdao.selectall(pageNum,limit,column,find); 
		int maxpage =(int)((double)classcount/limit +0.95);
		int startpage=((int)(pageNum/10.0+0.9)-1)*10+1;
		int endpage=startpage+9;
		if(endpage>maxpage) endpage=maxpage;
		request.setAttribute("classcount", classcount);
		request.setAttribute("pageNum", pageNum); //현페
		request.setAttribute("startpage", startpage);//페이지 시작번호
		request.setAttribute("endpage", endpage); //페이지의 마지막 번호
		request.setAttribute("maxpage", maxpage);//페이지 최대번호
		
		request.setAttribute("classList", classList);
		return "student-class-application";
	}
	

	@MSLogin("noticecheck")
	@RequestMapping("applicate")
	public String applicate(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		List<Attendance> attendList = attdao.selectAttend(id);
		List<Integer> subcodes = attendList.stream()
                .map(Attendance::getSubcode)
                .collect(Collectors.toList());
		List<Subject>  sub_info = subdao.selectSub(subcodes);
		
		int applicode=Integer.parseInt(request.getParameter("subcode"));
		
		Subject subject = subdao.selectSubOne(applicode);
		for(Subject sub : sub_info) {
			if(sub.getDay()==subject.getDay()&&
					!(sub.getStarttime()>=(subject.getStarttime()+sub.getTime())
					||subject.getStarttime()>=(sub.getStarttime()+sub.getTime())	
							)) {
				request.setAttribute("msg", "선택한 시간대에 강의가 이미 존재합니다.");
				request.setAttribute("url", "student-class-application");
				return "alert";
			}
			}
		

		if(attdao.insertsub(subject.getSubcode(),id)) {
			request.setAttribute("msg", "수강신청 완료.");
			request.setAttribute("url", "student-class-application");
		}else {
			request.setAttribute("msg", "수강신청 실패.");
			request.setAttribute("url", "student-class-application");
			
		}
		return "alert";
	}

	@MSLogin("noticecheck")
	@RequestMapping("student-subject-board")
	public String subjectnotice(HttpServletRequest request,HttpServletResponse response) {
		 try {
	         request.setCharacterEncoding("UTF-8");
	      } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	      }
		int pageNum=1;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}catch(NumberFormatException e) {}
		String boardid = request.getParameter("boardid");
		String subcode = request.getParameter("subcode");
		
		if(boardid==null||boardid.trim().equals("")) {
			boardid="1"; //boardid 파라미터가 없는 경우 "1"
		}
		int limit=10; //페이지당 출력되는 게시물의 건수
		int boardcount=boadao.subBoardCount(boardid,subcode,pageNum,limit);
		List<Board> list= boadao.subbBoardlist(boardid,subcode,pageNum,limit);
		int maxpage =(int)((double)boardcount/limit +0.95);
		int startpage=((int)(pageNum/10.0+0.9)-1)*10+1;
		int endpage=startpage+9; //화면에 출력한 마지막 페이지번호.한 화면에 10개의 페이지번호 출력
		//endpage는 maxpageq보다 작거나 같아야함.
		if(endpage>maxpage) endpage=maxpage;
		String boardName="공지사항";
		if(boardid.equals("2"))
			boardName="Q&A";
		Subject subject = subdao.selectSubject(subcode);
		request.setAttribute("s", subject);
		request.setAttribute("boardName", boardName); //개시판 일믐
		request.setAttribute("boardCount", boardcount); //게시판별 전체 게시ㅜㄹ 건수
		request.setAttribute("boardid", boardid); //게시판 동류,ㅈ게시판 코드.
		request.setAttribute("subcode", subcode);
		
		request.setAttribute("pageNum", pageNum); //현페
		request.setAttribute("list", list);//현재페이지에 출력할 겜시물 목록
		request.setAttribute("startpage", startpage);//페이지 시작번호
		request.setAttribute("endpage", endpage); //페이지의 마지막 번호
		request.setAttribute("maxpage", maxpage);//페이지 최대번호
		
		//boardnum : 보여주기 위한 번호
		request.setAttribute("boardName", boardName);
		request.setAttribute("today", new Date());
		return "student-subject-board";
	
	}

	@MSLogin("noticecheck")
	@RequestMapping("student-subject-board-writeForm")
	public String subBoardWriteForm(HttpServletRequest request,HttpServletResponse response) {
		String boardid=request.getParameter("boardid");
		String subcode=request.getParameter("subcode");
		Subject subject =subdao.selectSubject(subcode);
		request.setAttribute("boardid", boardid);
		request.setAttribute("s", subject);
		return "student-subject-board-writeForm";
	}
	
	@MSLogin("noticecheck")
	@RequestMapping("student-subject-board-write")
	public String subBoardWrite(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		User user= dao.selectOne(id);
		String path=request.getServletContext().getRealPath("/")+"/upload/QNA/";
		File f= new File(path);
		if(!f.exists()) f.mkdirs(); 
		int size=10*1024*1024;	//10M. 업로드 파일의 최대 크기
		MultipartRequest multi = null; //파일 업로드 클래스
		try {
			multi = new MultipartRequest(request,path,size,"UTF-8"); //파일 업롣,
		}catch(IOException e) {
			e.printStackTrace();
		}
		String boardid= multi.getParameter("boardid");
		int subcode= Integer.parseInt(multi.getParameter("subcode"));
		
		Board board = new Board();
		board.setWriter(user.getName());
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setFile1(multi.getFilesystemName("file1"));
		board.setBoardid(boardid);
		board.setSubcode(subcode);

		
		if(boadao.writeboard(board)) {
			request.setAttribute("msg", "등록되었습니다.");
			request.setAttribute("url", "student-subject-board?subcode="+subcode+"&boardid="+boardid);
			
		}else {
			request.setAttribute("msg", "등록실패.");
			request.setAttribute("url", "redirect:student-subject-board?subcode="+subcode+"&boardid="+boardid);
			
		}
		return "alert";
	}
	@MSLogin("noticecheck")
	@RequestMapping("student-subject-board-info")
	public String subBoardInfo(HttpServletRequest request,HttpServletResponse response) {
		Integer id =(Integer)request.getSession().getAttribute("login");
		String num = request.getParameter("num");
		Board board = boadao.selectOne(Integer.parseInt(num));
		Subject subject = subdao.selectSubject(Integer.toString(board.getSubcode()));
		User user = dao.selectOne(id);
		request.setAttribute("b", board);
		request.setAttribute("s", subject);
		request.setAttribute("u", user);
		List<Comment> commentlist= commdao.list(num) ;
		request.setAttribute("commlist", commentlist) ;
		return "student-subject-board-info";
	}
	@MSLogin("noticecheck")
	@RequestMapping("comment")
	public String comment(HttpServletRequest request,HttpServletResponse response) {
	      try {
	          request.setCharacterEncoding("UTF-8");
	       } catch (UnsupportedEncodingException e) {
	          e.printStackTrace();
	       }
			Integer id =(Integer)request.getSession().getAttribute("login");
		   Comment comm = new Comment() ;
		   User user =dao.selectOne(id);
		   comm.setNum2(Integer.parseInt(request.getParameter("num")));
		   comm.setContent(request.getParameter("content")) ;
		   comm.setWriter(user.getName());
		   int seq =commdao.maxseq(comm.getNum2()) ;
		   comm.setSeq(++seq) ;
		   if(commdao.insert(comm)) {
			   return "redirect:student-subject-board-info?num="+comm.getNum2()+"&readcnt=f" ;
		   }
		   request.setAttribute("msg", "답글 등록시 오류 발생") ;
		   request.setAttribute("url", "info?num="+comm.getNum2()+"&readcnt=f") ;
		   return "alert";
	}
	
	//history
	@MSLogin("noticecheck")
	@RequestMapping("student-history")
	public String StudentHistor(HttpServletRequest request, HttpServletResponse response) {
	    try {
	        request.setCharacterEncoding("UTF-8");
	    } catch (UnsupportedEncodingException e) {
	        e.printStackTrace();
	    }

	    HttpSession session = request.getSession();
	    Map<String, Object> param = new HashMap<>();

	    String id = request.getParameter("studno");
	    int studno;

	    if (id != null && !id.isEmpty()) {
	        studno = Integer.parseInt(id);
	        session.setAttribute("studno", studno);
	    } else {
	        studno = (Integer) session.getAttribute("studno");
	    }
	    
	    param.put("studno", studno);

	    String year = request.getParameter("year-select");
	    String semester = request.getParameter("semester-select");
	    if (year != null && semester != null && !year.isEmpty() && !semester.isEmpty()) {
	        String fullYear = year + "-" + semester;
	        param.put("year", fullYear); 
	    }

	    List<Map<String, Object>> map = his_dao.selectHistory(param);
	    System.out.println("조회된 row 수: " + map.size());
	    
	    request.setAttribute("option", year);
	    request.setAttribute("semester", semester);
	    request.setAttribute("list", map);
	    return "student-history";
	}
}
