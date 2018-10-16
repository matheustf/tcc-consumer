package com.puc.tcc.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.tcc.consumer.model.Entrega;
import com.puc.tcc.consumer.repository.EntregaRepository;

@Service
public class EntregaServiceImpl implements EntregaService {

	EntregaRepository entregaRepository;
	
	@Autowired
	public EntregaServiceImpl(EntregaRepository entregaRepository) {
		this.entregaRepository = entregaRepository;
	}

	@Override
	public Entrega incluir(Entrega entrega) {
		
		entregaRepository.save(entrega);
		
		return entrega;
	}

}
