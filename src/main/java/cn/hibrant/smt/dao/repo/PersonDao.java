package cn.hibrant.smt.dao.repo;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import cn.hibrant.smt.dao.entity.Person;

@Repository
public interface PersonDao {

	int insertOne(Person person);
	
	@Select("select * from person where name=#{name} limit 1;")
	Person getByName(String name);
	
	int deleteById(int id);
}
