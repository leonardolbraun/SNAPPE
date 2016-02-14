package br.ufmt.hujm.erp.model;

public enum VolumeUrinario {

	NAOMEDIDO("Não medido (RN bem)"), 
	MENORIGUAL1(">= 1"),
	V0V1A0V99("0,1 - 0,99 (oligúria)"), 
	MENOR0V1("menor 0,1 (anúria)");
	
	
	private String descricao;

	VolumeUrinario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}