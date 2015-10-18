package br.ufmt.hujm.erp.model;

public enum Razao {

	NAOEXISTENTE("Não existente"), 
	DOISVIRGULAQUATRONOVE("> 2,49"),
	UMADOISVIRGULAQUATRONOVE("1 - 2,49"),
	ZEROVIRGULATRESAZEROVIRGULANOVENTANOVE("0,3 - 0,99"),
	ZEROVIRGULATRES("menor 0,3");
	
	private String descricao;

	Razao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}