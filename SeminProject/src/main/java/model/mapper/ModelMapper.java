package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.attendance.Attendance;
import model.graduation.Graduation;
import model.personality.Personality;
import model.pratice.Practice;
import model.service.Service;
import model.student.Student;
import model.subject.Subject;
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

	@Insert("insert into pratice (studno,day,activename,content,emotion) "
			+ "values (#{studno},#{day},#{activename},#{content},#{emotion})")
	boolean prasubmit(Practice practice);

	@Select("select * from pratice where studno= #{id}")
	Practice selectparct(Integer id);

	@Insert("insert into service (studno,day,servicename,groupname,time,content,emotion) "
			+ "values (#{studno},#{day},#{servicename},#{groupname},#{time},#{content},#{emotion})")
	boolean servsubmit(Service service);

	@Insert("insert into personality (studno,self1,self2,self3,profno) values (#{studno},#{self1},#{self2},#{self3},#{profno})")
	boolean persubmit(Personality person);

	@Select("select * from personality where studno=#{id}")
	Personality selectper(Integer id);

	@Select("select * from student where studno=#{id}")
	Student selectStu(Integer id);

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

}
