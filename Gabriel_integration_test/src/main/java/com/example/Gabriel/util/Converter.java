package com.example.Gabriel.util;

import com.example.Gabriel.dto.DeliveryDTO;
import com.example.Gabriel.entities.EntityDelivery;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public static DeliveryDTO toDTO(EntityDelivery entity) {
        return new DeliveryDTO(
                entity.getOrderCode(),
                entity.getCpfReceiver(),
                entity.getDeliveryDate(),
                entity.getCep(),
                entity.getStatus(),
                entity.isActive()
        );
    }

    public static EntityDelivery toEntity(DeliveryDTO dto, boolean isNew) {
        EntityDelivery entity = new EntityDelivery();
        if (!isNew) {
            entity.setOrderCode(dto.getOrderCode());
        }
        entity.setCpfReceiver(dto.getCpfReceiver());
        entity.setDeliveryDate(dto.getDeliveryDate());
        entity.setCep(dto.getCep());
        entity.setStatus(dto.getStatus());
        entity.setActive(dto.isActive());
        return entity;
    }
}
