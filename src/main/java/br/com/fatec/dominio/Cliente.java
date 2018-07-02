package br.com.fatec.dominio;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.Produto;

public class Cliente {
	String nome;
	Integer cpf;
	List<Lance> lances;
	
	public Cliente(String nome) {
		this.nome = nome;
		lances = new ArrayList<Lance>();
	}
	public Cliente(Integer cpf) {
		setCpf(cpf);
	}
	public Cliente() {}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Lance> getLances() {
		return lances;
	}
	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}
	
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public boolean realizarLance(BigInteger id,Cliente cliente, Produto produto, Double valorOfertado,Double valorAtual) {
		if(valorOfertado>valorAtual) {
			Lance lance = new Lance(id,cliente, produto, valorOfertado, valorAtual);
			lances.add(lance);
			produto.cadastrarLance(lance);
			return true;
		}
		return false;

	}
	
}
