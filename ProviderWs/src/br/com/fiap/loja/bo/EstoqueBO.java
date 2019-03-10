package br.com.fiap.loja.bo;

import org.apache.axis2.AxisFault;

import br.com.fiap.loja.to.ProdutoTO;

public class EstoqueBO {

	public static ProdutoTO consultaBO(int codProd) throws AxisFault {

		if (codProd == 401) {
			return new ProdutoTO(codProd, 2.99, 4, "Camisa Branca");

		} else if (codProd == 402) {
			return new ProdutoTO(codProd, 2.99, 4, "Camisa Azul");
			// System.out.println( p.getDescricao());
		} else if (codProd == 403) {
			return new ProdutoTO(codProd, 2.99, 4, "Camisa Rosa");
		}if (codProd == 420) {
			return new ProdutoTO(codProd, 4.20, 4, "Camisa Verde");

		} else {
			throw new AxisFault ("Produto não encontrado");
		}
	}

}
