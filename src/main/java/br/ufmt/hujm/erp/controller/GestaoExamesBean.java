package br.ufmt.hujm.erp.controller;

import java.awt.image.RescaleOp;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.ufmt.hujm.erp.model.ApgarDeCincoMinutos;
import br.ufmt.hujm.erp.model.ConvulsoesMultiplas;
import br.ufmt.hujm.erp.model.IdadeGestacional;
import br.ufmt.hujm.erp.model.PIG;
import br.ufmt.hujm.erp.model.PesoAoNascer;
import br.ufmt.hujm.erp.model.PhDoSangue;
import br.ufmt.hujm.erp.model.PressaoArterialMedia;
import br.ufmt.hujm.erp.model.Razao;
import br.ufmt.hujm.erp.model.RecemNascido;
import br.ufmt.hujm.erp.model.Sexo;
import br.ufmt.hujm.erp.model.Temperatura;
import br.ufmt.hujm.erp.model.Exames;
import br.ufmt.hujm.erp.model.VolumeUrinario;
import br.ufmt.hujm.erp.repository.RecemNascidoDAO;
import br.ufmt.hujm.erp.service.CadastroRecemNascidoService;
import br.ufmt.hujm.erp.util.FacesMessages;

@Named
@ManagedBean
@ViewScoped
public class GestaoExamesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private RecemNascidoDAO recemNascidoDAO;

	@Inject
	private CadastroRecemNascidoService cadastroRecemNascido;

	@Inject
	private CadastroRecemNascidoService cadastroExames;

	@Inject
	private FacesMessages messages;

	private List<RecemNascido> todosRecemNascidos;

	private List<Exames> todosExames;

	public List<Exames> getTodosExames() {
		return todosExames;
	}

	private Exames recemNascidoExames = new Exames();

	private List<RecemNascido> recemNascidosFiltrados;
	private List<Exames> examesFiltrados;

	private RecemNascido recemNascidoEdicao = new RecemNascido();
	private RecemNascido recemNascidoSelecionado;
	private Exames exameSelecionado;

	public void prepararNovoCadastro() {
		recemNascidoEdicao = new RecemNascido();
	}

	@PostConstruct
	public void consultarDados() {
		todosRecemNascidos = recemNascidoDAO.todosRecemNascidos();
		todosExames = recemNascidoDAO.todosExames();
	}

	public void salvar() {
		cadastroRecemNascido.salvar(recemNascidoEdicao);
		consultarDados();

		messages.info("RN Salvo com Sucesso");

		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:rn-table"));

	}

	private String getRandomImageName() {
		int i = (int) (Math.random() * 10000000);

		return String.valueOf(i);
	}

	public void excluir() {
		cadastroRecemNascido.excluir(recemNascidoSelecionado);
		recemNascidoSelecionado = null;
		consultarDados();

		messages.info("RN excluído com Sucesso.");

		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:rn-table"));

	}

	public Exames getRecemNascidoExames() {
		return recemNascidoExames;
	}

	public void setRecemNascidoExames(Exames recemNascidoExames) {
		this.recemNascidoExames = recemNascidoExames;
	}

	public Exames getExameSelecionado() {
		return exameSelecionado;
	}

	public void setExameSelecionado(Exames exameSelecionado) {
		this.exameSelecionado = exameSelecionado;
	}

	public void salvaExame() {

		if (recemNascidoEdicao != null) {

			recemNascidoExames.setRecemNascido(recemNascidoEdicao);
			cadastroExames.salvarExame(recemNascidoExames);

			consultarDados();
		} else {

			recemNascidoExames.setRecemNascido(recemNascidoSelecionado);
			cadastroExames.salvarExame(recemNascidoExames);

			consultarDados();
		}
		messages.info("Exame salvo com sucesso");

	}

	// Calcular Pressao Arterial Media
	private String valorPressaoArterialMedia;

	public String getValorPressaoArterialMedia() {
		return valorPressaoArterialMedia;
	}

	public void pressaoChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getPressaoArterialMedia().getDescricao()
				.equals("Não avaliada"))
			valorPressaoArterialMedia = "0";

		if (recemNascidoExames.getPressaoArterialMedia().getDescricao()
				.equals(">= 30 mmHg"))
			valorPressaoArterialMedia = "0";

		if (recemNascidoExames.getPressaoArterialMedia().getDescricao()
				.equals("20 - 29 mmHg"))
			valorPressaoArterialMedia = "9";

		if (recemNascidoExames.getPressaoArterialMedia().getDescricao()
				.equals("menor 20 mmHg"))
			valorPressaoArterialMedia = "19";
	}

	// fim Calcular Pressao Arterial Media

	// Calcular temperatura
	private String valorTemperatura;

	public String getValorTemperatura() {
		return valorTemperatura;
	}

	public void temperaturaChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getTemperatura().getDescricao()
				.equals("Não avaliada"))
			valorTemperatura = "0";

		if (recemNascidoExames.getTemperatura().getDescricao()
				.equals("1. > 35,6ºC"))
			valorTemperatura = "0";

		if (recemNascidoExames.getTemperatura().getDescricao()
				.equals("2. 35 - 35,6ºC"))
			valorTemperatura = "8";

		if (recemNascidoExames.getTemperatura().getDescricao()
				.equals("3. 35ºC"))
			valorTemperatura = "15";
	}

	// fim Calcular temperatura

	// Calcular Razao
	private String valorRazao;

	public String getValorRazao() {
		return valorRazao;
	}

	public void razaoChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getRazao().getDescricao()
				.equals("Não existente"))
			valorRazao = "0";

		if (recemNascidoExames.getRazao().getDescricao().equals("> 2,49"))
			valorRazao = "0";

		if (recemNascidoExames.getRazao().getDescricao().equals("1 - 2,49"))
			valorRazao = "5";

		if (recemNascidoExames.getRazao().getDescricao().equals("0,3 - 0,99"))
			valorRazao = "16";

		if (recemNascidoExames.getRazao().getDescricao().equals("menor 0,3"))
			valorRazao = "28";
	}

	// fim Calcular razao

	// Calcular PhDoSangue
	private String valorPhDoSangue;

	public String getValorPhDoSangue() {
		return valorPhDoSangue;
	}

	public void phDoSangueChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getPhDoSangue().getDescricao()
				.equals("Não realizado"))
			valorPhDoSangue = "0";

		if (recemNascidoExames.getPhDoSangue().getDescricao().equals(">= 7,20"))
			valorPhDoSangue = "0";

		if (recemNascidoExames.getPhDoSangue().getDescricao()
				.equals("7,10 - 7,19"))
			valorPhDoSangue = "7";

		if (recemNascidoExames.getPhDoSangue().getDescricao()
				.equals("menor 7,10"))
			valorPhDoSangue = "16";
	}

	// fim Calcular PhDoSangue

	// Calcular Convulsoes Multiplas
	private String valorConvulsoesMultiplas;

	public String getValorConvulsoesMultiplas() {
		return valorConvulsoesMultiplas;
	}

	public void convulsoesMultiplasChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getConvulsoesMultiplas().getDescricao()
				.equals("Não"))
			valorConvulsoesMultiplas = "0";

		if (recemNascidoExames.getConvulsoesMultiplas().getDescricao()
				.equals("Sim"))
			valorConvulsoesMultiplas = "19";
	}

	// fim Calcular PhDoSangue

	// Calcular Volume Urinario
	private String valorVolumeUrinario;

	public String getValorVolumeUrinario() {
		return valorVolumeUrinario;
	}

	public void volumeUrinarioChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getVolumeUrinario().getDescricao()
				.equals("Não medido (RN bem)"))
			valorVolumeUrinario = "0";

		if (recemNascidoExames.getVolumeUrinario().getDescricao()
				.equals(">= 1"))
			valorVolumeUrinario = "0";

		if (recemNascidoExames.getVolumeUrinario().getDescricao()
				.equals("0,1 - 0,99 (oligúria)"))
			valorVolumeUrinario = "5";

		if (recemNascidoExames.getVolumeUrinario().getDescricao()
				.equals("menor 0,1 (anúria)"))
			valorVolumeUrinario = "18";
	}

	// fim Volume Urinario

	// Calcular Peso ao Nacer
	private String valorPesoAoNascer;

	public String getValorPesoAoNascer() {
		return valorPesoAoNascer;
	}

	public void pesoAoNascerChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getPesoAoNascer().getDescricao()
				.equals(">= 1.000 g"))
			valorPesoAoNascer = "0";

		if (recemNascidoExames.getPesoAoNascer().getDescricao()
				.equals("750 - 999 g"))
			valorPesoAoNascer = "10";

		if (recemNascidoExames.getPesoAoNascer().getDescricao()
				.equals("menor 750 g"))
			valorPesoAoNascer = "17";

	}

	// fim Peso ao Nacer

	// Calcular PIG
	private String valorPig;

	public String getValorPIG() {
		return valorPig;
	}

	public void pigChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getPig().getDescricao().equals(">= percentil 3"))
			valorPig = "0";

		if (recemNascidoExames.getPig().getDescricao()
				.equals("menor percentil 3"))
			valorPig = "12";
	}

	// fim PIG

	// Calcular Apgar
	private String valorApgar;

	public String getValorApgar() {
		return valorApgar;
	}

	public void apgarDeCincoMinutosChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getApgarDeCincoMinutos().getDescricao()
				.equals(">= 7"))
			valorApgar = "0";

		if (recemNascidoExames.getApgarDeCincoMinutos().getDescricao()
				.equals("menor 7"))
			valorApgar = "12";
	}

	// fim Apgar

	// Calcular Idade Gestacional
	private String valorIdadeGestacional;

	public String getValorIdadeGestacional() {
		return valorIdadeGestacional;
	}

	public void idadeGestacionalChanged(AjaxBehaviorEvent even) {

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("22"))
			valorIdadeGestacional = "320";
		System.out.println(valorIdadeGestacional);

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("23"))
			valorIdadeGestacional = "380";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("24"))
			valorIdadeGestacional = "430";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("25"))
			valorIdadeGestacional = "500";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("26"))
			valorIdadeGestacional = "580";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("27"))
			valorIdadeGestacional = "670";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("28"))
			valorIdadeGestacional = "740";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("29"))
			valorIdadeGestacional = "820";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("30"))
			valorIdadeGestacional = "920";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("31"))
			valorIdadeGestacional = "1030";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("32"))
			valorIdadeGestacional = "1140";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("33"))
			valorIdadeGestacional = "1280";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("34"))
			valorIdadeGestacional = "1420";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("35"))
			valorIdadeGestacional = "1580";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("36"))
			valorIdadeGestacional = "1750";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("37"))
			valorIdadeGestacional = "1920";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("38"))
			valorIdadeGestacional = "2120";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("39"))
			valorIdadeGestacional = "2350";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("40"))
			valorIdadeGestacional = "2520";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals("41"))
			valorIdadeGestacional = "2660";

		if (recemNascidoExames.getIdadeGestacional().getDescricao()
				.equals(">41"))
			valorIdadeGestacional = "2750";
	}

	// fim Apgar

	// calcular geral o SNAPPE (SCORE TOTAL)

	public void scoreChanged(AjaxBehaviorEvent even) {
		Integer score = new Integer(0);

		if (valorPressaoArterialMedia != null)
			score += new Integer(valorPressaoArterialMedia);

		if (valorTemperatura != null)
			score += new Integer(valorTemperatura);

		if (valorRazao != null)
			score += new Integer(valorRazao);

		if (valorPhDoSangue != null)
			score += new Integer(valorPhDoSangue);

		if (valorConvulsoesMultiplas != null)
			score += new Integer(valorConvulsoesMultiplas);

		if (valorVolumeUrinario != null)
			score += new Integer(valorVolumeUrinario);

		if (valorPesoAoNascer != null)
			score += new Integer(valorPesoAoNascer);

		if (valorApgar != null)
			score += new Integer(valorApgar);

		recemNascidoExames.setTotalScore(score.toString());

	}

	// Seta a hora quando o botão do relógio é pressionado

	public Date getDataAtual() {

		Date minhaData = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(minhaData);
		minhaData = calendar.getTime();
		return minhaData;
	}

	public void horaExameChanged(AjaxBehaviorEvent even) {
		System.out.println(recemNascidoExames.getDataExame());
		recemNascidoExames.setDataExame(this.getDataAtual());
		System.out.println(recemNascidoExames.getDataExame());
	}

	// fim data

	public RecemNascido getRecemNascidoEdicao() {
		return recemNascidoEdicao;
	}

	public void setRecemNascidoEdicao(RecemNascido recemNascidoEdicao) {
		this.recemNascidoEdicao = recemNascidoEdicao;
	}

	public List<RecemNascido> getRecemNascidosFiltrados() {
		return recemNascidosFiltrados;
	}

	public List<Exames> getExamesFiltrados() {
		return examesFiltrados;
	}

	public void setExamesFiltrados(List<Exames> examesFiltrados) {
		this.examesFiltrados = examesFiltrados;
	}

	public void setRecemNascidosFiltrados(
			List<RecemNascido> recemNascidosFiltrados) {
		this.recemNascidosFiltrados = recemNascidosFiltrados;
	}

	public RecemNascido getRecemNascidoSelecionado() {
		return recemNascidoSelecionado;
	}

	public void setRecemNascidoSelecionado(RecemNascido recemNascidoSelecionado) {
		this.recemNascidoSelecionado = recemNascidoSelecionado;
	}

	public List<RecemNascido> getTodosRecemNascidos() {
		return todosRecemNascidos;
	}

	public PressaoArterialMedia[] getPressaoArterialMedia() {
		return PressaoArterialMedia.values();
	}

	public Temperatura[] getTemperatura() {
		return Temperatura.values();
	}

	public Razao[] getRazao() {
		return Razao.values();
	}

	public PhDoSangue[] getPhDoSangue() {
		return PhDoSangue.values();
	}

	public ConvulsoesMultiplas[] getConvulsoesMultiplas() {
		return ConvulsoesMultiplas.values();
	}

	public VolumeUrinario[] getVolumeUrinario() {
		return VolumeUrinario.values();
	}

	public PesoAoNascer[] getPesoAoNascer() {
		return PesoAoNascer.values();
	}

	public PIG[] getPIG() {
		return PIG.values();
	}

	public ApgarDeCincoMinutos[] getApgarDeCincoMinutos() {
		return ApgarDeCincoMinutos.values();
	}

	public IdadeGestacional[] getIdadeGestacional() {
		return IdadeGestacional.values();
	}

	public Sexo[] getTiposSexo() {
		return Sexo.values();
	}

}
