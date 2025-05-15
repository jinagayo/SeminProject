package model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;

public class ServiceDao {
	private Class<ModelMapper> cls = ModelMapper.class;

	public List<Map<String, Object>> ServiceList() {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).ServiceList();
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return null;
	}

	public Service serviceInfo(int id) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).serviceInfo(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return null;
	}

	public boolean deleteservice(int id) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).deleteservice(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return false;
	}


}
