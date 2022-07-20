package br.com.viagem.projeto.model;


import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passagem")
public class Passagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "origem", length = 100, nullable = true)
	private String origem;
	
	@Column(name = "destino", length = 50, nullable = true)
	private String destino;
	
	@Column(name = "data_ida")
	private java.sql.Date data_ida;
	
	@Column(name = "data_volta")
	private java.sql.Date data_volta;
	
	@Column(name = "valor_passagem")
	private Integer valor_passagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public java.sql.Date getData_ida() {
		return data_ida;
	}

	public void setData_ida(java.sql.Date data_ida) {
		this.data_ida = data_ida;
	}

	public java.sql.Date getData_volta() {
		return data_volta;
	}

	public void setData_volta(java.sql.Date data_volta) {
		this.data_volta = data_volta;
	}

	public Integer getValor_passagem() {
		return valor_passagem;
	}

	public void setValor_passagem(Integer valor_passagem) {
		this.valor_passagem = valor_passagem;
	}
	
}