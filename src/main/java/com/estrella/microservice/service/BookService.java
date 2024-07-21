package com.estrella.microservice.service;

import com.estrella.microservice.request.BookRequest;
import com.estrella.microservice.response.BookResponse;

public interface BookService {
	
	BookResponse bookHouse(BookRequest request);
	
	BookResponse validateRequest(BookRequest request, String message);
	
}
