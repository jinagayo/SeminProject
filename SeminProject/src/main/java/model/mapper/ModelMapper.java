
package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import model.professor.Professor;
import model.student.Student;
import model.subject.Subject;
import model.attendance.Attendance;
import model.comment.Comment;
import model.graduation.Graduation;
import model.history.History;
import model.major.Major;
import model.personality.Personality;
import model.practice.Practice;
import model.service.Service;

import model.teacher.Teacher;
import model.user.User;
public interface ModelMapper {
	@Select("select * from user where id = #{id}")
	User selectOne(@Param("id")int id);
	
	@Select("SELECT s.tograde,s.entry,s.grade, m.mname AS major FROM student s JOIN major m ON s.mcode = m.mcode where s.studno = #{id}")
	Map<String, Object> selectStudent(@Param("id") int id);

	@Select("SELECT m.mname AS major FROM professor p JOIN major m ON p.mcode = m.mcode where p.profno = #{id}")
	Map<String, Object> selectProfessor(@Param("id") int id);

	@Select("SELECT * from graduation where studno= #{id}")
	Graduation selectGrad(Integer id);

	@Select("SELECT * from teacher where studno= #{id}")
	Teacher selectTeach(Integer id);

	@Select("SELECT subcode from attendance where studno= #{id}")
	List<Attendance> selectAttend(Integer id);
	
	@Select("SELECT subcode FROM subject sub JOIN professor p ON p.profno = sub.profno where p.profno = #{id}")
	List<Subject> selectLcode(Integer id);
	
	@Select(
			{
			    "<script>",
			    "SELECT * FROM subject",
			    "WHERE subcode IN",
			    "<foreach item='code' collection='list' open='(' separator=',' close=')'>",
			    "#{code}",
			    "</foreach>",
			    "</script>"
			})
	List<Subject> selectLecture(List<Integer> subcodes);
	
	@Select({
	    "<script>",
	    "SELECT * FROM subject",
	    "WHERE subcode IN",
	    "<foreach item='code' collection='list' open='(' separator=',' close=')'>",
	    "#{code}",
	    "</foreach>",
	    "</script>"
	})
	List<Subject> selectSub(List<Integer> subcodes);

	@Select("SELECT studno FROM student s JOIN professor p ON s.profno = p.profno where p.profno = #{id} ")
	List<Student> selectStudentId(int id);

	@Select({
	    "<script>",
	    "SELECT * FROM user",
	    "WHERE id IN",
	    "<foreach item='id' collection='list' open='(' separator=',' close=')'>",
	    "#{id}",
	    "</foreach>",
	    "</script>"
	})
	List<User> selectMany(List<Integer> studno);

	@Select("SELECT * FROM subject WHERE profno=#{id}")
	List<Subject> selectPsubject(int id);

	@Select("SELECT * FROM student WHERE studno = #{id}")
	Student pickStudent(int id);

	@Select("SELECT * FROM subject WHERE subcode=#{sub}")
	Subject selectSubject(String sub);

	@Select("SELECT studno FROM attendance WHERE subcode=#{subcode}")
	List<Student> select_sub_stdno(Integer subcode);

	@Select("SELECT * FROM attendance WHERE subcode=#{subcode}")
	List<Attendance> fixatt(Integer subcode);

	@Select("SELECT * FROM attendance WHERE studno=#{studno} AND subcode=#{subcode}")
	Attendance selectAtt(@Param("studno")int studno,  @Param("subcode")int subcode);

	@Update("Update attendance SET WEEK1=#{WEEK1}, WEEK2=#{WEEK2}, "
			+ "WEEK3=#{WEEK3}, WEEK4=#{WEEK4}, WEEK5=#{WEEK5}, WEEK6=#{WEEK6}, "
			+ "WEEK7=#{WEEK7},WEEK8=#{WEEK8}, WEEK9=#{WEEK9}, WEEK10=#{WEEK10}, WEEK11=#{WEEK11}, WEEK12=#{WEEK12}, "
			+ "WEEK13=#{WEEK13}, WEEK14=#{WEEK14}, WEEK15=#{WEEK15} "
			+ "WHERE studno=#{studno} AND subcode=#{subcode}")
	int updateAttendance(Attendance attendance);
	
