package br.ufmt.hujm.erp.model;

public enum VolumeUrinario {

	NAOMEDIDO("Não medido (RN bem)"), 
	MENORIGUALUM(">= 1"),
	ZEROVIRGULAUMAZEROVIRGULANOVENTANOVE("0,1 - 0,99 (oligúria)"), 
	MENORZEROVIRGULAUM("menor 0,1 (anúria)");
	
	
	private String descricao;

	VolumeUrinario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}