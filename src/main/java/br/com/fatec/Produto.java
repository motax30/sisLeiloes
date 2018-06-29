package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

import br.com.enuns.TipoProduto;
import br.com.fatec.dominio.Lance;

public abstract class Produto {
	TipoProduto tipoProduto;
	List<Lance> lancesProduto;
	
	public Produto() {}
	
	public Produto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
		lancesProduto = new ArrayList<Lance>();
	}
	
	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public List<Lance> getLancesProduto() {
		return lancesProduto;
	}
	
	public boolean cadastrarLance(Lance lance) {
		getLancesProduto().add(lance);
		return true;
	}
	
}
