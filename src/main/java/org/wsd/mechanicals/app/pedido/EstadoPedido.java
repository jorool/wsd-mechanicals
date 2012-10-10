package org.wsd.mechanicals.app.pedido;

import java.math.BigDecimal;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.joda.time.Days;
import org.wsd.mechanicals.app.produto.Produto;
import org.wsd.mechanicals.app.quantidade.Adicao;
import org.wsd.mechanicals.app.quantidade.Ops;
import org.wsd.mechanicals.app.quantidade.Quantidade;
import org.wsd.mechanicals.app.quantidade.QuantidadeFactory;

public enum EstadoPedido {

	ABERTO {
		@Override
		public Quantidade calcularQuantidade(Pedido pedido) {
			Quantidade quantidadeNormal = super.calcularQuantidade(pedido);
			DateTime hoje = new DateTime(DateTimeUtils.currentTimeMillis());
			if (Days.daysBetween(pedido.data, hoje).getDays() > 10) {
				Quantidade desconto = QuantidadeFactory.INSTANCE.newQuantidade(new BigDecimal("0.90"));
				return Ops.multiplicacao(quantidadeNormal).multiplicando(desconto).multiplicar();
			}
			return super.calcularQuantidade(pedido);
		}
	}
	, CANCELADO, PARCIALMENTE_CANCELADO {
		@Override
		boolean isParcialmenteCancelado() {
			return true;
		}
	}, FATURADO, PARCIALMENTE_FATURADO;

	boolean isParcialmenteCancelado() {
		return false;
	}

	public Quantidade calcularQuantidade(Pedido pedido) {
		Map<Produto, Quantidade> produtosNaoCancelados = pedido.getProdutosNaoCancelados();
		Adicao adicao = Ops.adicao();
		for (Produto produto: produtosNaoCancelados.keySet()) {
			adicao.somando(produtosNaoCancelados.get(produto));
		}
		return adicao.somar();
	}

}