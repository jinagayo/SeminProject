package model.subject;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.professor.Professor;

import model.attendance.Attendance;
import model.mapper.ModelMapper;

public class SubjectDao {
	private Class<ModelMapper> cls = ModelMapper.class; 
	public boolean insertSubject(Subject sub) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 if(session.getMapper(cls).InsertSubject(sub) > 0);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return false;
	}

	public List<Subject> selectSub(List<Integer> subcodes) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectSub(subcodes);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;	
	}
	public List<Map<String, Object>> listSubject(Map<String, Object> param) {
		 SqlSession session = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).ListSubject(param);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;	
	}

	public List<Subject> selectLcode(Integer id) {
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectLcode(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}

	public List<Subject> selectPsubject(Integer id) {
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectPsubject(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}

	public Subject selectSubject(String sub) {
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectSubject(sub);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}

}
