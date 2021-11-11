package com.example.demo;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaveController {

	@Autowired
	private LeaveService service;
	
	
	@PostMapping("/applyleave")
	public String applyleave(@RequestBody LeaveHistory leave) throws ClassNotFoundException,SQLException{
		return service.applyleave(leave);
	}
	
	@RequestMapping(value="/pending/{id}")
	public LeaveHistory pending(@PathVariable int id) {
		return service.pending(id);
	}
	
	@RequestMapping(value="/showleave")
	public List<LeaveHistory> list() {
		return service.showLeave();
	}
	
	@RequestMapping("/leave/{id}")
	public ResponseEntity<LeaveHistory> get(@PathVariable int id) {
		try {
		LeaveHistory leave = service.search(id);
		return new ResponseEntity<LeaveHistory>(leave,HttpStatus.OK);
		} catch(NoSuchElementException e) {
			return new ResponseEntity<LeaveHistory>(HttpStatus.NOT_FOUND);
		}
	}
}
