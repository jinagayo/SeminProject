package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.professor.Professor;
import model.student.Student;
import model.subject.Subject;
import model.user.User;
public interface ModelMapper {
	@Select("select * from user where id = #{id}")
	User selectOne(@Param("id")int id);
	
	@Select("SELECT s.tograde,s.entry,s.grade, m.mname AS major FROM student s JOIN major m ON s.mcode = m.mcode where s.studno = #{id}")
	Map<String, Object> selectStudent(@Param("id") int id);
	
	@Select("SELECT p.mcode AS major FROM professor p JOIN major m ON p.mcode = m.mcode WHERE p.profno = #{id}")
	Map<String, Object> selectProfessor(@Param("id") int id);
	
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
			+ " values (#{subcode},#{subname},#{time},#{starttime},#{day},#{location},#{profno},#{teachsub}")
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
		  "</script>"
		})
	List<Map<String, Object>> ListStudent(Map<String, Object> params);
	
	@Select({
		  "<script>",
		  "SELECT p.profno AS profno, m.mname AS major, u.name AS name",
		  "FROM professor p",
		  "JOIN user u ON p.profno = u.id",
		  "JOIN major m ON m.mcode = p.mcode",
		  "<where>",
		  "  <if test='select == \"name\" and keyword != null'>",
		  "    u.name LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select == \"profno\" and keyword != null'>",
		  "    p.profno LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "  <if test='select == \"major\" and keyword != null'>",
		  "    m.mname LIKE CONCAT('%', #{keyword}, '%')",
		  "  </if>",
		  "</where>",
		  "</script>"
		})
	List<Map<String, Object>> ListProfessor(Map<String, Object> params);

	
}
