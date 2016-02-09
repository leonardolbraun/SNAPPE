package br.ufmt.hujm.erp.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Exames implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_exame")
	private Date dataExame;
	
	@Column(name = "total_score", nullable = false, length = 5)
	private String totalScore;

	@ManyToOne
	@JoinColumn(name = "recemNascido_id")
	private RecemNascido recemNascido;

	@NotNull
	@Enumerated(EnumType.STRING)
	private PressaoArterialMedia pressaoArterialMedia;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Temperatura temperatura;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Razao razao;

	@NotNull
	@Enumerated(EnumType.STRING)
	private PhDoSangue phDoSangue;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ConvulsoesMultiplas convulsoesMultiplas;

	@NotNull
	@Enumerated(EnumType.STRING)
	private VolumeUrinario volumeUrinario;

	@NotNull
	@Enumerated(EnumType.STRING)
	private PesoAoNascer pesoAoNascer;

	@NotNull
	@Enumerated(EnumType.STRING)
	private PIG pig;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ApgarDeCincoMinutos apgarDeCincoMinutos;

	@NotNull
	@Enumerated(EnumType.STRING)
	private IdadeGestacional idadeGestacional;
	
	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

	public String getDataFormatada() {
		return new SimpleDateFormat("dd/MM/yyyy").format(dataExame);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}

	public RecemNascido getRecemNascido() {
		return recemNascido;
	}

	public void setRecemNascido(RecemNascido recemNascido) {
		this.recemNascido = recemNascido;
	}

	public PressaoArterialMedia getPressaoArterialMedia() {
		return pressaoArterialMedia;
	}

	public void setPressaoArterialMedia(
			PressaoArterialMedia pressaoArterialMedia) {
		this.pressaoArterialMedia = pressaoArterialMedia;
	}

	public Temperatura getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Temperatura temperatura) {
		this.temperatura = temperatura;
	}

	public Razao getRazao() {
		return razao;
	}

	public void setRazao(Razao razao) {
		this.razao = razao;
	}

	public PhDoSangue getPhDoSangue() {
		return phDoSangue;
	}

	public void setPhDoSangue(PhDoSangue phDoSangue) {
		this.phDoSangue = phDoSangue;
	}

	public ConvulsoesMultiplas getConvulsoesMultiplas() {
		return convulsoesMultiplas;
	}

	public void setConvulsoesMultiplas(ConvulsoesMultiplas convulsoesMultiplas) {
		this.convulsoesMultiplas = convulsoesMultiplas;
	}

	public VolumeUrinario getVolumeUrinario() {
		return volumeUrinario;
	}

	public void setVolumeUrinario(VolumeUrinario volumeUrinario) {
		this.volumeUrinario = volumeUrinario;
	}

	public PesoAoNascer getPesoAoNascer() {
		return pesoAoNascer;
	}

	public void setPesoAoNascer(PesoAoNascer pesoAoNascer) {
		this.pesoAoNascer = pesoAoNascer;
	}

	public PIG getPig() {
		return pig;
	}

	public void setPig(PIG pig) {
		this.pig = pig;
	}

	public ApgarDeCincoMinutos getApgarDeCincoMinutos() {
		return apgarDeCincoMinutos;
	}

	public void setApgarDeCincoMinutos(ApgarDeCincoMinutos apgarDeCincoMinutos) {
		this.apgarDeCincoMinutos = apgarDeCincoMinutos;
	}

	public IdadeGestacional getIdadeGestacional() {
		return idadeGestacional;
	}

	public void setIdadeGestacional(IdadeGestacional idadeGestacional) {
		this.idadeGestacional = idadeGestacional;
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
		Exames other = (Exames) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}