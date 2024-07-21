package com.estrella.microservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponse {

	private Integer houseId;
	private String discountCode;
	private Integer id;
	private String userId;
	private Boolean status;
	private Integer statusCode;
	private String error;
	private String message;
	private String code;

}
