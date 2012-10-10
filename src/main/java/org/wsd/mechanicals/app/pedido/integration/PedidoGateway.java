package org.wsd.mechanicals.app.pedido.integration;

import static org.wsd.mechanicals.app.IntegrationChannels.OUTPUT_PEDIDO_CHANNEL;

import org.springframework.integration.annotation.Gateway;
import org.wsd.mechanicals.app.pedido.Pedido;

public interface PedidoGateway {

	@Gateway(requestChannel = OUTPUT_PEDIDO_CHANNEL)
	public void criado(Pedido pedido);

}