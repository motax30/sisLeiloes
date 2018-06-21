package br.com.fatec.dominio.imovel;

import br.com.fatec.Imovel;

public class Edificio extends Imovel{

	public Edificio() {}

	public Edificio(String rua, Integer numero, String bairro, String cidade) {
		super(rua, numero, bairro, cidade);
	}

}
