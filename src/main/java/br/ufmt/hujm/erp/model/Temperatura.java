package br.ufmt.hujm.erp.model;

public enum Temperatura {

	T35V6("1. > 35,6ºC"), 
	T35A35V6("2. 35 - 35,6ºC"),
	T35("3. 35ºC");
	
	private String descricao;

	Temperatura(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}