package teste.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagementType;

import teste.model.Aluno;

@Stateless(name = "AlunoDao")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@Local
public class AlunoDao extends GenericDAOImpl<Aluno> {

}
