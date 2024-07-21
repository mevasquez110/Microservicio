package com.estrella.microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estrella.microservice.client.rest.postgres.service.BookServiceBD;
import com.estrella.microservice.client.rest.service.RestService;
import com.estrella.microservice.request.BookRequest;
import com.estrella.microservice.response.BookResponse;
import com.estrella.microservice.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private RestService restService;

	@Autowired
	private BookServiceBD bookServiceBD;

	@Override
	public BookResponse bookHouse(BookRequest request) {
		BookResponse response = new BookResponse();

		try {
			response = restService.consumerRest(request);

			if (response != null && !response.getStatus()) {
				response = validateRequest(request, "invalid discount");
			} else {
				bookServiceBD.insert(request);
			}
		} catch (Exception e) {
			response = validateRequest(request, e.getMessage());
		}

		return response;
	}

	@Override
	public BookResponse validateRequest(BookRequest request, String message) {
		BookResponse response = new BookResponse();
		response.setStatusCode(400);
		response.setError("Bad Request");
		response.setMessage(message);
		return response;
	}

}
