package br.com.enuns;

public enum TipoImovel {
	APARTAMENTO(1,"Apartamento"),CASA(2,"Casa"),EDIFICIO(3,"Edifício"),TERRENO(4,"Terreno");
	
	private int cod;
	private String descricao;
	
	TipoImovel(int cod,String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
