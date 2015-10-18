package br.ufmt.hujm.erp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class RecemNascido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Column(name = "nome_paciente", nullable = false, length = 80)
	private String nomePaciente;


	@Column(name = "recemNascidoDe_de", nullable = false, length = 80)
	private String recemNascidoDe;

	@NotEmpty
	@Column(name = "prontuario", nullable = false, length = 18, unique = true)
	private String prontuario;
	
	@OneToMany(mappedBy = "recemNascido", targetEntity = Exames.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Exames> exames;

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}

	public List<Exames> getExame() {
		return exames;
	}

	public void setExame(List<Exames> exame) {
		this.exames = exame;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRecemNascidoDe() {
		return recemNascidoDe;
	}

	public void setRecemNascidoDe(String recemNascidoDe) {
		this.recemNascidoDe = recemNascidoDe;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecemNascido other = (RecemNascido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}