package com.almeidatecnologia.CampanhaClientes.model;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name="TB_Beneficio")
public class Beneficio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false)
	private String nome;	
	
	@Column(nullable= false)
	private String descricao;
	
	@NotNull(message = "A Data Inicio não pode ser nula")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@PastOrPresent(message = "A Data Inicio deve estar no passado ou no presente")
	@Column(nullable= false)
	private LocalDate dataInicio;

	@NotNull(message = "A Data Fim não pode ser nula")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@FutureOrPresent(message = "A Data Fim deve estar no futuro ou no presente")
	@Column(nullable= false)		
	private LocalDate dataFim;	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_Cliente", referencedColumnName = "id")	
	private Cliente cliente;
	
	public Beneficio () {}

	public Beneficio(Long id, String nome, String descricao, LocalDate dataInicio, LocalDate dataFim) {		
		this.id = id;		
		this.nome = nome;
		this.descricao = descricao;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Beneficio other = (Beneficio) obj;
		return Objects.equals(id, other.id);
	}	
	
}
