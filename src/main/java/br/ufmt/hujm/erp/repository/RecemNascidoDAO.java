package br.ufmt.hujm.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.ufmt.hujm.erp.model.RecemNascido;
import br.ufmt.hujm.erp.model.Exames;

public class RecemNascidoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public RecemNascido recemNascidosPorId(Long id) {
		return manager.find(RecemNascido.class, id);
	}
	
	public List<RecemNascido> todosRecemNascidos() {
		return manager.createQuery("from RecemNascido", RecemNascido.class).getResultList();
	}
	
	public RecemNascido guardarRecemNascido(RecemNascido recemNascido) {
		return manager.merge(recemNascido);
	}
	
	public void removerRecemNascido(RecemNascido recemNascido) {
		recemNascido = recemNascidosPorId(recemNascido.getId());
		manager.remove(recemNascido);
	}
	
	public Exames examesPorId(Long id) {
		return manager.find(Exames.class, id);
	}
	
	public List<Exames> todosExames() {
		return manager.createQuery("from Exames", Exames.class).getResultList();
	}
	
	public Exames guardarExames(Exames exames) {
		return manager.merge(exames);
	}
	
	public void removerExames(Exames exames) {
		exames = examesPorId(exames.getId());
		manager.remove(exames);
	}
}