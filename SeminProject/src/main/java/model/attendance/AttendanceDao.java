package model.attendance;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.student.Student;

public class AttendanceDao {
	private Class<ModelMapper> cls = ModelMapper.class;

	public List<Attendance> selectAttend(Integer id) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectAttend(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;	
	}

	public List<Student> select_sub_stdno(Integer subcode) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).select_sub_stdno(subcode);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;	
}

	public List<Attendance> fixatt(Integer subcode) {
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).fixatt(subcode);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}
}
