package br.com.fatec.dominio.imovel;

import br.com.enuns.TipoProduto;
import br.com.fatec.Imovel;

public class Casa extends Imovel{
	
	public Casa(Integer registroImovel) {
		super(registroImovel);
	}

	public Casa(TipoProduto tipoProduto,String rua, Integer numero, String bairro, String cidade) {
		super(tipoProduto, numero, rua, numero, bairro, cidade);
	}

}
