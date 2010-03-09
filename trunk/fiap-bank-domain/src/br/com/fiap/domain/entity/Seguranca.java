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
 * @created 20-fev-2010 20:42:10
 */
@Entity
@Table(name = "SEGURANCA")
public class Seguranca implements EntityBasic{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "SENHA", nullable = false)
	private String senha;
	
	@Column(name = "FRASE_SECRETA", nullable = false)
	private String fraseSecreta;

	@OneToOne(mappedBy = "seguranca")
	private Conta conta;
	
	@OneToOne(mappedBy = "seguranca")
	private Funcionario funcionario;
	
	@Column(name = "PERFIL",nullable = false)
	private String perfil;
	
	@Column(name = "LOGIN", nullable = false)
	private String login;
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFraseSecreta() {
		return fraseSecreta;
	}

	public void setFraseSecreta(String fraseSecreta) {
		this.fraseSecreta = fraseSecreta;
	}
	
	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}