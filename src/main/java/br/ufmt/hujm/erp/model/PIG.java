package br.ufmt.hujm.erp.model;

public enum PIG {

	MAIORIGUALPERCENTIL3(">= percentil 3"), 
	MENORPERCENTIL3("menor percentil 3");
	
	private String descricao;

	PIG(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}