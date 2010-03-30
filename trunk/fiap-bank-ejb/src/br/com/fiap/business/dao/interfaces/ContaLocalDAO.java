/**
 * 
 */
package br.com.fiap.business.dao.interfaces;

import javax.ejb.Local;

import br.com.fiap.domain.entity.Conta;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface ContaLocalDAO extends BasicDAO<Conta> {

}
