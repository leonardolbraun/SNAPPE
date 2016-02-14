package br.ufmt.hujm.erp.model;

public enum Razao {

	NAOEXISTENTE("Não existente"), 
	R2V49("> 2,49"),
	R1A2V49("1 - 2,49"),
	R0V3A0V99("0,3 - 0,99"),
	MENOR0V3("menor 0,3");
	
	private String descricao;

	Razao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}