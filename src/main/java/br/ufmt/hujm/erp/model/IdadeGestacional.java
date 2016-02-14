package br.ufmt.hujm.erp.model;

public enum IdadeGestacional {
	
	I22("22"), 
	I23("23"), 
	I24("24"), 
	I25("25"), 
	I26("26"), 
	I27("27"), 
	I28("28"), 
	I29("29"), 
	I30("30"), 
	I31("31"), 
	I32("32"), 
	I33("33"), 
	I34("34"), 
	I35("35"), 
	I36("36"), 
	I37("37"), 
	I38("38"), 
	I39("39"), 
	I40("40"), 
	I41("41"), 
	MAIORQUE41(">41");
	
	private String descricao;

	IdadeGestacional(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}