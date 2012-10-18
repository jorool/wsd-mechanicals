package org.wsd.mechanicals.app.pedido.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.wsd.mechanicals.app.pedido.Pedido;
import org.wsd.mechanicals.app.pedido.facade.PedidoFacade;
import org.wsd.mechanicals.app.pedido.repository.PedidoRepository;
import org.wsd.mechanicals.app.pedido.web.filter.FiltroPedido;

@Controller
public class PedidoController {

	@Autowired
	private PedidoFacade pedidoFacade;

	@Autowired
	private PedidoRepository pedidoRepository;

	private FiltroPedido filtro = new FiltroPedido();

	public Pedido novo() {
		return pedidoFacade.novoPedido();
	}

	public FiltroPedido getFiltro() {
		return filtro;
	}

	public List<Pedido> getPedidos() {
		return pedidoRepository.findAll();
	}

}