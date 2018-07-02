package br.com.fatec;

import br.com.enuns.TipoProduto;

public class Imovel extends Produto {
	Integer registroImovel;
	String rua;
	Integer numero;
	String bairro;
	String cidade;
	
	public Imovel(Integer registroImovel) {
		setRegistroImovel(registroImovel);
	}
	
	public Imovel(Integer idProduto,Integer idLeilao,TipoProduto tipoProduto,Integer registroImovel,String rua, Integer numero, String bairro, String cidade) {
		super(idProduto,idLeilao,tipoProduto);
		this.registroImovel = registroImovel;
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}
	public Imovel() {
		// TODO Auto-generated constructor stub
	}

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getRegistroImovel() {
		return registroImovel;
	}

	public void setRegistroImovel(Integer registroImovel) {
		this.registroImovel = registroImovel;
	}
}
