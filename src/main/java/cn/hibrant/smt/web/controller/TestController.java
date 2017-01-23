package cn.hibrant.smt.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cn.hibrant.smt.dao.repo.PersonDao;

@RestController
public class TestController {
	
	@Autowired
	private PersonDao personDao;

	@RequestMapping("/timer")
	public String timer() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}
	
	@RequestMapping("/person/{name}")
	public Object getPersonByName(@PathVariable String name) {
		return JSONObject.toJSON(personDao.getByName(name));
	}
}
