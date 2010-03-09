/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import javax.ejb.Remote;

import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Correntista;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface AbrirContaRemote {

	/**
	 * 
	 * @param correntista
	 */
	public Conta abrirConta(Correntista correntista);
	
	/**
	 * 
	 * @param conta
	 */
	public void adicionarSenha(Conta conta);
}
