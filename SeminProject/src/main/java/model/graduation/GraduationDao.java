package model.graduation;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.user.User;

public class GraduationDao {
	private Class<ModelMapper> cls = ModelMapper.class;

	public Graduation selectGrad(Integer id) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectGrad(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;	
	}

	public boolean updateGrad(Graduation grad_info) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).updateGrad(grad_info);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return false;
	}



}
