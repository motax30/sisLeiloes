package br.com.fatec.dominio.imovel;

import br.com.fatec.Imovel;

public class Casa extends Imovel{

	public Casa() {}

	public Casa(String rua, Integer numero, String bairro, String cidade) {
		super(rua, numero, bairro, cidade);
	}

}
