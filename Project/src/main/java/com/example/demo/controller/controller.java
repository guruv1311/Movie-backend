package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.model;
import com.example.demo.service.service;

@RestController
@CrossOrigin
public class controller {
	

		@Autowired
		service s;

		@GetMapping("/get")
		public List<model> showDetails() {
			return s.getDetails();

		}
		@GetMapping("/movieget/{serialno}")
		   public model getmovie(@PathVariable("serialno") int serialno) {
		      return s.getMovieById(serialno);
		   }

		@PostMapping("/post")
		public String addDetails(@RequestBody model m) {
			s.add(m);
			return "Added product " + m.getSerialno();
		}
		
		@PutMapping("/updateDetails")
		public model updateInfo(@RequestBody model st) {
			return s.updateDetails(st);
		}
		@DeleteMapping("/deleteDetails")
		public String deleteInfo(@RequestBody model st2) {
			s.deleteDetails(st2);
			return "Details deleted";
		}
		@DeleteMapping("/deleteid/{serialno}")
		   public String deleteMovieId(@PathVariable("serialno") int serialno) {
		      s.deleteMovieById(serialno);
		      return "Details deleted";
		}	
		//sorting
		@GetMapping("/movie/{field}")
		public List<model> getWithSort(@PathVariable String field) {
			return s.getSorted(field);
		}

		// pagination
		@GetMapping("/order/{offset}/{pageSize}")
		public List<model> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
			return s.getWithPagination(offset, pageSize);
		}
		@GetMapping("/order/{offset}/{pageSize}/{field}")
		public List<model> PaginatedSorted(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		return s.readGainersPaginatedSorted(offset,pageSize,field);
		}
}
