package com.example.demo;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.PhonebookDAO;
import com.example.demo.domain.PhonebookVO;


@SpringBootTest
@Controller
class WebapplicationApplicationTests {
	
	@Autowired
	PhonebookDAO dao;
	
	@Test
	void contextLoads() throws SQLException {
		//System.out.println(dao.insert(new PhonebookVO("test3", "010-1234-5678", "test3"))); // OK
		System.out.println("전체출력 : " + dao.selectAll()); // OK
		System.out.println("선택 출력 : " + dao.selectById(1)); // OK
		// System.out.println("삭제 : " + dao.delete(1)); // OK
		System.out.println("검색" + dao.search("test2")); // OK
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
