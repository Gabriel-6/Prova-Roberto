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
	private long OrderCode;
	private long CpfReceiver;
	private Date DeliveryDate;
	private String Cep;
	private String Status;
}
