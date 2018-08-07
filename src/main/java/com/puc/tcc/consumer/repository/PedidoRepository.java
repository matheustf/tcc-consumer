package com.puc.tcc.consumer.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.puc.tcc.consumer.model.Pedido;

@Repository
public interface PedidoRepository extends ElasticsearchRepository<Pedido, String> {
	
	public Pedido findByDataDaPedido(String data);
}