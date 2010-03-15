/**
 * 
 */
package br.com.fiap.business.interfaces.remote;

import javax.ejb.Remote;

import br.com.fiap.domain.entity.Agencia;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Correntista;
import br.com.fiap.domain.entity.Seguranca;

/**
 * @author leandro.goncalves
 *
 */
@Remote
public interface AbrirContaRemote {

	/**
	 * 
	 * @param correntista
	 * @param agencia
	 */
	public Conta abrirConta(Correntista correntista,Agencia agencia);
	
	/**
	 * 
	 * @param conta
	 * @param seguranca
	 */
	public void adicionarSenha(Conta conta,Seguranca seguranca);
}
