package br.com.fatec.dominio.imovel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.print.attribute.SetOfIntegerSyntax;

import br.com.enuns.StatusLeilao;
import br.com.fatec.Produto;
import br.com.fatec.Produto;
import br.com.fatec.Veiculo;
import br.com.fatec.dominio.InstituicaoFinanceira;

public class Leilao {
	Integer id;
	List<Produto> produtos;
	Calendar inicio;
	Calendar fim;
	String endereco;
	String cidade;
	String estado;
	InstituicaoFinanceira instituicao;
	StatusLeilao status;
	
	public Leilao(Integer id,Calendar inicio,Calendar fim, String endereco, String cidade, String estado) {
		setId(id);
		setDataOcorrencia(inicio);
		setFim(fim);
		setEndereco(endereco);
		setCidade(cidade);
		setEstado(estado);
		setStatus(StatusLeilao.EM_ABERTO);
	}
	
	public Leilao(Integer id) {
		setId(id);
	}

	public Leilao() {}

	private void verificarInstanciacaoListaProdutos() {
		if(produtos==null) {
			produtos = new ArrayList<Produto>();
		}
	}
	
	public void cadastrarProduto(Produto produto) {
		verificarInstanciacaoListaProdutos();
		produtos.add(produto);
	}
	
	public Produto consultarProduto(Produto produto) {
		verificarInstanciacaoListaProdutos();
		for (Produto prod : produtos) {
			if(prod.equals(produto)) {
				return produto;
			}
		}
		return null;
	}
	
	public Produto atualizarProduto(Produto produto,Produto produtoAAtualizar) {
		verificarInstanciacaoListaProdutos();
		Produto prodAtualizar = consultarProduto(produto);
		if(prodAtualizar!=null) {
			int index = produtos.indexOf(prodAtualizar);
			produtos.add(index, produto);
			return produtos.get(index);
		}
		return null;
	}
	
	public Produto removerProduto(Produto produtoRemover) {
		verificarInstanciacaoListaProdutos();
		Produto prodAtualizar = consultarProduto(produtoRemover);
		if(prodAtualizar!=null) {
			int index = produtos.indexOf(prodAtualizar);
			return produtos.remove(index);
		}
		return null;
	}
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Calendar getDataOcorrencia() {
		return inicio;
	}

	public void setDataOcorrencia(Calendar dataOcorrencia) {
		this.inicio = dataOcorrencia;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public InstituicaoFinanceira getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(InstituicaoFinanceira instituicao) {
		this.instituicao = instituicao;
	}

	public StatusLeilao getStatus() {
		return status;
	}

	public void setStatus(StatusLeilao status) {
		this.status = status;
	}

	public Calendar getInicio() {
		return inicio;
	}

	public void setInicio(Calendar inicio) {
		this.inicio = inicio;
	}

	public Calendar getFim() {
		return fim;
	}

	public void setFim(Calendar fim) {
		this.fim = fim;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
}