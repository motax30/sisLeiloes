package br.com.fatec.dominio;

import java.math.BigInteger;

import br.com.fatec.Produto;

public class Lance {
	BigInteger id;
	Produto produto;
	Cliente cliente;
	Double valorOfertado;
	Double valorAtual;
	
	public Lance(BigInteger id,Cliente cliente, Produto produto, Double valorOfertado, Double valorAtual) {
		this.id = id;
		setCliente(cliente);
		setProduto(produto);
		setValorOfertado(valorOfertado);
		setValorAtual(valorAtual);
	}
	
	
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigInteger getId() {
		return id;
	}

	public Double getValorOfertado() {
		return valorOfertado;
	}

	public void setValorOfertado(Double valorOfertado) {
		this.valorOfertado = valorOfertado;
	}

	public Double getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(Double valorAtual) {
		this.valorAtual = valorAtual;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
