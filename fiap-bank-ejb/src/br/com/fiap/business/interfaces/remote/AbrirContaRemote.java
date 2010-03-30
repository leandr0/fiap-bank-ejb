/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import javax.ejb.Remote;

import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.domain.entity.Agencia;
import br.com.fiap.domain.entity.Correntista;
import br.com.fiap.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface AbrirContaRemote {

	/**
	 * Método responsável por montar as entidades relacionas na abertura da Conta
	 * @param correntista
	 * @param agencia
	 * @throws BusinessException
	 */
	public Correntista abrirConta(Correntista correntista,Agencia agencia) throws BusinessException;
	
	/**
	 * Método responsável pela adição da senha e persistência das entidades para abertura da conta 
	 * @param conta
	 * @param seguranca
	 * @throws BusinessException
	 */
	public void adicionarSenha(Correntista correntista,Seguranca seguranca) throws BusinessException;
}
