package model.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import gdu.mskim.MSLogin;
import gdu.mskim.MskimRequestMapping;
import gdu.mskim.RequestMapping;
import model.board.Board;
import model.board.BoardDao;
import model.comment.Comment;
import model.comment.CommentDao;
import model.student.StudentDao;
import model.subject.Subject;
import model.subject.SubjectDao;
import model.user.User;
import model.user.UserDao;

@WebServlet(urlPatterns= {"/board/*"},
initParams= {@WebInitParam(name="view",value="/view/board/")})
public class BoardController extends MskimRequestMapping{
	private BoardDao boardDao = new BoardDao();
	private StudentDao stuDao = new StudentDao();
	private UserDao userDao= new UserDao();
	private SubjectDao subDao = new SubjectDao();
	private CommentDao comDao = new CommentDao();
	
	public String noticecheck(HttpServletRequest request, HttpServletResponse response ) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		System.out.println(id);
		if(id==null) {
			request.setAttribute("msg", "접근 불가");
			request.setAttribute("url", "/main/main");
			return "/alert";
		}else {
			User user_std = userDao.selectOne(id);
			if(user_std.getPosition()!=3) {
				request.setAttribute("msg", "접근 불가");
				request.setAttribute("url", "/main/main");
				return "/alert";
			}
			return null;
		}
	}
	
	public String noticecheck2(HttpServletRequest request, HttpServletResponse response ) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		System.out.println(id);
		if(id==null) {
			request.setAttribute("msg", "접근 불가");
			request.setAttribute("url", "/main/main");
			return "/alert";
		}else {
			User user_std = userDao.selectOne(id);
			if(user_std.getPosition()!=2) {
				request.setAttribute("msg", "접근 불가");
				request.setAttribute("url", "/main/main");
				return "/alert";
			}
			return null;
		}
	}

	@RequestMapping("boardlayout") 
	public String boardlayout(HttpServletRequest request,HttpServletResponse response) {
		return "boardlayout";
	}

	@RequestMapping("notice") 
	public String Notice(HttpServletRequest request,HttpServletResponse response) {
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
				
		int limit=10; //페이지당 출력되는 게시물의 건수
		int boardcount=boardDao.MainboardCount(pageNum,limit,column,find);
		List<Board> list= boardDao.Mainlist(pageNum,limit,column,find);
		int maxpage =(int)((double)boardcount/limit +0.95);
		int startpage=((int)(pageNum/10.0+0.9)-1)*10+1;
		int endpage=startpage+9;
		if(endpage>maxpage) endpage=maxpage;
		String boardName="알림마당";
		request.setAttribute("boardName", boardName); //개시판 일믐
		request.setAttribute("boardCount", boardcount); 
				
		request.setAttribute("pageNum", pageNum); //현페
		request.setAttribute("list", list);//현재페이지에 출력할 겜시물 목록
		request.setAttribute("startpage", startpage);//페이지 시작번호
		request.setAttribute("endpage", endpage); //페이지의 마지막 번호
		request.setAttribute("maxpage", maxpage);//페이지 최대번호
				
		//boardnum : 보여주기 위한 번호
		request.setAttribute("boardName", boardName);
		request.setAttribute("today", new Date());
		Integer id = (Integer) request.getSession().getAttribute("login");
		if(id!=null) {
			User user_std = userDao.selectOne(id);
			request.setAttribute("user", user_std);
			
		}
		
				
				return "notice";
		
	}
	@MSLogin("noticecheck")
	@RequestMapping("writeForm") 
	public String writeForm(HttpServletRequest request,HttpServletResponse response) {
		return "writeForm";
	}
	
	@MSLogin("noticecheck2")
	@RequestMapping("p_writeForm") 
	public String p_writeForm(HttpServletRequest request,HttpServletResponse response) {
		String boardid=request.getParameter("boardid");
		String subcode=request.getParameter("subcode");
		request.setAttribute("boardid", boardid);
		return "p_writeForm";
	}

	@RequestMapping("s_writeForm") 
	public String s_writeForm(HttpServletRequest request,HttpServletResponse response) {
		String boardid=request.getParameter("boardid");
		String subcode=request.getParameter("subcode");
		request.setAttribute("boardid", boardid);
		return "s_writeForm";
	}
	

	@MSLogin("noticecheck")
	@RequestMapping("write")
	public String write(HttpServletRequest request, HttpServletResponse response ) {
		//파일업로드 되는 폴더 설정
		String path=request.getServletContext().getRealPath("/")+"/upload/board/";
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
		//파라미터 값 저장
		Board board = new Board();
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setFile1(multi.getFilesystemName("file1")); //업로드 된 파일이름
		System.out.println(multi.getParameter("content"));
		//시스템에서 필요한 정보를 저장
		String boardid =(String)request.getSession().getAttribute("boardid");
		if(boardid==null) boardid="1"; //공지사항 기본 게시판 설정
		board.setBoardid(boardid); //게시판 종류 : 1. 공지사항, 2:자유게시판
		if(board.getFile1()==null) board.setFile1(""); //업로드 파일이 없는 경우
		int num = boardDao.maxnum();
		board.setNum(++num);	//게시글의 키값. 게시글 번호.
		String msg="게시물 등록 실패";
		String url="writeForm";
		if(boardDao.insert(board)) { //게시글 등록 성공
			return "redirect:notice";
		}
		//게시글 등록 실패
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		return "alert";
	}
	
	@MSLogin("noticecheck2")
	@RequestMapping("write2")
	public String write2(HttpServletRequest request, HttpServletResponse response ) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		User user= userDao.selectOne(id);
		String path=request.getServletContext().getRealPath("/")+"/upload/subjectnotice/";
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

		
		if(boardDao.writeboard(board)) {
			request.setAttribute("msg", "등록되었습니다.");
			request.setAttribute("url", "../professor/professor-subject-Mboard?subcode="+subcode+"&boardid="+boardid);
			
		}else {
			request.setAttribute("msg", "등록실패.");
			request.setAttribute("url", "redirect:../professor/professor-subject-Mboard?subcode="+subcode+"&boardid="+boardid);
			
		}
		return "alert";
	}

	
	@RequestMapping("write3")
	public String write3(HttpServletRequest request, HttpServletResponse response ) {
		Integer id = (Integer) request.getSession().getAttribute("login");
		User user= userDao.selectOne(id);
		String path=request.getServletContext().getRealPath("/")+"/upload/subjectQ&A/";
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

		
		if(boardDao.writeboard(board)) {
			request.setAttribute("msg", "등록되었습니다.");
			request.setAttribute("url", "../student/student-subject-board?subcode="+subcode+"&boardid="+boardid);
			
		}else {
			request.setAttribute("msg", "등록실패.");
			request.setAttribute("url", "redirect:../student/student-subject-board?subcode="+subcode+"&boardid="+boardid);
			
		}
		return "alert";
	}
	

	@RequestMapping("info")
	public String info(HttpServletRequest request, HttpServletResponse response ) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board board;
		Integer id = (Integer) request.getSession().getAttribute("login");
		if(id!=null) {
			User user_std = userDao.selectOne(id);
			request.setAttribute("user", user_std);
			
		}
		try {
			board = BoardDao.getBoard(num);
			request.setAttribute("b", board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //num의 게시물 데이터 저장
		return "info";
	}
	
	@RequestMapping("p_info")
	public String p_info(HttpServletRequest request, HttpServletResponse response ) {
	
		Integer id =(Integer)request.getSession().getAttribute("login");
		String num = request.getParameter("num");
		Board board = boardDao.selectOne(Integer.parseInt(num));
		Subject subject = subDao.selectSubject(Integer.toString(board.getSubcode()));
		User user = userDao.selectOne(id);
		request.setAttribute("b", board);
		request.setAttribute("s", subject);
		request.setAttribute("u", user);
		List<Comment> commentlist= comDao.list(num) ;
		request.setAttribute("commlist", commentlist) ;
		return "p_info";
	}

	
	@RequestMapping("s_info")
	public String s_info(HttpServletRequest request, HttpServletResponse response ) {
	
		Integer id =(Integer)request.getSession().getAttribute("login");
		String num = request.getParameter("num");
		Board board = boardDao.selectOne(Integer.parseInt(num));
		Subject subject = subDao.selectSubject(Integer.toString(board.getSubcode()));
		User user = userDao.selectOne(id);
		request.setAttribute("b", board);
		request.setAttribute("s", subject);
		request.setAttribute("u", user);
		List<Comment> commentlist= comDao.list(num) ;
		request.setAttribute("commlist", commentlist) ;
		return "s_info";
	}
	

	@MSLogin("noticecheck")
	@RequestMapping("updateForm")
	public String updateForm(HttpServletRequest request, HttpServletResponse response ) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board b = BoardDao.getBoard(num);
		request.setAttribute("b", b);
		
		return "updateForm";
	}
	
	@MSLogin("noticecheck2")
	@RequestMapping("p_updateForm")
	public String p_updateForm(HttpServletRequest request, HttpServletResponse response ) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board b = BoardDao.getBoard(num);
		Subject subject = subDao.selectSubject(Integer.toString(b.getSubcode()));
		System.out.println(subject);
		request.setAttribute("s", subject);
		request.setAttribute("b", b);
		
		return "p_updateForm";
	}

	

	@RequestMapping("s_updateForm")
	public String s_updateForm(HttpServletRequest request, HttpServletResponse response ) {
		int num = Integer.parseInt(request.getParameter("num"));
		Board b = BoardDao.getBoard(num);
		Subject subject = subDao.selectSubject(Integer.toString(b.getSubcode()));
		System.out.println(subject);
		request.setAttribute("s", subject);
		request.setAttribute("b", b);
		
		return "s_updateForm";
	}


	   @RequestMapping("update")
	   public String update(HttpServletRequest request,HttpServletResponse response) {
	      String path = request.getServletContext().getRealPath("/") + "/upload/board";
	      Integer id = (Integer) request.getSession().getAttribute("login");
		  Integer subcode = Integer.parseInt(request.getParameter("subcode"));
		  Integer boardid = Integer.parseInt(request.getParameter("boardid"));
		  Integer num = Integer.parseInt(request.getParameter("num"));
		  User user_std = userDao.selectOne(id);
		   
	      File f= new File(path);
	      String msg = "";
	      String url = "";
	         
	      if(!f.exists()) f.mkdirs();
	      int size = 10*1024*1024;
	      MultipartRequest multi = null;
	      try {
	         multi = new MultipartRequest(request, path,size,"UTF-8");
	      }catch(IOException e) {
	         e.printStackTrace();
	      }
	      //1. 파라미터 정보를 Board 객체에 저장 => request 객체 사용 불가
	      Board board = new Board();
	      board.setNum(Integer.parseInt(multi.getParameter("num")));
	      board.setWriter(multi.getParameter("writer"));
	      board.setTitle(multi.getParameter("title"));
	      board.setContent(multi.getParameter("content"));
	      board.setFile1(multi.getParameter("file1"));
	      
	      //비밀번호 검증: 비밀번호 오류 시 메세지 출력 후 updateForm 페이지 이동
	      Board bdo = boardDao.selectOne(board.getNum());
	      //첨부파일 수정 안됨
	      if(board.getFile1()==null || board.getFile1().equals("")) {
	         //이전 첨부 파일을 유지
	         board.setFile1(multi.getParameter("file2"));
	      }

	      if(boardDao.update(board)) {   //수정 성공
	         msg = "게시글 수정 성공";
	         if(user_std.getPosition()==3) {
	         url = "info?num=" + board.getNum();
	         }else if(user_std.getPosition()==2){
	        	 url="p_info?boardid="+boardid+"&subcode="+subcode+"&num="+num;
	         }else {
	        	 url="s_info?boardid="+boardid+"&subcode="+subcode+"&num="+num;
	         }
	      }else { //수정실패
	         msg = "게시글 수정 실패";
	         url = "updateForm";
	      }
	      
	      
	      request.setAttribute("msg", msg);
	      request.setAttribute("url", url);
	      return "alert";
	   }
	   
	   @RequestMapping("delete")
	   public String delete(HttpServletRequest request,HttpServletResponse response) {
		   Integer id = (Integer) request.getSession().getAttribute("login");
		   Integer subcode = Integer.parseInt(request.getParameter("subcode"));
		   Integer boardid = Integer.parseInt(request.getParameter("boardid"));
		   User user_std = userDao.selectOne(id);
			int num = Integer.parseInt(request.getParameter("num"));
			Board board= BoardDao.getBoard(num);
			String msg , url;
			if(!boardDao.delete(board)) {
				msg="삭제 실패.";
				url="deleteForm?num="+num;
			}else {
				msg="삭제되었습니다.";
				if(user_std.getPosition()==3) {
				url="notice";
				}
				else{
					url="../professor/professor-subject-Mboard?boardid="+boardid+"&subcode="+subcode;
				}
			}
		System.out.println("delete 함수 실행됨");
		request.setAttribute("msg", msg);
		request.setAttribute("url",url);
			return "alert";
	   }
	   
	   @RequestMapping("comment")
		public String comment(HttpServletRequest request,HttpServletResponse response) {
		      try {
		          request.setCharacterEncoding("UTF-8");
		       } catch (UnsupportedEncodingException e) {
		          e.printStackTrace();
		       }
				Integer id =(Integer)request.getSession().getAttribute("login");
				Integer subcode = Integer.parseInt(request.getParameter("subcode"));
				Integer boardid = Integer.parseInt(request.getParameter("boardid"));
			   Comment comm = new Comment() ;
			   User user =userDao.selectOne(id);
			   comm.setNum2(Integer.parseInt(request.getParameter("num")));
			   comm.setContent(request.getParameter("content")) ;
			   comm.setWriter(user.getName());
			   int seq =comDao.maxseq(comm.getNum2()) ;
			   comm.setSeq(++seq) ;
			   if(comDao.insert(comm)) {
				   if(user.getPosition()==1) {

					   return "redirect:s_info?num="+comm.getNum2()+"&boardid="+boardid+"&subcode="+subcode;
				   }else {

					   return "redirect:p_info?num="+comm.getNum2()+"&boardid="+boardid+"&subcode="+subcode;
				   }
				   

			   }
			   request.setAttribute("msg", "답글 등록시 오류 발생") ;
			   request.setAttribute("url", "p_info?num="+comm.getNum2()+"&readcnt=f") ;
			   return "alert";
	
}
}