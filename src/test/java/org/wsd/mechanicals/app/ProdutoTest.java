package org.wsd.mechanicals.app;

import static org.junit.Assert.*;

import org.junit.Test;
import org.wsd.mechanicals.app.produto.Produto;


public class ProdutoTest {

	@Test
	public void equals() {
		Produto produto1 = Produto.newProduto("Camisa");
		Produto produto2 = Produto.newProduto("Camisa");
		assertEquals(produto1, produto2);
		assertFalse(produto1.equals(123));
	}

}