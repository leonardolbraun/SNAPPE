package br.ufmt.hujm.erp.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.ufmt.hujm.erp.controller.AbstractReportBean;
import br.ufmt.hujm.erp.model.Exames;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;

@ManagedBean(name = "reportsBean")
@SessionScoped
public class ReportsBean extends AbstractReportBean implements Serializable {

	private final String COMPILE_FILE_NAME = "SNAPPE";
	
	Long id = new Long(2);

	//ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	//HttpSession session = (HttpSession) externalContext.getSession(true);
	//GestaoExamesBean gestaoExamesBean= (GestaoExamesBean)session.getAttribute("gestaoExamesBean");

	@Override
	protected String getCompileFileName() {
		return COMPILE_FILE_NAME;
	}

	@Override
	protected Map<String, Object> getReportParameters() {
		Map<String, Object> reportParameters = new HashMap<String, Object>();

		reportParameters.put("idExame", id);

		return reportParameters;
	}

	Long idExame = new Long(0);

	public Long idExameSelecionado() {
		
		
		//System.out.println("ESTA AQUIIIII: " + gestaoExamesBean.getExameSelecionado().getTotalScore().toString());
		
		return idExame;
	}

	public String execute(Long id) {
		try {
			this.id = id;//sExameSelecionado();
			super.prepareReport();
		} catch (Exception e) {
			// criar a exception
			e.printStackTrace();
		}

		return null;
	}
}