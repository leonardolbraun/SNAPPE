package br.ufmt.hujm.erp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

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
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	
	@OneToMany(mappedBy = "recemNascido", targetEntity = Exames.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Exames> exames;
	
	@Column(name = "rn_externo")
	private Boolean rnExterno;
	
	private Sexo sexoRn;
	
	@Column(name = "prontuario_mae", nullable = false, length = 18, unique = true)
	private String prontuarioMae;
	
	@Column(name = "idade_mae")
	private String idadeMae;

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Enumerated(EnumType.STRING)
	public Sexo getSexoRn() {
		return sexoRn;
	}

	public void setSexoRn(Sexo sexoRn) {
		this.sexoRn = sexoRn;
	}

	public String getProntuarioMae() {
		return prontuarioMae;
	}

	public void setProntuarioMae(String prontuarioMae) {
		this.prontuarioMae = prontuarioMae;
	}

	public String getIdadeMae() {
		return idadeMae;
	}

	public void setIdadeMae(String idadeMae) {
		this.idadeMae = idadeMae;
	}

	public Boolean getRnExterno() {
		return rnExterno;
	}

	public void setRnExterno(Boolean rnExterno) {
		this.rnExterno = rnExterno;
	}

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