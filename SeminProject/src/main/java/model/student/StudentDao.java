package model.student;

import java.util.List;
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
		        return session.getMapper(cls).selectStudent(id);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		    return null;
	}

	public List<Student> selectStudentId(int id) {
		 SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(ModelMapper.class).selectStudentId(id);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		    return null;
	}


	public Student pickStudent(int id) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(ModelMapper.class).pickStudent(id);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return null;
	}


	public Student selectStu(Integer id) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectStu(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}

	//myclass dao
	public List<Map<String, Object>> MyclassInfo(int id) {
		 SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(ModelMapper.class).myclassInfo(id);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		    return null;
	}
	
	public List<Map<String, Object>> MyclassSubjectHome(int code) {
		 SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(ModelMapper.class).myclassSubjectHome(code);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		    return null;
	}

	public boolean updateStudent(Student student) {
		 SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(ModelMapper.class).updateStudent(student);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		return false;
	}


	public int countProfessorStudents(Integer id) {
		 SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(ModelMapper.class).countProfessorStudents(id);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		return 0;
	}

	public List<Student> selectStudentIdPage(Map<String, Object> param) {
		 SqlSession session = MybatisConnection.getConnection();
		    try {
		        return session.getMapper(ModelMapper.class).studentManagePage(param);
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        MybatisConnection.close(session);
		    }
		    return null;
	}
}

