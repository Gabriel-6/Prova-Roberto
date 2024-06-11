package com.example.Gabriel.Integration_Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.example.Gabriel.dto.DeliveryDTO;
import com.example.Gabriel.dto.NewDeliveryDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

public class Integration_Test {
	private ObjectMapper mapper = new ObjectMapper();
	private final String deliveryURL = "https://localhost:8080/";
	
	@Test
	public void testCreateDelivery() {
		NewDeliveryDTO delivery = new NewDeliveryDTO(1, 2, new Date(), "1", "1");
		Response resp = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(delivery)
				.post(deliveryURL);
		assertEquals(HttpStatus.CREATED.value(), resp.getStatusCode());
	}

}
