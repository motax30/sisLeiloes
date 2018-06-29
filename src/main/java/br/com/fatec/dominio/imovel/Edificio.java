package br.com.fatec.dominio.imovel;

import br.com.enuns.TipoProduto;
import br.com.fatec.Imovel;

public class Edificio extends Imovel{


	public Edificio(Integer registroImovel) {
		super(registroImovel);
	}

	public Edificio(TipoProduto tipoProduto,Integer registroImovel,String rua, Integer numero, String bairro, String cidade) {
		super(tipoProduto, registroImovel, rua, numero, bairro, cidade);
	}

}
