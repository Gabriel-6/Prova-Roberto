package com.example.Gabriel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Gabriel.dto.DeliveryDTO;
import com.example.Gabriel.service.DeliveryService;

public class DeliveryController {
	
	@Autowired
	private DeliveryService service;
	
	@GetMapping("/{code}")
	public DeliveryDTO getDeliveryById(@PathVariable Integer code) {
		return service.findById(code);
	}
	
	@PostMapping("")
	public void createService(@RequestBody DeliveryDTO delivery) {
		service.createDelivery(delivery);
		
	}
}
