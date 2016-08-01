package cn.hibrant.smt.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import cn.hibrant.smt.SpringTestBase;
import cn.hibrant.smt.dao.entity.Person;
import cn.hibrant.smt.dao.repo.PersonDao;

public class PersonDaoTest extends SpringTestBase {

	@Autowired
	private PersonDao dao;
	
	@Test
	@Transactional
	public void test() {
		String name = "test-" + System.currentTimeMillis();
		int age = (int) (System.currentTimeMillis() % 100);
		Person person = new Person(name, age);
		int ret = dao.insertOne(person);
		System.out.println(ret);
		
		person = dao.getByName(name);
		System.out.println(person);
		
		ret = dao.deleteById(person.getId());
		System.err.println(ret);
	}
	
}
