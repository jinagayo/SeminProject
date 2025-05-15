package model.major;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import model.MybatisConnection;
import model.mapper.ModelMapper;
import model.subject.Subject;

public class MajorDao {
	private Class<ModelMapper> cls = ModelMapper.class;

	public List<Subject> selectall() {
		// TODO Auto-generated method stub
		return null;
	}

}
