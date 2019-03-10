package br.com.fiap.loja.bo;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.log4j.Logger;

import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaBO;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultaBOResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {

	private static Logger log = Logger.getLogger(TerminalConsulta.class);

	public static void main(String[] args) throws RemoteException {
		log.warn("Ínicio da aplicação");
		String nome = "Banana";
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(nome + " " + hoje.format(formatador));
		System.out.println("Digite o código do produto desejado: ");
		Scanner scanner = new Scanner(System.in);
		int codigo = scanner.nextInt();
		scanner.close();
		
		
		EstoqueBOStub stub = new EstoqueBOStub();
		ConsultaBO consultar = new ConsultaBO();
		consultar.setCodProd(codigo);
		ConsultaBOResponse response = stub.consultaBO(consultar);
		ProdutoTO produto = response.get_return();

		
		
		System.out.println(produto.getDescricao());
		log.warn("Final da Aplicação");
	}

}
