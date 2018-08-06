package com.puc.tcc.consumer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.puc.tcc.consumer.consts.Constants;
import com.puc.tcc.consumer.model.Avaliacao;
import com.puc.tcc.consumer.repository.AvaliacaoRepository;
import com.puc.tcc.entrega.exceptions.ConsumerAvaliacaoException;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

	AvaliacaoRepository avaliacaoRepository;
	
	@Autowired
	public AvaliacaoServiceImpl(AvaliacaoRepository avaliacaoRepository) {
		this.avaliacaoRepository = avaliacaoRepository;
	}

	@Override
	public Avaliacao consultar(String id) throws ConsumerAvaliacaoException {
		
		Optional<Avaliacao> optional = avaliacaoRepository.findById(id);
		Avaliacao avaliacao = validarAvaliacao(optional);
		
		return avaliacao;
	}

	@Override
	public List<Avaliacao> buscarTodos() {

		List<Avaliacao> avaliacoes = (List<Avaliacao>) avaliacaoRepository.findAll();

		return avaliacoes;
	}

	@Override
	public Avaliacao incluir(Avaliacao avaliacao) {
		
		avaliacaoRepository.save(avaliacao);
		
		return avaliacao;
	}

	@Override
	public Avaliacao atualizar(String id, Avaliacao avaliacaoDetails) throws ConsumerAvaliacaoException {
		
		Optional<Avaliacao> optional = avaliacaoRepository.findById(id);
		Avaliacao avaliacao = validarAvaliacao(optional);
		
		avaliacaoRepository.save(avaliacao);

		return avaliacao;
	}

	@Override
	public ResponseEntity<Avaliacao> deletar(String id) throws ConsumerAvaliacaoException {
		
		Optional<Avaliacao> optional = avaliacaoRepository.findById(id);
		validarAvaliacao(optional);
		
		avaliacaoRepository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

	private Avaliacao validarAvaliacao(Optional<Avaliacao> optional) throws ConsumerAvaliacaoException {
		return Optional.ofNullable(optional).get()
		.orElseThrow(() -> new ConsumerAvaliacaoException(HttpStatus.NOT_FOUND, Constants.ITEM_NOT_FOUND));
	}
}