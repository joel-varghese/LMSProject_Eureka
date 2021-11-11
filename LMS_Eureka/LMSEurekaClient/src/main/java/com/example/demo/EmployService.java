package com.example.demo;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EmployService {

	@Autowired
    private EmployRepository repo;
	
	public Employee search(int menuId) {
		return repo.findById(menuId).get();
	}
	public List<Employee> showEmploy() {
		return repo.findAll();
	}
}

