package br.ufmt.hujm.erp.model;

public enum Temperatura {

	TRINTACINCOSEIS("1. > 35,6ºC"), 
	TRINTACINCOATRINTASEIS("2. 35 - 35,6ºC"),
	TRINTACINCO("3. 35ºC");
	
	private String descricao;

	Temperatura(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}