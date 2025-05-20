package model.comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;

public class CommentDao {
	private Class<ModelMapper> cls = ModelMapper.class;

	public int maxseq(int num2) {
		SqlSession session = MybatisConnection.getConnection() ;
		try {
			return session.getMapper(cls).maxseq(num2) ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally {
			MybatisConnection.close(session) ;
		}
		return 0;
	}

	public boolean insert(Comment comm) {
		SqlSession session = MybatisConnection.getConnection() ;
		try {
			return session.getMapper(cls).insert(comm) > 0 ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally {
			MybatisConnection.close(session) ;
		}
		return false;
	}

	public List<Comment> list(String num) {
		SqlSession session = MybatisConnection.getConnection() ;
		try {
			return session.getMapper(cls).list(num) ;
		}catch(Exception e) {
			e.printStackTrace() ;
		}finally {
			MybatisConnection.close(session) ;
		}
		return null;
	}

}
