package com.puc.tcc.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puc.tcc.consumer.model.Avaliacao;
import com.puc.tcc.consumer.service.AvaliacaoService;

@RestController
@RequestMapping("/relatorio/avaliacao")
public class AvaliacaoController {
	
	private AvaliacaoService avaliacaoService;

	@Autowired
	public AvaliacaoController(AvaliacaoService avaliacaoService) {
		this.avaliacaoService = avaliacaoService;
	}

	@PostMapping()
	public ResponseEntity<List<Avaliacao>> buscarTodos(@RequestBody String data) {
data="09/08/2018";
		List<Avaliacao> listAvaliacoes = avaliacaoService.buscarPorData(data);

		return new ResponseEntity<List<Avaliacao>>(listAvaliacoes, HttpStatus.OK);
	}
	
}