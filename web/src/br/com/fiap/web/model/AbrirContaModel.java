/**
 * 
 */
package br.com.fiap.web.model;

import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Correntista;
import br.com.fiap.domain.entity.Endereco;
import br.com.fiap.domain.entity.Seguranca;
import br.com.fiap.domain.entity.Usuario;

/**
 * @author User
 *
 */
public class AbrirContaModel {

	private Correntista correntista;
	
	private Seguranca seguranca;

	public AbrirContaModel() {
		correntista = new Correntista(new Usuario(new Endereco()));
		seguranca = new Seguranca();
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

	public Seguranca getSeguranca() {
		return seguranca;
	}

	public void setSeguranca(Seguranca seguranca) {
		this.seguranca = seguranca;
	}	
}
