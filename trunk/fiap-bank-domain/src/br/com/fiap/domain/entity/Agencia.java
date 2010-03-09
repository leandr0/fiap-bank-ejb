package br.com.fiap.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author User
 * @version 1.0
 * @created 20-fev-2010 20:42:10
 */
@Entity
@Table(name = "AGENCIA")
public class Agencia implements EntityBasic{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable = false, name = "BANCO_ID")
	private Banco banco;
	
	@OneToMany(mappedBy = "agencia")
	private List<Conta> contas;
	
	@OneToMany(mappedBy = "agencia")
	private List<Funcionario> funcionarios;
	
	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
}