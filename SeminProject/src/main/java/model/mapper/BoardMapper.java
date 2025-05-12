package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.board.Board;

public interface BoardMapper {

	String sqlcol="<if test='column != null'>"
			+ "<if test='col1 != null'> and (${col1} like '%${find}%'</if>"
			+ "<if test='col2 == null'> ) </if>"
			+ "<if test='col2 != null'> or (${col2} like '%${find}%'</if>"
			+ "<if test='col2 != null and col3==null'>)</if>"
			+ "<if test='col3 != null'> or $[col3} like '%${find}%') </if></if>";
	@Select({"<script>",
				 "select count(*) from board where boardid = 1 and subcode is null ORDER BY regdate DESC "
				+ sqlcol
				, "</script>"})
	int maincount(Map<String, Object> map);
	
	
	@Select({"<script>",
		" select * from board where boardid=1 and subcode is null ORDER BY regdate DESC"+sqlcol
		+" limit #{start},#{limit} "
		,"</script>"})
	List<Board> mainlist(Map<String, Object> map);

	@Select("select ifnull(max(num),0) from board")
	int maxnum();

	String sql="insert into board (writer,title,content,file1,regdate,boardid) "
			+ "values('관리자',#{title},#{content},#{file1},now(),1)";
	@Insert(sql)
	int insert(Board board);

	@Select("select *  from board where num =#{value}")
	Board getBoard(int num);
}
