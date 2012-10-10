package org.wsd.mechanicals.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.wsd.mechanicals.app.notafiscal.Item;
import org.wsd.mechanicals.app.notafiscal.NotaFiscal;
import org.wsd.mechanicals.app.notafiscal.repository.NotaFiscalRepository;

@Controller
public class NotaFiscalController {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	public NotaFiscal novo() {
		return NotaFiscal.newNotaFiscal(123);
	}

	public Item novoItem() {
		return Item.newItem();
	}

	public FiltroNotaFiscal getFiltro() {
		return new FiltroNotaFiscal();
	}

	public List<NotaFiscal> filtrar(FiltroNotaFiscal filtro) {
		return notaFiscalRepository.findAll();
	}

}