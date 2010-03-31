/**
 * 
 */
package br.com.fiap.business.beans;

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
import br.com.fiap.business.interfaces.local.AbrirPedidoCreditoLocal;
import br.com.fiap.business.interfaces.remote.AbrirPedidoCreditoRemote;
import br.com.fiap.business.validator.AbrirCreditoValidator;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;
import br.com.fiap.domain.enums.StatusCredito;

/**
 * @author leandro.goncalves
 * Classe responsável pela regras de negócio para abertura de pedido de crédito
 */
@Stateless(name = "abrirPedidoCredito")
@Remote(AbrirPedidoCreditoRemote.class)
@Local(AbrirPedidoCreditoLocal.class)
@SecurityDomain("fiap-bank-policy")
public class AbrirPedidoCreditoBean extends BeanValidator implements AbrirPedidoCreditoLocal,AbrirPedidoCreditoRemote{
	
	@EJB
	private CreditoLocalDAO creditoLocalDAO;

	private static Log LOG = LogFactory.getLog(AbrirPedidoCreditoBean.class);
	
	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.interfaces.local.AbrirPedidoCreditoLocal#abrirPedidoCredito(br.com.fiap.domain.entity.Credito, br.com.fiap.domain.entity.Conta)
	 */
	@Override
	@RolesAllowed(value = "CLIENTE")
	public Credito abrirPedidoCredito(Credito credito, Conta conta) throws BusinessException{
		LOG.info("Inserindo credito para conta : "+conta.getCodigoConta());
		creditoLocalDAO.insert(credito);
		
		return credito;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.interfaces.local.AbrirPedidoCreditoLocal#avaliarPedidoCredito(br.com.fiap.domain.entity.Credito, br.com.fiap.domain.entity.Conta)
	 */
	@Override
	@RolesAllowed(value = "CLIENTE")
	public Credito avaliarPedidoCredito(Credito credito, Conta conta) throws BusinessException{
		
		LOG.info("Avaliando pedido credito para conta : "+conta.getCodigoConta());

		validator = new AbrirCreditoValidator();
		
		messageValidator = validator.validar(credito);
		
		if(messageValidator != null){
			valid = false;
			return credito;
		}else
			valid = true;
		
		double renda 		= conta.getCorrentista().getRendaMensal();
		double gasto 		= conta.getCorrentista().getGastoMensalAproximado();
		double patrimonio 	= conta.getCorrentista().getValorTotalPatrimonio();
		double valor 		= credito.getValorCredito();
		int    meses    	= credito.getNumeroMesesPagamento();
		
		if(valor < ((renda - gasto) * 0.4 * meses) ||
				valor < (((renda - gasto) * 0.2 * meses)+ (0.1 * patrimonio)))
			credito.setStatusCredito(StatusCredito.APROVADO);
		else if(valor > (((renda - gasto) * 0.6 * meses) + (0.3 * patrimonio)))
			credito.setStatusCredito(StatusCredito.RECUSADO);
		else
			credito.setStatusCredito(StatusCredito.SUJEITO_A_APROVACAO);
		
		LOG.info("Credito com status "+credito.getStatusCredito()+" para conta : "+conta.getCodigoConta());
		
		credito.setConta(conta);
		
		return credito;
	}
}
