package com.puc.tcc.consumer.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.puc.tcc.consumer.model.Entrega;

@Repository
public interface EntregaRepository extends ElasticsearchRepository<Entrega, String> {

	List<Entrega> findByHistoricoDeEntregaByData(String data);

}