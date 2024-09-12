package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PhonebookDAO;
import com.example.demo.domain.PhonebookVO;

@Service
public class PhonebookService {

	@Autowired
	private PhonebookDAO dao;

	public int insert(PhonebookVO phonebook) {
		
		return dao.insert(phonebook);
	}

	public List<PhonebookVO> selectAll() {
		
		return dao.selectAll();
	}

	public List<PhonebookVO>  search(String search) {
		
		return dao.search(search);
	}

	public int update(PhonebookVO phonebook) {
		return dao.update(phonebook);
	}

	public int delete(int id) {
		
		return dao.delete(id);
	}
	
	
}
