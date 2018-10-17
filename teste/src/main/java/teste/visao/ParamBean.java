package teste.visao;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="paramBean")
@RequestScoped
public class ParamBean {

	private String param1;
	private String param2;

	@PostConstruct
	public void parametersAction() {
		System.out.println("Teste ...");
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		param1 = request.getParameter("param1Name");
		param2 = request.getParameter("param2Name");
	}

	public String getParam1() {
		return param1;
	}

	public String getParam2() {
		return param2;
	}

}
