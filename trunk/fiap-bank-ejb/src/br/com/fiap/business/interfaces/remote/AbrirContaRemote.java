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
	 * M�todo respons�vel por montar as entidades relacionas na abertura da Conta
	 * @param correntista
	 * @param agencia
	 * @throws BusinessException
	 */
	public Correntista abrirConta(Correntista correntista,Agencia agencia) throws BusinessException;
	
	/**
	 * M�todo respons�vel pela adi��o da senha e persist�ncia das entidades para abertura da conta 
	 * @param conta
	 * @param seguranca
	 * @throws BusinessException
	 */
	public void adicionarSenha(Correntista correntista,Seguranca seguranca) throws BusinessException;
}
