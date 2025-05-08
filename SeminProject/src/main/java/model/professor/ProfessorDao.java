package model.professor;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;

public class ProfessorDao {
	private Class<ModelMapper> cls = ModelMapper.class; 
	public Map<String, Object> selectProfessor(int id) {
		    SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(cls).selectProfessor(id);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		    return null;
		}
	
}	
