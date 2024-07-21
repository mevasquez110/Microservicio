package com.estrella.microservice.client.rest.postgres.service;

import com.estrella.microservice.request.BookRequest;

public interface BookServiceBD {

	public void insert(BookRequest request) throws Exception;
}
