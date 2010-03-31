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

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Valid;

/**
 * @author User
 * @version 1.0
 * @created 20-fev-2010 20:42:09
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements EntityBasic{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NOME", nullable = false)
	@NotNull(message = "O Nome é obrigatório, com no mínimo 3 (três) caracteres")
	@Length(min = 3,message = "O Nome é obrigatório, com no mínimo 3 (três) caracteres")
	private String nome;
	
	@Column(name = "RG", nullable = false)
	@NotNull(message = "O RG deve ser preenchido corretamente.Ex : '999999999' ou '99999999-9'")
	@Length(min = 9,max = 10,
			message = "O RG deve ser preenchido corretamente.Ex : '999999999' ou '99999999-9'")
	private String rg;
	
	@Column(name = "CPF", nullable = false)
	@NotNull(message = "O CPF deve ser preenchido corretamente.Ex : '99999999999' ou '999999999-99'")
	@Length(min = 10, max = 12,
			message = "O CPF deve ser preenchido corretamente.Ex : '99999999999' ou '999999999-99'")
	private String cpf;
	
	@Column(name = "TELEFONE",nullable = false)
	@NotNull(message = "O Telefone de ser preenchido corretamente.Ex: '9999-9999' ou 'DDD 9999-9999'")
	@Length(min = 9,max = 13,
			message = "O Telefone de ser preenchido corretamente.Ex: '9999-9999' ou 'DDD 9999-9999'")
	private String telefone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENDERECO_ID")
	@NotNull
	@Valid
	private Endereco endereco;

	@OneToOne(mappedBy = "usuario")
	private Correntista correntista;
	
	public Usuario() {}
	
	public Usuario(Endereco endereco) {
		this.endereco = endereco;
		this.endereco.setUsuario(this);
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}
}