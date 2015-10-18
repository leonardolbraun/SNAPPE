package br.ufmt.hujm.erp.model;

public enum PesoAoNascer {

	MAIORIGUALAMIL(">= 1.000 g"), 
	SETENSSENTOSCINQUENTAANOVECENTOSNOVENTANOVE("750 - 999 g"),
	MENORSETESSENTOSCINQUENTA("menor 750 g"); 
	
	private String descricao;

	PesoAoNascer(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}