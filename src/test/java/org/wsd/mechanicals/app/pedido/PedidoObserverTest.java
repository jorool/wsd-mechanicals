package org.wsd.mechanicals.app.pedido;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.wsd.mechanicals.app.estoque.ItemEstoque;
import org.wsd.mechanicals.app.produto.Produto;
import org.wsd.mechanicals.app.quantidade.QuantidadeFactory;


public class PedidoObserverTest {

	@Test
	public void faturado() {
		Pedido pedido = Pedido.newPedido(123);
		Produto camisa = Produto.newProduto("Camisa");
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("12.00")));

		ItemEstoque itemEstoque = ItemEstoque.newItemEstoque(camisa);
		itemEstoque.addQuantidade(QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("20.00")));
		pedido.addObservador(itemEstoque);

		Faturamento faturamento = Faturamento.newFaturamento(pedido);
		faturamento.setProduto(camisa);
		faturamento.setQuantidade(QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("5.00")));
		pedido.addFaturamento(faturamento);

		assertEquals(QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("15.00")),
				itemEstoque.getQuantidade());
	}

}
