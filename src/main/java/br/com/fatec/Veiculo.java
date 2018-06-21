package br.com.fatec;

import br.com.enuns.TipoCombustivel;

public abstract class Veiculo {
	String nome;
	TipoCombustivel tipoCombustivel;
	
	public Veiculo(String nome, TipoCombustivel tipoCombustivel) {
		super();
		setNome(nome);
		setTipoCombustivel(tipoCombustivel);
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
	
	
}
