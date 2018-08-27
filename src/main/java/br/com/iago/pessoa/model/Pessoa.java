package br.com.iago.pessoa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.iago.pessoa.util.Util;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "PESSOA")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2659378928276334249L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique=true, updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "DATA_NASCIMENTO")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name = "EMAIL")
	private String email;
	
	@OneToMany(mappedBy = "pessoa", targetEntity = Telefone.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL) 
	private List<Telefone> lstTelefone;
	
	@Transient
	private List<Telefone> lstTelefoneAux;
	
	@Transient
	private Integer idade;
	
	@Transient
	private Long qtdTelefones;
	
	public Pessoa(Long id, String nome, String cpf, Date dataNascimento, String email,
			Long qtdTelefones) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.qtdTelefones = qtdTelefones;
		setIdade(Util.calculaIdade(dataNascimento));
	}
	
	public Pessoa(Long id, String nome, String cpf, Date dataNascimento, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

}
