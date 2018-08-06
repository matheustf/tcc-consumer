package com.puc.tcc.consumer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.puc.tcc.consumer.model.Entrega;
import com.puc.tcc.entrega.exceptions.ConsumerEntregaException;

public interface EntregaService {

	Entrega consultar(String id) throws ConsumerEntregaException;

	List<Entrega> buscarTodos();

	Entrega incluir(Entrega entrega);

	Entrega atualizar(String id, Entrega entregaDetails) throws ConsumerEntregaException;

	ResponseEntity<Entrega> deletar(String id) throws ConsumerEntregaException;


}
