package model.subject;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.attendance.Attendance;
import model.mapper.ModelMapper;

public class SubjectDao {
	private Class<ModelMapper> cls = ModelMapper.class;

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
	
}
