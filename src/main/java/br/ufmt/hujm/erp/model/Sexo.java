package br.ufmt.hujm.erp.model;

public enum Sexo {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino"),
	IGNORADO("Ignorado");
	
	private String descricao;
	
	private Sexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
