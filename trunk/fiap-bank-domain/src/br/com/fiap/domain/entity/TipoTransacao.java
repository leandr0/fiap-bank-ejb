package br.com.fiap.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author User
 * @version 1.0
 * @created 20-fev-2010 20:42:11
 */
@Entity
@Table(name = "TIPO_TRANSACAO")
public class TipoTransacao implements EntityBasic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "DECRICAO", nullable = false)
	private String descricao;
	
	@OneToMany(mappedBy = "tipoTransacao")
	private List<Transacao> transacoes;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}
}