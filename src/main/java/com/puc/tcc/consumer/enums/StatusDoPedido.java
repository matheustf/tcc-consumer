package com.puc.tcc.consumer.enums;

public enum StatusDoPedido {

	CRIADO("CRIADO"), 
	AGUARDANDO_PAGAMENTO("AGUARDANDO_PAGAMENTO"), 
	PAGO("PAGO"), 
	EFETUADO("EFETUADO");

	private String descricao;

	private StatusDoPedido() {
	}
	
	private StatusDoPedido(String descricao) {
		this.descricao = descricao;
	}

	public String toString() {
		return this.descricao;
	}
}
