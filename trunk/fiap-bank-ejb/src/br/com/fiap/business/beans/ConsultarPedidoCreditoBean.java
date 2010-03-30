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
import br.com.fiap.business.interfaces.local.ConsultarPedidoCreditoLocal;
import br.com.fiap.business.interfaces.remote.ConsultarPedidoCreditoRemote;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;

/**
 * @author leandro.goncalves
 * Classe responsável pelas regras de negócio para cosulta de pedidos de crédito
 */
@Stateless(name = "consultaPedidoCredito")
@Remote(ConsultarPedidoCreditoRemote.class)
@Local(ConsultarPedidoCreditoLocal.class)
@SecurityDomain("fiap-bank-policy")
public class ConsultarPedidoCreditoBean implements ConsultarPedidoCreditoRemote,ConsultarPedidoCreditoLocal {

	@EJB
	private CreditoLocalDAO creditoLocalDAO;

	private static Log LOG = LogFactory.getLog(ConsultarPedidoCreditoBean.class);
	
	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.interfaces.remote.ConsultarPedidoCreditoRemote#consultarPedidosCredito(br.com.fiap.domain.entity.Conta)
	 */
	@Override
	@RolesAllowed(value = "CLIENTE")
	public List<Credito> consultarPedidosCredito(Conta conta) throws BusinessException{
		LOG.info("Listando lista de credito para conta : "+( conta != null ? conta.getCodigoConta(): ""));
		return creditoLocalDAO.listarCreditoConta(conta);
	}
}