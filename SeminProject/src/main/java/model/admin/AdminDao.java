package model.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.professor.Professor;
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
		 return true;	
	 }
	 
	 public boolean insertProfessor(Professor pro) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 if(session.getMapper(cls).InsertProfessor(pro) > 0) return true;
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return true;	
	 }
	 
	 public List<Map<String, Object>> list(Map<String, Object> param) {
		 SqlSession session = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).ListStudent(param);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	 }
	 
	 public List<Map<String, Object>> listPrno(Map<String, Object> param) {
		 SqlSession session = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).ListProfessor(param);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null; 
	 }
	 
	 //페이징
	 //===============================================================================
	 public int studentCount(Map<String, Object> param) {
		 SqlSession session = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).StudentCount(param);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return 0;
	 }
	 
	 public int professorCount(Map<String,Object> param) {
		 SqlSession session = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).ProfessorCount(param);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return 0;
	 }
	 
	 public int subjectCount(Map<String,Object> param) {
		 SqlSession session = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).SubjectCount(param);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return 0;
	 }
	 //===============================================================================
}
