package br.com.fatec.dominio.imovel;

import br.com.enuns.TipoProduto;
import br.com.fatec.Imovel;

public class Edificio extends Imovel{


	public Edificio(Integer registroImovel) {
		super(registroImovel);
	}

	public Edificio(Integer idProduto,Integer idLeilao,TipoProduto tipoProduto,Integer registroImovel,String rua, Integer numero, String bairro, String cidade) {
		super(idProduto,idLeilao,tipoProduto, registroImovel, rua, numero, bairro, cidade);
	}

}
