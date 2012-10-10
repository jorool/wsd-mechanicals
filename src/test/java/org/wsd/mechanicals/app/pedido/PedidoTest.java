package org.wsd.mechanicals.app.pedido;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import org.wsd.mechanicals.app.pessoa.Vendedor;
import org.wsd.mechanicals.app.produto.Produto;
import org.wsd.mechanicals.app.quantidade.Percentual;
import org.wsd.mechanicals.app.quantidade.Quantidade;
import org.wsd.mechanicals.app.quantidade.QuantidadeFactory;


public class PedidoTest {

	@Test
	public void equals() {
		Pedido pedido1 = Pedido.newPedido(123);
		Pedido pedido2 = Pedido.newPedido(123);
		Pedido pedido3 = Pedido.newPedido(321);
		assertEquals(pedido1, pedido2);
		assertFalse(pedido1.equals(pedido3));
		assertFalse(pedido2.equals(321));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void cancelamentosImutavel() {
		Pedido pedido = Pedido.newPedido(123);
		List<Cancelamento> cancelamentos = pedido.getCancelamentos();
		cancelamentos.add(Cancelamento.newCancelamento(pedido));
	}

	@Test
	public void addProduto() {
		Pedido pedido = Pedido.newPedido(123);
		Produto camisa = Produto.newProduto("Camisa");
		Produto calca = Produto.newProduto("Calça");
		QuantidadeFactory.INSTANCE.setCasasDecimais(3);
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.201")));
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.403")));
		pedido.addProduto(calca, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.157")));
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("3.333")));
		Quantidade quantidadeCamisas = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("3.937"));
		Quantidade quantidadeCalcas = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.157"));
		assertEquals(quantidadeCamisas, pedido.getProdutos().get(camisa));
		assertEquals(quantidadeCalcas, pedido.getProdutos().get(calca));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void produtosImutavel() {
		Pedido pedido = Pedido.newPedido(123);
		Produto camisa = Produto.newProduto("Camisa");
		Quantidade quantidadeCamisas = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.157"));
		pedido.getProdutos().put(camisa, quantidadeCamisas);
	}

	@Test
	public void produtosNaoCancelados() {
		Pedido pedido = Pedido.newPedido(123);
		Produto camisa = Produto.newProduto("Camisa");
		Produto calca = Produto.newProduto("Calça");
		Produto meia = Produto.newProduto("Meia");
		QuantidadeFactory.INSTANCE.setCasasDecimais(2);
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.00")));
		pedido.addProduto(calca, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("4.00")));
		pedido.addProduto(meia, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("8.00")));

		Cancelamento cancelamento = Cancelamento.newCancelamento(pedido);
		cancelamento.setProduto(meia);
		cancelamento.setQuantidade(QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("1.50")));
		pedido.addCancelamento(cancelamento);

		Map<Produto, Quantidade> produtosNaoCancelados = pedido.getProdutosNaoCancelados();
		assertEquals(QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.00")),
				produtosNaoCancelados.get(camisa));
		assertEquals(QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("4.00")), produtosNaoCancelados.get(calca));
		assertEquals(QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("6.50")), produtosNaoCancelados.get(meia));
	}

	@Test
	public void quantidade() {
		Pedido pedido = Pedido.newPedido(123);
		Produto camisa = Produto.newProduto("Camisa");
		Produto calca = Produto.newProduto("Calça");
		Produto meia = Produto.newProduto("Meia");
		QuantidadeFactory.INSTANCE.setCasasDecimais(2);
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("2.00")));
		pedido.addProduto(calca, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("4.00")));
		pedido.addProduto(meia, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("8.00")));

		DateTimeUtils.setCurrentMillisFixed(new DateTime(2012, 9, 10, 11, 0, 0).getMillis());

		pedido.data = new DateTime(2012, 9, 10, 10, 0, 0);
		Quantidade totalNormal = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("14.00"));
		assertEquals(totalNormal, pedido.getQuantidade());

		pedido.data = new DateTime(2012, 8, 20, 10, 0, 0);
		Quantidade totalComDesconto = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("12.60"));
		assertEquals(totalComDesconto, pedido.getQuantidade());
	}

	@Test
	public void observador() {
		Pedido pedido = Pedido.newPedido(123);
		PedidoObserver observador1 = mock(PedidoObserver.class);
		PedidoObserver observador2 = mock(PedidoObserver.class);
		Faturamento faturamento = mock(Faturamento.class);
		pedido.addObservador(observador1);
		pedido.addObservador(observador2);
		pedido.addFaturamento(faturamento);
		verify(observador1).faturado(any(Faturamento.class));
		verify(observador2).faturado(faturamento);
	}

	@Test
	public void comissao() {
		Pedido pedido = Pedido.newPedido(123);
		Produto camisa = Produto.newProduto("Camisa");
		Produto calca = Produto.newProduto("Calça");
		Produto meia = Produto.newProduto("Meia");
		QuantidadeFactory.INSTANCE.setCasasDecimais(2);
		pedido.addProduto(camisa, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("12.00")));
		pedido.addProduto(calca, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("24.00")));
		pedido.addProduto(meia, QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("28.00")));
		Vendedor vendedor = mock(Vendedor.class);
		when(vendedor.getComissao()).thenReturn(Percentual.newPercentual(new BigDecimal("7.5")));
		pedido.setVendedor(vendedor);
		Quantidade comissao = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("4.8"));
		assertEquals(comissao, pedido.getComissao());
	}

}