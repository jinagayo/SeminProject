package model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model.board.Board;

public interface BoardMapper {

   String sqlcol="<if test='column != null'>"
         + "<if test='col1 != null'> and (${col1} like '%${find}%'</if>"
         + "<if test='col2 == null'> ) </if>"
         + "<if test='col2 != null'> or (${col2} like '%${find}%'</if>"
         + "<if test='col2 != null and col3==null'>)</if>"
         + "<if test='col3 != null'> or $[col3} like '%${find}%') </if></if>";
   @Select({"<script>",
             "select count(*) from board where boardid = 1 and subcode is null "
                     + sqlcol
             + "ORDER BY regdate DESC "
            , "</script>"})
   int maincount(Map<String, Object> map);
   
   
   @Select({"<script>",
      " select * from board where boardid=1 and subcode is null "+sqlcol
      + " ORDER BY regdate DESC"
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


   @Update("update board set title=#{title}, content=#{content}, file1=#{file1} "
           + "where num=#{num}")

   int update(Board b);

   @Select("select * from board where num = #{value}")
   Board selectone(int num);

   @Delete("delete from board where num=#{num}")
   boolean delete(Board board);
}
