package model.pratice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;

public class PraticeDao {
	private Class<ModelMapper> cls = ModelMapper.class;
	public List<Map<String, Object>> listPratice(){
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).ListPratice();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}
	
	public List<Map<String, Object>> InfoService(){
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).ServiceInfo();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}
	
	public Map<String, Object> InfoServiceOne(int id){
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).ServiceInfoOne(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;
	}
}
