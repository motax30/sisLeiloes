package br.com.fatec.dominio;

public class InstituicaoFinanceira {
	String cnpj;

	public InstituicaoFinanceira(String cnpj) {
		super();
		this.cnpj = cnpj;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
}
