package br.ufmt.hujm.erp.model;

public enum ConvulsoesMultiplas {

	NAO("Não"), 
	SIM("Sim");
	
	private String descricao;

	ConvulsoesMultiplas(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}