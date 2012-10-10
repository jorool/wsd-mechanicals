package org.wsd.mechanicals.app.notafiscal.service;

import static org.wsd.mechanicals.app.IntegrationChannels.INPUT_PEDIDO_CHANNEL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Service;
import org.wsd.mechanicals.app.notafiscal.NotaFiscal;
import org.wsd.mechanicals.app.notafiscal.repository.NotaFiscalRepository;
import org.wsd.mechanicals.app.pedido.Pedido;

@Service
public class NotaFiscalFacade {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	@ServiceActivator(inputChannel = INPUT_PEDIDO_CHANNEL)
	public void pedidoCriado(Pedido pedido) {
		NotaFiscal notaFiscal = NotaFiscal.newNotaFiscal(pedido);
		notaFiscalRepository.save(notaFiscal);
	}

}