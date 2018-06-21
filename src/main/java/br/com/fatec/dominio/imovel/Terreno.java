package br.com.fatec.dominio.imovel;

import br.com.fatec.Imovel;

public class Terreno extends Imovel{

	public Terreno() {}

	public Terreno(String rua, Integer numero, String bairro, String cidade) {
		super(rua, numero, bairro, cidade);
	}
	
}
