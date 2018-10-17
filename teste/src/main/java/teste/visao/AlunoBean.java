package teste.visao;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import teste.dao.AlunoDao;
import teste.model.Aluno;

@Named(value = "alunoBean")
@RequestScoped
public class AlunoBean {

	private static final Logger LOGGER = LogManager.getLogger(AlunoBean.class);

	private String nome;
	private String sobrenome;

	@EJB
	private AlunoDao alunoDao;

	public String submit() {

		Aluno aluno = new Aluno();
		aluno.setId(1);
		aluno.setNome(nome);

		alunoDao.persist(aluno);

		return "nome_submit";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

}
