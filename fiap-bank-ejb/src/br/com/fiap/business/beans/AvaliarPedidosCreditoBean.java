/**
 * 
 */
package br.com.fiap.business.beans;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.business.dao.interfaces.CreditoLocalDAO;
import br.com.fiap.business.interfaces.local.AvaliarPedidosCreditoLocal;
import br.com.fiap.business.interfaces.remote.AvaliarPedidosCreditoRemote;
import br.com.fiap.domain.entity.Credito;
import br.com.fiap.domain.enums.StatusCredito;

/**
 * @author leandro.goncalves
 *
 */
@Stateless(name ="avaliarPedidosCredito")
@Remote(AvaliarPedidosCreditoRemote.class)
@Local(AvaliarPedidosCreditoLocal.class)
@SecurityDomain("fiap-bank-policy")
public class AvaliarPedidosCreditoBean /*extends AbstractPersistenceContextBean */implements AvaliarPedidosCreditoLocal,AvaliarPedidosCreditoRemote {

	@EJB
	private CreditoLocalDAO creditoLocalDAO;
	
	@Override
	@RolesAllowed(value = "GERENTE")
	public List<Credito> recuperarListaCreditos() {

		/*String jpql = "select c from "+Credito.class.getName()+" c "+
						"where c.statusCredito = :statusCredito";
		
		Query query = entityManager.createQuery(jpql);
			query.setParameter("statusCredito", StatusCredito.SUJEITO_A_APROVACAO);
		
		return query.getResultList();*/
		
		return creditoLocalDAO.listaCreditoAvaliacao();
	}

	@Override
	@RolesAllowed(value = "GERENTE")
	public List<Credito> aprovarCredito(Credito credito) {
		
		credito.setStatusCredito(StatusCredito.APROVADO);
		/*entityManager.merge(credito);*/
		creditoLocalDAO.update(credito);
		
		return recuperarListaCreditos();
	}

	@Override
	@RolesAllowed(value = "GERENTE")
	public List<Credito> reprovarCredito(Credito credito) {
		
		credito.setStatusCredito(StatusCredito.RECUSADO);
		/*entityManager.merge(credito);*/
		creditoLocalDAO.update(credito);
		
		return recuperarListaCreditos();
	}

}