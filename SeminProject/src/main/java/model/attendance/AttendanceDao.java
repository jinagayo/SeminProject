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


	public boolean insertsub(int subcode, Integer id) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).insertsub(subcode,id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return false;
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

	public Attendance selectAtt(Integer studno, Integer subcode) {
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectAtt(studno, subcode);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}

	public boolean updateAttendance(Attendance attendance) {
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).updateAttendance(attendance) > 0;
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return false;

	}

	public boolean updateGrade(Attendance attendance) {
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).updateGrade(attendance) > 0;
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return false;
	}
	
}

