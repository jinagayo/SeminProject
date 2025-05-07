package model.user;
import model.MybatisConnection;
import model.mapper.ModelMapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import gdu.mskim.MskimRequestMapping;
public class UserDao{
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

}
