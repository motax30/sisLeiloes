package br.com.fatec.main;

import java.io.LineNumberInputStream;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Scanner;

import br.com.enuns.TipoCombustivel;
import br.com.fatec.crud.CrudLeilao;

public class GerenciamentoLeiloes {
	public static CrudLeilao crud;
	public static BigInteger numerador = new BigInteger("0");
	
	private static int operacao = 0;
	private static int opcao = 0;
	//LEIL�O
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
	

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		crud = new CrudLeilao();
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
			System.out.println("SISTEMA DE CONTROLE DE LEIL�ES \n\n"
					+ "------------------------------Menu Principal------------------------------\n\n"
					+ "Selecione a op��o deseja informando o c�digo conforme abaixo\n"
					+ "1 - Leilao\n  2 - Cliente\n  3 - Veiculo\n 4 - Imovel\n 5 - Intitui��o Financeira\n 6 - Listar Leiloes \n "
					+ "7 - Detalhar um Leil�o Espec�fico 8 -  Detalhar produto de Leil�o 9 - SAIR\n\n");
			opcao = new Scanner(System.in).nextInt();
			if(opcao<1){
				System.out.println("Op��o inv�lida insira um c�digo v�lido!");
			}else if(opcao<6) {
			System.out.println("Insira o codigo da operacao desejada, conforme abaixo:\n"
					+ "1 - Cadastrar\n 2 - Atualizar\n 3 - Remover\n 4 - Consultar\n\n");
			operacao = new Scanner(System.in).nextInt();
				switch (operacao) {
				case 1:
					crud.efetuarCadatro(opcao);
					break;
				case 2:
					crud.efetuarAtualizacao(opcao);
					break;
				case 3:
					crud.efetuarRemocao(opcao);
					break;
				}
			}else {
				if(crud.getLeiloes().size()>0) {
					switch (opcao) {
					case 6:
							System.out.println("LISTAGEM DOS LEIL�ES CADASTRADOS ORDENADOS POR DATA DE OCORR�NCIA");
							crud.listaLeiloes(crud.getLeiloes());
							break;	
					case 7:
						int id = Integer.valueOf(crud.preencherDado("Informe o id do Leil�o para detalhamento: "));
						crud.detalharLeilao(id);
					case 8:
						int idLeilao = Integer.valueOf(crud.preencherDado("Informe o id do Leil�o para detalhamento: "));
						int idProduto = Integer.valueOf(crud.preencherDado("Informe o id do Produto do Leil�o para detalhamento: "));
						crud.detalharProdutoDeLeilao(idLeilao, idProduto);
					}	
				}else {
					System.out.println("N�o existem leil�es cadastrados, tente novamente!");
				}
			}
		} while (opcao<9);
	}
}
