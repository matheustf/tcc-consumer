package com.puc.tcc.consumer.model;

import com.puc.tcc.consumer.enums.StatusDaEntrega;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class HistoricoDeEntrega {
	
	private StatusDaEntrega statusDaEntrega;
	
	private String data;

}