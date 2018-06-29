package br.com.fatec.main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.enuns.TipoCombustivel;
import br.com.enuns.TipoImovel;
import br.com.enuns.TipoProduto;
import br.com.fatec.Imovel;
import br.com.fatec.Veiculo;
import br.com.fatec.crud.CrudLeilao;
import br.com.fatec.dominio.Cliente;
import br.com.fatec.dominio.imovel.Apartamento;
import br.com.fatec.dominio.imovel.Casa;
import br.com.fatec.dominio.imovel.Edificio;
import br.com.fatec.dominio.imovel.Leilao;

public class GerenciamentoLeiloes {
	public static CrudLeilao crud;
	public static BigInteger numerador = new BigInteger("0");
	
	private static int operacao = 0;
	private static int opcao = 0;
	//LEILÃO
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
	private static String ruaImovel;
	private static Integer numeroImovel;
	private static String bairroImovel;
	private static String cidadeImovel;
	
	public GerenciamentoLeiloes() {
		crud = new CrudLeilao();
	}
	
	private static void preencherDado(String solicitacaoDados,Object variavelAAtualizar) {
		System.out.println(solicitacaoDados);
		if(variavelAAtualizar.getClass().isInstance(Integer.class)) {
			variavelAAtualizar = new Scanner(System.in).nextInt();
		}
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		GerenciamentoLeiloes gerenciamentoLeiloes = new GerenciamentoLeiloes();
		
		
		do {
//			// muda o LookAndFeel para parecer com uma aplicacao nativa
//			try {
//				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			// --> cria um novo objeto do tipo Swing1
//			// por causa da execucao multithreading da
//			// API swing,isso deve ser feito dessa forma:
//			SwingUtilities.invokeLater(new Runnable() {
//				public void run() {
//					new TelaInicialLeiloes();
//				}
//			});
			System.out.println("SISTEMA DE CONTROLE DE LEILÕES \n\n"
					+ "------------------------------Menu Principal------------------------------\n\n"
					+ "Selecione a opção deseja informando o código conforme abaixo\n"
					+ "1 - Leilao\n  2 - Cliente\n  3 - Veiculo\n 4 - Imovel 5 - SAIR\n\n");
			opcao = new Scanner(System.in).nextInt();
			System.out.println("Insira o codigo da operacao desejada, conforme abaixo:\n"
					+ "1 - Cadastrar\n 2 - Atualizar\n 3 - Remover\n 4 - Consultar\n\n");
			operacao = new Scanner(System.in).nextInt();
			if(opcao<1){
				System.out.println("Opção inválida insira um código válido!");
			}else if(opcao<5) {
				switch (operacao) {
				case 1:
					crud.efetuarCadatro(1);
					break;
				case 2:
					System.out.println("Informe o id do Leilão que deseja alterar");
					int id = new Scanner(System.in).nextInt();
					crud.efetuarAtualizacao(opcao,id,null,null);
					break;
				case 3:
					System.out.println("Informe o id do Leilão que deseja remover");
					int idRemover = new Scanner(System.in).nextInt();
					crud.efetuarRemocao(opcao,idRemover,null,null);
					break;
				case 4:
//					crud.efetuarConsulta
					break;
				}
			}
		} while (opcao<5);
	}
	
	public BigInteger getNumerador() {
		return numerador;
	}

	public void setNumerador(BigInteger numerador) {
		this.numerador = numerador;
	}
}
