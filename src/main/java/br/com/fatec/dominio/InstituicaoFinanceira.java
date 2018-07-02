package br.com.fatec.dominio;

public class InstituicaoFinanceira {
	String cnpj;
	String nome;
	public InstituicaoFinanceira(String cnpj) {
		super();
		this.cnpj = cnpj;
	}

	public InstituicaoFinanceira() {
		// TODO Auto-generated constructor stub
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "InstituicaoFinanceira [cnpj=" + cnpj + ", nome=" + nome + "]";
	}
}
