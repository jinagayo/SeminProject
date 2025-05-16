package model.history;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;

public class HistoryDao {
	private Class<ModelMapper> cls = ModelMapper.class;
	 public List<Map<String, Object>> selectHistory(Map<String, Object> param) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectHistory(param);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;		 
	 }
}
