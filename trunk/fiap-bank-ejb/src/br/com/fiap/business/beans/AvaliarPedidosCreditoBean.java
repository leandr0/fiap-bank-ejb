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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.business.dao.interfaces.CreditoLocalDAO;
import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.business.interfaces.local.AvaliarPedidosCreditoLocal;
import br.com.fiap.business.interfaces.remote.AvaliarPedidosCreditoRemote;
import br.com.fiap.domain.entity.Credito;
import br.com.fiap.domain.enums.StatusCredito;

/**
 * @author leandro.goncalves
 * Classe responsável pelas regras de negócio para avaliação de pedidos de crédito
 */
@Stateless(name ="avaliarPedidosCredito")
@Remote(AvaliarPedidosCreditoRemote.class)
@Local(AvaliarPedidosCreditoLocal.class)
@SecurityDomain("fiap-bank-policy")
public class AvaliarPedidosCreditoBean implements AvaliarPedidosCreditoLocal,AvaliarPedidosCreditoRemote {

	@EJB
	private CreditoLocalDAO creditoLocalDAO;

	private static Log LOG = LogFactory.getLog(AvaliarPedidosCreditoBean.class);
	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.interfaces.local.AvaliarPedidosCreditoLocal#recuperarListaCreditos()
	 */
	@Override
	@RolesAllowed(value = "GERENTE")
	public List<Credito> recuperarListaCreditos() throws BusinessException{
		LOG.info("Listando creditos sujeitos a aprovacao");
		return creditoLocalDAO.listaCreditoAvaliacao();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.interfaces.local.AvaliarPedidosCreditoLocal#aprovarCredito(br.com.fiap.domain.entity.Credito)
	 */
	@Override
	@RolesAllowed(value = "GERENTE")
	public List<Credito> aprovarCredito(Credito credito) throws BusinessException{
		
		credito.setStatusCredito(StatusCredito.APROVADO);
		creditoLocalDAO.update(credito);
		
		return recuperarListaCreditos();
	}

	@Override
	@RolesAllowed(value = "GERENTE")
	public List<Credito> reprovarCredito(Credito credito) throws BusinessException{
		
		credito.setStatusCredito(StatusCredito.RECUSADO);
		creditoLocalDAO.update(credito);
		
		return recuperarListaCreditos();
	}
}