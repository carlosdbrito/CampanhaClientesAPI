package com.almeidatecnologia.CampanhaClientes.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="TB_Cliente")
public class Cliente {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false)
	private String nome;
	
	@Column(nullable= false)
	private String agencia;
	
	@Column(nullable= false)
	private String conta;
	
	@Column(nullable= false)
	private TipoConta  tipoConta;	 
	     //0 - Poupanca
	     //1 - ContaCorrente
	
	
	@Min(value = 0,    message = "O valor deve ser no mínimo 0")
	@Max(value = 1000, message = "O valor deve ser no máximo 1000")
	@Column(nullable= true)
	private Integer score; 
  
		
	public Cliente() {}
	
	public Cliente(Long id, String nome, String agencia, String conta, TipoConta tipoConta, Integer score) {
		this.id = id;
		this.nome = nome;
		this.agencia = agencia;
		this.conta = conta;
		this.tipoConta = tipoConta;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
		
	@Override
	public String toString() {
		String resposta = "[id = " + this.id + ", nome = " + this.nome +  ", agencia = " + this.agencia + ", conta = " + this.conta +  
				          ", tipoConta = " + this.tipoConta  + ", score = " + this.score + "]";
		return resposta;
	}
}
