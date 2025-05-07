package model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import model.student.Student;
import model.user.User;
public interface ModelMapper {
	@Select("select * from user where id = #{id}")
	User selectOne(@Param("id")int id);
	
	@Select("SELECT s.tograde,s.entry,s.grade, m.mname AS major FROM student s JOIN major m ON s.mcode = m.mcode where s.studno = #{id}")
	Map<String, Object> selectStudent(@Param("id") int id);
	
	@Insert("insert into user (id,name,birth,phone,address,email,position)"
			+ " values (#{id},#{name},#{birth},#{phone},#{address},#{email},#{position})")
	int InsertUser(User user);
	
	@Insert("insert into student (studno,entry,profno,mcode)"
			+" values (#{studno},#{entry},#{profno},#{mcode})")
	int InsertStudent(Student std);

}
