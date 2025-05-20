package model.major;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.subject.Subject;

public class MajorDao {
	private Class<ModelMapper> cls = ModelMapper.class;


	public List<Major> allccode() {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).allccode();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return null;
	}


	public List<Major> allMajor() {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).allMajor();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return null;
	}

}
