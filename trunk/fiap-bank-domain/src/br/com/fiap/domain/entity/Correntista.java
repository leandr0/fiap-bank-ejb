package br.com.fiap.domain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;

import br.com.fiap.validator.validadores.ValueNotZero;

/**
 * @author User
 * @version 1.0
 * @created 20-fev-2010 20:42:09
 */
@Entity
@Table(name = "CORRENTISTA")
public class Correntista implements EntityBasic{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "RENDA_MENSAL",nullable = false)
	@ValueNotZero(message = "A renda mensal deve ser maior que zero")
	private Double rendaMensal;
	
	@Column(name = "VALOR_TOTAL_PATRIMONIO",nullable = false)
	@ValueNotZero(message = "O valor do patrimônio total deve ser maior que zero")
	private Double valorTotalPatrimonio;
	
	@Column(name = "GASTO_MENSAL_APROXIMADO",nullable = false)
	@ValueNotZero(message = "O gasto mensal deve ser maior que zero")
	private Double gastoMensalAproximado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USUARIO_ID",nullable = false)
	@NotNull
	@Valid
	private Usuario usuario;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTA_ID",nullable = false)
	@NotNull
	@Valid
	private Conta conta;

	public Correntista() {}
	
	public Correntista(Usuario usuario) {
		this.usuario = usuario;
		this.usuario.setCorrentista(this);
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.domain.entity.EntityBasic#getId()
	 */
	public Long getId() {
		return id;
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.fiap.domain.entity.EntityBasic#setId(java.lang.Long)
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	public Double getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(Double rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public Double getValorTotalPatrimonio() {
		return valorTotalPatrimonio;
	}

	public void setValorTotalPatrimonio(Double valorTotalPatrimonio) {
		this.valorTotalPatrimonio = valorTotalPatrimonio;
	}

	public Double getGastoMensalAproximado() {
		return gastoMensalAproximado;
	}

	public void setGastoMensalAproximado(Double gastoMensalAproximado) {
		this.gastoMensalAproximado = gastoMensalAproximado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}