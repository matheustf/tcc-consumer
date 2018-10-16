package com.puc.tcc.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.tcc.consumer.model.Pedido;
import com.puc.tcc.consumer.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService {

	PedidoRepository pedidoRepository;
	
	@Autowired
	public PedidoServiceImpl(PedidoRepository pedidoRepository) {
		this.pedidoRepository = pedidoRepository;
	}

	@Override
	public Pedido incluir(Pedido pedido) {
		
		pedidoRepository.save(pedido);
		
		return pedido;
	}

}
