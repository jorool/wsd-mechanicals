package org.wsd.mechanicals.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.wsd.mechanicals.app.produto.Produto;
import org.wsd.mechanicals.app.produto.QProduto;
import org.wsd.mechanicals.app.produto.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> autocomplete(String query) {
		return produtoRepository.findAll(QProduto.produto.nome.containsIgnoreCase(query), new PageRequest(0, 5))
				.getContent();
	}

}
