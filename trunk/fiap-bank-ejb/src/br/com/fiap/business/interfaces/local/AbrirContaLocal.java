/**
 * 
 */
package br.com.fiap.business.interfaces.local;

import javax.ejb.Local;

import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Correntista;

/**
 * @author leandro.goncalves
 *
 */
@Local
public interface AbrirContaLocal {

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
