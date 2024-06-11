package com.example.Gabriel.Integration_Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;

import com.example.Gabriel.dto.DeliveryDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;

public class Integration_Test {
	private ObjectMapper mapper = new ObjectMapper();
	private final String deliveryURL = "https://localhost:8080/";
	
	@Test
	public void testCreateDelivery() {
		Date date = new Date();
		DeliveryDTO delivery = new DeliveryDTO(1, 2, date, "1", "1");
	}

}
