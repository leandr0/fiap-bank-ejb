package br.com.fiap.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author User
 * @version 1.0
 * @created 20-fev-2010 20:42:09
 */
@Entity
@Table(name = "ENDERECO")
public class Endereco implements EntityBasic{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "LOGRADOURO",nullable = false)
	private String logradouro;
	
	@Column(name = "NUMERO", nullable = false)
	private String  numero;
	
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;
	
	@Column(name = "UF",length = 2, nullable = false)
	private String uf;
	
	@Column(name = "MUNICIPIO", nullable = false)
	private String municipio;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
	
	@Column(name = "CEP", nullable = false, length = 9)
	private String cep;

	@OneToOne(mappedBy = "endereco")
	private Usuario usuario;
	
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}