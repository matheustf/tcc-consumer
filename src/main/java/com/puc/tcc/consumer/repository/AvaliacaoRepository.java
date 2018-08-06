package com.puc.tcc.consumer.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.puc.tcc.consumer.model.Avaliacao;

@Repository
public interface AvaliacaoRepository extends ElasticsearchRepository<Avaliacao, String> {

}