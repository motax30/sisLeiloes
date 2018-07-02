package br.com.fatec.dominio.imovel;

import br.com.enuns.TipoProduto;
import br.com.fatec.Imovel;

public class Terreno extends Imovel{

	public Terreno(Integer registroImovel) {
		super(registroImovel);
	}

	public Terreno(Integer idProduto,Integer idLeilao,TipoProduto tipoProduto,Integer registroImovel,String rua, Integer numero, String bairro, String cidade) {
		super(idProduto,idLeilao,tipoProduto,registroImovel,rua, numero, bairro, cidade);
	}
	
}
