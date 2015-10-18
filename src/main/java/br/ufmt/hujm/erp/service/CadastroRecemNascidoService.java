package br.ufmt.hujm.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.ufmt.hujm.erp.model.RecemNascido;
import br.ufmt.hujm.erp.model.Exames;
import br.ufmt.hujm.erp.repository.RecemNascidoDAO;
import br.ufmt.hujm.erp.util.Transacional;

public class CadastroRecemNascidoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private RecemNascidoDAO recemNascidoDAO;
	
	@Transacional
	public void salvar(RecemNascido recemNascido) {
		recemNascidoDAO.guardarRecemNascido(recemNascido);
	}
	
	@Transacional
	public void excluir(RecemNascido recemNascido) {
		recemNascidoDAO.removerRecemNascido(recemNascido);
	}
	
	@Transacional
	public void salvarExame(Exames exames) {
		recemNascidoDAO.guardarExames(exames);
	}
	
	@Transacional
	public void excluirExame(Exames exames) {
		recemNascidoDAO.removerExames(exames);
	}
	
	
	
}