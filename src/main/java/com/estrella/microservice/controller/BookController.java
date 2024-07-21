package com.estrella.microservice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estrella.microservice.request.BookRequest;
import com.estrella.microservice.response.BookResponse;
import com.estrella.microservice.service.BookService;

@RestController
@RequestMapping("/bideafactory")
public class BookController {

	@Autowired
	private BookService service;

	@PostMapping("/book")
	public ResponseEntity<BookResponse> bookHouse(@Valid @RequestBody BookRequest request, BindingResult bindingResult) {
		BookResponse response = new BookResponse();

		if (bindingResult.hasErrors()) {
			if (bindingResult.hasErrors()) {
				response = service.validateRequest(request, bindingResult.getFieldError().getDefaultMessage());
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
		}
		
		response = service.bookHouse(request);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
