/**
 * 
 */
package br.com.fiap.business.beans;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.apache.commons.lang.StringUtils;
import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.business.interfaces.local.AbrirContaLocal;
import br.com.fiap.business.interfaces.remote.AbrirContaRemote;
import br.com.fiap.domain.entity.Agencia;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Correntista;
import br.com.fiap.domain.entity.Seguranca;
import br.com.fiap.domain.entity.TipoConta;




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
	public Correntista abrirConta(Correntista correntista,Agencia agencia) {
		
		TipoConta tipoConta = new TipoConta();
		tipoConta.setId(1L);

		correntista.setConta(new Conta());
		correntista.getConta().setCorrentista(correntista);
		correntista.getConta().setAgencia(agencia);
		correntista.getConta().setTipoConta(tipoConta);
		
		//entityManager.persist(correntista);
		return correntista;
	}

	@Override
	@RolesAllowed(value = "GERENTE")
	public void adicionarSenha(Correntista correntista,Seguranca seguranca){
		entityManager.persist(correntista);
		seguranca.setPerfil("CLIENTE");
		String codigoConta = StringUtils.leftPad(correntista.getConta().getId().toString(), 6, "0");
		seguranca.setLogin(codigoConta);
		seguranca.setConta(correntista.getConta());
		correntista.getConta().setSeguranca(seguranca);
		entityManager.persist(seguranca);
		correntista.getConta().setCodigoConta(codigoConta);
		entityManager.merge(correntista.getConta());
	}
	
}
