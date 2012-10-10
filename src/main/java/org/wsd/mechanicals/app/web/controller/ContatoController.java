package org.wsd.mechanicals.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.wsd.mechanicals.app.contato.Contato;
import org.wsd.mechanicals.app.contato.repository.ContatoRepository;

@Controller
public class ContatoController {

	@Autowired
	private ContatoRepository contatoRepository;

	public Contato novo() {
		return Contato.newContato();
	}

	public List<Contato> filtrar() {
		return contatoRepository.findAll();
	}

}