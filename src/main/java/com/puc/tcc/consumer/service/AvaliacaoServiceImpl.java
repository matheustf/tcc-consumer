package com.puc.tcc.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.tcc.consumer.model.Avaliacao;
import com.puc.tcc.consumer.repository.AvaliacaoRepository;

@Service
public class AvaliacaoServiceImpl implements AvaliacaoService {

	AvaliacaoRepository avaliacaoRepository;

	@Autowired
	public AvaliacaoServiceImpl(AvaliacaoRepository avaliacaoRepository) {
		this.avaliacaoRepository = avaliacaoRepository;
	}

	@Override
	public Avaliacao incluir(Avaliacao avaliacao) {

		avaliacaoRepository.save(avaliacao);

		return avaliacao;
	}
}
