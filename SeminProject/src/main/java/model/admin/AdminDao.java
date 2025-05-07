package model.admin;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.student.Student;
import model.user.User;

public class AdminDao {
	private Class<ModelMapper> cls = ModelMapper.class;
	 public boolean insertUser(User user) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 if(session.getMapper(cls).InsertUser(user) > 0) return true;
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return false;		 
	 }
	 
	 public boolean insertStudent(Student std) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 if(session.getMapper(cls).InsertStudent(std) > 0) return true;
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return false;	
	 }
}
