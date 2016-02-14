package br.ufmt.hujm.erp.model;

public enum PhDoSangue {

	NAOREALIZADO("Não realizado"), 
	MAIOIGUAL7V20(">= 7,20"),
	PH7V10A7V19("7,10 - 7,19"),
	MENOR7V10("menor 7,10");
	
	private String descricao;

	PhDoSangue(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}