	@Update("Update attendance SET grade=#{grade} WHERE studno=#{studno} AND subcode=#{subcode}")
	int updateGrade(Attendance attendance);


	
	@Insert("insert into user (id,name,birth,phone,address,email,position)"
			+ " values (#{id},#{name},#{birth},#{phone},#{address},#{email},#{position})")
	int InsertUser(User user);
	
	@Insert("insert into student (studno,entry,profno,mcode)"
			+" values (#{studno},#{entry},#{profno},#{mcode})")
	int InsertStudent(Student std);

	@Insert("insert into professor (profno,sub,mcode)"
			+" values (#{profno},#{sub},#{mcode})")
	int InsertProfessor(Professor pro);
	
	@Insert("insert into subject (subcode,subname,time,starttime,day,location,profno,teachsub)"
			+ " values (#{subcode},#{subname},#{time},#{starttime},#{day},#{location},#{profno},#{teachsub})")
	int InsertSubject(Subject sub);
	
	@Select({
		  "<script>",
		  "SELECT s.studno AS studno, m.mname AS major, u.name AS name",
		  "FROM student s",
		  "JOIN user u ON s.studno = u.id",
		  "JOIN major m ON m.mcode = s.mcode",
		  "<where>",
		  "  <if test='select == \"name\" and keyword != null'>",
		  "    u.name LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select == \"studno\" and keyword != null'>",
		  "    s.studno LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select == \"major\" and keyword != null'>",
		  "    m.mname LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "</where>",
		  "ORDER BY s.studno",
		  "LIMIT #{startRow},#{pagesize}",
		  "</script>"
		})
	List<Map<String, Object>> ListStudent(Map<String, Object> params);

	//페이징
	//==============================================================================================
	@Select({
		  "<script>",
		  "SELECT count(*) FROM student s",
		  "JOIN user u ON s.studno = u.id",
		  "JOIN major m ON m.mcode = s.mcode",
		  "<where>",
		  "  <if test='select == \"name\" and keyword != null'>",
		  "    u.name LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select == \"studno\" and keyword != null'>",
		  "    s.studno LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select == \"major\" and keyword != null'>",
		  "    m.mname LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "</where>",
		  "</script>"
		})
	int StudentCount(Map<String, Object> param);
	
	
	@Select({
		  "<script>",
		  "SELECT count(*)",
		  "FROM professor p",
		  "JOIN user u ON p.profno = u.id",
		  "JOIN major m ON m.mcode = p.mcode",
		  "<where>",
		  "  <if test='select eq \"name\" and keyword != null'>",
		  "    u.name LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select eq \"profno\" and keyword != null'>",
		  "    p.profno LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select eq \"major\" and keyword != null'>",
		  "    m.mname LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "</where>",
		  "</script>"
		})
	int ProfessorCount(Map<String, Object> param);
	
	@Select({
		  "<script>",
		  "SELECT count(*)",
		  "FROM subject s",
		  "JOIN user u ON s.profno = u.id",
		  "<where>",
		  "  <if test='select == \"subname\" and keyword != null'>",
		  "    s.subname LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select == \"name\" and keyword != null'>",
		  "    u.name LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "</where>",
		  "</script>"
		})
	int SubjectCount(Map<String, Object> param);
	
	//==============================================================================================
	@Select({
		  "<script>",
		  "SELECT p.profno AS profno, m.mname AS major, u.name AS name",
		  "FROM professor p",
		  "JOIN user u ON p.profno = u.id",
		  "JOIN major m ON m.mcode = p.mcode",
		  "<where>",
		  "  <if test='select eq \"name\" and keyword != null'>",
		  "    u.name LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select eq \"profno\" and keyword != null'>",
		  "    p.profno LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select eq \"major\" and keyword != null'>",
		  "    m.mname LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "</where>",
		  "ORDER BY p.profno",
		  "LIMIT #{startRow},#{pagesize}",
		  "</script>"
		})
	List<Map<String, Object>> ListProfessor(Map<String, Object> params);

