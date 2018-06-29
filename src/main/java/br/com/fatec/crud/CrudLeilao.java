package br.com.fatec.crud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.enuns.TipoCombustivel;
import br.com.enuns.TipoImovel;
import br.com.enuns.TipoProduto;
import br.com.fatec.Imovel;
import br.com.fatec.Veiculo;
import br.com.fatec.dominio.Cliente;
import br.com.fatec.dominio.imovel.Apartamento;
import br.com.fatec.dominio.imovel.Casa;
import br.com.fatec.dominio.imovel.Edificio;
import br.com.fatec.dominio.imovel.Leilao;
import br.com.fatec.dominio.imovel.Terreno;

public class CrudLeilao implements ICrudLeilao<Object> {
	
	public List<Cliente> clientes;
	public List<Leilao> leiloes;
	private List<Veiculo> veiculos;
	private List<Imovel> imoveis;
	
	private static Calendar inicioLeilao;
	private static Calendar fimLeilao;
	private static String enderecoLeilao;
	private static String cidadeLeilao;
	private static String estadoLeilao;
	
	//Cliente
	private static String nomeCliente = null;
	
	//Veiculo
	private static String nomeVeiculo;
	private static TipoCombustivel tipoCombustivel;
	
	//Imovel
	private static Integer registroImovel;
	private static String ruaImovel;
	private static Integer numeroImovel;
	private static String bairroImovel;
	private static String cidadeImovel;
	
	public CrudLeilao() {
		clientes = new ArrayList<Cliente>();
		leiloes = new ArrayList<Leilao>();
		veiculos = new ArrayList<Veiculo>();
		imoveis = new ArrayList<Imovel>();
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}


	public List<Imovel> getImoveis() {
		return imoveis;
	}


	public void setImoveis(List<Imovel> imoveis) {
		this.imoveis = imoveis;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Leilao> getLeiloes() {
		return leiloes;
	}

	public void setLeiloes(List<Leilao> leiloes) {
		this.leiloes = leiloes;
	}

	public boolean cadastrar(Object obj) {
		if(obj.getClass().isInstance(new Cliente())) {
			clientes.add((Cliente)obj);
			return true;
		}else if(obj.getClass().isInstance(new Leilao())) {
			 leiloes.add((Leilao)obj);
			 return true;
		}else if(obj.getClass().isInstance(new Veiculo())) {
			veiculos.add((Veiculo)obj);
		}
		return false;
	}
	
	public Object consultar(Object obj) {
		if(obj.getClass().isInstance(new Cliente())) {
			for (Cliente c : clientes) {
				if(c.getCpf().equals(((Cliente)obj).getCpf())){
					return c;
				}
			}
		}else if(obj.getClass().isInstance(new Leilao())) {
			for (Leilao l : leiloes) {
				if(l.getId().equals(((Leilao)obj).getId())){
					return l;
				}
			}
		}
		return null;
	}
	
	public boolean atualizar(Object objAtualizar, int idObjCadastrado) {
		if(objAtualizar.getClass().isInstance(new Cliente())) {
			Cliente clienteCadastrado = clientes.get(idObjCadastrado);
			Cliente clienteAtualizado = (Cliente)objAtualizar;
			if(consultar(clienteCadastrado)!=null) {
				clientes.add(idObjCadastrado, clienteAtualizado);
				return true;
			}
			
		}else if(objAtualizar.getClass().isInstance(new Leilao())) {
			Leilao leilaoCadastrado = leiloes.get(idObjCadastrado);
			Leilao leilaoAtualizado = (Leilao)objAtualizar;
			if(consultar(leilaoCadastrado)!=null) {
				leiloes.add(idObjCadastrado, leilaoAtualizado);
			}
		}
		return false;
	}
	
	public boolean remover(Object objRemover) {
		Leilao leilao;
		Cliente cliente;
		Object obj = consultar(objRemover);
		if(obj!=null) {
			if(obj.getClass().isInstance(new Cliente())) {
				cliente = (Cliente)obj;
				return clientes.remove(cliente);
			}else if(obj.getClass().isInstance(new Leilao())) {
				leilao = (Leilao)obj;
				return leiloes.remove(leilao);
			}
		}
		return false;
	}
	
	@SuppressWarnings("resource")
	public static String preencherDado(String solicitacaoDados) {
		System.out.println(solicitacaoDados);
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void efetuarRemocao(int op,int id,Integer cpf,Integer registroImovel) {
		int opcaoExcluir = 0;
		switch (op) {
		case 1:
			Leilao leilao = (Leilao) consultar(new Leilao(id));
			if(leilao!=null) {	
				opcaoExcluir = Integer.valueOf(preencherDado("Tem certeza que deseja excluir o Leilão? 1-SIM  2-NÂO"));
				if(op>0 && op<2) {
					leiloes.remove(leilao);
				}else {
					System.out.println("Não existe um Leilão cadastrado com esse id!");
				}
			}
			break;
		case 2:
			Cliente cliente = (Cliente) consultar(new Cliente(id));
			if(cliente!=null) {	
				opcaoExcluir = Integer.valueOf(preencherDado("Tem certeza que deseja excluir o Cliente? 1-SIM  2-NÂO"));
				if(op>0 && op<2) {
					clientes.remove(cliente);
				}
			}else {
				System.out.println("Não existe um Cliente cadastrado com esse id!");
			}
			break;
		case 3:
			Veiculo veiculo = (Veiculo) consultar(new Veiculo(id));
			if(veiculo!=null) {	
				opcaoExcluir = Integer.valueOf(preencherDado("Tem certeza que deseja excluir o Cliente? 1-SIM  2-NÂO"));
				if(op>0 && op<2) {
					leiloes.remove(veiculo);
				}
			}else {
				System.out.println("Não existe um Veículo cadastrado com esse id!");
			}
			break;
		case 4:
			Imovel imovel = (Imovel) consultar(new Imovel(registroImovel));
			if(imovel!=null) {	
				opcaoExcluir = Integer.valueOf(preencherDado("Tem certeza que deseja excluir o Cliente? 1-SIM  2-NÂO"));
				if(op>0 && op<2) {
					leiloes.remove(imovel);
				}
			}else {
				System.out.println("Não existe um Imóvel cadastrado com esse id!");
			}
			break;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void efetuarAtualizacao(int op,int id,Integer cpf,Integer registroImovel) {
		switch (op) {
		case 1:
			Leilao leilao = (Leilao) consultar(new Leilao(id));
			if(leilao!=null) {	
				atualizarLeilao(leilao);
			}
			System.out.println("Não existe um Leilão cadastrado com esse id!");
			break;
		case 2:
			Cliente cliente = (Cliente) consultar(new Cliente(id));
			atualizarCliente(cliente);
			break;
		case 3:
			Veiculo veiculo = (Veiculo) consultar(new Veiculo(id));
			atualizarVeiculo(veiculo);
			break;
		case 4:
			Imovel imovel = (Imovel) consultar(new Imovel(registroImovel));
			atualizarImovel(imovel);
		}
	}

	private void atualizarImovel(Imovel imovel) {
		int pergunta;
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o número de registro do Imóvel? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				Integer registroImovel = null;
				registroImovel = Integer.valueOf(preencherDado("Preencha o novo número de registro do Imóvel: "));
				imovel.setRegistroImovel(registroImovel);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o número da rua do Imóvel? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				String rua = null;
				rua = preencherDado("Preencha o novo nome de rua do Imóvel: ");
					imovel.setRua(rua);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o número da rua do Imóvel? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				Integer numero = null;
				numero = Integer.valueOf(preencherDado("Preencha o novo nome de rua do Imóvel: "));
				imovel.setNumero(numero);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o bairro do Imóvel? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				String bairro = null;
				bairro = preencherDado("Preencha o novo bairro do Imóvel: ");
					imovel.setBairro(bairro);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar a cidade do Imóvel? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				String cidade = null;
				cidade = preencherDado("Preencha o nova cidade do Imóvel: ");
					imovel.setCidade(cidade);
			}
		}
	}

	private void atualizarVeiculo(Veiculo veiculo) {
		int pergunta;
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o nome do Veiculo? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				String nome = null;
				nome = preencherDado("Informe o novo nome do Veículo:");
				veiculo.setNome(nome);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o tipo de combustível do Veiculo? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				alteraCombustivelVeiculo(veiculo);
			}
		}
	}

