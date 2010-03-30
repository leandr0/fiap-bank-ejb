/**
 * 
 */
package br.com.fiap.business.dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.business.exceptions.DAOException;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface CreditoLocalDAO extends BasicDAO<Credito> {

	/**
	 * M�todo respons�vel por listar todos os cr�ditos vinculados a <p>
	 * conta informada como par�metro
	 * @param conta
	 * @return {@link List}< {@link Credito} >
	 * @throws DAOException
	 */
	public List<Credito> listarCreditoConta(Conta conta)throws DAOException;
	
	/**
	 * Recupera da base de dados todos os cr�ditos com status SUJEITO_A_APROVACAO
	 * @return {@link List}< {@link Credito} >
	 * @throws DAOException
	 */
	public List<Credito> listaCreditoAvaliacao()throws DAOException;
}
