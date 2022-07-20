package br.com.viagem.projeto.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospedagem")
public class Hospedagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome_cidade", length = 100, nullable = true)
	private String nome_cidade;
	/*
	@Column(name = "data_entrada", length = 8, nullable = true)
	private Date data_entrada;
	*/
	
	@Column(name = "data_entrada")
	private java.sql.Date data_entrada;
	
	@Column(name = "data_saida")
	private java.sql.Date data_saida;
	
	@Column(name = "numero_quartos")
	private Integer numero_quartos;
	
	@Column(name = "quantidade_pessoas")
	private Integer quantidade_pessoas;
	/*
	@Column(name = "valor")
	private Integer valor;
	*/
	
	@Column(name = "valor")
	private Integer valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}

	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}

	public java.sql.Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(java.sql.Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public java.sql.Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(java.sql.Date data_saida) {
		this.data_saida = data_saida;
	}

	public Integer getNumero_quartos() {
		return numero_quartos;
	}

	public void setNumero_quartos(Integer numero_quartos) {
		this.numero_quartos = numero_quartos;
	}

	public Integer getQuantidade_pessoas() {
		return quantidade_pessoas;
	}

	public void setQuantidade_pessoas(Integer quantidade_pessoas) {
		this.quantidade_pessoas = quantidade_pessoas;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	

}