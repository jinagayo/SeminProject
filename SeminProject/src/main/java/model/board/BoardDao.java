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
	private Map<String,Object> map2 = new HashMap<>();

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

	public Board selectOne(int num) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			  return session.getMapper(cls).selectone(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public boolean update(Board b) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).update(b) > 0;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return false;
	}


	public boolean delete(Board board) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).delete(board);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return false;
	}

	public int subBoardCount(String boardid, String subcode, int pageNum, int limit) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.put("start",(pageNum-1)*limit);
			map.put("limit",limit);
			map.put("subcode", subcode);
			map.put("boardid", boardid);
			return session.getMapper(cls).subBoardCount(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public List<Board> subbBoardlist(String boardid, String subcode, int pageNum, int limit) {
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
			map.put("boardid", boardid);
			map.put("subcode", subcode);		
			return session.getMapper(cls).subbBoardlist(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public boolean writeboard(Board board) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			return session.getMapper(cls).writeboard(board);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return false;
	}

	public int subBoardCount2(Integer boardid, String subcode, int pageNum, int limit) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map.put("start",(pageNum-1)*limit);
			map.put("limit",limit);
			map.put("subcode", subcode);
			map.put("boardid", 1);
			return session.getMapper(cls).subBoardCount2(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public List<Board> subbBoardlist2(Integer boardid, String subcode, int pageNum, int limit) {
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
			map.put("boardid", 1);
			map.put("subcode", subcode);		
			return session.getMapper(cls).subbBoardlist2(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return null;
	}

	public int subBoardCount3(Integer boardid, String subcode, int pageNum, int limit) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map2.put("start",(pageNum-1)*limit);
			map2.put("limit",limit);
			map2.put("subcode", subcode);
			map2.put("boardid", 2);
			return session.getMapper(cls).subBoardCount3(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return 0;
	}

	public List<Board> subbBoardlist3(Integer boardid, String subcode, int pageNum, int limit) {
		SqlSession session = MybatisConnection.getConnection();
		try {
			map2.clear();
			map2.put("start", (pageNum-1)*limit);
			/*
			 * pageNum	start
			 *   1		  0
			 *   2		 10
			 */
			
			map2.put("limit", limit);
			map2.put("boardid", boardid);
			map2.put("subcode", subcode);	
			System.out.println("map2==========="+map2);
			return session.getMapper(cls).subbBoardlist3(map);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			MybatisConnection.close(session);
		}
		return null;
	}

}
