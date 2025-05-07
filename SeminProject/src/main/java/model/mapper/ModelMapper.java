package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.attendance.Attendance;
import model.graduation.Graduation;
import model.subject.Subject;
import model.teacher.Teacher;
import model.user.User;
public interface ModelMapper {
	@Select("select * from user where id = #{id}")
	User selectOne(@Param("id")int id);
	
	@Select("SELECT s.tograde,s.entry,s.grade, m.mname AS major FROM student s JOIN major m ON s.mcode = m.mcode where s.studno = #{id}")
	Map<String, Object> selectStudent(@Param("id") int id);

	@Select("SELECT * from graduation where studno= #{id}")
	Graduation selectGrad(Integer id);

	@Select("SELECT * from teacher where studno= #{id}")
	Teacher selectTeach(Integer id);

	@Select("SELECT subcode from attendance where studno= #{id}")
	List<Attendance> selectAttend(Integer id);
	
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
}
