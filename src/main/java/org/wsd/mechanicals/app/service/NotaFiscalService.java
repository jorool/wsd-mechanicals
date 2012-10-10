package org.wsd.mechanicals.app.service;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wsd.mechanicals.app.notafiscal.NotaFiscal;

@Service
public class NotaFiscalService {

	WebServiceReceita webServiceReceita;

	@Transactional
	public void enviarParaReceita(NotaFiscal notaFiscal) {
		checkNotNull(notaFiscal);
		notaFiscal.enviar(webServiceReceita);
	}

}