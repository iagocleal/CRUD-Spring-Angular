package br.com.iago.pessoa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "TELEFONE")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Telefone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1274718511953271725L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID", unique=true, updatable = false, nullable = false)
	private Long id;
	
	@Column(name = "DDD")
	private String ddd;
	
	@Column(name = "NUMERO")
	private String numero;
	
	@ManyToOne
	@JoinColumn(name = "ID_PESSOA")
	private Pessoa pessoa;

	public Telefone(Long id, String ddd, String numero) {
		super();
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
	}

}
