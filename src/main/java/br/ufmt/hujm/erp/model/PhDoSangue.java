package br.ufmt.hujm.erp.model;

public enum PhDoSangue {

	NAOREALIZADO("Não realizado"), 
	MAIOIGUALSETEVIRGULAVINTE(">= 7,20"),
	SETEVIRULADEZASETEVIRGULADEZENOVE("7,10 - 7,19"),
	MENORSETEVIRGULADEZ("menor 7,10");
	
	private String descricao;

	PhDoSangue(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}