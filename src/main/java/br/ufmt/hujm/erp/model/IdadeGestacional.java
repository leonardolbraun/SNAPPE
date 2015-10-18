package br.ufmt.hujm.erp.model;

public enum IdadeGestacional {
	
	VINTEEDOIS("22"), 
	VINTEETRES("23"), 
	VINTEEQUATRO("24"), 
	VINTEECINCO("25"), 
	VINTEESEIS("26"), 
	VINTEESETE("27"), 
	VINTEEOITO("28"), 
	VINTEENOVE("29"), 
	TRINTA("30"), 
	TRINTAEUM("31"), 
	TRINTAEDOIS("32"), 
	TRINTAETRES("33"), 
	TRINTAEUQUATRO("34"), 
	TRINTAECINCO("35"), 
	TRINTAESEIS("36"), 
	TRINTAESETE("37"), 
	TRINTAEOITO("38"), 
	TRINTAENOVE("39"), 
	QUARENTA("40"), 
	QUARENTAEUM("41"), 
	MAIORQUEQUARENTAEUM(">41");
	
	private String descricao;

	IdadeGestacional(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}