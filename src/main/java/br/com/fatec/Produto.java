package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

import br.com.enuns.TipoProduto;
import br.com.fatec.dominio.Lance;

public abstract class Produto {
	Integer id;
	Integer idLeilao;
	TipoProduto tipoProduto;
	List<Lance> lancesProduto;
	
	public Produto() {}
	
	public Produto(Integer id,Integer idLeilao,TipoProduto tipoProduto) {
		this.id = id;
		this.idLeilao = idLeilao;
		this.tipoProduto = tipoProduto;
		lancesProduto = new ArrayList<Lance>();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdLeilao() {
		return idLeilao;
	}

	public void setIdLeilao(Integer idLeilao) {
		this.idLeilao = idLeilao;
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
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", idLeilao=" + idLeilao + ", tipoProduto=" + tipoProduto + "]";
	}
	
	
	
}