	@Select({
		  "<script>",
		  "SELECT s.subname AS subname, s.time AS time, s.starttime AS starttime, s.teachsub AS teachsub, u.name AS name",
		  "FROM subject s",
		  "JOIN user u ON s.profno = u.id",
		  "<where>",
		  "  <if test='select == \"subname\" and keyword != null'>",
		  "    s.subname LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select == \"name\" and keyword != null'>",
		  "    u.name LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "</where>",
		  "ORDER BY s.subname",
		  "LIMIT #{startRow},#{pagesize}",
		  "</script>"
		})
	List<Map<String, Object>> ListSubject(Map<String, Object> param);

	@Select("SELECT m.mname AS major FROM professor p JOIN major m ON p.mcode = m.mcode where p.profno = #{id}")
	Map<String, Object> selectMajor(@Param("id") int id);

	

	@Insert("insert into pratice (studno,day,activename,content,emotion,file1) "
			+ "values (#{studno},#{day},#{activename},#{content},#{emotion},#{file1})")
	boolean prasubmit(Practice practice);

	@Select("select * from pratice where studno= #{id}")
	Practice selectparct(Integer id);

	@Insert("insert into service (studno,day,servicename,groupname,time,content,emotion,file1) "
			+ "values (#{studno},#{day},#{servicename},#{groupname},#{time},#{content},#{emotion},#{file1})")
	boolean servsubmit(Service service);

	@Insert("insert into personality (studno,self1,self2,self3,profno) values (#{studno},#{self1},#{self2},#{self3},#{profno})")
	boolean persubmit(Personality person);

	@Select("select * from personality where studno=#{id}")
	Personality selectper(Integer id);

	@Select("select * from student where studno=#{id}")
	Student selectStu(Integer id);


	
	@Select("SELECT p.studno as studno, p.day as day, t.pracice as pra,t.service as service, u.name as name"
			+ " FROM pratice p JOIN teacher t ON p.studno = t.studno JOIN user u ON p.studno = u.id")
	List<Map<String, Object>> ListPratice();
	
	@Select("SELECT p.studno as studno ,p.day as day ,p.activename as active ,t.service as service ,u.name as name"
			+ " FROM pratice p JOIN teacher t ON p.studno = t.studno JOIN user u ON p.studno = u.id")
	List<Map<String, Object>> ServiceInfo();
	
	@Select("SELECT p.studno as studno ,p.day as day ,p.activename as active ,t.service as service ,u.name as name"
			+ " FROM pratice p JOIN teacher t ON p.studno = t.studno JOIN user u ON p.studno = u.id where p.studno = #{id}")
	Map<String, Object> ServiceInfoOne(@Param("id")int id);
	
	
	/* myclass */
	@Select("SELECT s.subname as subname,s.subcode as subcode, 15-SUM(a.week1+a.week2+a.week3+a.week4+a.week5+a.week6+a.week7+a.week8+a.week9+a.week10+a.week11+a.week12+a.week13+a.week14+a.week15) AS week"
			+ " FROM subject s"
			+ " JOIN attendance a"
			+ " ON s.subcode = a.subcode"
			+ " WHERE a.studno = #{id}"
			+ " GROUP BY s.subcode,s.subname")
	List<Map<String, Object>> myclassInfo(@Param("id")int id);
	
	@Select("SELECT s.subname,s.subcode,a.week1,a.week2,a.week3,a.week4,a.week5,a.week6,a.week7,a.week8,a.week9,a.week10,a.week11,a.week12,a.week13,a.week14,a.week15"
			+ " FROM subject s"
			+ " JOIN attendance a"
			+ " ON s.subcode = a.subcode"
			+ " WHERE s.subcode = 50"
			+ " GROUP BY s.subcode,s.subname")
	List<Map<String, Object>> myclassSubjectHome(@Param("code")int code);

	@Select("SELECT * from personality")
	List<Personality> selectPersonalities();

	@Select("SELECT * FROM personality WHERE studno = #{studno}")
	Personality selectPersonality(Integer studno);
	
