/**
 * 
 */
package br.com.fiap.business.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.fiap.business.dao.interfaces.ContaLocalDAO;
import br.com.fiap.domain.entity.Conta;

/**
 * @author leandro.goncalves
 *
 */
@Stateless(name = "contaDAO")
@Local(ContaLocalDAO.class)
public class ContaDAO extends GenericDAO<Conta> implements ContaLocalDAO {

}
