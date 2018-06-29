package br.com.enuns;

public enum TipoCombustivel {
	GASOLINA(1,"GASOLINA"),ALCOOL(2,"ALCOOL"),FLEX(3,"FLEX");
	private Integer codigo;
	private String descricao;
	
	TipoCombustivel(Integer codigo,String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
