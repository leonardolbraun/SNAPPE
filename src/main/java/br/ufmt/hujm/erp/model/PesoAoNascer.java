package br.ufmt.hujm.erp.model;

public enum PesoAoNascer {

	MAIOROUIGUAL1000(">= 1.000 g"), 
	P750a999("750 - 999 g"),
	MENORQUE750("menor 750 g"); 
	
	private String descricao;

	PesoAoNascer(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}