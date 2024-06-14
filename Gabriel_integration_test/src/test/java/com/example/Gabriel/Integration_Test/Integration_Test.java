package com.example.Gabriel.Integration_Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.example.Gabriel.dto.DeliveryDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.junit.jupiter.api.Test;

public class Integration_Test {


    private ObjectMapper mapper = new ObjectMapper();
    private final String deliveryURL = "http://localhost:8080/deliveries";

    @Test
    public void testCreateNewDeliverySuccess() {
        long code = 10;
        DeliveryDTO newDelivery = new DeliveryDTO(code, 12345678901L, new Date(), "12345-678", "Pending", true);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(newDelivery)
                .post(deliveryURL);

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode());
    }

    @Test
    public void testCreateDeliveryExists() {
        DeliveryDTO duplicateDelivery = new DeliveryDTO(1, 12345678901L, new Date(), "12345-678", "Pending", true);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(duplicateDelivery)
                .post(deliveryURL);

        assertEquals(HttpStatus.CONFLICT.value(), response.getStatusCode());
    }

    @Test
    public void testCreateDeliveryWithNoData() {
        DeliveryDTO invalidDelivery = new DeliveryDTO(0, 0L, null, "", "", false);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(invalidDelivery)
                .post(deliveryURL);

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());
    }

    @Test
    public void testDeliveryActiveStatus() {
        long deliveryCode = 1;

        DeliveryDTO originalDelivery = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(deliveryURL + "/" + deliveryCode)
                .as(DeliveryDTO.class);

        boolean originalState = originalDelivery.isActive();
        originalDelivery.setActive(!originalState);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(originalDelivery)
                .put(deliveryURL + "/" + deliveryCode);

        assertEquals(HttpStatus.NO_CONTENT.value(), response.getStatusCode());

        DeliveryDTO updatedDelivery = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .get(deliveryURL + "/" + deliveryCode)
                .as(DeliveryDTO.class);

        assertNotEquals(originalState, updatedDelivery.isActive());
    }

    @Test
    public void testDeliveryActiveForNonExistentDelivery() {
        long nonExistentDeliveryCode = 100;

        DeliveryDTO nonExistentDelivery = new DeliveryDTO(nonExistentDeliveryCode, 12345678901L, new Date(), "12345-678", "Pending", true);

        Response response = RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(nonExistentDelivery)
                .put(deliveryURL + "/" + nonExistentDeliveryCode);

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());
    }
}