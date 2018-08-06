package com.puc.tcc.consumer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.puc.tcc.consumer.consts.Constants;
import com.puc.tcc.consumer.model.Entrega;
import com.puc.tcc.consumer.repository.EntregaRepository;
import com.puc.tcc.entrega.exceptions.ConsumerEntregaException;

@Service
public class EntregaServiceImpl implements EntregaService {

	EntregaRepository entregaRepository;
	
	@Autowired
	public EntregaServiceImpl(EntregaRepository entregaRepository) {
		this.entregaRepository = entregaRepository;
	}

	@Override
	public Entrega consultar(String id) throws ConsumerEntregaException {
		
		Optional<Entrega> optional = entregaRepository.findById(id);
		Entrega entrega = validarEntrega(optional);
		
		return entrega;
	}

	@Override
	public List<Entrega> buscarTodos() {

		List<Entrega> entregas = (List<Entrega>) entregaRepository.findAll();

		return entregas;
	}

	@Override
	public Entrega incluir(Entrega entrega) {
		
		entregaRepository.save(entrega);
		
		return entrega;
	}

	@Override
	public Entrega atualizar(String id, Entrega entregaDetails) throws ConsumerEntregaException {
		
		Optional<Entrega> optional = entregaRepository.findById(id);
		Entrega entrega = validarEntrega(optional);
		
		entregaRepository.save(entrega);

		return entrega;
	}

	@Override
	public ResponseEntity<Entrega> deletar(String id) throws ConsumerEntregaException {
		
		Optional<Entrega> optional = entregaRepository.findById(id);
		validarEntrega(optional);
		
		entregaRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

	private Entrega validarEntrega(Optional<Entrega> optional) throws ConsumerEntregaException {
		return Optional.ofNullable(optional).get()
		.orElseThrow(() -> new ConsumerEntregaException(HttpStatus.NOT_FOUND, Constants.ITEM_NOT_FOUND));
	}
}
