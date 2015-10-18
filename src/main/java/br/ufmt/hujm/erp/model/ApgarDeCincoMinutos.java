package br.ufmt.hujm.erp.model;

public enum ApgarDeCincoMinutos {

	MAIORIGUALSETE(">= 7"), 
	MENORSETE("menor 7");
	
	private String descricao;

	ApgarDeCincoMinutos(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}