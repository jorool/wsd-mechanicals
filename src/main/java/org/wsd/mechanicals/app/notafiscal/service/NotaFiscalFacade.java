package org.wsd.mechanicals.app.notafiscal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wsd.mechanicals.app.notafiscal.NotaFiscal;
import org.wsd.mechanicals.app.notafiscal.repository.NotaFiscalRepository;
import org.wsd.mechanicals.app.pedido.Pedido;

@Service
public class NotaFiscalFacade {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	public void pedidoCriado(Pedido pedido) {
		NotaFiscal notaFiscal = NotaFiscal.newNotaFiscal(pedido);
		notaFiscalRepository.save(notaFiscal);
	}

}