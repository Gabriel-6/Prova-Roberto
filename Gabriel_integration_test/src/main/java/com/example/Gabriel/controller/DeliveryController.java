package com.example.Gabriel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.Gabriel.dto.DeliveryDTO;
import com.example.Gabriel.service.DeliveryService;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	@Autowired
	private DeliveryService service;

	@GetMapping("/{code}")
	public DeliveryDTO getDeliveryById(@PathVariable Integer code) {
		return service.findById(code);
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDelivery(@RequestBody DeliveryDTO delivery) {
		service.createDelivery(delivery);
	}

	@PutMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateDelivery(@PathVariable Integer code, @RequestBody DeliveryDTO delivery) {
		delivery.setOrderCode(code);
		service.createDelivery(delivery);
	}
}
