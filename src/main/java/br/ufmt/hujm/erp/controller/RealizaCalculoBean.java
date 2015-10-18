package br.ufmt.hujm.erp.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import br.ufmt.hujm.erp.model.PressaoArterialMedia;

@ManagedBean
public class RealizaCalculoBean implements Serializable {

	public String pressao(PressaoArterialMedia pressao) {

		if (pressao.getDescricao().equals("Não avaliada"))
			return "24";

		return "";

	}
}