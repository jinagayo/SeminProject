package model.subject;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.professor.Professor;

public class SubjectDao {
	private Class<ModelMapper> cls = ModelMapper.class;
	 
	public boolean insertSubject(Subject sub) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 if(session.getMapper(cls).InsertSubject(sub) > 0) return true;
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return false;	
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
	
}
