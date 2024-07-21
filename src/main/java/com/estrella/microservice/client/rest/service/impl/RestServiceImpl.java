package com.estrella.microservice.client.rest.service.impl;

import java.util.concurrent.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import com.estrella.microservice.client.rest.service.RestService;
import com.estrella.microservice.request.BookRequest;
import com.estrella.microservice.response.BookResponse;

@Service
public class RestServiceImpl implements RestService {

	private final RestTemplate restTemplate;

	@Autowired
	public RestServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public BookResponse consumerRest(BookRequest request) throws Exception {
		BookResponse response = new BookResponse();
		String url = "https://sbv2bumkomidlxwffpgbh4k6jm0ydskh.lambda-url.us-east-1.on.aws/";
		HttpEntity<BookRequest> httpEntity = new HttpEntity<>(request);

		try {
			ResponseEntity<BookResponse> responseEntity = restTemplate.exchange(url, HttpMethod.POST, httpEntity,
					BookResponse.class);
			if (responseEntity != null && responseEntity.getBody() != null) {
				response = responseEntity.getBody();
			}
		} catch (ResourceAccessException  e) {
			throw new TimeoutException("TimeOutException");
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			throw e;
		}

		return response;
	}


}
