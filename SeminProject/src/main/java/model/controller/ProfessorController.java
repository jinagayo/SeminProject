package model.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import java.util.Collections;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import model.board.Board;
import model.board.BoardDao;

import model.comment.Comment;
import model.comment.CommentDao;

import model.graduation.Graduation;
import model.graduation.GraduationDao;
import model.personality.Personality;
import model.personality.PersonalityDao;
import model.professor.ProfessorDao;
import model.student.Student;
import model.student.StudentDao;
import model.subject.Subject;
import model.subject.SubjectDao;
import model.teacher.TeacherDao;
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
	private PersonalityDao pdao = new PersonalityDao();
	private BoardDao boadao = new BoardDao();
	private CommentDao commdao = new CommentDao();
	private TeacherDao teadao = new TeacherDao(); 
	
	public String noticecheck(HttpServletRequest request, HttpServletResponse response ) {
		Integer id = (Integer) request.getSession().getAttribute("login");

		if(id==null) {
			request.setAttribute("msg", "로그인 후 접근가능합니다.");
			request.setAttribute("url", "/main/login");
			return "openeralert";
		}else {
			User user_std = dao.selectOne(id);
			if(user_std.getPosition()!=2) {
				request.setAttribute("msg", "접근권한이 없습니다.");
				request.setAttribute("url", "/main/main");
				return "openeralert";
			}
			return null;
		}
	}

	@MSLogin("noticecheck")
	@RequestMapping("professor-mypage-info")
	public String MypageInfo(HttpServletRequest request,HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		User user_prof = dao.selectOne(id);
		Map<String, Object> professor = dao.selectProfessor(id);
		
		String path = request.getServletContext().getRealPath("") + "picture/";
		request.setAttribute("path",path);
		request.setAttribute("user_prof", user_prof); //user 테이블 정보
		request.setAttribute("prof", professor); //professor 테이블 정보
		return "professor-mypage-info";
	}
	
	@MSLogin("noticecheck")
	@RequestMapping("professor-mypage-time") 
	public String MypageTime(HttpServletRequest request,
			HttpServletResponse response) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		
		List<Subject> lcodeList = subdao.selectLcode(id);
		request.setAttribute("lcodeList", lcodeList);
		
		List<Subject>  sub_info = new ArrayList<Subject>();
		
		if(lcodeList != null && !lcodeList.isEmpty()) {
			List<Integer> subcodes = lcodeList.stream()
	                .map(Subject::getSubcode)
	                .collect(Collectors.toList());
			if(!subcodes.isEmpty()) {
				sub_info = subdao.selectSub(subcodes);
			}
		}
		
		//List<Subject>  sub_info = subdao.selectSub(subcodes);
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
	
	@MSLogin("noticecheck")
	@RequestMapping("professor-student-manage") 
	public String StudentManage(HttpServletRequest request,
			HttpServletResponse response) {
	    Integer id = (Integer) request.getSession().getAttribute("login");

	    // 1. 페이지 관련 설정
	    int pagesize = 10;
	    String pageNumStr = request.getParameter("pageNum");
	    int pageNum = (pageNumStr != null && !pageNumStr.trim().equals("")) ? Integer.parseInt(pageNumStr) : 1;
	    int startRow = (pageNum - 1) * pagesize;

	    // 2. 쿼리 파라미터 준비
	    Map<String, Object> param = new HashMap<>();
	    param.put("id", id);
	    param.put("startRow", startRow);
	    param.put("pagesize", pagesize);

	    // 3. 페이징된 학생 목록 조회
	    List<Student> studentList = stddao.selectStudentIdPage(param);
	    request.setAttribute("studentList", studentList);

	    System.out.println("stdList"+studentList);
	    
	    // 4. 학생의 studno만 추출
	    List<Integer> studno = studentList.stream()
	            .map(Student::getStudno)
	            .collect(Collectors.toList());
	    
	    if (studentList == null || studentList.isEmpty()) {
	        request.setAttribute("studentList", Collections.emptyList());
	        request.setAttribute("user", Collections.emptyList());
	        request.setAttribute("pageNum", 1);
	        request.setAttribute("startpage", 1);
	        request.setAttribute("endpage", 1);
	        request.setAttribute("maxpage", 1);
	        return "professor-student-manage";
	    }

	    List<User> user_info = userdao.selectMany(studno);
	    request.setAttribute("user", user_info);

	    // 5. 전체 학생 수 계산
	    int total = stddao.countProfessorStudents(id);
	    int maxpage = (int)((total + pagesize - 1) / pagesize);
	    int startpage = ((pageNum - 1) / 10) * 10 + 1;
	    int endpage = Math.min(startpage + 9, maxpage);

	    request.setAttribute("pageNum", pageNum);
	    request.setAttribute("startpage", startpage);
	    request.setAttribute("endpage", endpage);
	    request.setAttribute("maxpage", maxpage);

	    return "professor-student-manage";
	}
	
	@MSLogin("noticecheck")
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
		List<Personality> plist = pdao.selectPersonalities();
		request.setAttribute("plist", plist);
		return "professor-student-info";
	}
	
	@MSLogin("noticecheck")
	@RequestMapping("professor-myclass")
	public String MyClass(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		Integer id = (Integer) request.getSession().getAttribute("login");

		List<Subject>sublist = subdao.selectPsubject(id);
		request.setAttribute("sublist",sublist);
		ArrayList countQA = new ArrayList();
		for (Subject i : sublist) {
		    int x = boadao.countQA(i);
		    countQA.add(x);
		}
		request.setAttribute("countQA",countQA);
		return "professor-myclass";
	}
	
	@MSLogin("noticecheck")
	@RequestMapping("professor-classHome")	
	public String ClassHome(HttpServletRequest request,HttpServletResponse response) {
		String sub = request.getParameter("subcode");
		request.setAttribute("subcode",sub);
		Subject subject =  subdao.selectSubject(sub);
		request.setAttribute("subject",subject);
		return "professor-classHome";
	}
	
	@MSLogin("noticecheck")
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
	
	@MSLogin("noticecheck")
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
	
	@MSLogin("noticecheck")
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
	
	@MSLogin("noticecheck")
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
	
	@MSLogin("noticecheck")
	@RequestMapping("professor-Ckpersonality")	
	public String Ckpersonality(HttpServletRequest request,HttpServletResponse response) {
		String id = request.getParameter("studno");
		Integer studno = Integer.parseInt(id);
		request.setAttribute("studno",studno);
		return "professor-Ckpersonality";
	}
	
	@MSLogin("noticecheck")
	@RequestMapping("persubmit")
	public String persubmit(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("studno");
		Integer studno = Integer.parseInt(id);
		Personality p = pdao.selectPersonality(studno);

		p.setProf1(Integer.parseInt(request.getParameter("num1")));
		p.setProf2(Integer.parseInt(request.getParameter("num2")));
		p.setProf3(Integer.parseInt(request.getParameter("num3")));
		
		request.setAttribute("url","professor-Ckpersonality?studno="+studno);

		if(pdao.perChek(p)&&teadao.updatePersonYN(studno)) {
			request.setAttribute("msg", "등록되었습니다");
		}else {
			request.setAttribute("msg", "등록 실패");	
		}
		
		return "alert"; 
			
	}
	
	@MSLogin("noticecheck")
	@RequestMapping("professor-subject-board")
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
		Integer boardid = 1;
		String subcode = request.getParameter("subcode");
		
		int limit=10; //페이지당 출력되는 게시물의 건수
		int boardcount=boadao.subBoardCount2(boardid,subcode,pageNum,limit);
		List<Board> list= boadao.subbBoardlist2(boardid,subcode,pageNum,limit);
		System.out.println("board1: " + list);
		int maxpage =(int)((double)boardcount/limit +0.95);
		int startpage=((int)(pageNum/10.0+0.9)-1)*10+1;
		int endpage=startpage+9; //화면에 출력한 마지막 페이지번호.한 화면에 10개의 페이지번호 출력
		//endpage는 maxpageq보다 작거나 같아야함.
		if(endpage>maxpage) endpage=maxpage;
		String boardName="공지사항";
		
		request.setAttribute("boardName", boardName); //개시판 일믐
		request.setAttribute("boardCount", boardcount); //게시판별 전체 게시물 건수
		request.setAttribute("boardid", boardid); //게시판 종류. 게시판 코드.
		request.setAttribute("subcode", subcode);
		
		request.setAttribute("pageNum", pageNum); //현페
		request.setAttribute("list", list);//현재페이지에 출력할 게시물 목록
		request.setAttribute("startpage", startpage);//페이지 시작번호
		request.setAttribute("endpage", endpage); //페이지의 마지막 번호
		request.setAttribute("maxpage", maxpage);//페이지 최대번호
		
		//boardnum : 보여주기 위한 번호
		request.setAttribute("boardName", boardName);
		request.setAttribute("today", new Date());
		return "professor-subject-board";
	
	}
	
	@MSLogin("noticecheck")
	@RequestMapping("professor-subject-board2")
	public String subBoard(HttpServletRequest request,
			HttpServletResponse response) {
		 try {
	         request.setCharacterEncoding("UTF-8");
	      } catch (UnsupportedEncodingException e) {
	         e.printStackTrace();
	      }
		int pageNum=1;
		try {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}catch(NumberFormatException e) {}
		
		Integer boardid = 2;
		String subcode = request.getParameter("subcode");
		
		int limit=10; //페이지당 출력되는 게시물의 건수
		int boardcount=boadao.subBoardCount3(boardid,subcode,pageNum,limit);
		List<Board> list= boadao.subbBoardlist3(boardid,subcode,pageNum,limit);
		System.out.println("board2: " + list);
		int maxpage =(int)((double)boardcount/limit +0.95);
		int startpage=((int)(pageNum/10.0+0.9)-1)*10+1;
		int endpage=startpage+9; //화면에 출력한 마지막 페이지번호.한 화면에 10개의 페이지번호 출력
		//endpage는 maxpageq보다 작거나 같아야함.
		if(endpage>maxpage) endpage=maxpage;
		String boardName="Q&A";
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
		
		return "professor-subject-board2";
	}
	

	
	
	
	@RequestMapping("professor-subject-Mboard")
	public String subMBoard(HttpServletRequest request,
			HttpServletResponse response) {
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
		request.setAttribute("boardCount", boardcount); //게시판별 전체 게시물 건수
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
		
		return "professor-subject-Mboard";
	}
	@RequestMapping("professor-subject-board2")
	public String subBoard2(HttpServletRequest request,
			HttpServletResponse response) {
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
		
		return "professor-subject-board";
	}
	

	@RequestMapping("professor-subject-board-info")
	public String subBoardInfo(HttpServletRequest request,
			HttpServletResponse response) {
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
		return "professor-subject-board-info";
	}
	
	@RequestMapping("professor-subject-Mboard-info")
	public String subMBoardInfo(HttpServletRequest request,
			HttpServletResponse response) {
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
		return "professor-subject-Mboard-info";
	}
	
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
			   return "redirect:professor-subject-board-info?num="+comm.getNum2()+"&readcnt=f" ;
		   }
		   request.setAttribute("msg", "답글 등록시 오류 발생") ;
		   request.setAttribute("url", "p_info?num="+comm.getNum2()+"&readcnt=f") ;
		   return "alert";
	}
	
	@RequestMapping("pictureForm") 
	public String pictureForm (HttpServletRequest request,
			   HttpServletResponse response) {
		
		return "pictureForm";
	}
	
	/*
	   1. request 객체로 이미지 업로드 불가 => cos.jar  
	   2. 이미지 업로드 폴더 : 현재폴더/picture 설정 
	   3. opener 화면에 이미지 볼수 있도록 결과 전달 => javascript
	   4. 현재 화면 close 하기                   => javascript
	 */
	   @RequestMapping("picture")
	   public String picture (HttpServletRequest request,
			   HttpServletResponse response) {
		   String path = request.getServletContext().getRealPath("") + "picture/";
		   String fname = null;
		   File f = new File(path); //업로드되는 폴더 정보
		   System.out.println(f);
		   if(!f.exists()) f.mkdirs(); //폴더 생성
		   MultipartRequest multi = null;
		   try {
	     	multi =   new MultipartRequest(request,path, 10*1024*1024,"utf-8");
		   } catch (IOException e) {
			   e.printStackTrace();
		   }
		   fname = multi.getFilesystemName("picture"); //선택된 파일의 이름
		   request.setAttribute("fname", fname);
		   Integer id = (Integer) request.getSession().getAttribute("login");
		   userdao.updatePicture(id, fname); // DB에 사진 파일명 저장
		
		   return "picture";
	   }
}


