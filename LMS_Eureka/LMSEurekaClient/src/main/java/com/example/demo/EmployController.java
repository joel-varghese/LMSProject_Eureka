package com.example.demo;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployController {

	@Autowired
	private EmployService service;
	
	@RequestMapping(value="/showEmploy")
	public List<Employee> list() {
		return service.showEmploy();
	}
	
	@RequestMapping("/employ/{id}")
	public ResponseEntity<Employee> get(@PathVariable int id) {
		try {
		Employee employ = service.search(id);
		return new ResponseEntity<Employee>(employ,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
}
