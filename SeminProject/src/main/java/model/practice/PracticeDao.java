package model.practice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.service.Service;

public class PracticeDao {
	private Class<ModelMapper> cls = ModelMapper.class;

	public boolean prasubmit(Practice practice) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).prasubmit(practice);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return false;
	}

	public Practice selectparct(Integer id) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectparct(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
			return null;
	}

	public boolean servsubmit(Service service) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).servsubmit(service);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return false;
	}
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

	public Practice InfoPracticeOne(int id) {
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).InfoPracticeOne(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return null;
	}

	public boolean praciceDelete(int id) {
		SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).praciceDelete(id);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return false;
	}

}
