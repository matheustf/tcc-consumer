package com.puc.tcc.consumer.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.puc.tcc.consumer.model.Entrega;

@Repository
public interface EntregaRepository extends ElasticsearchRepository<Entrega, String> {

	
	@Query("{ \"bool\": { \"must\": [ { \"match\": { \"historicoDeEntrega.data\": ?0 }} ] } },\"from\":0,\"size\":150 ")
	List<Entrega> findByHistoricoDeEntregaByData(String data, Pageable pageable);

}

