package br.com.fatec;

import br.com.enuns.TipoCombustivel;
import br.com.enuns.TipoProduto;

public class Veiculo extends Produto{
	String nome;
	TipoCombustivel tipoCombustivel;
	
	public Veiculo(Integer idProduto,Integer idLeilao,TipoProduto tipoProduto,String nome, TipoCombustivel tipoCombustivel) {
		super(idProduto,idLeilao,tipoProduto);
		setNome(nome);
		setTipoCombustivel(tipoCombustivel);
	}
	
	public Veiculo(Integer id) {
		super();
		this.id = id;
	}


	public Veiculo() {}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCombustivel getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(TipoCombustivel tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	@Override
	public String toString() {
		return "Veiculo [id=" + id + ", nome=" + nome + ", tipoCombustivel=" + tipoCombustivel + "]";
	}
	
}
