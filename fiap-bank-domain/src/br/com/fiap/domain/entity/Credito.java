/**
 * 
 */
package br.com.fiap.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fiap.domain.enums.StatusCredito;
import br.com.fiap.validator.validadores.ValueNotZero;

/**
 * @author leandro.goncalves
 *
 */
@Entity
@Table(name = "CREDITO")
public class Credito implements EntityBasic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS_CREDITO", nullable = false)
	private StatusCredito statusCredito; 
	
	@Column(name = "VALOR_CREDITO", nullable = false)
	@ValueNotZero(message = "O valor do crédito deve ser maior que zero")
	private Double valorCredito;
	
	@Column(name = "NR_MESES_PAGAMENTO",nullable = false)
	@ValueNotZero(message = "O número de meses deve ser maior que zero")
	private Integer numeroMesesPagamento;
	
	@ManyToOne
	@JoinColumn(name = "CONTA_ID", nullable = false)
	private Conta conta;

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

	public StatusCredito getStatusCredito() {
		return statusCredito;
	}

	public void setStatusCredito(StatusCredito statusCredito) {
		this.statusCredito = statusCredito;
	}

	public Double getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(Double valorCredito) {
		this.valorCredito = valorCredito;
	}

	public Integer getNumeroMesesPagamento() {
		return numeroMesesPagamento;
	}

	public void setNumeroMesesPagamento(Integer numeroMesesPagamento) {
		this.numeroMesesPagamento = numeroMesesPagamento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
