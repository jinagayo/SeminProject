package model.user;
import model.MybatisConnection;
import model.mapper.ModelMapper;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
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
	 
	public List<User> selectMany(List<Integer> studno) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).selectMany(studno);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;		

}

	public String pwSearch(String id, String email, String tel) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).pwSearch(id, email, tel);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;		
	}

	public String searchId(String name, String email) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).searchId(name, email);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return null;	
	}

	public boolean updatePass(Integer id, String chgpass) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).updatePass(id, chgpass);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return false;	
	}


	public boolean updatePicture(Integer id, String fname) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).updatePicture(id, fname);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		 return false;	
	}

  
	public boolean updateUser(User user) {
		 SqlSession session  = MybatisConnection.getConnection();
		 try {
			 return session.getMapper(cls).updateUser(user);
		 } catch (Exception e) {
			 e.printStackTrace();
		 } finally {
			 MybatisConnection.close(session);
		 }
		return false;
	}

}
