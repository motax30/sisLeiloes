package br.com.fatec.crud;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.enuns.StatusLeilao;
import br.com.enuns.TipoCombustivel;
import br.com.enuns.TipoImovel;
import br.com.enuns.TipoProduto;
import br.com.fatec.Imovel;
import br.com.fatec.Produto;
import br.com.fatec.Veiculo;
import br.com.fatec.dominio.Cliente;
import br.com.fatec.dominio.InstituicaoFinanceira;
import br.com.fatec.dominio.Lance;
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
	private List<InstituicaoFinanceira> instituicoes;
	private Integer idLeilao;
	
	private static Calendar horaInicioLeilao;
	private static Calendar horaFimLeilao;
	private static Calendar dataOcorrenciaLeilao;
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
		instituicoes = new ArrayList<InstituicaoFinanceira>();
	}

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public List<InstituicaoFinanceira> getInstituicoes() {
		return instituicoes;
	}

	public void setInstituicoes(List<InstituicaoFinanceira> instituicoes) {
		this.instituicoes = instituicoes;
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
			for (Cliente c : getClientes()) {
				if(c.getCpf().equals(((Cliente)obj).getCpf())){
					return c;
				}
			}
		}else if(obj.getClass().isInstance(new Leilao())) {
			for (Leilao l : getLeiloes()) {
				if(l.getId().equals(((Leilao)obj).getId())){
					return l;
				}
			}
		}else if(obj.getClass().isInstance(new InstituicaoFinanceira())) {
			for (InstituicaoFinanceira instituicao:getInstituicoes()) {
				if(instituicao.getCnpj().equals(((InstituicaoFinanceira)obj).getCnpj())){
					return instituicao;
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
	public String preencherDado(String solicitacaoDados) {
		System.out.println(solicitacaoDados);
		return new Scanner(System.in).next();
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void efetuarRemocao(int op) {
		int opcaoExcluir = 0;
		int id = 0;
		String numCNPJ = null;
		int regImovel = 0;
		switch (op) {
		case 1:
			System.out.println("Informe o n�mero id para remo��o: ");
			id = new Scanner(System.in).nextInt();
			Leilao leilao = (Leilao) consultar(new Leilao(id));
			if(leilao!=null) {	
				opcaoExcluir = Integer.valueOf(preencherDado("Tem certeza que deseja excluir o Leil�o? 1-SIM  2-N�O"));
				if(opcaoExcluir>0 && opcaoExcluir<2) {
					leiloes.remove(leilao);
				}else {
					System.out.println("N�o existe um Leil�o cadastrado com esse id!");
				}
			}
			break;
		case 2:
			System.out.println("Informe o n�mero id para remo��o: ");
			id = new Scanner(System.in).nextInt();
			Cliente cliente = (Cliente) consultar(new Cliente(id));
			if(cliente!=null) {	
				opcaoExcluir = Integer.valueOf(preencherDado("Tem certeza que deseja excluir o Cliente? 1-SIM  2-N�O"));
				if(opcaoExcluir>0 && opcaoExcluir<2) {
					clientes.remove(cliente);
				}
			}else {
				System.out.println("N�o existe um Cliente cadastrado com esse id!");
			}
			break;
		case 3:
			System.out.println("Informe o n�mero id para remo��o: ");
			id = new Scanner(System.in).nextInt();
			Veiculo veiculo = (Veiculo) consultar(new Veiculo(id));
			if(veiculo!=null) {	
				opcaoExcluir = Integer.valueOf(preencherDado("Tem certeza que deseja excluir o Cliente? 1-SIM  2-N�O"));
				if(opcaoExcluir>0 && opcaoExcluir<2) {
					leiloes.remove(veiculo);
				}
			}else {
				System.out.println("N�o existe um Ve�culo cadastrado com esse id!");
			}
			break;
		case 4:
			System.out.println("Informe o n�mero id para remo��o: ");
			regImovel = new Scanner(System.in).nextInt();
			Imovel imovel = (Imovel) consultar(new Imovel(registroImovel));
			if(imovel!=null) {	
				opcaoExcluir = Integer.valueOf(preencherDado("Tem certeza que deseja excluir o Cliente? 1-SIM  2-N�O"));
				if(opcaoExcluir>0 && opcaoExcluir<2) {
					leiloes.remove(imovel);
				}
			}else {
				System.out.println("N�o existe um Im�vel cadastrado com esse id!");
			}
			break;
		case 5:
			System.out.println("Informe o n�mero CNPJ da Institui��o Financeira para remo��o: ");
			numCNPJ = new Scanner(System.in).next();
			InstituicaoFinanceira instituicao = (InstituicaoFinanceira) consultar(new InstituicaoFinanceira(numCNPJ));
			if(instituicao!=null) {	
				opcaoExcluir = Integer.valueOf(preencherDado("Tem certeza que deseja excluir esta Institui��o? 1-SIM  2-N�O"));
				if(opcaoExcluir>0 && opcaoExcluir<2) {
					getInstituicoes().remove(instituicao);
				}
			}else {
				System.out.println("N�o existe uma Institui��o Financeira cadastrada com esse id!");
			}
			break;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void efetuarAtualizacao(int op) {
		int id = 0;
		int regImovel = 0;
		String numCNPJ = null;
		switch (op) {
		case 1:
			System.out.println("Informe o n�mero id para altera��o: ");
			id = new Scanner(System.in).nextInt();
			Leilao leilao = (Leilao) consultar(new Leilao(id));
			if(leilao!=null) {	
				atualizarLeilao(leilao);
			}
			System.out.println("N�o existe um Leil�o cadastrado com esse id!");
			break;
		case 2:
			System.out.println("Informe o n�mero id para altera��o: ");
			id = new Scanner(System.in).nextInt();
			Cliente cliente = (Cliente) consultar(new Cliente(id));
			atualizarCliente(cliente);
			break;
		case 3:
			System.out.println("Informe o n�mero id para altera��o: ");
			id = new Scanner(System.in).nextInt();
			Veiculo veiculo = (Veiculo) consultar(new Veiculo(id));
			atualizarVeiculo(veiculo);
			break;
		case 4:
			System.out.println("Informe o n�mero do registro de im�vel para altera��o: ");
			regImovel = new Scanner(System.in).nextInt();
			Imovel imovel = (Imovel) consultar(new Imovel(registroImovel));
			atualizarImovel(imovel);
		case 5:
			System.out.println("Informe o n�mero do CNPJ da Institui��o Financeira para altera��o: ");
			numCNPJ = new Scanner(System.in).next();
			InstituicaoFinanceira instituicao = (InstituicaoFinanceira)consultar(new InstituicaoFinanceira(numCNPJ));
			atualizarInstituicaoFinanceira(instituicao);
		}
	}

	private void atualizarInstituicaoFinanceira(InstituicaoFinanceira instituicao) {
		int pergunta;
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o n�mero de registro do Im�vel? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				String nomeInstituicaoFinaceira;
				nomeInstituicaoFinaceira = preencherDado("Preencha o novo nome da Institui��o Financeira: ");
				instituicao.setNome(nomeInstituicaoFinaceira);
			}
		}
	}

	private void atualizarImovel(Imovel imovel) {
		int pergunta;
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o n�mero de registro do Im�vel? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				Integer registroImovel = null;
				registroImovel = Integer.valueOf(preencherDado("Preencha o novo n�mero de registro do Im�vel: "));
				imovel.setRegistroImovel(registroImovel);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o n�mero da rua do Im�vel? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				String rua = null;
				rua = preencherDado("Preencha o novo nome de rua do Im�vel: ");
					imovel.setRua(rua);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o n�mero da rua do Im�vel? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				Integer numero = null;
				numero = Integer.valueOf(preencherDado("Preencha o novo nome de rua do Im�vel: "));
				imovel.setNumero(numero);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o bairro do Im�vel? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				String bairro = null;
				bairro = preencherDado("Preencha o novo bairro do Im�vel: ");
					imovel.setBairro(bairro);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar a cidade do Im�vel? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				String cidade = null;
				cidade = preencherDado("Preencha o nova cidade do Im�vel: ");
					imovel.setCidade(cidade);
			}
		}
	}

	private void atualizarVeiculo(Veiculo veiculo) {
		int pergunta;
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o nome do Veiculo? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				String nome = null;
				nome = preencherDado("Informe o novo nome do Ve�culo:");
				veiculo.setNome(nome);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o tipo de combust�vel do Veiculo? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				alteraTipoCombustivelVeiculo(veiculo);
			}
		}
	}

	private void alteraTipoCombustivelVeiculo(Veiculo veiculo) {
		String op = null;
		op = preencherDado("Informe o novo tipo de combust�vel do Ve�culo conforme o c�digo: "
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
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o nome do Cliente? Informe o c�digo: 1-SIM 2-N�o"));
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
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o nome da cidade de realiza��o do Leil�o? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				String cidade = null;
				cidade = preencherDado("Informe o nome da cidade: ");
				leilao.setCidade(cidade);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar data de ocorr�ncia do Leil�o? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				Calendar dataOcorrencia = null;
				System.out.println("Informe a nova data de ocorr�ncia do Leil�o no formato dd/mm/aaaa: ");
				dataOcorrencia = Calendar.getInstance();
				dataOcorrencia.setTime(new Date(new Scanner(System.in).next()));
				leilao.setDataOcorrenciaFutura(dataOcorrencia);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar o endere�o do Leil�o? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				String endereco = null;
				endereco = preencherDado("Informe o novo endere�o do Leil�o: ");
				leilao.setEndereco(endereco);
			}
		}
		pergunta = Integer.valueOf(preencherDado("Deseja alterar a UF para o Leil�o? Informe o c�digo: 1-SIM 2-N�o"));
		if(pergunta>0) {
			if(pergunta<2) {
				String estado = null;
				estado = preencherDado("Informe o nova UF para o Leil�o: ");
				leilao.setEstado(estado);
			}
		}
	}
	
	public void listaLeiloes(List<Leilao>lista) {
		StringBuffer sb = new StringBuffer();
		if(lista.getClass().isInstance(new ArrayList<Leilao>())) {
			Collections.sort(lista, new Comparator<Leilao>() {
				@Override
				public int compare(Leilao l1, Leilao l2) {
					return l1.getDataOcorrenciaFutura().compareTo(l2.getDataOcorrenciaFutura());
				}
			});
			for (Leilao leilao:leiloes) {
				sb.append(leilao.toString()+"\n");
			}
		}
		System.out.println(sb);
	}
	
	public void listaClientes(List<Cliente>lista) {
		StringBuffer sb = new StringBuffer();
		if(lista.getClass().isInstance(new ArrayList<Cliente>())) {
			for (Cliente cliente:clientes) {
				sb.append(cliente.toString()+"\n");
			}
		}
		System.out.println(sb);
	}
	
	public void listaVeiculos(List<Veiculo>lista) {
		StringBuffer sb = new StringBuffer();
		if(lista.getClass().isInstance(new ArrayList<Veiculo>())) {
			if(veiculos.size()>0) {
				for (Veiculo veiculo: veiculos) {
					sb.append(veiculo.toString()+"\n");
				}
				System.out.println(sb);
			}else {
				System.out.println("Nenhum ve�culo foi cadastrado at� o momento");
			}

		}
		
	}
	
	public void listaLances(List<Lance>lista) {
		if(lista.getClass().isInstance(new ArrayList<Lance>())) {
			for(Leilao leilao:leiloes) {
				for (Produto produto: leilao.getProdutos()) {
					for (Lance lance:produto.getLancesProduto()) {
						StringBuffer sb = new StringBuffer();
						sb.append(lance.toString()+"\n");
					}
				}
			}
		}
	}
	
	public void listaImoveis(List<Imovel>lista) {
		StringBuffer sb = new StringBuffer();
		if(lista.getClass().isInstance(new Imovel())) {
			for (Imovel imovel : lista) {
				sb.append(imovel.toString()+"\n");
			}
		}
		System.out.println(sb);
	}
	
	public void listaInstituicoes(List<InstituicaoFinanceira>lista) {
		StringBuffer sb = new StringBuffer();
		if(lista.getClass().isInstance(new Imovel())) {
			for (InstituicaoFinanceira instituicao:instituicoes) {
				sb.append(instituicao.toString()+"\n");
			}
		}
		System.out.println(sb);
	}
	
	public void efetuarCadatro(int op) {
		switch (op) {
		case 1:
			if(getInstituicoes().size()>0) {
				listaInstituicoes(getInstituicoes());
				cadastrarLeilao();
			}
			
			break;
		case 2:
			cadastrarCliente();
			break;
		case 3:
			if(getLeiloes().size()>0) {
				System.out.println("LISTAGEM DE TODOS OS LEIL�ES CADASTRADOS\n");
				listaLeiloes(getLeiloes());
				cadastrarVeiculo();
			}else {
				System.out.println("Para cadastrar um ve�culo � necess�rio que se tenha criado pelo menos um Leil�o.");
			}
			break;
		case 4:
			if(imoveis.size()>0) {
				System.out.println("LISTAGEM DE TODOS OS LEIL�ES CADASTRADOS");
				listaImoveis(imoveis);
				cadastrarImovel();
			}else {
				System.out.println("Para cadastrar um im�vel � necess�rio que se tenha criado pelo menos um Leil�o.");
			}
			break;
		}
	}

	private void cadastrarImovel() {
		int opImovel = 0;
		idLeilao = Integer.valueOf(preencherDado("Informe o id do Leil�o que ser� associado a este Produto: "));
		System.out.println("Informe o Tipo de Im�vel conforme c�digo: "
					+TipoImovel.APARTAMENTO.getCod()+" - "+TipoImovel.APARTAMENTO
					+TipoImovel.CASA.getCod()+" - "+TipoImovel.CASA
					+TipoImovel.EDIFICIO.getCod()+" - "+TipoImovel.EDIFICIO
					+TipoImovel.TERRENO.getCod()+" - "+TipoImovel.TERRENO);
		opImovel = new Scanner(System.in).nextInt();
		registroImovel = Integer.valueOf(preencherDado("Insira o n�mero de registro de im�vel"));
		ruaImovel = preencherDado("Insira o nome da rua: ");
		numeroImovel =Integer.valueOf(preencherDado("Insira o n�mero do Im�vel: "));
		bairroImovel = preencherDado("Insira o bairro do Im�vel: ");
		cidadeImovel = preencherDado("Insira a cidade do Im�vel:");
		Imovel imovel = null;
		switch(opImovel) {
			case 1:
				imovel = new Apartamento(getProximoId(new Imovel()),idLeilao,TipoProduto.IMOVEL,registroImovel, ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
				cadastrar(imovel);
				break;
			case 2:
				imovel = new Casa(getProximoId(new Imovel()),idLeilao,TipoProduto.IMOVEL, ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
				cadastrar(imovel);
				break;
			case 3:
				imovel = new Edificio(getProximoId(new Imovel()),idLeilao,TipoProduto.IMOVEL,registroImovel, ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
				cadastrar(imovel);
				break;
			case 4:
				imovel = new Terreno(getProximoId(new Imovel()),idLeilao,TipoProduto.IMOVEL, registroImovel,ruaImovel, numeroImovel, bairroImovel, cidadeImovel);
				cadastrar(imovel);
				break;
		}
	}

	@SuppressWarnings("resource")
	private void cadastrarVeiculo() {
		idLeilao = Integer.valueOf(preencherDado("Informe o id do Leil�o que ser� associado a este Produto: "));
		nomeVeiculo = preencherDado("Informe o nome do veiculo: ");
		System.out.println("Informe tipo de combust�vel conforme c�digo: 1 - "+TipoCombustivel.ALCOOL
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
		Veiculo veiculo = new Veiculo(getProximoId(new Veiculo()),idLeilao,TipoProduto.VEICULO, nomeVeiculo, tipoCombustivel);
		cadastrar(veiculo);
	}

	private void cadastrarCliente() {
		nomeCliente = preencherDado("Informe o nome do cliente: ");
		Cliente cliente = new Cliente(nomeCliente);
		cadastrar(cliente);
	}

	@SuppressWarnings("static-access")
	private void cadastrarLeilao() {
		String variavel = null;
		variavel = preencherDado("Informe a data de ocorr�ncia do Leil�o no formato dd/mm/aaaa:");
		dataOcorrenciaLeilao = Calendar.getInstance();
		dataOcorrenciaLeilao.setTime(new Date(variavel));
		variavel = preencherDado("Informe a hora de in�cio do Leil�o no formato hh:mm  ");
		horaInicioLeilao = Calendar.getInstance();
		horaInicioLeilao.set(dataOcorrenciaLeilao.YEAR, dataOcorrenciaLeilao.MONTH, dataOcorrenciaLeilao.DATE, Integer.valueOf(variavel.substring(0, 1)).intValue(), Integer.valueOf(variavel.substring(3,4)).intValue());
		variavel = preencherDado("Informe a hora de t�rmino do Leil�o no formato hh:mm : ");
		horaFimLeilao = Calendar.getInstance();
		horaFimLeilao.set(dataOcorrenciaLeilao.YEAR, dataOcorrenciaLeilao.MONTH, dataOcorrenciaLeilao.DATE, Integer.valueOf(variavel.substring(0, 1)).intValue(), Integer.valueOf(variavel.substring(3,4)).intValue());
		variavel = preencherDado("Informe a endere�o de realiza��o do Leil�o: ");
		enderecoLeilao = variavel;
		cidadeLeilao = preencherDado("Informe a cidade de realiza��o do Leil�o: ");
		estadoLeilao = preencherDado("Informe o estado(UF) de realiza��o do Leil�o: ");
		int id = getProximoId(new Leilao());
		Leilao leilao = new Leilao(id,horaInicioLeilao, horaFimLeilao, dataOcorrenciaLeilao, enderecoLeilao, cidadeLeilao, estadoLeilao);
		leilao.setStatus(StatusLeilao.EM_ABERTO);
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

	public void efetuarConsulta(int opcao, int idConsulta) {
		switch (opcao) {
		case 1:
			break;

		default:
			break;
		}	
	}

	public void detalharLeilao(int id) {
		StringBuilder sb = new StringBuilder();
		Leilao leilao = (Leilao) consultar(new Leilao(id));
		if(leilao!=null) {
			System.out.println(leilao.toString());
		}
	}
	
	public void detalharProdutoDeLeilao(Integer idLeilao,Integer idProduto) {
		Leilao leilao = (Leilao)consultar(new Leilao(idLeilao));
		for (Produto p:leilao.getProdutos()) {
			if(p.getId().equals(idProduto)) {
				System.out.println(p.toString());
				break;
			}
		}
	}
}