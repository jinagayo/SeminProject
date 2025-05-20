package model.professor;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.user.User;

public class ProfessorDao {
	private Class<ModelMapper> cls = ModelMapper.class;
	 public User selectOne(int id) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectOne(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;		 
	 }
	 
	 public Map<String, Object> selectProfessor(int id) {
		    SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(ModelMapper.class).selectProfessor(id);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		    return null;
		}

	public boolean updateProfessor(Professor professor) {
	    SqlSession session = MybatisConnection.getConnection();
	    try {
	        return session.getMapper(ModelMapper.class).updateProfessor(professor);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        MybatisConnection.close(session);
	    }
		return false;
	}
	
}	
