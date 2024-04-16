package com.example.Gabriel.util;

import com.example.Gabriel.dto.DeliveryDTO;
import com.example.Gabriel.entities.EntityDelivery;


public class Converter {
	public static DeliveryDTO toDTO(EntityDelivery product) {
		return new DeliveryDTO(
				product.getOrderCode(), product.getCpfReceiver(), 
				product.getDeliveryDate(), product.getCep(),
				product.getStatus());
	}
	
	public EntityDelivery toEntity(DeliveryDTO prod, boolean activate) {
		return new EntityDelivery(
				prod.getOrderCode(), prod.getCpfReceiver(), 
				prod.getDeliveryDate(), prod.getCep(),
				prod.getStatus(), activate);
	}

}	
