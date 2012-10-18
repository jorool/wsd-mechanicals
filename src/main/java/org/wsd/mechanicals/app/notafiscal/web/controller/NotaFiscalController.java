package org.wsd.mechanicals.app.notafiscal.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.wsd.mechanicals.app.notafiscal.NotaFiscalItem;
import org.wsd.mechanicals.app.notafiscal.NotaFiscal;
import org.wsd.mechanicals.app.notafiscal.repository.NotaFiscalRepository;
import org.wsd.mechanicals.app.notafiscal.web.filter.FiltroNotaFiscal;

@Controller
public class NotaFiscalController {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	public NotaFiscal novo() {
		return NotaFiscal.newNotaFiscal(123);
	}

	public NotaFiscalItem novoItem() {
		return NotaFiscalItem.newItem();
	}

	public FiltroNotaFiscal getFiltro() {
		return new FiltroNotaFiscal();
	}

	public List<NotaFiscal> filtrar(FiltroNotaFiscal filtro) {
		return notaFiscalRepository.findAll();
	}

}