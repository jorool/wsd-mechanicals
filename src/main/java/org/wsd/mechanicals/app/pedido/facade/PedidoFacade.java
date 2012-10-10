package org.wsd.mechanicals.app.pedido.facade;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.wsd.mechanicals.app.pedido.Pedido;
import org.wsd.mechanicals.app.pedido.repository.PedidoRepository;
import org.wsd.mechanicals.app.pedido.sequencial.SequencialPedidoRepository;

@Service
public class PedidoFacade {

	@Autowired
	private SequencialPedidoRepository sequencialPedidoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Pedido novoPedido() {
		Integer proximoNumeroDoPedido = sequencialPedidoRepository.getSequencialPedido().proximoNumeroDoPedido();
		return Pedido.newPedido(proximoNumeroDoPedido);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Integer proximoNumeroPedido() {
		return sequencialPedidoRepository.getSequencialPedido().proximoNumeroDoPedido();
	}

	@Transactional
	public Pedido save(Pedido pedido) {
		checkNotNull(pedido);
		return pedidoRepository.save(pedido);
	}

}