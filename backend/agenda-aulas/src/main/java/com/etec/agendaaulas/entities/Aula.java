package com.etec.agendaaulas.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_aulas")
public class Aula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@GeneratedValue (generator = "system-uuid")
//	@GenericGenerator (name = "system-uuid", strategy = "uuid")
	private Long id;
	private String sala;
	private	String nome;
	private	String aula;
	private LocalDate data;
	private String inicioAula;
	private String fimAula;
		
	public Aula() {
		
	}

	public Aula(Long id, String sala, String nome, String aula, LocalDate data, String inicioAula, String fimAula) {
		this.id = id;
		this.sala = sala;
		this.nome = nome;
		this.aula = aula;
		this.data = data;
		this.inicioAula = inicioAula;
		this.fimAula = fimAula;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getInicioAula() {
		return inicioAula;
	}

	public void setInicioAula(String inicioAula) {
		this.inicioAula = inicioAula;
	}

	public String getFimAula() {
		return fimAula;
	}

	public void setFimAula(String fimAula) {
		this.fimAula = fimAula;
	}	
}