	private void alteraCombustivelVeiculo(Veiculo veiculo) {
		String op = null;
		op = preencherDado("Informe o novo tipo de combustível do Veículo conforme o código: "
										+TipoCombustivel.ALCOOL.getCodigo().toString()+" - "+TipoCombustivel.ALCOOL.getDescricao()
										+TipoCombustivel.GASOLINA.getCodigo().toString()+" - "+TipoCombustivel.GASOLINA.getDescricao()
										+TipoCombustivel.FLEX.getCodigo().toString()+" - "+TipoCombustivel.FLEX.getDescricao());
		switch (Integer.valueOf(op)) {
		case 1:
			veiculo.setTipoCombustivel(TipoCombustivel.ALCOOL);
			break;
		case 2:
			veiculo.setTipoCombustivel(TipoCombustivel.GASOLINA);
		case 3:
			veiculo.setTipoCombustivel(TipoCombustivel.FLEX);
			break;
		}
	}

	private void atualizarCliente(Cliente cliente) {
		int pergunta;
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o nome do Cliente? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				String nome = null;
				nome = preencherDado("Informe o nome do Cliente");
				cliente.setNome(nome);
			}
		}
	}

	@SuppressWarnings({ "resource", "deprecation" })
	private void atualizarLeilao(Leilao leilao) {
		int pergunta;
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o nome da cidade de realização do Leilão? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				String cidade = null;
				cidade = preencherDado("Informe o nome da cidade: ");
				leilao.setCidade(cidade);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar data de ocorrência do Leilão? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				Calendar dataOcorrencia = null;
				System.out.println("Informe a nova data de ocorrência do Leilão no formato dd/mm/aaaa: ");
				dataOcorrencia = Calendar.getInstance();
				dataOcorrencia.setTime(new Date(new Scanner(System.in).next()));
				leilao.setDataOcorrencia(dataOcorrencia);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o endereço do Leilão? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				String endereco = null;
				endereco = preencherDado("Informe o novo endereço do Leilão: ");
				leilao.setEndereco(endereco);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar a UF para o Leilão? Informe o código: 1-SIM 2-Não"));
		if(pergunta>0) {
			if(pergunta<2) {
				String estado = null;
				estado = preencherDado("Informe o nova UF para o Leilão: ");
				leilao.setEstado(estado);
			}
		}
	}
	
	public void efetuarCadatro(int op) {
		switch (op) {
		case 1:
			cadastrarLeilao();
			break;
		case 2:
			cadastrarCliente();
			break;
		case 3:
			cadastrarVeiculo();
			break;
		case 4:
			cadastrarImovel();
		}
	}

	private void cadastrarImovel() {
		int opImovel = 0;
		System.out.println("Informe o Tipo de Imóvel conforme código: "
					+TipoImovel.APARTAMENTO.getCod()+" - "+TipoImovel.APARTAMENTO
					+TipoImovel.CASA.getCod()+" - "+TipoImovel.CASA
					+TipoImovel.EDIFICIO.getCod()+" - "+TipoImovel.EDIFICIO
					+TipoImovel.TERRENO.getCod()+" - "+TipoImovel.TERRENO);
		opImovel = new Scanner(System.in).nextInt();
		registroImovel = Integer.valueOf(preencherDado("Insira o número de registro de imóvel"));
		ruaImovel = preencherDado("Insira o nome da rua: ");
		numeroImovel =Integer.valueOf(preencherDado("Insira o número do Imóvel: "));
		bairroImovel = preencherDado("Insira o bairro do Imóvel: ");
		cidadeImovel = preencherDado("Insira a cidade do Imóvel:");
		Imovel imovel = null;
		switch(opImovel) {
			case 1:
				imovel = new Apartamento(TipoProduto.IMOVEL,registroImovel, ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
				cadastrar(imovel);
				break;
			case 2:
				imovel = new Casa(TipoProduto.IMOVEL, ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
				cadastrar(imovel);
				break;
			case 3:
				imovel = new Edificio(TipoProduto.IMOVEL,registroImovel, ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
				cadastrar(imovel);
				break;
			case 4:
				imovel = new Terreno(TipoProduto.IMOVEL, registroImovel,ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
				cadastrar(imovel);
				break;
		}
	}

	@SuppressWarnings("resource")
	private void cadastrarVeiculo() {
		nomeVeiculo = preencherDado("Informe o nome do veiculo: ");
		System.out.println("Informe tipo de combustível conforme código: 1 - "+TipoCombustivel.ALCOOL
				+"2 - "+TipoCombustivel.GASOLINA+"3 - "+TipoCombustivel.FLEX+": ");
		int op1 = 0;
		op1 = new Scanner(System.in).nextInt();
		switch (op1) {
		case 1:
			tipoCombustivel = TipoCombustivel.ALCOOL;
			break;
		case 2:
			tipoCombustivel = TipoCombustivel.GASOLINA;
			break;
		case 3:
			tipoCombustivel = TipoCombustivel.FLEX;
			break;
		default:
			break;
		}
		Veiculo veiculo = new Veiculo(TipoProduto.VEICULO, nomeVeiculo, tipoCombustivel);
		cadastrar(veiculo);
	}

	private void cadastrarCliente() {
		nomeCliente = preencherDado("Informe o nome do cliente: ");
		Cliente cliente = new Cliente(nomeCliente);
		cadastrar(cliente);
	}

	private void cadastrarLeilao() {
		String variavel = null;
		variavel = preencherDado("Informe a data de início para o Leilão no formato dd/mm/aaaa:");
		inicioLeilao = Calendar.getInstance();
		inicioLeilao.setTime(new Date(variavel));
		variavel = preencherDado("Informe a data de término para o Leilão no formato dd/mm/aaaa:");
		fimLeilao = Calendar.getInstance();
		fimLeilao.setTime(new Date(variavel));
		variavel = preencherDado("Informe a endereço de realização do Leilão: ");
		enderecoLeilao = variavel;
		cidadeLeilao = preencherDado("Informe a cidade de realização do Leilão: ");
		estadoLeilao = preencherDado("Informe o estado(UF) de realização do Leilão: ");
		int id = getProximoId(new Leilao());
		Leilao leilao = new Leilao(id,inicioLeilao, fimLeilao, enderecoLeilao, cidadeLeilao, estadoLeilao);
		cadastrar(leilao);
	}

	private int getProximoId(Object obj) {
		Integer numero = new Integer(0);
		if(obj.getClass().isInstance(new Leilao()) && leiloes.size()>=0) {
			for (Leilao leilao:leiloes) {
				if(numero<leilao.getId()) {
					numero = leilao.getId();
				}
			}
			numero++;
		}
		if(obj.getClass().isInstance(new Cliente()) && clientes.size()<=0) {
			for (Leilao leilao:leiloes) {
				if(numero<leilao.getId()) {
					numero = leilao.getId();
				}
			}
			numero++;
		}
		return numero;
	}
}