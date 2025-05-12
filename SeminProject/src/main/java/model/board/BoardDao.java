package model.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.BoardMapper;

public class BoardDao {
	private static Class<BoardMapper> cls = BoardMapper.class;
	private Map<String,Object> map = new HashMap<>();

	public int MainboardCount(int pageNum, int limit, String column, String find) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.put("start",(pageNum-1)*limit);
			map.put("limit",limit);
			map.put("column", column);
			map.put("find", find);
			if(column!=null) {
				String[] cols=column.split(",");
				switch(cols.length) {
				case 3: map.put("col3", cols[2].trim());
				case 2: map.put("col2", cols[1].trim());
				case 1: map.put("col1", cols[0].trim());
				}
			}
			return session.getMapper(cls).maincount(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public List<Board> Mainlist(int pageNum, int limit, String column, String find) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.clear();
			map.put("start", (pageNum-1)*limit);
			/*
			 * pageNum	start
			 *   1		  0
			 *   2		 10
			 */
			
			map.put("limit", limit);
			map.put("column", column);
			map.put("find", find);
			if(column!=null) {
				String[] cols=column.split(",");
				switch(cols.length) {
				case 3: map.put("col3", cols[2].trim());
				case 2: map.put("col2", cols[1].trim());
				case 1: map.put("col1", cols[0].trim());
				}
			}			
			return session.getMapper(cls).mainlist(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public int maxnum() {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).maxnum();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public boolean insert(Board board) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).insert(board)>0;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return false;
	}

	public static Board getBoard(int num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).getBoard(num);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return null;
	}

}
