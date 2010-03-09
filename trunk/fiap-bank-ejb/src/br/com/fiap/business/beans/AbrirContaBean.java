/**
 * 
 */
package br.com.fiap.business.beans;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.apache.commons.lang.StringUtils;
import org.jboss.annotation.security.SecurityDomain;

import br.com.fiap.business.interfaces.local.AbrirContaLocal;
import br.com.fiap.business.interfaces.remote.AbrirContaRemote;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Correntista;




/**
 * @author leandro.goncalves
 *
 */
@Stateful(name = "abrirConta")
@Remote(AbrirContaRemote.class)
@Local(AbrirContaLocal.class)
@SecurityDomain("fiap-bank-policy")
public class AbrirContaBean extends AbstractPersistenceContextBean implements AbrirContaLocal,AbrirContaRemote{
	
	@Override
	@RolesAllowed(value = "GERENTE")
	public Conta abrirConta(Correntista correntista) {
		entityManager.persist(correntista);
		return correntista.getConta();
	}

	@Override
	@RolesAllowed(value = "GERENTE")
	public void adicionarSenha(Conta conta){
		conta.getSeguranca().setPerfil("CLIENTE");
		String codigoConta = StringUtils.leftPad(conta.getId().toString(), 6, "0");
		conta.getSeguranca().setLogin(codigoConta);
		entityManager.persist(conta.getSeguranca());
		conta.setCodigoConta(codigoConta);
		entityManager.merge(conta);
	}
	
}
