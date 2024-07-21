package com.estrella.microservice.client.rest.postgres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.estrella.microservice.client.rest.postgres.entity.Book;
import com.estrella.microservice.client.rest.postgres.repository.BookRepository;
import com.estrella.microservice.client.rest.postgres.service.BookServiceBD;
import com.estrella.microservice.request.BookRequest;

@Service
public class BookServiceBDImpl implements BookServiceBD {

	@Autowired
	private BookRepository repository;

	public void insert(BookRequest request) throws Exception {
		Book book = new Book();
		book.setUserId(request.getUserId());
		book.setName(request.getName());
		book.setLastname(request.getLastname());
		book.setAge(request.getAge());
		book.setPhoneNumber(request.getPhoneNumber());
		book.setStartDate(request.getStartDate());
		book.setEndDate(request.getEndDate());
		book.setHouseId(request.getHouseId());
		book.setDiscountCode(request.getDiscountCode());
		repository.save(book);
	}
}
