package br.com.fatec.dominio.veiculo;

import br.com.enuns.TipoCombustivel;
import br.com.enuns.TipoProduto;
import br.com.fatec.Veiculo;

public class Carro extends Veiculo{

	public Carro(Integer idProduto,Integer idLeilao,TipoProduto tipoProduto,String nome, TipoCombustivel tipoCombustivel) {
		super(idProduto, idLeilao, tipoProduto,nome, tipoCombustivel);
	}

}
