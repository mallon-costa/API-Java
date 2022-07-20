package br.com.viagem.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "numeroCartao")
	private Integer nuemroCartao;
	
	@Column(name = "codSeguranca")
	private Integer codSeguranca;
	
	@Column(name = "quantParcelas")
	private Integer quantParcelas;
	
	@Column(name = "valor")
	private Integer valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNuemroCartao() {
		return nuemroCartao;
	}

	public void setNuemroCartao(Integer nuemroCartao) {
		this.nuemroCartao = nuemroCartao;
	}

	public Integer getCodSeguranca() {
		return codSeguranca;
	}

	public void setCodSeguranca(Integer codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

	public Integer getQuantParcelas() {
		return quantParcelas;
	}

	public void setQuantParcelas(Integer quantParcelas) {
		this.quantParcelas = quantParcelas;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}
