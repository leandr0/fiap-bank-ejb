/**
 * 
 */
package br.com.fiap.business.beans;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.business.dao.interfaces.CreditoLocalDAO;
import br.com.fiap.business.interfaces.local.AbrirPedidoCreditoLocal;
import br.com.fiap.business.interfaces.remote.AbrirPedidoCreditoRemote;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;
import br.com.fiap.domain.enums.StatusCredito;

/**
 * @author leandro.goncalves
 *
 */
@Stateless(name = "abrirPedidoCredito")
@Remote(AbrirPedidoCreditoRemote.class)
@Local(AbrirPedidoCreditoLocal.class)
@SecurityDomain("fiap-bank-policy")
public class AbrirPedidoCreditoBean  implements AbrirPedidoCreditoLocal,AbrirPedidoCreditoRemote{
	
	@EJB
	private CreditoLocalDAO creditoLocalDAO;
	
	
	@Override
	@RolesAllowed(value = "CLIENTE")
	public Credito abrirPedidoCredito(Credito credito, Conta conta) {
		
		creditoLocalDAO.insert(credito);
		
		return credito;
	}

	@Override
	@RolesAllowed(value = "CLIENTE")
	public Credito avaliarPedidoCredito(Credito credito, Conta conta) {
		
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
		
		credito.setConta(conta);

		return credito;
	}
}