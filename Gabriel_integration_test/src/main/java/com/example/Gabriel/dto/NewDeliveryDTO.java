package com.example.Gabriel.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewDeliveryDTO {
	private long OrderCode;
	private long CpfReceiver;
	private Date DeliveryDate;
	private String Cep;
	private String Status;
}
