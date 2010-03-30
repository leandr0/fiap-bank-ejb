/**
 * 
 */
package br.com.fiap.business.beans;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateful;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.security.annotation.SecurityDomain;

import br.com.fiap.business.dao.interfaces.ContaLocalDAO;
import br.com.fiap.business.dao.interfaces.CorrentistaLocalDAO;
import br.com.fiap.business.dao.interfaces.SegurancaLocalDAO;
import br.com.fiap.business.dao.interfaces.TipoContaLocalDAO;
import br.com.fiap.business.exceptions.BusinessException;
import br.com.fiap.business.interfaces.local.AbrirContaLocal;
import br.com.fiap.business.interfaces.remote.AbrirContaRemote;
import br.com.fiap.domain.entity.Agencia;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Correntista;
import br.com.fiap.domain.entity.Seguranca;
import br.com.fiap.domain.entity.TipoConta;




/**
 * @author leandro.goncalves
 * Classe com regras de negócio para abertura de conta
 */
@Stateful(name = "abrirConta")
@Remote(AbrirContaRemote.class)
@Local(AbrirContaLocal.class)
@SecurityDomain("fiap-bank-policy")
public class AbrirContaBean implements AbrirContaLocal,AbrirContaRemote{
	
	@EJB
	private ContaLocalDAO contaLocalDAO;
	
	@EJB
	private CorrentistaLocalDAO correntistaLocalDAO;
	
	@EJB
	private SegurancaLocalDAO segurancaLocalDAO;
	
	@EJB
	private TipoContaLocalDAO tipoContaLocalDAO;
	
	private static Log LOG = LogFactory.getLog(AbrirContaBean.class);
	
	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.interfaces.local.AbrirContaLocal#abrirConta(br.com.fiap.domain.entity.Correntista, br.com.fiap.domain.entity.Agencia)
	 */
	@Override
	@RolesAllowed(value = "GERENTE")
	public Correntista abrirConta(Correntista correntista,Agencia agencia) throws BusinessException{
		
		LOG.info("Montando entidades para criar conta corrente");
		
		/*
		 * Conta CORRENTE
		 */
		TipoConta tipoConta = tipoContaLocalDAO.getTipoContaCorrente();

		correntista.setConta(new Conta());
		correntista.getConta().setCorrentista(correntista);
		correntista.getConta().setAgencia(agencia);
		correntista.getConta().setTipoConta(tipoConta);
		
		return correntista;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.business.interfaces.local.AbrirContaLocal#adicionarSenha(br.com.fiap.domain.entity.Correntista, br.com.fiap.domain.entity.Seguranca)
	 */
	@Override
	@RolesAllowed(value = "GERENTE")
	public void adicionarSenha(Correntista correntista,Seguranca seguranca)throws BusinessException{
		
		LOG.info("Persistindo conta corrente");
		
		correntistaLocalDAO.insert(correntista);
		seguranca.setPerfil("CLIENTE");
		String codigoConta = StringUtils.leftPad(correntista.getConta().getId().toString(), 6, "0");
		seguranca.setLogin(codigoConta);
		seguranca.setConta(correntista.getConta());
		correntista.getConta().setSeguranca(seguranca);
		segurancaLocalDAO.insert(seguranca);
		correntista.getConta().setCodigoConta(codigoConta);
		contaLocalDAO.update(correntista.getConta());
	}	
}
