/**
 * 
 */
package br.com.fiap.business.beans;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.annotation.security.SecurityDomain;

import br.com.fiap.business.interfaces.local.ConsultarPedidoCreditoLocal;
import br.com.fiap.business.interfaces.remote.ConsultarPedidoCreditoRemote;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 *
 */
@Stateless(name = "consultaPedidoCredito")
@Remote(ConsultarPedidoCreditoRemote.class)
@Local(ConsultarPedidoCreditoLocal.class)
@SecurityDomain("fiap-bank-policy")
public class ConsultarPedidoCreditoBean extends AbstractPersistenceContextBean  implements ConsultarPedidoCreditoRemote,ConsultarPedidoCreditoLocal {

	@Override
	@RolesAllowed(value = "CLIENTE")
	public List<Credito> consultarPedidosCredito(Conta conta) {
		
		conta = entityManager.find(Conta.class, conta.getId());
		
		return conta.getCreditos();
	}
}
