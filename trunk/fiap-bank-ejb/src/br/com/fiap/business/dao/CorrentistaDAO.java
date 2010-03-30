/**
 * 
 */
package br.com.fiap.business.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.fiap.business.dao.interfaces.CorrentistaLocalDAO;
import br.com.fiap.domain.entity.Correntista;

/**
 * @author leandro.goncalves
 *
 */
@Stateless(name = "correntistaDAO")
@Local(CorrentistaLocalDAO.class)
public class CorrentistaDAO extends GenericDAO<Correntista> implements CorrentistaLocalDAO {
}
