package com.puc.tcc.consumer.rabbitmq.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puc.tcc.consumer.model.Avaliacao;
import com.puc.tcc.consumer.model.Entrega;
import com.puc.tcc.consumer.model.Pedido;
import com.puc.tcc.consumer.rabbitmq.config.RabbitMQConfig;
import com.puc.tcc.consumer.service.AvaliacaoService;
import com.puc.tcc.consumer.service.EntregaService;
import com.puc.tcc.consumer.service.PedidoService;

@Service
public class Receiver {
	
	AvaliacaoService avaliacaoService;
	
	EntregaService entregaService;
	
	PedidoService pedidoService;
	
	@Autowired
	public Receiver(AvaliacaoService avaliacaoService, EntregaService entregaService, PedidoService pedidoService) {
		this.avaliacaoService = avaliacaoService;
		this.entregaService = entregaService;
		this.pedidoService = pedidoService;
	}
	
	
	@RabbitListener(queues = RabbitMQConfig.ROUTING_AVALIACOES)
	public void receiveMessage(Avaliacao avaliacao) {
		System.out.println("Received <Avaliacao" + avaliacao.getId() + ">");
		avaliacaoService.incluir(avaliacao);
		
	}

	@RabbitListener(queues = RabbitMQConfig.ROUTING_ENTREGA)
	public void receiveMessage(Entrega entrega) {
		System.out.println("Received <Entrega" + entrega.getId() + ">");
		entregaService.incluir(entrega);
	}
	
	@RabbitListener(queues = RabbitMQConfig.ROUTING_PEDIDOS)
	public void receiveMessage(Pedido pedido) {
		System.out.println("Received <Pedido>");
		pedidoService.incluir(pedido);
	}
}