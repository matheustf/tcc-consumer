package com.puc.tcc.consumer.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.puc.tcc.consumer.exceptions.ConsumerPedidoException;
import com.puc.tcc.consumer.model.Pedido;

public interface PedidoService {

	Pedido consultar(String id) throws ConsumerPedidoException;

	List<Pedido> buscarTodos();

	Pedido incluir(Pedido pedido);

	Pedido atualizar(String id, Pedido pedidoDetails) throws ConsumerPedidoException;

	ResponseEntity<Pedido> deletar(String id) throws ConsumerPedidoException;

	Pedido gerarRelatorio(String id) throws ConsumerPedidoException;

	List<Pedido> buscarPorData(String data);

}
