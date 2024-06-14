package com.example.Gabriel.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class DeliveryDTO {
    private long orderCode;
    private long cpfReceiver;
    private Date deliveryDate;
    private String cep;
    private String status;
    private boolean active;
}
