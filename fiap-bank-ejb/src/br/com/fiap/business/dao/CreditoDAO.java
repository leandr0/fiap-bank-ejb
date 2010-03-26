/**
 * 
 */
package br.com.fiap.business.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.fiap.business.dao.interfaces.CreditoLocalDAO;
import br.com.fiap.domain.entity.Conta;
import br.com.fiap.domain.entity.Credito;
import br.com.fiap.domain.enums.StatusCredito;

/**
 * @author leandro.goncalves
 *
 */
@SuppressWarnings("unchecked")
@Stateless(name = "creditoDAO")
@Local(CreditoLocalDAO.class)
public class CreditoDAO extends GenericDAO<Credito> implements CreditoLocalDAO {

	@Override
	public List<Credito> listarCreditoConta(Conta conta) {
		
		Criteria criteria = ((Session)entityManager.getDelegate()).createCriteria(Credito.class);
		
		return criteria.addOrder(Order.asc("statusCredito"))
				.add(Restrictions.eq("conta.id", conta.getId())).list();
	}

	@Override
	public List<Credito> listaCreditoAvaliacao() {
		
		Criteria criteria = ((Session)entityManager.getDelegate()).createCriteria(Credito.class);
		
		criteria.add(Restrictions.eq("statusCredito", StatusCredito.SUJEITO_A_APROVACAO));
		
		return criteria.list();
	}
	
}
