package br.com.fatec.dominio.imovel;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.Imovel;
import br.com.fatec.Veiculo;

public class Leilao {
	List<Imovel> imoveis;
	List<Veiculo> veiculos;
	
	public void cadastrarImovel(Imovel imovel) {
		imoveis = new ArrayList<Imovel>();
		imoveis.add(imovel);
	}
	
	public void cadastrarVeiculo(Veiculo veiculo) {
		veiculos = new ArrayList<Veiculo>();
		veiculos.add(veiculo);
	}
	
	public Imovel consultarImovel(Imovel imovel) {
		for (Imovel imovel1 : imoveis) {
			if(imovel.equals(imovel)) {
				return imovel1;
			}
		}
		return null;
	}
	
	public Veiculo consultarVeiculo(Veiculo veiculo) {
		for (Veiculo veiculo1 : veiculos) {
			if(veiculo1.equals(veiculo1)) {
				return veiculo1;
			}
		}
		return null;
	}
}
