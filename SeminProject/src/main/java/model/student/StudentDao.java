package model.student;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.user.User;

public class StudentDao {
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
	 
	 public Map<String, Object> selectStudent(int id) {
		    SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(ModelMapper.class).selectStudent(id);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		    return null;
		}
}
