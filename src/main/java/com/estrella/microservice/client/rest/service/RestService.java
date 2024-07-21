package com.estrella.microservice.client.rest.service;

import com.estrella.microservice.request.BookRequest;
import com.estrella.microservice.response.BookResponse;

public interface RestService {
	
	public BookResponse consumerRest(BookRequest request) throws Exception;

}
