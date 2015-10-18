package br.ufmt.hujm.erp.model;

public enum PressaoArterialMedia {

	NAOAVALIADA("Não avaliada"), 
	MENORIGUAL30(">= 30 mmHg"),
	VINTEAVINTENOVE("20 - 29 mmHg"),
	MENOR20("menor 20 mmHg");
	
	private String descricao;
	private String valor;

	PressaoArterialMedia(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getValor() {
		
		if (this.descricao.equals("Não avaliada"))
			return this.valor = "24";
		return valor= "";
	}
	
}