	@Update("UPDATE personality SET prof1 = #{prof1}, prof2 = #{prof2}, prof3 = #{prof3}, personsubmit = 1 WHERE studno=#{studno}")
	boolean perChek(Personality p);

	@Select("SELECT password FROM user WHERE id=#{id} and email=#{email} and phone=#{tel}")
	String pwSearch(@Param("id")String id, @Param("email")String email, @Param("tel")String tel);

	@Select("SELECT id FROM user WHERE name=#{name} AND email=#{email}")
	String searchId(@Param("name")String name, @Param("email")String email);

	@Update("UPDATE user SET password=#{chgpass} WHERE id=#{id}")
	boolean updatePass(@Param("id")Integer id, @Param("chgpass")String chgpass);

	@Select("SELECT * FROM pratice where studno=#{id}")
	Practice InfoPracticeOne(int id);


	@Update("update teacher set pracice=#{accept} where studno=#{id}")
	boolean teacherUpdate(@Param("id")int id, @Param("accept")String accept);

	@Delete("delete from pratice where studno=#{id}")
	boolean praciceDelete(int id);

	@Select("select u.name as name, s.time as time ,s.studno as studno,s.day as day from service s join user u on s.studno=u.id")
	List<Map<String, Object>> ServiceList();

	@Select("select *  from service where studno=#{id}")
	Service serviceInfo(int id);

	@Update("UPDATE teacher SET service = service + #{time} WHERE studno = #{id}")
	boolean serviceUpdate(@Param("id")int id, @Param("time")int time);

	@Delete("delete from service where studno=#{id}")
	boolean deleteservice(int id);

	@Select({"<script>", 
		"SELECT s.subcode, s.subname subname ,s.time,s.starttime,s.day,s.location,s.profno,s.teachsub,u.name profname "
		+ "from subject s join user u ON u.id=s.profno where 1=1 "
				+sqlcol,
			    "LIMIT #{start}, #{limit}"
		,"</script>"})
	List<Map<String, Object>> selectall(Map<String, Object> map);

	String sqlcol = 
		    "<if test='column != null and find != null'>" +
		    " AND " +
		    "<choose>" +
		    "  <when test='column == \"profname\"'>" +
		    "    u.name LIKE CONCAT('%', #{find}, '%')" +
		    "  </when>" +
		    "  <when test='column == \"subname\"'>" +
		    "    s.subname LIKE CONCAT('%', #{find}, '%')" +
		    "  </when>" +
		    "</choose>" +
		    "</if>";

	
	@Select("select ifnull(max(Seq),0) from comment where num2=${value}")
	int maxseq(int num2);

	@Insert("insert into comment (num2,seq,writer,content,regdate)"
			+ " values (#{num2},#{seq},#{writer},#{content},now())")
	int insert(Comment comm);

	@Select ("select * from comment where num2=${value}")
	List<Comment> list(String num);


	@Update("update graduation set graduation=true where studno=#{studno}")
	boolean updateGrad(Graduation grad_info);

	@Update("update teacher set teacherYN=true where studno=#{studno}")
	boolean updateTeach(Teacher teach_info);

	
	
	
	
	
	
	

	@Select({"<script>",
				 "select count(*) from subject s join user u ON u.id=s.profno where 1=1 "
				+ sqlcol
			, "</script>"})
	int classCount(Map<String, Object> map);

	@Select("select * from subject where subcode = #{applicode}")
	Subject selectSubOne(int applicode);

	@Insert("Insert into attendance (studno,subcode) values (#{studno},#{subcode})")
	boolean insertsub(@Param("subcode")int subcode, @Param("studno")Integer id);
	
	
	//history
	@Select({
	    "<script>",
	    "SELECT year, subject, grade",
	    "FROM history",
	    "<where>",
	    "  studno = #{studno}",
	    "  <if test='year != null and year != \"\"'>",
	    "    AND year = #{year}",
	    "  </if>",
	    "</where>",
	    "</script>"
	})
	List<Map<String, Object>> selectHistory(Map<String, Object> param);
	
	
}