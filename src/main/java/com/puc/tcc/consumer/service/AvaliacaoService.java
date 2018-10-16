package com.puc.tcc.consumer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.puc.tcc.consumer.exceptions.ConsumerAvaliacaoException;
import com.puc.tcc.consumer.model.Avaliacao;

public interface AvaliacaoService {

	Avaliacao consultar(String id) throws ConsumerAvaliacaoException;

	List<Avaliacao> buscarTodos();

	Avaliacao incluir(Avaliacao avaliacao);

	Avaliacao atualizar(String id, Avaliacao avaliacaoDetails) throws ConsumerAvaliacaoException;

	ResponseEntity<Avaliacao> deletar(String id) throws ConsumerAvaliacaoException;

	List<Avaliacao> buscarPorData(String data);
	

}
