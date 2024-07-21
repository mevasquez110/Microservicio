package com.estrella.microservice.request;

import java.util.Date;
import javax.validation.constraints.*;
import lombok.Data;

@Data
public class BookRequest {

    @Size(min = 9, max = 10, message = "Required property userId")
    private String userId;

    @Size(min = 2, max = 50, message = "Required property name")
    private String name;

    @Size(min = 2, max = 50, message = "Required property lastname")
    private String lastname;

    @Min(value = 18, message = "Required property age")
    @Max(value = 100, message = "Required property age")
    private Integer age;

    @Size(min = 9, max = 20, message = "Required property phoneNumber")
    private String phoneNumber;

    @PastOrPresent(message = "Required property startDate")
    private Date startDate;

    @FutureOrPresent(message = "Required property endDate")
    private Date endDate;

    @NotBlank(message = "Required property houseId")
    @Size(min = 6, max = 15, message = "Required property houseId")
    private String houseId;

    @NotBlank(message = "Required property discountCode")
    @Size(min = 8, max = 8, message = "Required property discountCode")
    private String discountCode;

}
